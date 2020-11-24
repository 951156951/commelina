// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: matching_room_request_opcode.proto

package com.commelina.math24.matching_room.proto;

/**
 * Protobuf type {@code def.matching_room.CREATE_ROOM_REQUEST}
 */
public  final class CREATE_ROOM_REQUEST extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:def.matching_room.CREATE_ROOM_REQUEST)
    CREATE_ROOM_REQUESTOrBuilder {
private static final long serialVersionUID = 0L;
  // Use CREATE_ROOM_REQUEST.newBuilder() to construct.
  private CREATE_ROOM_REQUEST(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private CREATE_ROOM_REQUEST() {
    roomId_ = 0L;
    userIds_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private CREATE_ROOM_REQUEST(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
          case 8: {

            roomId_ = input.readUInt64();
            break;
          }
          case 16: {
            if (!((mutable_bitField0_ & 0x00000002) == 0x00000002)) {
              userIds_ = new java.util.ArrayList<java.lang.Long>();
              mutable_bitField0_ |= 0x00000002;
            }
            userIds_.add(input.readUInt64());
            break;
          }
          case 18: {
            int length = input.readRawVarint32();
            int limit = input.pushLimit(length);
            if (!((mutable_bitField0_ & 0x00000002) == 0x00000002) && input.getBytesUntilLimit() > 0) {
              userIds_ = new java.util.ArrayList<java.lang.Long>();
              mutable_bitField0_ |= 0x00000002;
            }
            while (input.getBytesUntilLimit() > 0) {
              userIds_.add(input.readUInt64());
            }
            input.popLimit(limit);
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      if (((mutable_bitField0_ & 0x00000002) == 0x00000002)) {
        userIds_ = java.util.Collections.unmodifiableList(userIds_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.commelina.math24.matching_room.proto.OpcodeDef.internal_static_def_matching_room_CREATE_ROOM_REQUEST_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.commelina.math24.matching_room.proto.OpcodeDef.internal_static_def_matching_room_CREATE_ROOM_REQUEST_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.commelina.math24.matching_room.proto.CREATE_ROOM_REQUEST.class, com.commelina.math24.matching_room.proto.CREATE_ROOM_REQUEST.Builder.class);
  }

  private int bitField0_;
  public static final int ROOMID_FIELD_NUMBER = 1;
  private long roomId_;
  /**
   * <code>uint64 roomId = 1;</code>
   */
  public long getRoomId() {
    return roomId_;
  }

  public static final int USERIDS_FIELD_NUMBER = 2;
  private java.util.List<java.lang.Long> userIds_;
  /**
   * <code>repeated uint64 userIds = 2;</code>
   */
  public java.util.List<java.lang.Long>
      getUserIdsList() {
    return userIds_;
  }
  /**
   * <code>repeated uint64 userIds = 2;</code>
   */
  public int getUserIdsCount() {
    return userIds_.size();
  }
  /**
   * <code>repeated uint64 userIds = 2;</code>
   */
  public long getUserIds(int index) {
    return userIds_.get(index);
  }
  private int userIdsMemoizedSerializedSize = -1;

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    getSerializedSize();
    if (roomId_ != 0L) {
      output.writeUInt64(1, roomId_);
    }
    if (getUserIdsList().size() > 0) {
      output.writeUInt32NoTag(18);
      output.writeUInt32NoTag(userIdsMemoizedSerializedSize);
    }
    for (int i = 0; i < userIds_.size(); i++) {
      output.writeUInt64NoTag(userIds_.get(i));
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (roomId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt64Size(1, roomId_);
    }
    {
      int dataSize = 0;
      for (int i = 0; i < userIds_.size(); i++) {
        dataSize += com.google.protobuf.CodedOutputStream
          .computeUInt64SizeNoTag(userIds_.get(i));
      }
      size += dataSize;
      if (!getUserIdsList().isEmpty()) {
        size += 1;
        size += com.google.protobuf.CodedOutputStream
            .computeInt32SizeNoTag(dataSize);
      }
      userIdsMemoizedSerializedSize = dataSize;
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.commelina.math24.matching_room.proto.CREATE_ROOM_REQUEST)) {
      return super.equals(obj);
    }
    com.commelina.math24.matching_room.proto.CREATE_ROOM_REQUEST other = (com.commelina.math24.matching_room.proto.CREATE_ROOM_REQUEST) obj;

    boolean result = true;
    result = result && (getRoomId()
        == other.getRoomId());
    result = result && getUserIdsList()
        .equals(other.getUserIdsList());
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + ROOMID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getRoomId());
    if (getUserIdsCount() > 0) {
      hash = (37 * hash) + USERIDS_FIELD_NUMBER;
      hash = (53 * hash) + getUserIdsList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.commelina.math24.matching_room.proto.CREATE_ROOM_REQUEST parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.commelina.math24.matching_room.proto.CREATE_ROOM_REQUEST parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.commelina.math24.matching_room.proto.CREATE_ROOM_REQUEST parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.commelina.math24.matching_room.proto.CREATE_ROOM_REQUEST parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.commelina.math24.matching_room.proto.CREATE_ROOM_REQUEST parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.commelina.math24.matching_room.proto.CREATE_ROOM_REQUEST parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.commelina.math24.matching_room.proto.CREATE_ROOM_REQUEST parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.commelina.math24.matching_room.proto.CREATE_ROOM_REQUEST parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.commelina.math24.matching_room.proto.CREATE_ROOM_REQUEST parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.commelina.math24.matching_room.proto.CREATE_ROOM_REQUEST parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.commelina.math24.matching_room.proto.CREATE_ROOM_REQUEST parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.commelina.math24.matching_room.proto.CREATE_ROOM_REQUEST parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.commelina.math24.matching_room.proto.CREATE_ROOM_REQUEST prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code def.matching_room.CREATE_ROOM_REQUEST}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:def.matching_room.CREATE_ROOM_REQUEST)
      com.commelina.math24.matching_room.proto.CREATE_ROOM_REQUESTOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.commelina.math24.matching_room.proto.OpcodeDef.internal_static_def_matching_room_CREATE_ROOM_REQUEST_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.commelina.math24.matching_room.proto.OpcodeDef.internal_static_def_matching_room_CREATE_ROOM_REQUEST_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.commelina.math24.matching_room.proto.CREATE_ROOM_REQUEST.class, com.commelina.math24.matching_room.proto.CREATE_ROOM_REQUEST.Builder.class);
    }

    // Construct using com.commelina.math24.matching_room.proto.CREATE_ROOM_REQUEST.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    public Builder clear() {
      super.clear();
      roomId_ = 0L;

      userIds_ = java.util.Collections.emptyList();
      bitField0_ = (bitField0_ & ~0x00000002);
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.commelina.math24.matching_room.proto.OpcodeDef.internal_static_def_matching_room_CREATE_ROOM_REQUEST_descriptor;
    }

    public com.commelina.math24.matching_room.proto.CREATE_ROOM_REQUEST getDefaultInstanceForType() {
      return com.commelina.math24.matching_room.proto.CREATE_ROOM_REQUEST.getDefaultInstance();
    }

    public com.commelina.math24.matching_room.proto.CREATE_ROOM_REQUEST build() {
      com.commelina.math24.matching_room.proto.CREATE_ROOM_REQUEST result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.commelina.math24.matching_room.proto.CREATE_ROOM_REQUEST buildPartial() {
      com.commelina.math24.matching_room.proto.CREATE_ROOM_REQUEST result = new com.commelina.math24.matching_room.proto.CREATE_ROOM_REQUEST(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      result.roomId_ = roomId_;
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        userIds_ = java.util.Collections.unmodifiableList(userIds_);
        bitField0_ = (bitField0_ & ~0x00000002);
      }
      result.userIds_ = userIds_;
      result.bitField0_ = to_bitField0_;
      onBuilt();
      return result;
    }

    public Builder clone() {
      return (Builder) super.clone();
    }
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.commelina.math24.matching_room.proto.CREATE_ROOM_REQUEST) {
        return mergeFrom((com.commelina.math24.matching_room.proto.CREATE_ROOM_REQUEST)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.commelina.math24.matching_room.proto.CREATE_ROOM_REQUEST other) {
      if (other == com.commelina.math24.matching_room.proto.CREATE_ROOM_REQUEST.getDefaultInstance()) return this;
      if (other.getRoomId() != 0L) {
        setRoomId(other.getRoomId());
      }
      if (!other.userIds_.isEmpty()) {
        if (userIds_.isEmpty()) {
          userIds_ = other.userIds_;
          bitField0_ = (bitField0_ & ~0x00000002);
        } else {
          ensureUserIdsIsMutable();
          userIds_.addAll(other.userIds_);
        }
        onChanged();
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.commelina.math24.matching_room.proto.CREATE_ROOM_REQUEST parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.commelina.math24.matching_room.proto.CREATE_ROOM_REQUEST) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private long roomId_ ;
    /**
     * <code>uint64 roomId = 1;</code>
     */
    public long getRoomId() {
      return roomId_;
    }
    /**
     * <code>uint64 roomId = 1;</code>
     */
    public Builder setRoomId(long value) {
      
      roomId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>uint64 roomId = 1;</code>
     */
    public Builder clearRoomId() {
      
      roomId_ = 0L;
      onChanged();
      return this;
    }

    private java.util.List<java.lang.Long> userIds_ = java.util.Collections.emptyList();
    private void ensureUserIdsIsMutable() {
      if (!((bitField0_ & 0x00000002) == 0x00000002)) {
        userIds_ = new java.util.ArrayList<java.lang.Long>(userIds_);
        bitField0_ |= 0x00000002;
       }
    }
    /**
     * <code>repeated uint64 userIds = 2;</code>
     */
    public java.util.List<java.lang.Long>
        getUserIdsList() {
      return java.util.Collections.unmodifiableList(userIds_);
    }
    /**
     * <code>repeated uint64 userIds = 2;</code>
     */
    public int getUserIdsCount() {
      return userIds_.size();
    }
    /**
     * <code>repeated uint64 userIds = 2;</code>
     */
    public long getUserIds(int index) {
      return userIds_.get(index);
    }
    /**
     * <code>repeated uint64 userIds = 2;</code>
     */
    public Builder setUserIds(
        int index, long value) {
      ensureUserIdsIsMutable();
      userIds_.set(index, value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated uint64 userIds = 2;</code>
     */
    public Builder addUserIds(long value) {
      ensureUserIdsIsMutable();
      userIds_.add(value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated uint64 userIds = 2;</code>
     */
    public Builder addAllUserIds(
        java.lang.Iterable<? extends java.lang.Long> values) {
      ensureUserIdsIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
          values, userIds_);
      onChanged();
      return this;
    }
    /**
     * <code>repeated uint64 userIds = 2;</code>
     */
    public Builder clearUserIds() {
      userIds_ = java.util.Collections.emptyList();
      bitField0_ = (bitField0_ & ~0x00000002);
      onChanged();
      return this;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:def.matching_room.CREATE_ROOM_REQUEST)
  }

  // @@protoc_insertion_point(class_scope:def.matching_room.CREATE_ROOM_REQUEST)
  private static final com.commelina.math24.matching_room.proto.CREATE_ROOM_REQUEST DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.commelina.math24.matching_room.proto.CREATE_ROOM_REQUEST();
  }

  public static com.commelina.math24.matching_room.proto.CREATE_ROOM_REQUEST getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<CREATE_ROOM_REQUEST>
      PARSER = new com.google.protobuf.AbstractParser<CREATE_ROOM_REQUEST>() {
    public CREATE_ROOM_REQUEST parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new CREATE_ROOM_REQUEST(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<CREATE_ROOM_REQUEST> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<CREATE_ROOM_REQUEST> getParserForType() {
    return PARSER;
  }

  public com.commelina.math24.matching_room.proto.CREATE_ROOM_REQUEST getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

