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
            System.out.println(outcome);
        }
		AccessResponse response = AccessResponse.newBuilder().setMessage(outcome).build();
		responseObserver.onNext(response);
	    responseObserver.onCompleted();
		
	}
	
	@Override
	public void leaveCarpark(LeaveRequest request, StreamObserver<LeaveResponse> responseObserver) {
		logger.info("Recieving Leave Request..");
		LeaveResponse response = LeaveResponse.newBuilder().setMessage("You are leaving... ").build();
		responseObserver.onNext(response);
	     
	    responseObserver.onCompleted();
	}
	
	@Override
	public void getAvailSpaces(SpacesRequest request, StreamObserver<SpacesResponse> responseObserver) {
		logger.info("Recieving Spaces Request..");
		// Below is a hardcoded fictional array of parking space available
		// Each int represents a parking space id
		int[] parkingSpaces = new int[] { 112, 213, 13, 98, 5 };
		for(int i=0;i<parkingSpaces.length;i++) {
			int space = parkingSpaces[i];
			SpacesResponse response = SpacesResponse.newBuilder().setMessage(space).build();
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