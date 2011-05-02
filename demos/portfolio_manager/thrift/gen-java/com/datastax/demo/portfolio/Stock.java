/**
 * Autogenerated by Thrift
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package com.datastax.demo.portfolio;

import java.util.*;

import org.apache.commons.lang.builder.HashCodeBuilder;

public class Stock implements org.apache.thrift.TBase<Stock, Stock._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("Stock");

  private static final org.apache.thrift.protocol.TField TICKER_FIELD_DESC = new org.apache.thrift.protocol.TField("ticker", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField PRICE_FIELD_DESC = new org.apache.thrift.protocol.TField("price", org.apache.thrift.protocol.TType.DOUBLE, (short)2);

  public String ticker;
  public double price;

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    TICKER((short)1, "ticker"),
    PRICE((short)2, "price");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // TICKER
          return TICKER;
        case 2: // PRICE
          return PRICE;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __PRICE_ISSET_ID = 0;
  private BitSet __isset_bit_vector = new BitSet(1);

  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.TICKER, new org.apache.thrift.meta_data.FieldMetaData("ticker", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.PRICE, new org.apache.thrift.meta_data.FieldMetaData("price", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(Stock.class, metaDataMap);
  }

  public Stock() {
  }

  public Stock(
    String ticker,
    double price)
  {
    this();
    this.ticker = ticker;
    this.price = price;
    setPriceIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public Stock(Stock other) {
    __isset_bit_vector.clear();
    __isset_bit_vector.or(other.__isset_bit_vector);
    if (other.isSetTicker()) {
      this.ticker = other.ticker;
    }
    this.price = other.price;
  }

  public Stock deepCopy() {
    return new Stock(this);
  }

  @Override
  public void clear() {
    this.ticker = null;
    setPriceIsSet(false);
    this.price = 0.0;
  }

  public String getTicker() {
    return this.ticker;
  }

  public Stock setTicker(String ticker) {
    this.ticker = ticker;
    return this;
  }

  public void unsetTicker() {
    this.ticker = null;
  }

  /** Returns true if field ticker is set (has been assigned a value) and false otherwise */
  public boolean isSetTicker() {
    return this.ticker != null;
  }

  public void setTickerIsSet(boolean value) {
    if (!value) {
      this.ticker = null;
    }
  }

  public double getPrice() {
    return this.price;
  }

  public Stock setPrice(double price) {
    this.price = price;
    setPriceIsSet(true);
    return this;
  }

  public void unsetPrice() {
    __isset_bit_vector.clear(__PRICE_ISSET_ID);
  }

  /** Returns true if field price is set (has been assigned a value) and false otherwise */
  public boolean isSetPrice() {
    return __isset_bit_vector.get(__PRICE_ISSET_ID);
  }

  public void setPriceIsSet(boolean value) {
    __isset_bit_vector.set(__PRICE_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case TICKER:
      if (value == null) {
        unsetTicker();
      } else {
        setTicker((String)value);
      }
      break;

    case PRICE:
      if (value == null) {
        unsetPrice();
      } else {
        setPrice((Double)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case TICKER:
      return getTicker();

    case PRICE:
      return new Double(getPrice());

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case TICKER:
      return isSetTicker();
    case PRICE:
      return isSetPrice();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof Stock)
      return this.equals((Stock)that);
    return false;
  }

  public boolean equals(Stock that) {
    if (that == null)
      return false;

    boolean this_present_ticker = true && this.isSetTicker();
    boolean that_present_ticker = true && that.isSetTicker();
    if (this_present_ticker || that_present_ticker) {
      if (!(this_present_ticker && that_present_ticker))
        return false;
      if (!this.ticker.equals(that.ticker))
        return false;
    }

    boolean this_present_price = true;
    boolean that_present_price = true;
    if (this_present_price || that_present_price) {
      if (!(this_present_price && that_present_price))
        return false;
      if (this.price != that.price)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    HashCodeBuilder builder = new HashCodeBuilder();

    boolean present_ticker = true && (isSetTicker());
    builder.append(present_ticker);
    if (present_ticker)
      builder.append(ticker);

    boolean present_price = true;
    builder.append(present_price);
    if (present_price)
      builder.append(price);

    return builder.toHashCode();
  }

  public int compareTo(Stock other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    Stock typedOther = (Stock)other;

    lastComparison = Boolean.valueOf(isSetTicker()).compareTo(typedOther.isSetTicker());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTicker()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.ticker, typedOther.ticker);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetPrice()).compareTo(typedOther.isSetPrice());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPrice()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.price, typedOther.price);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    org.apache.thrift.protocol.TField field;
    iprot.readStructBegin();
    while (true)
    {
      field = iprot.readFieldBegin();
      if (field.type == org.apache.thrift.protocol.TType.STOP) { 
        break;
      }
      switch (field.id) {
        case 1: // TICKER
          if (field.type == org.apache.thrift.protocol.TType.STRING) {
            this.ticker = iprot.readString();
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 2: // PRICE
          if (field.type == org.apache.thrift.protocol.TType.DOUBLE) {
            this.price = iprot.readDouble();
            setPriceIsSet(true);
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        default:
          org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
      }
      iprot.readFieldEnd();
    }
    iprot.readStructEnd();

    // check for required fields of primitive type, which can't be checked in the validate method
    validate();
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    validate();

    oprot.writeStructBegin(STRUCT_DESC);
    if (this.ticker != null) {
      oprot.writeFieldBegin(TICKER_FIELD_DESC);
      oprot.writeString(this.ticker);
      oprot.writeFieldEnd();
    }
    oprot.writeFieldBegin(PRICE_FIELD_DESC);
    oprot.writeDouble(this.price);
    oprot.writeFieldEnd();
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("Stock(");
    boolean first = true;

    sb.append("ticker:");
    if (this.ticker == null) {
      sb.append("null");
    } else {
      sb.append(this.ticker);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("price:");
    sb.append(this.price);
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
  }

}

