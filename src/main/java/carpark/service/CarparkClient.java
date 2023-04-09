package carpark.service;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import carpark.service.carparkServicesGrpc.carparkServicesBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

public class CarparkClient {
	private static final Logger logger = Logger.getLogger(CarparkClient.class.getName());
	public static void main(String[] args) throws Exception {
		String host = "localhost";
		int port = 50051;
		
		ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
		
		carparkServicesBlockingStub blockingStub = carparkServicesGrpc.newBlockingStub(channel);
		CarparkClient client = new CarparkClient();
		
		
		try {
			String idNumber = "2";
			AccessRequest request = AccessRequest.newBuilder().setIdNumber(idNumber).build();
			AccessResponse response = blockingStub.accessCarpark(request);
			logger.info("Client Side Started..");
			logger.info(response.getMessage());
		}
		catch(StatusRuntimeException e) {
			logger.log(Level.WARNING, "RCP failed: (0)", e.getStatus());
		}
		finally {
			channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
		}
	}
}