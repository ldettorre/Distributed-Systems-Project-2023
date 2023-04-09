package carpark.service;

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
    comments = "Source: carpark.proto")
public final class carparkServicesGrpc {

  private carparkServicesGrpc() {}

  public static final String SERVICE_NAME = "carpark.carparkServices";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<carpark.service.AccessRequest,
      carpark.service.AccessResponse> getAccessCarparkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AccessCarpark",
      requestType = carpark.service.AccessRequest.class,
      responseType = carpark.service.AccessResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<carpark.service.AccessRequest,
      carpark.service.AccessResponse> getAccessCarparkMethod() {
    io.grpc.MethodDescriptor<carpark.service.AccessRequest, carpark.service.AccessResponse> getAccessCarparkMethod;
    if ((getAccessCarparkMethod = carparkServicesGrpc.getAccessCarparkMethod) == null) {
      synchronized (carparkServicesGrpc.class) {
        if ((getAccessCarparkMethod = carparkServicesGrpc.getAccessCarparkMethod) == null) {
          carparkServicesGrpc.getAccessCarparkMethod = getAccessCarparkMethod = 
              io.grpc.MethodDescriptor.<carpark.service.AccessRequest, carpark.service.AccessResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "carpark.carparkServices", "AccessCarpark"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  carpark.service.AccessRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  carpark.service.AccessResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new carparkServicesMethodDescriptorSupplier("AccessCarpark"))
                  .build();
          }
        }
     }
     return getAccessCarparkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<carpark.service.LeaveRequest,
      carpark.service.LeaveResponse> getLeaveCarparkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "LeaveCarpark",
      requestType = carpark.service.LeaveRequest.class,
      responseType = carpark.service.LeaveResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<carpark.service.LeaveRequest,
      carpark.service.LeaveResponse> getLeaveCarparkMethod() {
    io.grpc.MethodDescriptor<carpark.service.LeaveRequest, carpark.service.LeaveResponse> getLeaveCarparkMethod;
    if ((getLeaveCarparkMethod = carparkServicesGrpc.getLeaveCarparkMethod) == null) {
      synchronized (carparkServicesGrpc.class) {
        if ((getLeaveCarparkMethod = carparkServicesGrpc.getLeaveCarparkMethod) == null) {
          carparkServicesGrpc.getLeaveCarparkMethod = getLeaveCarparkMethod = 
              io.grpc.MethodDescriptor.<carpark.service.LeaveRequest, carpark.service.LeaveResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "carpark.carparkServices", "LeaveCarpark"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  carpark.service.LeaveRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  carpark.service.LeaveResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new carparkServicesMethodDescriptorSupplier("LeaveCarpark"))
                  .build();
          }
        }
     }
     return getLeaveCarparkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<carpark.service.SpacesRequest,
      carpark.service.SpacesResponse> getGetAvailSpacesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAvailSpaces",
      requestType = carpark.service.SpacesRequest.class,
      responseType = carpark.service.SpacesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<carpark.service.SpacesRequest,
      carpark.service.SpacesResponse> getGetAvailSpacesMethod() {
    io.grpc.MethodDescriptor<carpark.service.SpacesRequest, carpark.service.SpacesResponse> getGetAvailSpacesMethod;
    if ((getGetAvailSpacesMethod = carparkServicesGrpc.getGetAvailSpacesMethod) == null) {
      synchronized (carparkServicesGrpc.class) {
        if ((getGetAvailSpacesMethod = carparkServicesGrpc.getGetAvailSpacesMethod) == null) {
          carparkServicesGrpc.getGetAvailSpacesMethod = getGetAvailSpacesMethod = 
              io.grpc.MethodDescriptor.<carpark.service.SpacesRequest, carpark.service.SpacesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "carpark.carparkServices", "GetAvailSpaces"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  carpark.service.SpacesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  carpark.service.SpacesResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new carparkServicesMethodDescriptorSupplier("GetAvailSpaces"))
                  .build();
          }
        }
     }
     return getGetAvailSpacesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<carpark.service.AvailRequest,
      carpark.service.AvailResponse> getGetSumAvailSpacesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSumAvailSpaces",
      requestType = carpark.service.AvailRequest.class,
      responseType = carpark.service.AvailResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<carpark.service.AvailRequest,
      carpark.service.AvailResponse> getGetSumAvailSpacesMethod() {
    io.grpc.MethodDescriptor<carpark.service.AvailRequest, carpark.service.AvailResponse> getGetSumAvailSpacesMethod;
    if ((getGetSumAvailSpacesMethod = carparkServicesGrpc.getGetSumAvailSpacesMethod) == null) {
      synchronized (carparkServicesGrpc.class) {
        if ((getGetSumAvailSpacesMethod = carparkServicesGrpc.getGetSumAvailSpacesMethod) == null) {
          carparkServicesGrpc.getGetSumAvailSpacesMethod = getGetSumAvailSpacesMethod = 
              io.grpc.MethodDescriptor.<carpark.service.AvailRequest, carpark.service.AvailResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "carpark.carparkServices", "GetSumAvailSpaces"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  carpark.service.AvailRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  carpark.service.AvailResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new carparkServicesMethodDescriptorSupplier("GetSumAvailSpaces"))
                  .build();
          }
        }
     }
     return getGetSumAvailSpacesMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static carparkServicesStub newStub(io.grpc.Channel channel) {
    return new carparkServicesStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static carparkServicesBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new carparkServicesBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static carparkServicesFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new carparkServicesFutureStub(channel);
  }

  /**
   */
  public static abstract class carparkServicesImplBase implements io.grpc.BindableService {

