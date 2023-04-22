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
		logger.info("Receiving Print Requests..");
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
		logger.info("Receiving Room Requests..");
		return new StreamObserver<RoomRequest>() {
			
			ArrayList<Integer> bookedRooms = new ArrayList<Integer>();
			String status = "";
			@Override
			public void onNext(RoomRequest request) {
				// TODO Auto-generated method stub
				System.out.println("Requesting booking for room: "+request.getRoomNumber());
				if(bookedRooms.contains(request.getRoomNumber())){
					System.out.println("Room Unavailable.");
					status = "This room is not available.";
					
				}
				else {
					bookedRooms.add(request.getRoomNumber());
					System.out.println("Room Available.");
					status = "This room has been booked successfully.";
				}
				RoomResponse response = RoomResponse.newBuilder().setRoomStatus(status).build();
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