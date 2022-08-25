package com.example.weightedexample;

import java.math.BigDecimal;

public class AttributeModel {

    private String name;

    private String value;

    private BigDecimal valueNumber;

    private String[] listValues;
    private boolean mandatory;

    private String valueArray;
    private int attributeId;
    private String valueType; // List - L, String - S, Number - N.

    transient private int attributeSetId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public BigDecimal getValueNumber() {
        return valueNumber;
    }

    public void setValueNumber(BigDecimal valueNumber) {
        this.valueNumber = valueNumber;
    }

    public String[] getListValues() {
        return listValues;
    }

    public void setListValues(String[] listValues) {
        this.listValues = listValues;
    }

    public boolean isMandatory() {
        return mandatory;
    }

    public void setMandatory(boolean mandatory) {
        this.mandatory = mandatory;
    }

    public String getValueArray() {
        return valueArray;
    }

    public void setValueArray(String valueArray) {
        this.valueArray = valueArray;
    }

    public int getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(int attributeId) {
        this.attributeId = attributeId;
    }

    public String getValueType() {
        return valueType;
    }

    public void setValueType(String valueType) {
        this.valueType = valueType;
    }

    public int getAttributeSetId() {
        return attributeSetId;
    }

    public void setAttributeSetId(int attributeSetId) {
        this.attributeSetId = attributeSetId;
    }
}
