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
		System.out.println("Received Code: "+ request.getCodeEntered());
		String codeEntered = request.getCodeEntered();
		int unlockCode = 1234;
		String lockStatus = "";
		try {
			if(Integer.parseInt(codeEntered) == unlockCode) {
				lockStatus = "Door Unlocked.";
			}
			else {
				lockStatus = "Code Failed. Door Locked";
			}
			System.out.println(lockStatus);
		}
		catch (NumberFormatException e) {
			lockStatus = "Error! Passcodes only contain numbers.";
		}
		
		UnlockResponse response = UnlockResponse.newBuilder().setLockStatus(lockStatus).build();
		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}
	
	@Override
	public void emergencyUnlock(EmUnlockRequest request, StreamObserver<EmUnlockResponse> responseObserver) {
		logger.info("Receiving Emergency Unlock Request");

		String emCodeEntered = request.getCodeEntered();
		String emLockStatus = "Inactive.";
		
		try {
			if(Integer.parseInt(emCodeEntered) == 9999) {
				emLockStatus = "Active. Evacuate immediately";
				for(int i=1;i<=10;i++) {
					EmUnlockResponse response = EmUnlockResponse.newBuilder()
							.setLockStatus("Door" + i + " " + emLockStatus).build();
					responseObserver.onNext(response);
				}
			}
			else {
				emLockStatus = "Denied.";
			}
		}
		catch (NumberFormatException e) {
			emLockStatus = "Error! Numbers Only.";
        }
		
		EmUnlockResponse response = EmUnlockResponse.newBuilder().setLockStatus(emLockStatus).build();
		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}
	
	
	@Override
	public StreamObserver<DetailsRequest> accessBuilding(StreamObserver<DetailsResponse> responseObserver){
		logger.info("Receiving Access Building Request");
		return new StreamObserver<DetailsRequest>() {
			ArrayList<String> entryLog = new ArrayList<String>();
			@Override
			public void onNext(DetailsRequest request) {
				// TODO Auto-generated method stub
				String recordEntry = request.getStaffID()+"/"+request.getStaffLName()+request.getStaffFName()+"/"
						+request.getFloor();
				entryLog.add(recordEntry);
				System.out.println("Adding record to signed in log on row: "+ entryLog.size());
				System.out.println(recordEntry);
				DetailsResponse response = DetailsResponse.newBuilder().setMessage(recordEntry).build();
				responseObserver.onNext(response);
			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onCompleted() {
				// TODO Auto-generated method stub
//				DetailsResponse response = DetailsResponse.newBuilder().setMessage("Completed.").build();
//				System.out.println(response);
//				responseObserver.onNext(response);
				responseObserver.onCompleted();
			}
			
		};
	}
}