// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: carpark.proto

package carpark.service;

public final class CarparkImpl {
  private CarparkImpl() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_carpark_AccessRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_carpark_AccessRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_carpark_AccessResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_carpark_AccessResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_carpark_LeaveRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_carpark_LeaveRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_carpark_LeaveResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_carpark_LeaveResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_carpark_SpacesRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_carpark_SpacesRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_carpark_SpacesResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_carpark_SpacesResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\rcarpark.proto\022\007carpark\"!\n\rAccessReques" +
      "t\022\020\n\010idNumber\030\001 \001(\t\"!\n\016AccessResponse\022\017\n" +
      "\007message\030\001 \001(\t\"\016\n\014LeaveRequest\" \n\rLeaveR" +
      "esponse\022\017\n\007message\030\001 \001(\t\"\017\n\rSpacesReques" +
      "t\"!\n\016SpacesResponse\022\017\n\007message\030\001 \001(\0052\340\001\n" +
      "\017carparkServices\022B\n\rAccessCarpark\022\026.carp" +
      "ark.AccessRequest\032\027.carpark.AccessRespon" +
      "se\"\000\022?\n\014LeaveCarpark\022\025.carpark.LeaveRequ" +
      "est\032\026.carpark.LeaveResponse\"\000\022H\n\021GetNumA" +
      "vailSpaces\022\026.carpark.SpacesRequest\032\027.car" +
      "park.SpacesResponse\"\0000\001B \n\017carpark.servi" +
      "ceB\013CarparkImplP\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_carpark_AccessRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_carpark_AccessRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_carpark_AccessRequest_descriptor,
        new java.lang.String[] { "IdNumber", });
    internal_static_carpark_AccessResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_carpark_AccessResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_carpark_AccessResponse_descriptor,
        new java.lang.String[] { "Message", });
    internal_static_carpark_LeaveRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_carpark_LeaveRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_carpark_LeaveRequest_descriptor,
        new java.lang.String[] { });
    internal_static_carpark_LeaveResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_carpark_LeaveResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_carpark_LeaveResponse_descriptor,
        new java.lang.String[] { "Message", });
    internal_static_carpark_SpacesRequest_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_carpark_SpacesRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_carpark_SpacesRequest_descriptor,
        new java.lang.String[] { });
    internal_static_carpark_SpacesResponse_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_carpark_SpacesResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_carpark_SpacesResponse_descriptor,
        new java.lang.String[] { "Message", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
