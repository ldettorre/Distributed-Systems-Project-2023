//package carpark.service;
//
//import java.util.Iterator;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//import carpark.service.carparkServicesGrpc.carparkServicesBlockingStub;
//import carpark.service.carparkServicesGrpc.carparkServicesStub;
//import io.grpc.ManagedChannel;
//import io.grpc.ManagedChannelBuilder;
//import io.grpc.StatusRuntimeException;
//import io.grpc.stub.StreamObserver;
//
//public class CarparkClient {
//	private static final Logger logger = Logger.getLogger(CarparkClient.class.getName());
//	private static carparkServicesBlockingStub blockingStub;
//	private static carparkServicesStub asyncStub;
//	public static void main(String[] args) throws Exception {
//		String host = "localhost";
//		int port = 50051;
//		
//		ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
//		
//		
//		
//		blockingStub = carparkServicesGrpc.newBlockingStub(channel);
//		asyncStub = carparkServicesGrpc.newStub(channel);
//		CarparkClient client = new CarparkClient();
		
//		accessCarpark();
//		leaveCarpark();
//		getAvailSpaces();
//		getSumAvailSpaces();
//	}
	
	// Unary
//	public static void accessCarpark() {
//		logger.info("accessCarpark Started..");
////		String idNumber = "2";
//		AccessRequest request = AccessRequest.newBuilder().setIdNumber().build();
//		AccessResponse response = blockingStub.accessCarpark(request);
//		System.out.println("Requesting access for ID: "+ response.getMessage());
//	}
	
	
	
	// Unary
//	public static void leaveCarpark() {
//		logger.info("leaveCarpark Started..");
//		LeaveRequest request = LeaveRequest.newBuilder().build();
//		LeaveResponse response = blockingStub.leaveCarpark(request);
//		System.out.println(response.getMessage());
//	}	
	
	
	
	// Server Streaming
//	public static void getAvailSpaces() throws InterruptedException {
//		logger.info("getAvailSpaces Started..");
//		SpacesRequest request = SpacesRequest.newBuilder().build();
//		Iterator<SpacesResponse> response = blockingStub.getAvailSpaces(request);
//		
//		while (response.hasNext()) {
//			Thread.sleep(1000);
//		    SpacesResponse singleResponse = response.next();
//		    System.out.println("Parking Spot: " + singleResponse.getMessage());
//		}
//	}
	
	
	
	// Client Streaming
//	public static void getSumAvailSpaces() throws InterruptedException {
//		logger.info("getSumAvailSpaces Started..");
//		StreamObserver<AvailResponse> responseObserver = new StreamObserver<AvailResponse>() {
//
//			@Override
//			public void onNext(AvailResponse response) {
//				// TODO Auto-generated method stub
//				System.out.println("Number of available parking spaces: " + response.getSumAvail());
//			}
//	
//			@Override
//			public void onError(Throwable t) {
//				// TODO Auto-generated method stub
//				logger.info("Error with getSumAvailSpaces client stream method");
//			}
//			
//			@Override
//			public void onCompleted() {
//				// TODO Auto-generated method stub
//				logger.info("Finished client streaming sum of available spaces.");
//			}
//		};
//		
//		StreamObserver<AvailRequest> requestObserver = asyncStub.getSumAvailSpaces(responseObserver);
//		
//		Boolean[] availStatuses = {true, true, false, false, true, false, true, true};
//		try {
//			for(int i=0;i<availStatuses.length;i++) {
//				AvailRequest request = AvailRequest.newBuilder().setIsAvail(availStatuses[i]).build();
//				requestObserver.onNext(request);
//				Thread.sleep(500);
//			}
//			requestObserver.onCompleted();
//			Thread.sleep(5000);
//		}
//		catch(StatusRuntimeException e) {
//			logger.log(Level.WARNING, "RCP failed: (0)", e.getStatus());
//		}
//	}
//	
//}
