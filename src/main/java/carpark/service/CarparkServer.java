package carpark.service;

import java.io.IOException;
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
		AccessResponse response = AccessResponse.newBuilder().setMessage("Message returned. "+ request.getIdNumber()).build();
		responseObserver.onNext(response);
	     
	    responseObserver.onCompleted();
	}
}