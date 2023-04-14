package carpark.service;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import carpark.service.carparkServicesGrpc.carparkServicesImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.ServerServiceDefinition;
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
			server.awaitTermination();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    logger.info("Server started, listening on " + port);
	    		    
	}
	
	@Override
	public void accessCarpark(AccessRequest request, StreamObserver<AccessResponse> responseObserver) {
		System.out.println("Recieving Access Request");
		String idPresented = request.getIdNumber();
		String outcome = "";
		if(Integer.parseInt(idPresented) % 2 ==0){
			outcome += "Valid ID :"+request.getIdNumber()+" Access Granted";
		}
		else {
			outcome += "ID :"+request.getIdNumber()+" is not valid.\n Access Denied.";
		}
		AccessResponse response = AccessResponse.newBuilder().setMessage(outcome).build();
		responseObserver.onNext(response);
	     
	    responseObserver.onCompleted();
	}
	
	@Override
	public void leaveCarpark(LeaveRequest request, StreamObserver<LeaveResponse> responseObserver) {
		System.out.println("Recieving Leave Request");
		LeaveResponse response = LeaveResponse.newBuilder().setMessage("You are leaving... ").build();
		responseObserver.onNext(response);
	     
	    responseObserver.onCompleted();
	}
	
	@Override
	public void getAvailSpaces(SpacesRequest request, StreamObserver<SpacesResponse> responseObserver) {
		System.out.println("Recieving Spaces Request");
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
		System.out.println("Recieving Sum of Available Spaces Request");
	return new StreamObserver<AvailRequest>() {
		int availSpaces = 0;
		@Override
		public void onNext(AvailRequest isAvail) {
			// TODO Auto-generated method stub
			System.out.println("Is this spot available: "+isAvail.getIsAvail());
			if(isAvail.getIsAvail() == true) {
				availSpaces +=1;
			}
		}
		
		@Override
		public void onError(Throwable t) {
			// TODO Auto-generated method stub
			logger.info("Error occured with getSumAvailSpaces on server file.");
		}

		@Override
		public void onCompleted() {
			// TODO Auto-generated method stub
			AvailResponse response = AvailResponse.newBuilder().setSumAvail(availSpaces).build();
			responseObserver.onNext(response);
			responseObserver.onCompleted();
		}
		
		};
		
	}
}