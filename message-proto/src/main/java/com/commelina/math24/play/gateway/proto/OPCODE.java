// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: gateway_notify_opcode.proto

package com.commelina.math24.play.gateway.proto;

/**
 * Protobuf enum {@code def.gateway.OPCODE}
 */
public enum OPCODE
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <code>EMPTY1 = 0;</code>
   */
  EMPTY1(0),
  UNRECOGNIZED(-1),
  ;

  /**
   * <code>EMPTY1 = 0;</code>
   */
  public static final int EMPTY1_VALUE = 0;


  public final int getNumber() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalArgumentException(
          "Can't get the number of an unknown enum value.");
    }
    return value;
  }

  /**
   * @deprecated Use {@link #forNumber(int)} instead.
   */
  @java.lang.Deprecated
  public static OPCODE valueOf(int value) {
    return forNumber(value);
  }

  public static OPCODE forNumber(int value) {
    switch (value) {
      case 0: return EMPTY1;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<OPCODE>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      OPCODE> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<OPCODE>() {
          public OPCODE findValueByNumber(int number) {
            return OPCODE.forNumber(number);
          }
        };

  public final com.google.protobuf.Descriptors.EnumValueDescriptor
      getValueDescriptor() {
    return getDescriptor().getValues().get(ordinal());
  }
  public final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptorForType() {
    return getDescriptor();
  }
  public static final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptor() {
    return com.commelina.math24.play.gateway.proto.NotifyOpcodeProtos.getDescriptor().getEnumTypes().get(0);
  }

  private static final OPCODE[] VALUES = values();

  public static OPCODE valueOf(
      com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
    if (desc.getType() != getDescriptor()) {
      throw new java.lang.IllegalArgumentException(
        "EnumValueDescriptor is not for this type.");
    }
    if (desc.getIndex() == -1) {
      return UNRECOGNIZED;
    }
    return VALUES[desc.getIndex()];
  }

  private final int value;

  private OPCODE(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:def.gateway.OPCODE)
}

