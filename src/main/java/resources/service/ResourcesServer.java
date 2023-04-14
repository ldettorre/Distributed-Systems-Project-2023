package resources.service;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import carpark.service.AvailRequest;
import resources.service.resourcesServicesGrpc.resourcesServicesImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.ServerServiceDefinition;
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
	public StreamObserver<PrintRequest> wifiPrinting(final StreamObserver<PrintResponse> responseObserver){
		return new StreamObserver<PrintRequest>() {
		
			@Override
			public void onNext(PrintRequest request) {
				// TODO Auto-generated method stub
				System.out.println("Document ID: "+ request.getDocId()+ " is printing..");
				
			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub
				logger.info("Error occured with wifiPrinting on server file.");
				
			}

			@Override
			public void onCompleted() {
				// TODO Auto-generated method stub
				PrintResponse response = PrintResponse.newBuilder()
						.setIsPrinted("Printing Complete")
						.build();
				responseObserver.onNext(response);
				responseObserver.onCompleted();
				
			}
		};
	}
}