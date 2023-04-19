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
}