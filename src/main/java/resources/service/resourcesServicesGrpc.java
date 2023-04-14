package resources.service;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: resources.proto")
public final class resourcesServicesGrpc {

  private resourcesServicesGrpc() {}

  public static final String SERVICE_NAME = "resources.resourcesServices";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<resources.service.PrintRequest,
      resources.service.PrintResponse> getWifiPrintingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "WifiPrinting",
      requestType = resources.service.PrintRequest.class,
      responseType = resources.service.PrintResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<resources.service.PrintRequest,
      resources.service.PrintResponse> getWifiPrintingMethod() {
    io.grpc.MethodDescriptor<resources.service.PrintRequest, resources.service.PrintResponse> getWifiPrintingMethod;
    if ((getWifiPrintingMethod = resourcesServicesGrpc.getWifiPrintingMethod) == null) {
      synchronized (resourcesServicesGrpc.class) {
        if ((getWifiPrintingMethod = resourcesServicesGrpc.getWifiPrintingMethod) == null) {
          resourcesServicesGrpc.getWifiPrintingMethod = getWifiPrintingMethod = 
              io.grpc.MethodDescriptor.<resources.service.PrintRequest, resources.service.PrintResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "resources.resourcesServices", "WifiPrinting"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  resources.service.PrintRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  resources.service.PrintResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new resourcesServicesMethodDescriptorSupplier("WifiPrinting"))
                  .build();
          }
        }
     }
     return getWifiPrintingMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static resourcesServicesStub newStub(io.grpc.Channel channel) {
    return new resourcesServicesStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static resourcesServicesBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new resourcesServicesBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static resourcesServicesFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new resourcesServicesFutureStub(channel);
  }

  /**
   */
  public static abstract class resourcesServicesImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<resources.service.PrintRequest> wifiPrinting(
        io.grpc.stub.StreamObserver<resources.service.PrintResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getWifiPrintingMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getWifiPrintingMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                resources.service.PrintRequest,
                resources.service.PrintResponse>(
                  this, METHODID_WIFI_PRINTING)))
          .build();
    }
  }

  /**
   */
  public static final class resourcesServicesStub extends io.grpc.stub.AbstractStub<resourcesServicesStub> {
    private resourcesServicesStub(io.grpc.Channel channel) {
      super(channel);
    }

    private resourcesServicesStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected resourcesServicesStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new resourcesServicesStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<resources.service.PrintRequest> wifiPrinting(
        io.grpc.stub.StreamObserver<resources.service.PrintResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getWifiPrintingMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class resourcesServicesBlockingStub extends io.grpc.stub.AbstractStub<resourcesServicesBlockingStub> {
    private resourcesServicesBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private resourcesServicesBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected resourcesServicesBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new resourcesServicesBlockingStub(channel, callOptions);
    }
  }

  /**
   */
  public static final class resourcesServicesFutureStub extends io.grpc.stub.AbstractStub<resourcesServicesFutureStub> {
    private resourcesServicesFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private resourcesServicesFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected resourcesServicesFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new resourcesServicesFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_WIFI_PRINTING = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final resourcesServicesImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(resourcesServicesImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_WIFI_PRINTING:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.wifiPrinting(
              (io.grpc.stub.StreamObserver<resources.service.PrintResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class resourcesServicesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    resourcesServicesBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return resources.service.ResourcesImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("resourcesServices");
    }
  }

  private static final class resourcesServicesFileDescriptorSupplier
      extends resourcesServicesBaseDescriptorSupplier {
    resourcesServicesFileDescriptorSupplier() {}
  }

  private static final class resourcesServicesMethodDescriptorSupplier
      extends resourcesServicesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    resourcesServicesMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (resourcesServicesGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new resourcesServicesFileDescriptorSupplier())
              .addMethod(getWifiPrintingMethod())
              .build();
        }
      }
    }
    return result;
  }
}
