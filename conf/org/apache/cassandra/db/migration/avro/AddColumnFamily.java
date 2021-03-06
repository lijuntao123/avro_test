/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package org.apache.cassandra.db.migration.avro;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class AddColumnFamily extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"AddColumnFamily\",\"namespace\":\"org.apache.cassandra.db.migration.avro\",\"fields\":[{\"name\":\"cf\",\"type\":\"int\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public int cf;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public AddColumnFamily() {}

  /**
   * All-args constructor.
   */
  public AddColumnFamily(java.lang.Integer cf) {
    this.cf = cf;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return cf;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: cf = (java.lang.Integer)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'cf' field.
   */
  public java.lang.Integer getCf() {
    return cf;
  }

  /**
   * Sets the value of the 'cf' field.
   * @param value the value to set.
   */
  public void setCf(java.lang.Integer value) {
    this.cf = value;
  }

  /** Creates a new AddColumnFamily RecordBuilder */
  public static org.apache.cassandra.db.migration.avro.AddColumnFamily.Builder newBuilder() {
    return new org.apache.cassandra.db.migration.avro.AddColumnFamily.Builder();
  }
  
  /** Creates a new AddColumnFamily RecordBuilder by copying an existing Builder */
  public static org.apache.cassandra.db.migration.avro.AddColumnFamily.Builder newBuilder(org.apache.cassandra.db.migration.avro.AddColumnFamily.Builder other) {
    return new org.apache.cassandra.db.migration.avro.AddColumnFamily.Builder(other);
  }
  
  /** Creates a new AddColumnFamily RecordBuilder by copying an existing AddColumnFamily instance */
  public static org.apache.cassandra.db.migration.avro.AddColumnFamily.Builder newBuilder(org.apache.cassandra.db.migration.avro.AddColumnFamily other) {
    return new org.apache.cassandra.db.migration.avro.AddColumnFamily.Builder(other);
  }
  
  /**
   * RecordBuilder for AddColumnFamily instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<AddColumnFamily>
    implements org.apache.avro.data.RecordBuilder<AddColumnFamily> {

    private int cf;

    /** Creates a new Builder */
    private Builder() {
      super(org.apache.cassandra.db.migration.avro.AddColumnFamily.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(org.apache.cassandra.db.migration.avro.AddColumnFamily.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.cf)) {
        this.cf = data().deepCopy(fields()[0].schema(), other.cf);
        fieldSetFlags()[0] = true;
      }
    }
    
    /** Creates a Builder by copying an existing AddColumnFamily instance */
    private Builder(org.apache.cassandra.db.migration.avro.AddColumnFamily other) {
            super(org.apache.cassandra.db.migration.avro.AddColumnFamily.SCHEMA$);
      if (isValidValue(fields()[0], other.cf)) {
        this.cf = data().deepCopy(fields()[0].schema(), other.cf);
        fieldSetFlags()[0] = true;
      }
    }

    /** Gets the value of the 'cf' field */
    public java.lang.Integer getCf() {
      return cf;
    }
    
    /** Sets the value of the 'cf' field */
    public org.apache.cassandra.db.migration.avro.AddColumnFamily.Builder setCf(int value) {
      validate(fields()[0], value);
      this.cf = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'cf' field has been set */
    public boolean hasCf() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'cf' field */
    public org.apache.cassandra.db.migration.avro.AddColumnFamily.Builder clearCf() {
      fieldSetFlags()[0] = false;
      return this;
    }

    @Override
    public AddColumnFamily build() {
      try {
        AddColumnFamily record = new AddColumnFamily();
        record.cf = fieldSetFlags()[0] ? this.cf : (java.lang.Integer) defaultValue(fields()[0]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}
