package security.service;

import java.util.Iterator;
import java.util.logging.Logger;


import carpark.service.CarparkClient;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import security.service.securityServicesGrpc.securityServicesBlockingStub;
import security.service.securityServicesGrpc.securityServicesStub;

public class SecurityClient {
	private static final Logger logger = Logger.getLogger(CarparkClient.class.getName());
	
	private static securityServicesBlockingStub blockingStub;
	private static securityServicesStub asyncStub;
	
	public static void main(String[] args) throws Exception {
		String host = "localhost";
		int port = 50053;
		
		ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
		
		
		blockingStub = securityServicesGrpc.newBlockingStub(channel);
		asyncStub = securityServicesGrpc.newStub(channel);
		SecurityClient client = new SecurityClient();
		
		unlockDoor();
		emergencyUnlock();
		accessBuilding();
	}
	
	private static void unlockDoor() {
		logger.info("Unlock Request Started..");
		int codeEntered = 1234;
		UnlockRequest request = UnlockRequest.newBuilder().setCodeEntered(codeEntered).build();
		UnlockResponse response = blockingStub.unlockDoor(request);
		System.out.println("Door lock status: "+ response.getLockStatus());
	}
	
	private static void emergencyUnlock() throws InterruptedException {
		logger.info("Emergency Unlock Request Started..");
		int codeEntered = 9999;
		EmUnlockRequest request = EmUnlockRequest.newBuilder().setCodeEntered(codeEntered).build();
		Iterator<EmUnlockResponse> response = blockingStub.emergencyUnlock(request);
		
		while(response.hasNext()) {
			Thread.sleep(1000);
			EmUnlockResponse singleResponse = response.next();
			System.out.println("Emergency Lock Status: "+ singleResponse.getLockStatus());
		}
		
	}
	
	private static void accessBuilding() throws InterruptedException {
		logger.info("Access Building Request Started");
		StreamObserver<DetailsResponse> responseObserver = new StreamObserver<DetailsResponse>() {
			@Override
			public void onNext(DetailsResponse response) {
				// TODO Auto-generated method stub
				System.out.println(response.getMessage());
			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onCompleted() {
				// TODO Auto-generated method stub
				System.out.println("Staff Details Sent..");
			}
			
		};
		
		StreamObserver<DetailsRequest> requestObserver = asyncStub.accessBuilding(responseObserver);
		try {
			requestObserver.onNext(DetailsRequest.newBuilder().setStaffID(21121).setStaffFName("John")
					.setStaffLName("Johnson").setFloor(1).build());
			Thread.sleep(1000);
			
			requestObserver.onNext(DetailsRequest.newBuilder().setStaffID(41144).setStaffFName("Liam")
					.setStaffLName("Martin").setFloor(2).build());
			Thread.sleep(1000);
			requestObserver.onNext(DetailsRequest.newBuilder().setStaffID(32145).setStaffFName("Thomas")
					.setStaffLName("Kent").setFloor(5).build());
			Thread.sleep(1000);
			
			requestObserver.onCompleted();
			
		}
		finally {
			Thread.sleep(1000);
		}
	}
}