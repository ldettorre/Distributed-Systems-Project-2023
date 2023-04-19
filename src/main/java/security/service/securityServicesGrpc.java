package security.service;

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
    comments = "Source: security.proto")
public final class securityServicesGrpc {

  private securityServicesGrpc() {}

  public static final String SERVICE_NAME = "security.securityServices";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<security.service.UnlockRequest,
      security.service.UnlockResponse> getUnlockDoorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UnlockDoor",
      requestType = security.service.UnlockRequest.class,
      responseType = security.service.UnlockResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<security.service.UnlockRequest,
      security.service.UnlockResponse> getUnlockDoorMethod() {
    io.grpc.MethodDescriptor<security.service.UnlockRequest, security.service.UnlockResponse> getUnlockDoorMethod;
    if ((getUnlockDoorMethod = securityServicesGrpc.getUnlockDoorMethod) == null) {
      synchronized (securityServicesGrpc.class) {
        if ((getUnlockDoorMethod = securityServicesGrpc.getUnlockDoorMethod) == null) {
          securityServicesGrpc.getUnlockDoorMethod = getUnlockDoorMethod = 
              io.grpc.MethodDescriptor.<security.service.UnlockRequest, security.service.UnlockResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "security.securityServices", "UnlockDoor"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  security.service.UnlockRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  security.service.UnlockResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new securityServicesMethodDescriptorSupplier("UnlockDoor"))
                  .build();
          }
        }
     }
     return getUnlockDoorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<security.service.EmUnlockRequest,
      security.service.EmUnlockResponse> getEmergencyUnlockMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "EmergencyUnlock",
      requestType = security.service.EmUnlockRequest.class,
      responseType = security.service.EmUnlockResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<security.service.EmUnlockRequest,
      security.service.EmUnlockResponse> getEmergencyUnlockMethod() {
    io.grpc.MethodDescriptor<security.service.EmUnlockRequest, security.service.EmUnlockResponse> getEmergencyUnlockMethod;
    if ((getEmergencyUnlockMethod = securityServicesGrpc.getEmergencyUnlockMethod) == null) {
      synchronized (securityServicesGrpc.class) {
        if ((getEmergencyUnlockMethod = securityServicesGrpc.getEmergencyUnlockMethod) == null) {
          securityServicesGrpc.getEmergencyUnlockMethod = getEmergencyUnlockMethod = 
              io.grpc.MethodDescriptor.<security.service.EmUnlockRequest, security.service.EmUnlockResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "security.securityServices", "EmergencyUnlock"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  security.service.EmUnlockRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  security.service.EmUnlockResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new securityServicesMethodDescriptorSupplier("EmergencyUnlock"))
                  .build();
          }
        }
     }
     return getEmergencyUnlockMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static securityServicesStub newStub(io.grpc.Channel channel) {
    return new securityServicesStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static securityServicesBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new securityServicesBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static securityServicesFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new securityServicesFutureStub(channel);
  }

  /**
   */
  public static abstract class securityServicesImplBase implements io.grpc.BindableService {

    /**
     */
    public void unlockDoor(security.service.UnlockRequest request,
        io.grpc.stub.StreamObserver<security.service.UnlockResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getUnlockDoorMethod(), responseObserver);
    }

    /**
     */
    public void emergencyUnlock(security.service.EmUnlockRequest request,
        io.grpc.stub.StreamObserver<security.service.EmUnlockResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getEmergencyUnlockMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getUnlockDoorMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                security.service.UnlockRequest,
                security.service.UnlockResponse>(
                  this, METHODID_UNLOCK_DOOR)))
          .addMethod(
            getEmergencyUnlockMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                security.service.EmUnlockRequest,
                security.service.EmUnlockResponse>(
                  this, METHODID_EMERGENCY_UNLOCK)))
          .build();
    }
  }

  /**
   */
  public static final class securityServicesStub extends io.grpc.stub.AbstractStub<securityServicesStub> {
    private securityServicesStub(io.grpc.Channel channel) {
      super(channel);
    }

    private securityServicesStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected securityServicesStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new securityServicesStub(channel, callOptions);
    }

    /**
     */
    public void unlockDoor(security.service.UnlockRequest request,
        io.grpc.stub.StreamObserver<security.service.UnlockResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUnlockDoorMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void emergencyUnlock(security.service.EmUnlockRequest request,
        io.grpc.stub.StreamObserver<security.service.EmUnlockResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getEmergencyUnlockMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class securityServicesBlockingStub extends io.grpc.stub.AbstractStub<securityServicesBlockingStub> {
    private securityServicesBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private securityServicesBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected securityServicesBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new securityServicesBlockingStub(channel, callOptions);
    }

    /**
     */
    public security.service.UnlockResponse unlockDoor(security.service.UnlockRequest request) {
      return blockingUnaryCall(
          getChannel(), getUnlockDoorMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<security.service.EmUnlockResponse> emergencyUnlock(
        security.service.EmUnlockRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getEmergencyUnlockMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class securityServicesFutureStub extends io.grpc.stub.AbstractStub<securityServicesFutureStub> {
    private securityServicesFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private securityServicesFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected securityServicesFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new securityServicesFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<security.service.UnlockResponse> unlockDoor(
        security.service.UnlockRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUnlockDoorMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_UNLOCK_DOOR = 0;
  private static final int METHODID_EMERGENCY_UNLOCK = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final securityServicesImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(securityServicesImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_UNLOCK_DOOR:
          serviceImpl.unlockDoor((security.service.UnlockRequest) request,
              (io.grpc.stub.StreamObserver<security.service.UnlockResponse>) responseObserver);
          break;
        case METHODID_EMERGENCY_UNLOCK:
          serviceImpl.emergencyUnlock((security.service.EmUnlockRequest) request,
              (io.grpc.stub.StreamObserver<security.service.EmUnlockResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class securityServicesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    securityServicesBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return security.service.SecurityImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("securityServices");
    }
  }

  private static final class securityServicesFileDescriptorSupplier
      extends securityServicesBaseDescriptorSupplier {
    securityServicesFileDescriptorSupplier() {}
  }

  private static final class securityServicesMethodDescriptorSupplier
      extends securityServicesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    securityServicesMethodDescriptorSupplier(String methodName) {
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
      synchronized (securityServicesGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new securityServicesFileDescriptorSupplier())
              .addMethod(getUnlockDoorMethod())
              .addMethod(getEmergencyUnlockMethod())
              .build();
        }
      }
    }
    return result;
  }
}
