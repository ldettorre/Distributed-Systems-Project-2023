package security.service;

import java.util.logging.Logger;


import carpark.service.CarparkClient;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import security.service.securityServicesGrpc.securityServicesBlockingStub;

public class SecurityClient {
	private static final Logger logger = Logger.getLogger(CarparkClient.class.getName());
	
	private static securityServicesBlockingStub blockingStub;
	
	public static void main(String[] args) throws Exception {
		String host = "localhost";
		int port = 50053;
		
		ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
		
		
		blockingStub = securityServicesGrpc.newBlockingStub(channel);
		SecurityClient client = new SecurityClient();
		
		unlockDoor();
	}
	
	private static void unlockDoor() {
		logger.info("Unlock Request Started..");
		int codeEntered = 12345;
		UnlockRequest request = UnlockRequest.newBuilder().setCodeEntered(codeEntered).build();
		UnlockResponse response = blockingStub.unlockDoor(request);
		System.out.println("Door lock status: "+ response.getLockStatus());
	}
}