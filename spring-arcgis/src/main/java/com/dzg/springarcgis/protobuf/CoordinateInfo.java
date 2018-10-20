// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Coordinate.proto

package com.dzg.springarcgis.protobuf;

public final class CoordinateInfo {
  private CoordinateInfo() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface CoordinateMsgOrBuilder extends
      // @@protoc_insertion_point(interface_extends:CoordinateMsg)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <pre>
     * ID  
     * </pre>
     *
     * <code>int32 id = 1;</code>
     */
    int getId();

    /**
     * <pre>
     * 用户id  
     * </pre>
     *
     * <code>int32 userId = 2;</code>
     */
    int getUserId();

    /**
     * <pre>
     * 坐标  
     * </pre>
     *
     * <code>string coordinate = 3;</code>
     */
    String getCoordinate();
    /**
     * <pre>
     * 坐标  
     * </pre>
     *
     * <code>string coordinate = 3;</code>
     */
    com.google.protobuf.ByteString
        getCoordinateBytes();

    /**
     * <pre>
     * 状态 
     * </pre>
     *
     * <code>int32 state = 4;</code>
     */
    int getState();
  }
  /**
   * Protobuf type {@code CoordinateMsg}
   */
  public  static final class CoordinateMsg extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:CoordinateMsg)
      CoordinateMsgOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use CoordinateMsg.newBuilder() to construct.
    private CoordinateMsg(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private CoordinateMsg() {
      id_ = 0;
      userId_ = 0;
      coordinate_ = "";
      state_ = 0;
    }

    @Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private CoordinateMsg(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      if (extensionRegistry == null) {
        throw new NullPointerException();
      }
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
            case 8: {

              id_ = input.readInt32();
              break;
            }
            case 16: {

              userId_ = input.readInt32();
              break;
            }
            case 26: {
              String s = input.readStringRequireUtf8();

              coordinate_ = s;
              break;
            }
            case 32: {

              state_ = input.readInt32();
              break;
            }
            default: {
              if (!parseUnknownFieldProto3(
                  input, unknownFields, extensionRegistry, tag)) {
                done = true;
              }
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
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return CoordinateInfo.internal_static_CoordinateMsg_descriptor;
    }

    @Override
    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return CoordinateInfo.internal_static_CoordinateMsg_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              CoordinateMsg.class, Builder.class);
    }

    public static final int ID_FIELD_NUMBER = 1;
    private int id_;
    /**
     * <pre>
     * ID  
     * </pre>
     *
     * <code>int32 id = 1;</code>
     */
    public int getId() {
      return id_;
    }

    public static final int USERID_FIELD_NUMBER = 2;
    private int userId_;
    /**
     * <pre>
     * 用户id  
     * </pre>
     *
     * <code>int32 userId = 2;</code>
     */
    public int getUserId() {
      return userId_;
    }

    public static final int COORDINATE_FIELD_NUMBER = 3;
    private volatile Object coordinate_;
    /**
     * <pre>
     * 坐标  
     * </pre>
     *
     * <code>string coordinate = 3;</code>
     */
    public String getCoordinate() {
      Object ref = coordinate_;
      if (ref instanceof String) {
        return (String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        coordinate_ = s;
        return s;
      }
    }
    /**
     * <pre>
     * 坐标  
     * </pre>
     *
     * <code>string coordinate = 3;</code>
     */
    public com.google.protobuf.ByteString
        getCoordinateBytes() {
      Object ref = coordinate_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        coordinate_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int STATE_FIELD_NUMBER = 4;
    private int state_;
    /**
     * <pre>
     * 状态 
     * </pre>
     *
     * <code>int32 state = 4;</code>
     */
    public int getState() {
      return state_;
    }

    private byte memoizedIsInitialized = -1;
    @Override
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    @Override
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (id_ != 0) {
        output.writeInt32(1, id_);
      }
      if (userId_ != 0) {
        output.writeInt32(2, userId_);
      }
      if (!getCoordinateBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 3, coordinate_);
      }
      if (state_ != 0) {
        output.writeInt32(4, state_);
      }
      unknownFields.writeTo(output);
    }

    @Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (id_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(1, id_);
      }
      if (userId_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(2, userId_);
      }
      if (!getCoordinateBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, coordinate_);
      }
      if (state_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(4, state_);
      }
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @Override
    public boolean equals(final Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof CoordinateMsg)) {
        return super.equals(obj);
      }
      CoordinateMsg other = (CoordinateMsg) obj;

      boolean result = true;
      result = result && (getId()
          == other.getId());
      result = result && (getUserId()
          == other.getUserId());
      result = result && getCoordinate()
          .equals(other.getCoordinate());
      result = result && (getState()
          == other.getState());
      result = result && unknownFields.equals(other.unknownFields);
      return result;
    }

    @Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + ID_FIELD_NUMBER;
      hash = (53 * hash) + getId();
      hash = (37 * hash) + USERID_FIELD_NUMBER;
      hash = (53 * hash) + getUserId();
      hash = (37 * hash) + COORDINATE_FIELD_NUMBER;
      hash = (53 * hash) + getCoordinate().hashCode();
      hash = (37 * hash) + STATE_FIELD_NUMBER;
      hash = (53 * hash) + getState();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static CoordinateMsg parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static CoordinateMsg parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static CoordinateMsg parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static CoordinateMsg parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static CoordinateMsg parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static CoordinateMsg parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static CoordinateMsg parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static CoordinateMsg parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static CoordinateMsg parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static CoordinateMsg parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static CoordinateMsg parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static CoordinateMsg parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    @Override
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(CoordinateMsg prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    @Override
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @Override
    protected Builder newBuilderForType(
        BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code CoordinateMsg}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:CoordinateMsg)
        CoordinateMsgOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return CoordinateInfo.internal_static_CoordinateMsg_descriptor;
      }

      @Override
      protected FieldAccessorTable
          internalGetFieldAccessorTable() {
        return CoordinateInfo.internal_static_CoordinateMsg_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                CoordinateMsg.class, Builder.class);
      }

      // Construct using com.dzg.springarcgis.protobuf.CoordinateInfo.CoordinateMsg.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      @Override
      public Builder clear() {
        super.clear();
        id_ = 0;

        userId_ = 0;

        coordinate_ = "";

        state_ = 0;

        return this;
      }

      @Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return CoordinateInfo.internal_static_CoordinateMsg_descriptor;
      }

      @Override
      public CoordinateMsg getDefaultInstanceForType() {
        return CoordinateMsg.getDefaultInstance();
      }

      @Override
      public CoordinateMsg build() {
        CoordinateMsg result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @Override
      public CoordinateMsg buildPartial() {
        CoordinateMsg result = new CoordinateMsg(this);
        result.id_ = id_;
        result.userId_ = userId_;
        result.coordinate_ = coordinate_;
        result.state_ = state_;
        onBuilt();
        return result;
      }

      @Override
      public Builder clone() {
        return (Builder) super.clone();
      }
      @Override
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.setField(field, value);
      }
      @Override
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return (Builder) super.clearField(field);
      }
      @Override
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return (Builder) super.clearOneof(oneof);
      }
      @Override
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, Object value) {
        return (Builder) super.setRepeatedField(field, index, value);
      }
      @Override
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.addRepeatedField(field, value);
      }
      @Override
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof CoordinateMsg) {
          return mergeFrom((CoordinateMsg)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(CoordinateMsg other) {
        if (other == CoordinateMsg.getDefaultInstance()) return this;
        if (other.getId() != 0) {
          setId(other.getId());
        }
        if (other.getUserId() != 0) {
          setUserId(other.getUserId());
        }
        if (!other.getCoordinate().isEmpty()) {
          coordinate_ = other.coordinate_;
          onChanged();
        }
        if (other.getState() != 0) {
          setState(other.getState());
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      @Override
      public final boolean isInitialized() {
        return true;
      }

      @Override
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        CoordinateMsg parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (CoordinateMsg) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private int id_ ;
      /**
       * <pre>
       * ID  
       * </pre>
       *
       * <code>int32 id = 1;</code>
       */
      public int getId() {
        return id_;
      }
      /**
       * <pre>
       * ID  
       * </pre>
       *
       * <code>int32 id = 1;</code>
       */
      public Builder setId(int value) {
        
        id_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       * ID  
       * </pre>
       *
       * <code>int32 id = 1;</code>
       */
      public Builder clearId() {
        
        id_ = 0;
        onChanged();
        return this;
      }

      private int userId_ ;
      /**
       * <pre>
       * 用户id  
       * </pre>
       *
       * <code>int32 userId = 2;</code>
       */
      public int getUserId() {
        return userId_;
      }
      /**
       * <pre>
       * 用户id  
       * </pre>
       *
       * <code>int32 userId = 2;</code>
       */
      public Builder setUserId(int value) {
        
        userId_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       * 用户id  
       * </pre>
       *
       * <code>int32 userId = 2;</code>
       */
      public Builder clearUserId() {
        
        userId_ = 0;
        onChanged();
        return this;
      }

      private Object coordinate_ = "";
      /**
       * <pre>
       * 坐标  
       * </pre>
       *
       * <code>string coordinate = 3;</code>
       */
      public String getCoordinate() {
        Object ref = coordinate_;
        if (!(ref instanceof String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          String s = bs.toStringUtf8();
          coordinate_ = s;
          return s;
        } else {
          return (String) ref;
        }
      }
      /**
       * <pre>
       * 坐标  
       * </pre>
       *
       * <code>string coordinate = 3;</code>
       */
      public com.google.protobuf.ByteString
          getCoordinateBytes() {
        Object ref = coordinate_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (String) ref);
          coordinate_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <pre>
       * 坐标  
       * </pre>
       *
       * <code>string coordinate = 3;</code>
       */
      public Builder setCoordinate(
          String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        coordinate_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       * 坐标  
       * </pre>
       *
       * <code>string coordinate = 3;</code>
       */
      public Builder clearCoordinate() {
        
        coordinate_ = getDefaultInstance().getCoordinate();
        onChanged();
        return this;
      }
      /**
       * <pre>
       * 坐标  
       * </pre>
       *
       * <code>string coordinate = 3;</code>
       */
      public Builder setCoordinateBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        coordinate_ = value;
        onChanged();
        return this;
      }

      private int state_ ;
      /**
       * <pre>
       * 状态 
       * </pre>
       *
       * <code>int32 state = 4;</code>
       */
      public int getState() {
        return state_;
      }
      /**
       * <pre>
       * 状态 
       * </pre>
       *
       * <code>int32 state = 4;</code>
       */
      public Builder setState(int value) {
        
        state_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       * 状态 
       * </pre>
       *
       * <code>int32 state = 4;</code>
       */
      public Builder clearState() {
        
        state_ = 0;
        onChanged();
        return this;
      }
      @Override
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFieldsProto3(unknownFields);
      }

      @Override
      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:CoordinateMsg)
    }

    // @@protoc_insertion_point(class_scope:CoordinateMsg)
    private static final CoordinateMsg DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new CoordinateMsg();
    }

    public static CoordinateMsg getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<CoordinateMsg>
        PARSER = new com.google.protobuf.AbstractParser<CoordinateMsg>() {
      @Override
      public CoordinateMsg parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new CoordinateMsg(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<CoordinateMsg> parser() {
      return PARSER;
    }

    @Override
    public com.google.protobuf.Parser<CoordinateMsg> getParserForType() {
      return PARSER;
    }

    @Override
    public CoordinateMsg getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_CoordinateMsg_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_CoordinateMsg_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\020Coordinate.proto\"N\n\rCoordinateMsg\022\n\n\002i" +
      "d\030\001 \001(\005\022\016\n\006userId\030\002 \001(\005\022\022\n\ncoordinate\030\003 " +
      "\001(\t\022\r\n\005state\030\004 \001(\005B/\n\035com.dzg.springarcg" +
      "is.protobufB\016CoordinateInfob\006proto3"
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
    internal_static_CoordinateMsg_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_CoordinateMsg_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_CoordinateMsg_descriptor,
        new String[] { "Id", "UserId", "Coordinate", "State", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}