package resources.service;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import resources.service.resourcesServicesGrpc.resourcesServicesBlockingStub;

public class ResourcesClient {
	private static final Logger logger = Logger.getLogger(ResourcesClient.class.getName());
	public static void main(String[] args) throws Exception{
		String host = "localhost";
		int port = 50052;
		
		ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
		resourcesServicesBlockingStub blockingStub = resourcesServicesGrpc.newBlockingStub(channel);
		
		try {
			String input = "test input";
			logger.info("TestMethod request being made...");
			TestRequest request = TestRequest.newBuilder().setInput(input).build();
			
			TestResponse response = blockingStub.testMethod(request);
			
			logger.info("TestMethod Response:");
			System.out.println(response.getOutput());
		}
		catch(StatusRuntimeException e) {
			logger.log(Level.WARNING, "RCP failed: (0)", e.getStatus());
		}
		finally {
			channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
		}
	}
}