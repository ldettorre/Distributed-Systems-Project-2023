package security.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import security.service.securityServicesGrpc.securityServicesImplBase;

public class SecurityServer extends securityServicesImplBase{
	private static final Logger logger = Logger.getLogger(SecurityServer.class.getName());
	
	public static void main(String[] args) throws InterruptedException {
		
		SecurityServer securityServices = new SecurityServer();
		int port = 50053;
		
		try {
			Server server = ServerBuilder.forPort(port)
					.addService(securityServices)
					.build()
					.start();
			logger.info("Server started, listening on " + port);
			server.awaitTermination();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void unlockDoor(UnlockRequest request, StreamObserver<UnlockResponse> responseObserver) {
		logger.info("Receiving Unlock Request");
		int unlockCode = 1234;
		String lockStatus = "";
		if(request.getCodeEntered() == unlockCode) {
			lockStatus = "Door Unlocked.";
		}
		else {
			lockStatus = "Code Failed. Door Locked";
		}
		System.out.println(lockStatus);
		UnlockResponse response = UnlockResponse.newBuilder().setLockStatus(lockStatus).build();
		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}
	
	@Override
	public void emergencyUnlock(EmUnlockRequest request, StreamObserver<EmUnlockResponse> responseObserver) {
		logger.info("Receiving Emergency Unlock Request");
		int count = 0;
		String emLockStatus = "Inactive.";
		while(count <= 10) {
			count ++;
			if(request.getCodeEntered() == 9999) {
				emLockStatus = "Active. Evacuate immediately";
			}
			EmUnlockResponse response = EmUnlockResponse.newBuilder().setLockStatus(emLockStatus).build();
			responseObserver.onNext(response);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		responseObserver.onCompleted();
	}
	
	@Override
	public StreamObserver<DetailsRequest> accessBuilding(StreamObserver<DetailsResponse> responseObserver){
		return new StreamObserver<DetailsRequest>() {
			ArrayList<String> signedIn = new ArrayList<String>();
			@Override
			public void onNext(DetailsRequest request) {
				// TODO Auto-generated method stub
				System.out.println("Adding record to signed in log on row: "+ signedIn.size()+1);
				signedIn.add(request.getFloor()+"/"+request.getStaffLName()+request.getStaffFName()+"/"
						+request.getFloor());
			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onCompleted() {
				// TODO Auto-generated method stub
				DetailsResponse response = DetailsResponse.newBuilder()
						.setMessage("*** Need to update response message ***").build();
				responseObserver.onNext(response);

				responseObserver.onCompleted();
			}
			
		};
	}
}