package resources.service;


import java.util.logging.Level;
import java.util.logging.Logger;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import resources.service.resourcesServicesGrpc.resourcesServicesStub;

public class ResourcesClient {
	private static final Logger logger = Logger.getLogger(ResourcesClient.class.getName());
	private static resourcesServicesStub asyncStub;
	public static void main(String[] args) throws Exception{
		String host = "localhost";
		int port = 50052;
		
		ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
		asyncStub = resourcesServicesGrpc.newStub(channel);
		
		
		wifiPrinting();
		roomAvailability();
		
	}
	
		

	private static void wifiPrinting () throws InterruptedException {
		logger.info("wifiPrinting Started..");
		StreamObserver<PrintResponse> responseObserver = new StreamObserver<PrintResponse>() {

		@Override
		public void onNext(PrintResponse response) {
			// TODO Auto-generated method stub
			System.out.println("Document ID: "+ response.getDocId());
			System.out.println("Print status: "+ response.getIsPrinted());
			
		}

		@Override
		public void onError(Throwable t) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onCompleted() {
			// TODO Auto-generated method stub
			System.out.println("Finished requesting documents");
		}
	};
		StreamObserver<PrintRequest> requestObserver = asyncStub.wifiPrinting(responseObserver);
		
		try {
			requestObserver.onNext(PrintRequest.newBuilder().setDocId(1).build());
			Thread.sleep(1000);
			requestObserver.onNext(PrintRequest.newBuilder().setDocId(2).build());
			Thread.sleep(1000);
			requestObserver.onNext(PrintRequest.newBuilder().setDocId(3).build());
			Thread.sleep(1000);
			requestObserver.onNext(PrintRequest.newBuilder().setDocId(4).build());
			Thread.sleep(1000);
			requestObserver.onNext(PrintRequest.newBuilder().setDocId(5).build());
			Thread.sleep(1000);
			
			requestObserver.onCompleted();
			Thread.sleep(1000);
		}
		catch(StatusRuntimeException e) {
			logger.log(Level.WARNING, "RCP failed: (0)", e.getStatus());
		}
	}
	
	
	
	private static void roomAvailability() throws InterruptedException {
		logger.info("roomAvailability Started..");
		StreamObserver<RoomResponse> responseObserver = new StreamObserver<RoomResponse>() {
			
			@Override
			public void onNext(RoomResponse response) {
				// TODO Auto-generated method stub
				System.out.println("Room status: "+ response.getRoomStatus());
				
				
			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onCompleted() {
				// TODO Auto-generated method stub
				System.out.println("Finished requesting rooms.");
			}
		};
		StreamObserver<RoomRequest> requestObserver = asyncStub.roomAvailability(responseObserver);
		
		try {
			requestObserver.onNext(RoomRequest.newBuilder().setRoomNumber(1).build());
			Thread.sleep(500);
			requestObserver.onNext(RoomRequest.newBuilder().setRoomNumber(2).build());
			Thread.sleep(500);
			requestObserver.onNext(RoomRequest.newBuilder().setRoomNumber(3).build());
			Thread.sleep(500);
			requestObserver.onNext(RoomRequest.newBuilder().setRoomNumber(4).build());
			Thread.sleep(500);
			requestObserver.onNext(RoomRequest.newBuilder().setRoomNumber(5).build());
			Thread.sleep(500);
			requestObserver.onNext(RoomRequest.newBuilder().setRoomNumber(2).build());
			Thread.sleep(500);
			requestObserver.onNext(RoomRequest.newBuilder().setRoomNumber(4).build());
			Thread.sleep(500);
			requestObserver.onNext(RoomRequest.newBuilder().setRoomNumber(6).build());
			Thread.sleep(500);
			
			requestObserver.onCompleted();
			Thread.sleep(1000);
		}
		catch(StatusRuntimeException e) {
			logger.log(Level.WARNING, "RCP failed: (0)", e.getStatus());
		}
	}
}