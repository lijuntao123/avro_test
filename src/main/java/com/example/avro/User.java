/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package com.example.avro;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class User extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"User\",\"namespace\":\"com.example.avro\",\"fields\":[{\"name\":\"name\",\"type\":\"string\"},{\"name\":\"favorite_number\",\"type\":[\"string\",\"null\"]},{\"name\":\"favorite_color\",\"type\":[\"string\",\"null\"]},{\"name\":\"age\",\"type\":[\"string\",\"null\"]},{\"name\":\"class1\",\"type\":[\"string\",\"null\"]},{\"name\":\"number\",\"type\":[\"string\",\"null\"]},{\"name\":\"address\",\"type\":[\"string\",\"null\"]},{\"name\":\"phone\",\"type\":[\"string\",\"null\"]},{\"name\":\"first_name\",\"type\":[\"string\",\"null\"]},{\"name\":\"last_name\",\"type\":[\"string\",\"null\"]}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public java.lang.CharSequence name;
  @Deprecated public java.lang.CharSequence favorite_number;
  @Deprecated public java.lang.CharSequence favorite_color;
  @Deprecated public java.lang.CharSequence age;
  @Deprecated public java.lang.CharSequence class1;
  @Deprecated public java.lang.CharSequence number;
  @Deprecated public java.lang.CharSequence address;
  @Deprecated public java.lang.CharSequence phone;
  @Deprecated public java.lang.CharSequence first_name;
  @Deprecated public java.lang.CharSequence last_name;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use {@link \#newBuilder()}. 
   */
  public User() {}

  /**
   * All-args constructor.
   */
  public User(java.lang.CharSequence name, java.lang.CharSequence favorite_number, java.lang.CharSequence favorite_color, java.lang.CharSequence age, java.lang.CharSequence class1, java.lang.CharSequence number, java.lang.CharSequence address, java.lang.CharSequence phone, java.lang.CharSequence first_name, java.lang.CharSequence last_name) {
    this.name = name;
    this.favorite_number = favorite_number;
    this.favorite_color = favorite_color;
    this.age = age;
    this.class1 = class1;
    this.number = number;
    this.address = address;
    this.phone = phone;
    this.first_name = first_name;
    this.last_name = last_name;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return name;
    case 1: return favorite_number;
    case 2: return favorite_color;
    case 3: return age;
    case 4: return class1;
    case 5: return number;
    case 6: return address;
    case 7: return phone;
    case 8: return first_name;
    case 9: return last_name;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: name = (java.lang.CharSequence)value$; break;
    case 1: favorite_number = (java.lang.CharSequence)value$; break;
    case 2: favorite_color = (java.lang.CharSequence)value$; break;
    case 3: age = (java.lang.CharSequence)value$; break;
    case 4: class1 = (java.lang.CharSequence)value$; break;
    case 5: number = (java.lang.CharSequence)value$; break;
    case 6: address = (java.lang.CharSequence)value$; break;
    case 7: phone = (java.lang.CharSequence)value$; break;
    case 8: first_name = (java.lang.CharSequence)value$; break;
    case 9: last_name = (java.lang.CharSequence)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'name' field.
   */
  public java.lang.CharSequence getName() {
    return name;
  }

  /**
   * Sets the value of the 'name' field.
   * @param value the value to set.
   */
  public void setName(java.lang.CharSequence value) {
    this.name = value;
  }

  /**
   * Gets the value of the 'favorite_number' field.
   */
  public java.lang.CharSequence getFavoriteNumber() {
    return favorite_number;
  }

  /**
   * Sets the value of the 'favorite_number' field.
   * @param value the value to set.
   */
  public void setFavoriteNumber(java.lang.CharSequence value) {
    this.favorite_number = value;
  }

  /**
   * Gets the value of the 'favorite_color' field.
   */
  public java.lang.CharSequence getFavoriteColor() {
    return favorite_color;
  }

  /**
   * Sets the value of the 'favorite_color' field.
   * @param value the value to set.
   */
  public void setFavoriteColor(java.lang.CharSequence value) {
    this.favorite_color = value;
  }

  /**
   * Gets the value of the 'age' field.
   */
  public java.lang.CharSequence getAge() {
    return age;
  }

  /**
   * Sets the value of the 'age' field.
   * @param value the value to set.
   */
  public void setAge(java.lang.CharSequence value) {
    this.age = value;
  }

  /**
   * Gets the value of the 'class1' field.
   */
  public java.lang.CharSequence getClass1() {
    return class1;
  }

  /**
   * Sets the value of the 'class1' field.
   * @param value the value to set.
   */
  public void setClass1(java.lang.CharSequence value) {
    this.class1 = value;
  }

  /**
   * Gets the value of the 'number' field.
   */
  public java.lang.CharSequence getNumber() {
    return number;
  }

  /**
   * Sets the value of the 'number' field.
   * @param value the value to set.
   */
  public void setNumber(java.lang.CharSequence value) {
    this.number = value;
  }

  /**
   * Gets the value of the 'address' field.
   */
  public java.lang.CharSequence getAddress() {
    return address;
  }

  /**
   * Sets the value of the 'address' field.
   * @param value the value to set.
   */
  public void setAddress(java.lang.CharSequence value) {
    this.address = value;
  }

  /**
   * Gets the value of the 'phone' field.
   */
  public java.lang.CharSequence getPhone() {
    return phone;
  }

  /**
   * Sets the value of the 'phone' field.
   * @param value the value to set.
   */
  public void setPhone(java.lang.CharSequence value) {
    this.phone = value;
  }

  /**
   * Gets the value of the 'first_name' field.
   */
  public java.lang.CharSequence getFirstName() {
    return first_name;
  }

  /**
   * Sets the value of the 'first_name' field.
   * @param value the value to set.
   */
  public void setFirstName(java.lang.CharSequence value) {
    this.first_name = value;
  }

  /**
   * Gets the value of the 'last_name' field.
   */
  public java.lang.CharSequence getLastName() {
    return last_name;
  }

  /**
   * Sets the value of the 'last_name' field.
   * @param value the value to set.
   */
  public void setLastName(java.lang.CharSequence value) {
    this.last_name = value;
  }

  /** Creates a new User RecordBuilder */
  public static com.example.avro.User.Builder newBuilder() {
    return new com.example.avro.User.Builder();
  }
  
  /** Creates a new User RecordBuilder by copying an existing Builder */
  public static com.example.avro.User.Builder newBuilder(com.example.avro.User.Builder other) {
    return new com.example.avro.User.Builder(other);
  }
  
  /** Creates a new User RecordBuilder by copying an existing User instance */
  public static com.example.avro.User.Builder newBuilder(com.example.avro.User other) {
    return new com.example.avro.User.Builder(other);
  }
  
  /**
   * RecordBuilder for User instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<User>
    implements org.apache.avro.data.RecordBuilder<User> {

    private java.lang.CharSequence name;
    private java.lang.CharSequence favorite_number;
    private java.lang.CharSequence favorite_color;
    private java.lang.CharSequence age;
    private java.lang.CharSequence class1;
    private java.lang.CharSequence number;
    private java.lang.CharSequence address;
    private java.lang.CharSequence phone;
    private java.lang.CharSequence first_name;
    private java.lang.CharSequence last_name;

    /** Creates a new Builder */
    private Builder() {
      super(com.example.avro.User.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(com.example.avro.User.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.name)) {
        this.name = data().deepCopy(fields()[0].schema(), other.name);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.favorite_number)) {
        this.favorite_number = data().deepCopy(fields()[1].schema(), other.favorite_number);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.favorite_color)) {
        this.favorite_color = data().deepCopy(fields()[2].schema(), other.favorite_color);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.age)) {
        this.age = data().deepCopy(fields()[3].schema(), other.age);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.class1)) {
        this.class1 = data().deepCopy(fields()[4].schema(), other.class1);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.number)) {
        this.number = data().deepCopy(fields()[5].schema(), other.number);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.address)) {
        this.address = data().deepCopy(fields()[6].schema(), other.address);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.phone)) {
        this.phone = data().deepCopy(fields()[7].schema(), other.phone);
        fieldSetFlags()[7] = true;
      }
      if (isValidValue(fields()[8], other.first_name)) {
        this.first_name = data().deepCopy(fields()[8].schema(), other.first_name);
        fieldSetFlags()[8] = true;
      }
      if (isValidValue(fields()[9], other.last_name)) {
        this.last_name = data().deepCopy(fields()[9].schema(), other.last_name);
        fieldSetFlags()[9] = true;
      }
    }
    
    /** Creates a Builder by copying an existing User instance */
    private Builder(com.example.avro.User other) {
            super(com.example.avro.User.SCHEMA$);
      if (isValidValue(fields()[0], other.name)) {
        this.name = data().deepCopy(fields()[0].schema(), other.name);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.favorite_number)) {
        this.favorite_number = data().deepCopy(fields()[1].schema(), other.favorite_number);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.favorite_color)) {
        this.favorite_color = data().deepCopy(fields()[2].schema(), other.favorite_color);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.age)) {
        this.age = data().deepCopy(fields()[3].schema(), other.age);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.class1)) {
        this.class1 = data().deepCopy(fields()[4].schema(), other.class1);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.number)) {
        this.number = data().deepCopy(fields()[5].schema(), other.number);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.address)) {
        this.address = data().deepCopy(fields()[6].schema(), other.address);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.phone)) {
        this.phone = data().deepCopy(fields()[7].schema(), other.phone);
        fieldSetFlags()[7] = true;
      }
      if (isValidValue(fields()[8], other.first_name)) {
        this.first_name = data().deepCopy(fields()[8].schema(), other.first_name);
        fieldSetFlags()[8] = true;
      }
      if (isValidValue(fields()[9], other.last_name)) {
        this.last_name = data().deepCopy(fields()[9].schema(), other.last_name);
        fieldSetFlags()[9] = true;
      }
    }

    /** Gets the value of the 'name' field */
    public java.lang.CharSequence getName() {
      return name;
    }
    
    /** Sets the value of the 'name' field */
    public com.example.avro.User.Builder setName(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.name = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'name' field has been set */
    public boolean hasName() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'name' field */
    public com.example.avro.User.Builder clearName() {
      name = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'favorite_number' field */
    public java.lang.CharSequence getFavoriteNumber() {
      return favorite_number;
    }
    
    /** Sets the value of the 'favorite_number' field */
    public com.example.avro.User.Builder setFavoriteNumber(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.favorite_number = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'favorite_number' field has been set */
    public boolean hasFavoriteNumber() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'favorite_number' field */
    public com.example.avro.User.Builder clearFavoriteNumber() {
      favorite_number = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /** Gets the value of the 'favorite_color' field */
    public java.lang.CharSequence getFavoriteColor() {
      return favorite_color;
    }
    
    /** Sets the value of the 'favorite_color' field */
    public com.example.avro.User.Builder setFavoriteColor(java.lang.CharSequence value) {
      validate(fields()[2], value);
      this.favorite_color = value;
      fieldSetFlags()[2] = true;
      return this; 
    }
    
    /** Checks whether the 'favorite_color' field has been set */
    public boolean hasFavoriteColor() {
      return fieldSetFlags()[2];
    }
    
    /** Clears the value of the 'favorite_color' field */
    public com.example.avro.User.Builder clearFavoriteColor() {
      favorite_color = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /** Gets the value of the 'age' field */
    public java.lang.CharSequence getAge() {
      return age;
    }
    
    /** Sets the value of the 'age' field */
    public com.example.avro.User.Builder setAge(java.lang.CharSequence value) {
      validate(fields()[3], value);
      this.age = value;
      fieldSetFlags()[3] = true;
      return this; 
    }
    
    /** Checks whether the 'age' field has been set */
    public boolean hasAge() {
      return fieldSetFlags()[3];
    }
    
    /** Clears the value of the 'age' field */
    public com.example.avro.User.Builder clearAge() {
      age = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /** Gets the value of the 'class1' field */
    public java.lang.CharSequence getClass1() {
      return class1;
    }
    
    /** Sets the value of the 'class1' field */
    public com.example.avro.User.Builder setClass1(java.lang.CharSequence value) {
      validate(fields()[4], value);
      this.class1 = value;
      fieldSetFlags()[4] = true;
      return this; 
    }
    
    /** Checks whether the 'class1' field has been set */
    public boolean hasClass1() {
      return fieldSetFlags()[4];
    }
    
    /** Clears the value of the 'class1' field */
    public com.example.avro.User.Builder clearClass1() {
      class1 = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    /** Gets the value of the 'number' field */
    public java.lang.CharSequence getNumber() {
      return number;
    }
    
    /** Sets the value of the 'number' field */
    public com.example.avro.User.Builder setNumber(java.lang.CharSequence value) {
      validate(fields()[5], value);
      this.number = value;
      fieldSetFlags()[5] = true;
      return this; 
    }
    
    /** Checks whether the 'number' field has been set */
    public boolean hasNumber() {
      return fieldSetFlags()[5];
    }
    
    /** Clears the value of the 'number' field */
    public com.example.avro.User.Builder clearNumber() {
      number = null;
      fieldSetFlags()[5] = false;
      return this;
    }

    /** Gets the value of the 'address' field */
    public java.lang.CharSequence getAddress() {
      return address;
    }
    
    /** Sets the value of the 'address' field */
    public com.example.avro.User.Builder setAddress(java.lang.CharSequence value) {
      validate(fields()[6], value);
      this.address = value;
      fieldSetFlags()[6] = true;
      return this; 
    }
    
    /** Checks whether the 'address' field has been set */
    public boolean hasAddress() {
      return fieldSetFlags()[6];
    }
    
    /** Clears the value of the 'address' field */
    public com.example.avro.User.Builder clearAddress() {
      address = null;
      fieldSetFlags()[6] = false;
      return this;
    }

    /** Gets the value of the 'phone' field */
    public java.lang.CharSequence getPhone() {
      return phone;
    }
    
    /** Sets the value of the 'phone' field */
    public com.example.avro.User.Builder setPhone(java.lang.CharSequence value) {
      validate(fields()[7], value);
      this.phone = value;
      fieldSetFlags()[7] = true;
      return this; 
    }
    
    /** Checks whether the 'phone' field has been set */
    public boolean hasPhone() {
      return fieldSetFlags()[7];
    }
    
    /** Clears the value of the 'phone' field */
    public com.example.avro.User.Builder clearPhone() {
      phone = null;
      fieldSetFlags()[7] = false;
      return this;
    }

    /** Gets the value of the 'first_name' field */
    public java.lang.CharSequence getFirstName() {
      return first_name;
    }
    
    /** Sets the value of the 'first_name' field */
    public com.example.avro.User.Builder setFirstName(java.lang.CharSequence value) {
      validate(fields()[8], value);
      this.first_name = value;
      fieldSetFlags()[8] = true;
      return this; 
    }
    
    /** Checks whether the 'first_name' field has been set */
    public boolean hasFirstName() {
      return fieldSetFlags()[8];
    }
    
    /** Clears the value of the 'first_name' field */
    public com.example.avro.User.Builder clearFirstName() {
      first_name = null;
      fieldSetFlags()[8] = false;
      return this;
    }

    /** Gets the value of the 'last_name' field */
    public java.lang.CharSequence getLastName() {
      return last_name;
    }
    
    /** Sets the value of the 'last_name' field */
    public com.example.avro.User.Builder setLastName(java.lang.CharSequence value) {
      validate(fields()[9], value);
      this.last_name = value;
      fieldSetFlags()[9] = true;
      return this; 
    }
    
    /** Checks whether the 'last_name' field has been set */
    public boolean hasLastName() {
      return fieldSetFlags()[9];
    }
    
    /** Clears the value of the 'last_name' field */
    public com.example.avro.User.Builder clearLastName() {
      last_name = null;
      fieldSetFlags()[9] = false;
      return this;
    }

    public User build() {
      try {
        User record = new User();
        record.name = fieldSetFlags()[0] ? this.name : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.favorite_number = fieldSetFlags()[1] ? this.favorite_number : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.favorite_color = fieldSetFlags()[2] ? this.favorite_color : (java.lang.CharSequence) defaultValue(fields()[2]);
        record.age = fieldSetFlags()[3] ? this.age : (java.lang.CharSequence) defaultValue(fields()[3]);
        record.class1 = fieldSetFlags()[4] ? this.class1 : (java.lang.CharSequence) defaultValue(fields()[4]);
        record.number = fieldSetFlags()[5] ? this.number : (java.lang.CharSequence) defaultValue(fields()[5]);
        record.address = fieldSetFlags()[6] ? this.address : (java.lang.CharSequence) defaultValue(fields()[6]);
        record.phone = fieldSetFlags()[7] ? this.phone : (java.lang.CharSequence) defaultValue(fields()[7]);
        record.first_name = fieldSetFlags()[8] ? this.first_name : (java.lang.CharSequence) defaultValue(fields()[8]);
        record.last_name = fieldSetFlags()[9] ? this.last_name : (java.lang.CharSequence) defaultValue(fields()[9]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}