/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package com.eastsoft.river.router.proto.service1;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class ServiceException extends org.apache.avro.specific.SpecificExceptionBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"error\",\"name\":\"ServiceException\",\"namespace\":\"com.eastsoft.river.router.proto.service1\",\"fields\":[{\"name\":\"errorCode\",\"type\":\"int\"},{\"name\":\"description\",\"type\":[\"null\",\"string\"]}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public int errorCode;
  @Deprecated public java.lang.CharSequence description;

  public ServiceException() {
    super();
  }
  
  public ServiceException(Object value) {
    super(value);
  }

  public ServiceException(Throwable cause) {
    super(cause);
  }

  public ServiceException(Object value, Throwable cause) {
    super(value, cause);
  }
  
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return errorCode;
    case 1: return description;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: errorCode = (java.lang.Integer)value$; break;
    case 1: description = (java.lang.CharSequence)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'errorCode' field.
   */
  public java.lang.Integer getErrorCode() {
    return errorCode;
  }

  /**
   * Sets the value of the 'errorCode' field.
   * @param value the value to set.
   */
  public void setErrorCode(java.lang.Integer value) {
    this.errorCode = value;
  }

  /**
   * Gets the value of the 'description' field.
   */
  public java.lang.CharSequence getDescription() {
    return description;
  }

  /**
   * Sets the value of the 'description' field.
   * @param value the value to set.
   */
  public void setDescription(java.lang.CharSequence value) {
    this.description = value;
  }

  /** Creates a new ServiceException RecordBuilder */
  public static com.eastsoft.river.router.proto.service1.ServiceException.Builder newBuilder() {
    return new com.eastsoft.river.router.proto.service1.ServiceException.Builder();
  }
  
  /** Creates a new ServiceException RecordBuilder by copying an existing Builder */
  public static com.eastsoft.river.router.proto.service1.ServiceException.Builder newBuilder(com.eastsoft.river.router.proto.service1.ServiceException.Builder other) {
    return new com.eastsoft.river.router.proto.service1.ServiceException.Builder(other);
  }
  
  /** Creates a new ServiceException RecordBuilder by copying an existing ServiceException instance */
  public static com.eastsoft.river.router.proto.service1.ServiceException.Builder newBuilder(com.eastsoft.river.router.proto.service1.ServiceException other) {
    return new com.eastsoft.river.router.proto.service1.ServiceException.Builder(other);
  }
  
  /**
   * RecordBuilder for ServiceException instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificErrorBuilderBase<ServiceException>
    implements org.apache.avro.data.ErrorBuilder<ServiceException> {

    private int errorCode;
    private java.lang.CharSequence description;

    /** Creates a new Builder */
    private Builder() {
      super(com.eastsoft.river.router.proto.service1.ServiceException.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(com.eastsoft.river.router.proto.service1.ServiceException.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.errorCode)) {
        this.errorCode = data().deepCopy(fields()[0].schema(), other.errorCode);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.description)) {
        this.description = data().deepCopy(fields()[1].schema(), other.description);
        fieldSetFlags()[1] = true;
      }
    }
    
    /** Creates a Builder by copying an existing ServiceException instance */
    private Builder(com.eastsoft.river.router.proto.service1.ServiceException other) {
      super(other);
      if (isValidValue(fields()[0], other.errorCode)) {
        this.errorCode = data().deepCopy(fields()[0].schema(), other.errorCode);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.description)) {
        this.description = data().deepCopy(fields()[1].schema(), other.description);
        fieldSetFlags()[1] = true;
      }
    }

    @Override
    public com.eastsoft.river.router.proto.service1.ServiceException.Builder setValue(Object value) {
      super.setValue(value);
      return this;
    }
    
    @Override
    public com.eastsoft.river.router.proto.service1.ServiceException.Builder clearValue() {
      super.clearValue();
      return this;
    }

    @Override
    public com.eastsoft.river.router.proto.service1.ServiceException.Builder setCause(Throwable cause) {
      super.setCause(cause);
      return this;
    }
    
    @Override
    public com.eastsoft.river.router.proto.service1.ServiceException.Builder clearCause() {
      super.clearCause();
      return this;
    }

    /** Gets the value of the 'errorCode' field */
    public java.lang.Integer getErrorCode() {
      return errorCode;
    }
    
    /** Sets the value of the 'errorCode' field */
    public com.eastsoft.river.router.proto.service1.ServiceException.Builder setErrorCode(int value) {
      validate(fields()[0], value);
      this.errorCode = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'errorCode' field has been set */
    public boolean hasErrorCode() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'errorCode' field */
    public com.eastsoft.river.router.proto.service1.ServiceException.Builder clearErrorCode() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'description' field */
    public java.lang.CharSequence getDescription() {
      return description;
    }
    
    /** Sets the value of the 'description' field */
    public com.eastsoft.river.router.proto.service1.ServiceException.Builder setDescription(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.description = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'description' field has been set */
    public boolean hasDescription() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'description' field */
    public com.eastsoft.river.router.proto.service1.ServiceException.Builder clearDescription() {
      description = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    public ServiceException build() {
      try {
        ServiceException record = new ServiceException(getValue(), getCause());
        record.errorCode = fieldSetFlags()[0] ? this.errorCode : (java.lang.Integer) defaultValue(fields()[0]);
        record.description = fieldSetFlags()[1] ? this.description : (java.lang.CharSequence) defaultValue(fields()[1]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}
