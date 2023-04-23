package carpark.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;
import carpark.service.carparkServicesGrpc.carparkServicesImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class CarparkServer extends carparkServicesImplBase{
	
	private static final Logger logger = Logger.getLogger(CarparkServer.class.getName());
	
	public static void main(String[] args) {
		
		CarparkServer carparkServices = new CarparkServer();
		
		int port = 50051;
		
		try {
			Server server = ServerBuilder.forPort(port)
					.addService(carparkServices)
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
	public void accessCarpark(AccessRequest request, StreamObserver<AccessResponse> responseObserver) {
		logger.info("Recieving Access Request..");
		String idPresented = request.getIdNumber();
		String outcome = "";
		
		try {
			if(Integer.parseInt(idPresented) % 2 ==0){
				outcome += "Access Granted";
			}
			else {
				outcome += "Access Denied.";
			}
		}
		catch (NumberFormatException e) {
			outcome = "Error! ID's only contain numbers.";
        }
		System.out.println(outcome);
		AccessResponse response = AccessResponse.newBuilder().setMessage(outcome).build();
		responseObserver.onNext(response);
	    responseObserver.onCompleted();
		
	}
	
	@Override
	public void leaveCarpark(LeaveRequest request, StreamObserver<LeaveResponse> responseObserver) {
		logger.info("Recieving Leave Request..");
		LeaveResponse response = LeaveResponse.newBuilder().setMessage("Caution: Barrier Lifting. ").build();
		responseObserver.onNext(response);
	     
	    responseObserver.onCompleted();
	}
	
	@Override
	public void getAvailSpaces(SpacesRequest request, StreamObserver<SpacesResponse> responseObserver) {
		logger.info("Recieving Spaces Request..");
		
		ArrayList<Integer> parkingSpaces = new ArrayList<Integer>();
		int minParkingId = 1;  
		int maxParkingId= 20;  
		
		int minNumSpaces = 0;
		int maxNumSpaces = 20;
		int randomNumOfSpaces = (int)(Math.random()*(maxNumSpaces-minNumSpaces+1)+minNumSpaces);
		
		/* The logic below is to simulates a random number of spaces available and adds random
		 * parking space Id's to a list.
		 * This is to simulate real life parking spaces becoming available and occupied.
		 */
		for(int i=0; i<randomNumOfSpaces; i++) {
			int randomParkingId = (int)(Math.random()*(maxParkingId-minParkingId+1)+minParkingId);
			if(!parkingSpaces.contains(randomParkingId)) {
				parkingSpaces.add(randomParkingId);
				System.out.println("Parking Bay: "+randomParkingId + " is available.");
			}
		}
		
		/* I then use a for loop to start streaming those spaces back to the GUI */
		if(parkingSpaces.size()==0) {
			SpacesResponse response = SpacesResponse.newBuilder().setMessage("No Bays Available.").build();
			responseObserver.onNext(response);
		}
		for(int k=0; k<parkingSpaces.size(); k++) {
			SpacesResponse response = SpacesResponse.newBuilder().setMessage("Parking Bay: "+parkingSpaces.get(k)).build();
			responseObserver.onNext(response);
		}
		responseObserver.onCompleted();
	}
	
	
	@Override
	public StreamObserver<AvailRequest> getSumAvailSpaces(final StreamObserver<AvailResponse> responseObserver) {
		logger.info("Recieving Sum of Available Spaces Request");
		return new StreamObserver<AvailRequest>() {
			int availSpaces = 0;
			ArrayList<Boolean> availStatuses = new ArrayList<Boolean>();
			
			@Override
			public void onNext(AvailRequest request) {
				// TODO Auto-generated method stub
				System.out.println("Is this spot available: "+request.getIsAvail());
				availStatuses.add(request.getIsAvail());
			}
			
			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub
				logger.info("Error occured with getSumAvailSpaces on server file.");
			}
	
			@Override
			public void onCompleted() {
				// TODO Auto-generated method stub
				for(int i=0;i<availStatuses.size();i++) {
					if(availStatuses.get(i) == true) {
						availSpaces +=1;
					}
				}
				AvailResponse response = AvailResponse.newBuilder().setSumAvail(availSpaces).build();
				System.out.println("Number of available spaces: "+ response.getSumAvail());
				responseObserver.onNext(response);
				responseObserver.onCompleted();
			}
			
		};
		
	}
}