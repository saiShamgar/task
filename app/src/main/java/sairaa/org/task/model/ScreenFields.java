package sairaa.org.task.model;

import java.util.List;

public class ScreenFields {

    String fieldName;
    String displayName;
    Integer required;
    String type;
    Integer minLength;
    Integer maxLength;
    Boolean multiline;
    List<String> values;

    public ScreenFields(String fieldName, String displayName, Integer required, String type, Integer minLength, Integer maxLength, Boolean multiline, List<String> values) {
        this.fieldName = fieldName;
        this.displayName = displayName;
        this.required = required;
        this.type = type;
        this.minLength = minLength;
        this.maxLength = maxLength;
        this.multiline = multiline;
        this.values = values;
    }

    public List<String> getValues() {
        return values;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }

    public ScreenFields() {
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Integer getRequired() {
        return required;
    }

    public void setRequired(Integer required) {
        this.required = required;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getMinLength() {
        return minLength;
    }

    public void setMinLength(Integer minLength) {
        this.minLength = minLength;
    }

    public Integer getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(Integer maxLength) {
        this.maxLength = maxLength;
    }

    public Boolean getMultiline() {
        return multiline;
    }

    public void setMultiline(Boolean multiline) {
        this.multiline = multiline;
    }
}
