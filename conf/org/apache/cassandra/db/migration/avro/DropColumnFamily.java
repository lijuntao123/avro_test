/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package org.apache.cassandra.db.migration.avro;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class DropColumnFamily extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"DropColumnFamily\",\"namespace\":\"org.apache.cassandra.db.migration.avro\",\"fields\":[{\"name\":\"ksname\",\"type\":\"string\"},{\"name\":\"cfname\",\"type\":\"string\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public java.lang.CharSequence ksname;
  @Deprecated public java.lang.CharSequence cfname;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public DropColumnFamily() {}

  /**
   * All-args constructor.
   */
  public DropColumnFamily(java.lang.CharSequence ksname, java.lang.CharSequence cfname) {
    this.ksname = ksname;
    this.cfname = cfname;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return ksname;
    case 1: return cfname;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: ksname = (java.lang.CharSequence)value$; break;
    case 1: cfname = (java.lang.CharSequence)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'ksname' field.
   */
  public java.lang.CharSequence getKsname() {
    return ksname;
  }

  /**
   * Sets the value of the 'ksname' field.
   * @param value the value to set.
   */
  public void setKsname(java.lang.CharSequence value) {
    this.ksname = value;
  }

  /**
   * Gets the value of the 'cfname' field.
   */
  public java.lang.CharSequence getCfname() {
    return cfname;
  }

  /**
   * Sets the value of the 'cfname' field.
   * @param value the value to set.
   */
  public void setCfname(java.lang.CharSequence value) {
    this.cfname = value;
  }

  /** Creates a new DropColumnFamily RecordBuilder */
  public static org.apache.cassandra.db.migration.avro.DropColumnFamily.Builder newBuilder() {
    return new org.apache.cassandra.db.migration.avro.DropColumnFamily.Builder();
  }
  
  /** Creates a new DropColumnFamily RecordBuilder by copying an existing Builder */
  public static org.apache.cassandra.db.migration.avro.DropColumnFamily.Builder newBuilder(org.apache.cassandra.db.migration.avro.DropColumnFamily.Builder other) {
    return new org.apache.cassandra.db.migration.avro.DropColumnFamily.Builder(other);
  }
  
  /** Creates a new DropColumnFamily RecordBuilder by copying an existing DropColumnFamily instance */
  public static org.apache.cassandra.db.migration.avro.DropColumnFamily.Builder newBuilder(org.apache.cassandra.db.migration.avro.DropColumnFamily other) {
    return new org.apache.cassandra.db.migration.avro.DropColumnFamily.Builder(other);
  }
  
  /**
   * RecordBuilder for DropColumnFamily instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<DropColumnFamily>
    implements org.apache.avro.data.RecordBuilder<DropColumnFamily> {

    private java.lang.CharSequence ksname;
    private java.lang.CharSequence cfname;

    /** Creates a new Builder */
    private Builder() {
      super(org.apache.cassandra.db.migration.avro.DropColumnFamily.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(org.apache.cassandra.db.migration.avro.DropColumnFamily.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.ksname)) {
        this.ksname = data().deepCopy(fields()[0].schema(), other.ksname);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.cfname)) {
        this.cfname = data().deepCopy(fields()[1].schema(), other.cfname);
        fieldSetFlags()[1] = true;
      }
    }
    
    /** Creates a Builder by copying an existing DropColumnFamily instance */
    private Builder(org.apache.cassandra.db.migration.avro.DropColumnFamily other) {
            super(org.apache.cassandra.db.migration.avro.DropColumnFamily.SCHEMA$);
      if (isValidValue(fields()[0], other.ksname)) {
        this.ksname = data().deepCopy(fields()[0].schema(), other.ksname);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.cfname)) {
        this.cfname = data().deepCopy(fields()[1].schema(), other.cfname);
        fieldSetFlags()[1] = true;
      }
    }

    /** Gets the value of the 'ksname' field */
    public java.lang.CharSequence getKsname() {
      return ksname;
    }
    
    /** Sets the value of the 'ksname' field */
    public org.apache.cassandra.db.migration.avro.DropColumnFamily.Builder setKsname(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.ksname = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'ksname' field has been set */
    public boolean hasKsname() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'ksname' field */
    public org.apache.cassandra.db.migration.avro.DropColumnFamily.Builder clearKsname() {
      ksname = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'cfname' field */
    public java.lang.CharSequence getCfname() {
      return cfname;
    }
    
    /** Sets the value of the 'cfname' field */
    public org.apache.cassandra.db.migration.avro.DropColumnFamily.Builder setCfname(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.cfname = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'cfname' field has been set */
    public boolean hasCfname() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'cfname' field */
    public org.apache.cassandra.db.migration.avro.DropColumnFamily.Builder clearCfname() {
      cfname = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    public DropColumnFamily build() {
      try {
        DropColumnFamily record = new DropColumnFamily();
        record.ksname = fieldSetFlags()[0] ? this.ksname : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.cfname = fieldSetFlags()[1] ? this.cfname : (java.lang.CharSequence) defaultValue(fields()[1]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}
