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
		StreamObserver<PrintRequest> requestObserver = stub.wifiPrinting(new StreamObserver<PrintResponse>() {

			@Override
			public void onNext(PrintResponse value) {
				// TODO Auto-generated method stub
				
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
	}
}