package security.service;

import java.io.IOException;
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
}