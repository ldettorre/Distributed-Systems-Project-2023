package resources.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;
import resources.service.resourcesServicesGrpc.resourcesServicesImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class ResourcesServer extends resourcesServicesImplBase{
	
	private static final Logger logger = Logger.getLogger(ResourcesServer.class.getName());
	
	public static void main(String[] args) {
		
		ResourcesServer resourcesServices = new ResourcesServer();
		
		int port = 50052;
		
		try {
			Server server = ServerBuilder.forPort(port)
					.addService(resourcesServices)
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
	public StreamObserver<PrintRequest> wifiPrinting(StreamObserver<PrintResponse> responseObserver){
		return new StreamObserver<PrintRequest>() {
		ArrayList<Integer> docsToPrint = new ArrayList<Integer>();
			@Override
			public void onNext(PrintRequest request) {
				// TODO Auto-generated method stub
				docsToPrint.add(request.getDocId());
				System.out.println("Document ID: "+ request.getDocId()+ " is printing..");
				int documentPrinting = request.getDocId();
				PrintResponse response = PrintResponse.newBuilder().setIsPrinted("Printing complete.").setDocId(documentPrinting).build();
				responseObserver.onNext(response);
			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub
				logger.info("Error occured with wifiPrinting on server file.");
				
			}

			@Override
			public void onCompleted() {
				// TODO Auto-generated method stub
				System.out.println("Finished printing " + docsToPrint.size() + " documents");
				responseObserver.onCompleted();
				
			}
		};
	}
	
	@Override
	public StreamObserver<RoomRequest> roomAvailability(StreamObserver<RoomResponse> responseObserver){
		return new StreamObserver<RoomRequest>() {
			@Override
			public void onNext(RoomRequest request) {
				// TODO Auto-generated method stub
				System.out.println("Room selected "+ request.getRoomNumber());
				RoomResponse response = RoomResponse.newBuilder().setRoomStatus("Booked").build();
				responseObserver.onNext(response);
			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub
				logger.info("Error occured with roomAvailability on server file.");
				
			}

			@Override
			public void onCompleted() {
				// TODO Auto-generated method stub
				System.out.println("Room availability stream finished.");
				responseObserver.onCompleted();
				
			}
		};
	}
}