package resources.service;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import carpark.service.AvailRequest;
import carpark.service.AvailResponse;
import carpark.service.carparkServicesGrpc;
import carpark.service.carparkServicesGrpc.carparkServicesStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import resources.service.resourcesServicesGrpc.resourcesServicesStub;

public class ResourcesClient {
	private static final Logger logger = Logger.getLogger(ResourcesClient.class.getName());
	public static void main(String[] args) throws Exception{
		String host = "localhost";
		int port = 50052;
		
		ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
		resourcesServicesStub stub = resourcesServicesGrpc.newStub(channel);
		
//		try {
//			String docId = "12345";
//			logger.info("wifiPrinting request being made...");
//			PrintRequest request = PrintRequest.newBuilder().setDocId(docId).build();
//			
//			PrintResponse response = stub.wifiPrinting(request);
//			
//			logger.info("wifiPrinting Response:");
//			System.out.println(response.getDocId());
//			System.out.println(response.getIsPrinted());
//		}
//		catch(StatusRuntimeException e) {
//			logger.log(Level.WARNING, "RCP failed: (0)", e.getStatus());
//		}
//		finally {
//			channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
//		}
		try {
		StreamObserver<PrintRequest> requestObserver = stub.wifiPrinting(new StreamObserver<PrintResponse>() {

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
				
			}
		});
		
		Integer[] docsToPrint = {21,22,23,24,25,26};
		for(int numDocs=0; numDocs<docsToPrint.length; numDocs++) {
			PrintRequest request = PrintRequest.newBuilder().setDocId(docsToPrint[numDocs]).build();
			requestObserver.onNext(request);
			System.out.println("Sending Doc ID: "+request.getDocId() + " to print..");
			Thread.sleep(500);
		}
		requestObserver.onCompleted();
		
		}
		catch(StatusRuntimeException e) {
			logger.log(Level.WARNING, "RCP failed: (0)", e.getStatus());
		}
		finally {
			channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
		}
	}
}