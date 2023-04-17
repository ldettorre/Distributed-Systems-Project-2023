package carpark.service;

import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import carpark.service.carparkServicesGrpc.carparkServicesBlockingStub;
import carpark.service.carparkServicesGrpc.carparkServicesStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

public class CarparkClient {
	private static final Logger logger = Logger.getLogger(CarparkClient.class.getName());
	private static carparkServicesBlockingStub blockingStub;
	private static carparkServicesStub asyncStub;
	public static void main(String[] args) throws Exception {
		String host = "localhost";
		int port = 50051;
		
		ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
		
		
		
		blockingStub = carparkServicesGrpc.newBlockingStub(channel);
		asyncStub = carparkServicesGrpc.newStub(channel);
		CarparkClient client = new CarparkClient();
		
		accessCarpark();
		leaveCarpark();
		getAvailSpaces();
		getSumAvailSpaces();
	}
	
	private static void accessCarpark() {
		String idNumber = "2";
		AccessRequest request = AccessRequest.newBuilder().setIdNumber(idNumber).build();
		AccessResponse response = blockingStub.accessCarpark(request);
		logger.info("Access Request Started..");
		System.out.println("Requesting access for ID: "+ request.getIdNumber());
	}
	
	
	public static void leaveCarpark() {
		LeaveRequest requestL = LeaveRequest.newBuilder().build();
		logger.info("Access Request Started..");
		LeaveResponse responseL = blockingStub.leaveCarpark(requestL);
		System.out.println(responseL.getMessage());
	}	
	
	
	public static void getAvailSpaces() throws InterruptedException {
		SpacesRequest requestS = SpacesRequest.newBuilder().build();
		Iterator<SpacesResponse> responseS = blockingStub.getAvailSpaces(requestS);
		
		while (responseS.hasNext()) {
			Thread.sleep(1000);
		    SpacesResponse singleResponse = responseS.next();
		    System.out.println("Available Parking Bays: " + singleResponse.getMessage());
		}
	}
	
	public static void getSumAvailSpaces() throws InterruptedException {
		StreamObserver<AvailResponse> responseObserver = new StreamObserver<AvailResponse>() {

			@Override
			public void onNext(AvailResponse sumAvail) {
				// TODO Auto-generated method stub
				System.out.println("Number of available parking spaces: " + sumAvail.getSumAvail());
			}
	
			@Override
			public void onCompleted() {
				// TODO Auto-generated method stub
				logger.info("Finished client side streaming sum of available spaces.");
			}
	
			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub
				logger.info("Error with client side stream method");
			}
		};
		
		StreamObserver<AvailRequest> requestObserver = asyncStub.getSumAvailSpaces(responseObserver);
		
		Boolean[] availStatuses = {true, true, false, false, true};
		try {
			for(int i=0;i<availStatuses.length;i++) {
				AvailRequest requestA = AvailRequest.newBuilder().setIsAvail(availStatuses[i]).build();
				requestObserver.onNext(requestA);
				Thread.sleep(500);
			}
		requestObserver.onCompleted();
		}
		catch(StatusRuntimeException e) {
			logger.log(Level.WARNING, "RCP failed: (0)", e.getStatus());
		}
	}
	
		
		
	}
