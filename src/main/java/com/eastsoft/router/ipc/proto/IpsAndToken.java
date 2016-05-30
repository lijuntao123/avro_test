/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package com.eastsoft.router.ipc.proto;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class IpsAndToken extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"IpsAndToken\",\"namespace\":\"com.eastsoft.router.ipc.proto\",\"fields\":[{\"name\":\"bridgeIp\",\"type\":{\"type\":\"string\",\"java-class\":\"java.lang.String\"}},{\"name\":\"token\",\"type\":{\"type\":\"string\",\"java-class\":\"java.lang.String\"}},{\"name\":\"routerList\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"string\",\"java-class\":\"java.lang.String\"}}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public java.lang.String bridgeIp;
  @Deprecated public java.lang.String token;
  @Deprecated public java.util.List<java.lang.String> routerList;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public IpsAndToken() {}

  /**
   * All-args constructor.
   */
  public IpsAndToken(java.lang.String bridgeIp, java.lang.String token, java.util.List<java.lang.String> routerList) {
    this.bridgeIp = bridgeIp;
    this.token = token;
    this.routerList = routerList;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return bridgeIp;
    case 1: return token;
    case 2: return routerList;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: bridgeIp = (java.lang.String)value$; break;
    case 1: token = (java.lang.String)value$; break;
    case 2: routerList = (java.util.List<java.lang.String>)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'bridgeIp' field.
   */
  public java.lang.String getBridgeIp() {
    return bridgeIp;
  }

  /**
   * Sets the value of the 'bridgeIp' field.
   * @param value the value to set.
   */
  public void setBridgeIp(java.lang.String value) {
    this.bridgeIp = value;
  }

  /**
   * Gets the value of the 'token' field.
   */
  public java.lang.String getToken() {
    return token;
  }

  /**
   * Sets the value of the 'token' field.
   * @param value the value to set.
   */
  public void setToken(java.lang.String value) {
    this.token = value;
  }

  /**
   * Gets the value of the 'routerList' field.
   */
  public java.util.List<java.lang.String> getRouterList() {
    return routerList;
  }

  /**
   * Sets the value of the 'routerList' field.
   * @param value the value to set.
   */
  public void setRouterList(java.util.List<java.lang.String> value) {
    this.routerList = value;
  }

  /** Creates a new IpsAndToken RecordBuilder */
  public static com.eastsoft.router.ipc.proto.IpsAndToken.Builder newBuilder() {
    return new com.eastsoft.router.ipc.proto.IpsAndToken.Builder();
  }
  
  /** Creates a new IpsAndToken RecordBuilder by copying an existing Builder */
  public static com.eastsoft.router.ipc.proto.IpsAndToken.Builder newBuilder(com.eastsoft.router.ipc.proto.IpsAndToken.Builder other) {
    return new com.eastsoft.router.ipc.proto.IpsAndToken.Builder(other);
  }
  
  /** Creates a new IpsAndToken RecordBuilder by copying an existing IpsAndToken instance */
  public static com.eastsoft.router.ipc.proto.IpsAndToken.Builder newBuilder(com.eastsoft.router.ipc.proto.IpsAndToken other) {
    return new com.eastsoft.router.ipc.proto.IpsAndToken.Builder(other);
  }
  
  /**
   * RecordBuilder for IpsAndToken instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<IpsAndToken>
    implements org.apache.avro.data.RecordBuilder<IpsAndToken> {

    private java.lang.String bridgeIp;
    private java.lang.String token;
    private java.util.List<java.lang.String> routerList;

    /** Creates a new Builder */
    private Builder() {
      super(com.eastsoft.router.ipc.proto.IpsAndToken.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(com.eastsoft.router.ipc.proto.IpsAndToken.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.bridgeIp)) {
        this.bridgeIp = data().deepCopy(fields()[0].schema(), other.bridgeIp);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.token)) {
        this.token = data().deepCopy(fields()[1].schema(), other.token);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.routerList)) {
        this.routerList = data().deepCopy(fields()[2].schema(), other.routerList);
        fieldSetFlags()[2] = true;
      }
    }
    
    /** Creates a Builder by copying an existing IpsAndToken instance */
    private Builder(com.eastsoft.router.ipc.proto.IpsAndToken other) {
            super(com.eastsoft.router.ipc.proto.IpsAndToken.SCHEMA$);
      if (isValidValue(fields()[0], other.bridgeIp)) {
        this.bridgeIp = data().deepCopy(fields()[0].schema(), other.bridgeIp);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.token)) {
        this.token = data().deepCopy(fields()[1].schema(), other.token);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.routerList)) {
        this.routerList = data().deepCopy(fields()[2].schema(), other.routerList);
        fieldSetFlags()[2] = true;
      }
    }

    /** Gets the value of the 'bridgeIp' field */
    public java.lang.String getBridgeIp() {
      return bridgeIp;
    }
    
    /** Sets the value of the 'bridgeIp' field */
    public com.eastsoft.router.ipc.proto.IpsAndToken.Builder setBridgeIp(java.lang.String value) {
      validate(fields()[0], value);
      this.bridgeIp = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'bridgeIp' field has been set */
    public boolean hasBridgeIp() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'bridgeIp' field */
    public com.eastsoft.router.ipc.proto.IpsAndToken.Builder clearBridgeIp() {
      bridgeIp = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'token' field */
    public java.lang.String getToken() {
      return token;
    }
    
    /** Sets the value of the 'token' field */
    public com.eastsoft.router.ipc.proto.IpsAndToken.Builder setToken(java.lang.String value) {
      validate(fields()[1], value);
      this.token = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'token' field has been set */
    public boolean hasToken() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'token' field */
    public com.eastsoft.router.ipc.proto.IpsAndToken.Builder clearToken() {
      token = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /** Gets the value of the 'routerList' field */
    public java.util.List<java.lang.String> getRouterList() {
      return routerList;
    }
    
    /** Sets the value of the 'routerList' field */
    public com.eastsoft.router.ipc.proto.IpsAndToken.Builder setRouterList(java.util.List<java.lang.String> value) {
      validate(fields()[2], value);
      this.routerList = value;
      fieldSetFlags()[2] = true;
      return this; 
    }
    
    /** Checks whether the 'routerList' field has been set */
    public boolean hasRouterList() {
      return fieldSetFlags()[2];
    }
    
    /** Clears the value of the 'routerList' field */
    public com.eastsoft.router.ipc.proto.IpsAndToken.Builder clearRouterList() {
      routerList = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    @Override
    public IpsAndToken build() {
      try {
        IpsAndToken record = new IpsAndToken();
        record.bridgeIp = fieldSetFlags()[0] ? this.bridgeIp : (java.lang.String) defaultValue(fields()[0]);
        record.token = fieldSetFlags()[1] ? this.token : (java.lang.String) defaultValue(fields()[1]);
        record.routerList = fieldSetFlags()[2] ? this.routerList : (java.util.List<java.lang.String>) defaultValue(fields()[2]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}