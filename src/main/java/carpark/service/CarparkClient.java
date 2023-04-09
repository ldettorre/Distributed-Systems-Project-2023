package carpark.service;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import carpark.service.carparkServicesGrpc.carparkServicesBlockingStub;
import carpark.service.carparkServicesGrpc.carparkServicesStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

public class CarparkClient {
	private static final Logger logger = Logger.getLogger(CarparkClient.class.getName());
	public static void main(String[] args) throws Exception {
		String host = "localhost";
		int port = 50051;
		
		ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
		
		carparkServicesBlockingStub blockingStub = carparkServicesGrpc.newBlockingStub(channel);
		
		//for async calls
		carparkServicesStub asyncStub = carparkServicesGrpc.newStub(channel);
		CarparkClient client = new CarparkClient();
		
		
		try {
			String idNumber = "2";
			AccessRequest request = AccessRequest.newBuilder().setIdNumber(idNumber).build();
			LeaveRequest requestL = LeaveRequest.newBuilder().build();
			SpacesRequest requestS = SpacesRequest.newBuilder().build();
			
			AccessResponse response = blockingStub.accessCarpark(request);
			LeaveResponse responseL = blockingStub.leaveCarpark(requestL);
			Iterator<SpacesResponse> responseS = blockingStub.getAvailSpaces(requestS);
			
			logger.info("Access Request Started..");
			System.out.println(response.getMessage());
			logger.info("Leave Request Started..");
			System.out.println(responseL.getMessage());
			logger.info("Getting Spaces Started..");

			while (responseS.hasNext()) {
				Thread.sleep(1000);
			    SpacesResponse singleResponse = responseS.next();
			    System.out.println("Available Parking Bays: " + singleResponse.getMessage());
			}
			
			
			
			
		}
		catch(StatusRuntimeException e) {
			logger.log(Level.WARNING, "RCP failed: (0)", e.getStatus());
		}
		finally {
			channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
		}
	}
}