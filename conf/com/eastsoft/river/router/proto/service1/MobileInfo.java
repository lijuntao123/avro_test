/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package com.eastsoft.river.router.proto.service1;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class MobileInfo extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"MobileInfo\",\"namespace\":\"com.eastsoft.river.router.proto.service1\",\"fields\":[{\"name\":\"gid\",\"type\":\"string\"},{\"name\":\"timeStamp\",\"type\":\"string\"},{\"name\":\"optionalIMEI\",\"type\":[\"null\",\"string\"]},{\"name\":\"optionalTelNumber\",\"type\":[\"null\",\"string\"]}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public java.lang.CharSequence gid;
  @Deprecated public java.lang.CharSequence timeStamp;
  @Deprecated public java.lang.CharSequence optionalIMEI;
  @Deprecated public java.lang.CharSequence optionalTelNumber;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public MobileInfo() {}

  /**
   * All-args constructor.
   */
  public MobileInfo(java.lang.CharSequence gid, java.lang.CharSequence timeStamp, java.lang.CharSequence optionalIMEI, java.lang.CharSequence optionalTelNumber) {
    this.gid = gid;
    this.timeStamp = timeStamp;
    this.optionalIMEI = optionalIMEI;
    this.optionalTelNumber = optionalTelNumber;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return gid;
    case 1: return timeStamp;
    case 2: return optionalIMEI;
    case 3: return optionalTelNumber;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: gid = (java.lang.CharSequence)value$; break;
    case 1: timeStamp = (java.lang.CharSequence)value$; break;
    case 2: optionalIMEI = (java.lang.CharSequence)value$; break;
    case 3: optionalTelNumber = (java.lang.CharSequence)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'gid' field.
   */
  public java.lang.CharSequence getGid() {
    return gid;
  }

  /**
   * Sets the value of the 'gid' field.
   * @param value the value to set.
   */
  public void setGid(java.lang.CharSequence value) {
    this.gid = value;
  }

  /**
   * Gets the value of the 'timeStamp' field.
   */
  public java.lang.CharSequence getTimeStamp() {
    return timeStamp;
  }

  /**
   * Sets the value of the 'timeStamp' field.
   * @param value the value to set.
   */
  public void setTimeStamp(java.lang.CharSequence value) {
    this.timeStamp = value;
  }

  /**
   * Gets the value of the 'optionalIMEI' field.
   */
  public java.lang.CharSequence getOptionalIMEI() {
    return optionalIMEI;
  }

  /**
   * Sets the value of the 'optionalIMEI' field.
   * @param value the value to set.
   */
  public void setOptionalIMEI(java.lang.CharSequence value) {
    this.optionalIMEI = value;
  }

  /**
   * Gets the value of the 'optionalTelNumber' field.
   */
  public java.lang.CharSequence getOptionalTelNumber() {
    return optionalTelNumber;
  }

  /**
   * Sets the value of the 'optionalTelNumber' field.
   * @param value the value to set.
   */
  public void setOptionalTelNumber(java.lang.CharSequence value) {
    this.optionalTelNumber = value;
  }

  /** Creates a new MobileInfo RecordBuilder */
  public static com.eastsoft.river.router.proto.service1.MobileInfo.Builder newBuilder() {
    return new com.eastsoft.river.router.proto.service1.MobileInfo.Builder();
  }
  
  /** Creates a new MobileInfo RecordBuilder by copying an existing Builder */
  public static com.eastsoft.river.router.proto.service1.MobileInfo.Builder newBuilder(com.eastsoft.river.router.proto.service1.MobileInfo.Builder other) {
    return new com.eastsoft.river.router.proto.service1.MobileInfo.Builder(other);
  }
  
  /** Creates a new MobileInfo RecordBuilder by copying an existing MobileInfo instance */
  public static com.eastsoft.river.router.proto.service1.MobileInfo.Builder newBuilder(com.eastsoft.river.router.proto.service1.MobileInfo other) {
    return new com.eastsoft.river.router.proto.service1.MobileInfo.Builder(other);
  }
  
  /**
   * RecordBuilder for MobileInfo instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<MobileInfo>
    implements org.apache.avro.data.RecordBuilder<MobileInfo> {

    private java.lang.CharSequence gid;
    private java.lang.CharSequence timeStamp;
    private java.lang.CharSequence optionalIMEI;
    private java.lang.CharSequence optionalTelNumber;

    /** Creates a new Builder */
    private Builder() {
      super(com.eastsoft.river.router.proto.service1.MobileInfo.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(com.eastsoft.river.router.proto.service1.MobileInfo.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.gid)) {
        this.gid = data().deepCopy(fields()[0].schema(), other.gid);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.timeStamp)) {
        this.timeStamp = data().deepCopy(fields()[1].schema(), other.timeStamp);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.optionalIMEI)) {
        this.optionalIMEI = data().deepCopy(fields()[2].schema(), other.optionalIMEI);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.optionalTelNumber)) {
        this.optionalTelNumber = data().deepCopy(fields()[3].schema(), other.optionalTelNumber);
        fieldSetFlags()[3] = true;
      }
    }
    
    /** Creates a Builder by copying an existing MobileInfo instance */
    private Builder(com.eastsoft.river.router.proto.service1.MobileInfo other) {
            super(com.eastsoft.river.router.proto.service1.MobileInfo.SCHEMA$);
      if (isValidValue(fields()[0], other.gid)) {
        this.gid = data().deepCopy(fields()[0].schema(), other.gid);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.timeStamp)) {
        this.timeStamp = data().deepCopy(fields()[1].schema(), other.timeStamp);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.optionalIMEI)) {
        this.optionalIMEI = data().deepCopy(fields()[2].schema(), other.optionalIMEI);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.optionalTelNumber)) {
        this.optionalTelNumber = data().deepCopy(fields()[3].schema(), other.optionalTelNumber);
        fieldSetFlags()[3] = true;
      }
    }

    /** Gets the value of the 'gid' field */
    public java.lang.CharSequence getGid() {
      return gid;
    }
    
    /** Sets the value of the 'gid' field */
    public com.eastsoft.river.router.proto.service1.MobileInfo.Builder setGid(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.gid = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'gid' field has been set */
    public boolean hasGid() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'gid' field */
    public com.eastsoft.river.router.proto.service1.MobileInfo.Builder clearGid() {
      gid = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'timeStamp' field */
    public java.lang.CharSequence getTimeStamp() {
      return timeStamp;
    }
    
    /** Sets the value of the 'timeStamp' field */
    public com.eastsoft.river.router.proto.service1.MobileInfo.Builder setTimeStamp(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.timeStamp = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'timeStamp' field has been set */
    public boolean hasTimeStamp() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'timeStamp' field */
    public com.eastsoft.river.router.proto.service1.MobileInfo.Builder clearTimeStamp() {
      timeStamp = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /** Gets the value of the 'optionalIMEI' field */
    public java.lang.CharSequence getOptionalIMEI() {
      return optionalIMEI;
    }
    
    /** Sets the value of the 'optionalIMEI' field */
    public com.eastsoft.river.router.proto.service1.MobileInfo.Builder setOptionalIMEI(java.lang.CharSequence value) {
      validate(fields()[2], value);
      this.optionalIMEI = value;
      fieldSetFlags()[2] = true;
      return this; 
    }
    
    /** Checks whether the 'optionalIMEI' field has been set */
    public boolean hasOptionalIMEI() {
      return fieldSetFlags()[2];
    }
    
    /** Clears the value of the 'optionalIMEI' field */
    public com.eastsoft.river.router.proto.service1.MobileInfo.Builder clearOptionalIMEI() {
      optionalIMEI = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /** Gets the value of the 'optionalTelNumber' field */
    public java.lang.CharSequence getOptionalTelNumber() {
      return optionalTelNumber;
    }
    
    /** Sets the value of the 'optionalTelNumber' field */
    public com.eastsoft.river.router.proto.service1.MobileInfo.Builder setOptionalTelNumber(java.lang.CharSequence value) {
      validate(fields()[3], value);
      this.optionalTelNumber = value;
      fieldSetFlags()[3] = true;
      return this; 
    }
    
    /** Checks whether the 'optionalTelNumber' field has been set */
    public boolean hasOptionalTelNumber() {
      return fieldSetFlags()[3];
    }
    
    /** Clears the value of the 'optionalTelNumber' field */
    public com.eastsoft.river.router.proto.service1.MobileInfo.Builder clearOptionalTelNumber() {
      optionalTelNumber = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    @Override
    public MobileInfo build() {
      try {
        MobileInfo record = new MobileInfo();
        record.gid = fieldSetFlags()[0] ? this.gid : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.timeStamp = fieldSetFlags()[1] ? this.timeStamp : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.optionalIMEI = fieldSetFlags()[2] ? this.optionalIMEI : (java.lang.CharSequence) defaultValue(fields()[2]);
        record.optionalTelNumber = fieldSetFlags()[3] ? this.optionalTelNumber : (java.lang.CharSequence) defaultValue(fields()[3]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}
