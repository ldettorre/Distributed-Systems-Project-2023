package resources.service;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

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
	
//	@Override
//	public void wifiPrinting(PrintRequest request, StreamObserver<PrintResponse> responseObserver) {
//		System.out.println("Recieving wifiPrinting request");
//		String docId = request.getDocId();
//		PrintResponse response = PrintResponse.newBuilder().setIsPrinted("Yes.").setDocId(docId).build();
//		responseObserver.onNext(response);
//		responseObserver.onCompleted();
//		System.out.println("wifiPrinting response sent.");
//	}
}