    /**
     */
    public void accessCarpark(carpark.service.AccessRequest request,
        io.grpc.stub.StreamObserver<carpark.service.AccessResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getAccessCarparkMethod(), responseObserver);
    }

    /**
     */
    public void leaveCarpark(carpark.service.LeaveRequest request,
        io.grpc.stub.StreamObserver<carpark.service.LeaveResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getLeaveCarparkMethod(), responseObserver);
    }

    /**
     */
    public void getAvailSpaces(carpark.service.SpacesRequest request,
        io.grpc.stub.StreamObserver<carpark.service.SpacesResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAvailSpacesMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<carpark.service.AvailRequest> getSumAvailSpaces(
        io.grpc.stub.StreamObserver<carpark.service.AvailResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getGetSumAvailSpacesMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAccessCarparkMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                carpark.service.AccessRequest,
                carpark.service.AccessResponse>(
                  this, METHODID_ACCESS_CARPARK)))
          .addMethod(
            getLeaveCarparkMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                carpark.service.LeaveRequest,
                carpark.service.LeaveResponse>(
                  this, METHODID_LEAVE_CARPARK)))
          .addMethod(
            getGetAvailSpacesMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                carpark.service.SpacesRequest,
                carpark.service.SpacesResponse>(
                  this, METHODID_GET_AVAIL_SPACES)))
          .addMethod(
            getGetSumAvailSpacesMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                carpark.service.AvailRequest,
                carpark.service.AvailResponse>(
                  this, METHODID_GET_SUM_AVAIL_SPACES)))
          .build();
    }
  }

  /**
   */
  public static final class carparkServicesStub extends io.grpc.stub.AbstractStub<carparkServicesStub> {
    private carparkServicesStub(io.grpc.Channel channel) {
      super(channel);
    }

    private carparkServicesStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected carparkServicesStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new carparkServicesStub(channel, callOptions);
    }

    /**
     */
    public void accessCarpark(carpark.service.AccessRequest request,
        io.grpc.stub.StreamObserver<carpark.service.AccessResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAccessCarparkMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void leaveCarpark(carpark.service.LeaveRequest request,
        io.grpc.stub.StreamObserver<carpark.service.LeaveResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLeaveCarparkMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAvailSpaces(carpark.service.SpacesRequest request,
        io.grpc.stub.StreamObserver<carpark.service.SpacesResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetAvailSpacesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<carpark.service.AvailRequest> getSumAvailSpaces(
        io.grpc.stub.StreamObserver<carpark.service.AvailResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getGetSumAvailSpacesMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class carparkServicesBlockingStub extends io.grpc.stub.AbstractStub<carparkServicesBlockingStub> {
    private carparkServicesBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private carparkServicesBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected carparkServicesBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new carparkServicesBlockingStub(channel, callOptions);
    }

    /**
     */
    public carpark.service.AccessResponse accessCarpark(carpark.service.AccessRequest request) {
      return blockingUnaryCall(
          getChannel(), getAccessCarparkMethod(), getCallOptions(), request);
    }

    /**
     */
    public carpark.service.LeaveResponse leaveCarpark(carpark.service.LeaveRequest request) {
      return blockingUnaryCall(
          getChannel(), getLeaveCarparkMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<carpark.service.SpacesResponse> getAvailSpaces(
        carpark.service.SpacesRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getGetAvailSpacesMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class carparkServicesFutureStub extends io.grpc.stub.AbstractStub<carparkServicesFutureStub> {
    private carparkServicesFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private carparkServicesFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected carparkServicesFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new carparkServicesFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<carpark.service.AccessResponse> accessCarpark(
        carpark.service.AccessRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getAccessCarparkMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<carpark.service.LeaveResponse> leaveCarpark(
        carpark.service.LeaveRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getLeaveCarparkMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ACCESS_CARPARK = 0;
  private static final int METHODID_LEAVE_CARPARK = 1;
  private static final int METHODID_GET_AVAIL_SPACES = 2;
  private static final int METHODID_GET_SUM_AVAIL_SPACES = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final carparkServicesImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(carparkServicesImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ACCESS_CARPARK:
          serviceImpl.accessCarpark((carpark.service.AccessRequest) request,
              (io.grpc.stub.StreamObserver<carpark.service.AccessResponse>) responseObserver);
          break;
        case METHODID_LEAVE_CARPARK:
          serviceImpl.leaveCarpark((carpark.service.LeaveRequest) request,
              (io.grpc.stub.StreamObserver<carpark.service.LeaveResponse>) responseObserver);
          break;
        case METHODID_GET_AVAIL_SPACES:
          serviceImpl.getAvailSpaces((carpark.service.SpacesRequest) request,
              (io.grpc.stub.StreamObserver<carpark.service.SpacesResponse>) responseObserver);
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
        case METHODID_GET_SUM_AVAIL_SPACES:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.getSumAvailSpaces(
              (io.grpc.stub.StreamObserver<carpark.service.AvailResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class carparkServicesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    carparkServicesBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return carpark.service.CarparkImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("carparkServices");
    }
  }

  private static final class carparkServicesFileDescriptorSupplier
      extends carparkServicesBaseDescriptorSupplier {
    carparkServicesFileDescriptorSupplier() {}
  }

  private static final class carparkServicesMethodDescriptorSupplier
      extends carparkServicesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    carparkServicesMethodDescriptorSupplier(String methodName) {
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
      synchronized (carparkServicesGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new carparkServicesFileDescriptorSupplier())
              .addMethod(getAccessCarparkMethod())
              .addMethod(getLeaveCarparkMethod())
              .addMethod(getGetAvailSpacesMethod())
              .addMethod(getGetSumAvailSpacesMethod())
              .build();
        }
      }
    }
    return result;
  }
}
