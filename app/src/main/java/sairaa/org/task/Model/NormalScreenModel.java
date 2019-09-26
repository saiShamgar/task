package sairaa.org.task.Model;

import java.io.Serializable;

public class NormalScreenModel implements Serializable {

    private String surName;
    private String fullName;
    private String creationDate;
    private String gender;
    private String address;
    private String ppIssueDate;
    private String ppExpriyDate;
    private String bloodGroup;
    private String PassPortId;

    public NormalScreenModel(String surName, String fullName, String creationDate, String gender, String address, String ppIssueDate, String ppExpriyDate, String bloodGroup, String passPortId) {
        this.surName = surName;
        this.fullName = fullName;
        this.creationDate = creationDate;
        this.gender = gender;
        this.address = address;
        this.ppIssueDate = ppIssueDate;
        this.ppExpriyDate = ppExpriyDate;
        this.bloodGroup = bloodGroup;
        PassPortId = passPortId;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getPassPortId() {
        return PassPortId;
    }

    public void setPassPortId(String passPortId) {
        PassPortId = passPortId;
    }

    public NormalScreenModel() {
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPpIssueDate() {
        return ppIssueDate;
    }

    public void setPpIssueDate(String ppIssueDate) {
        this.ppIssueDate = ppIssueDate;
    }

    public String getPpExpriyDate() {
        return ppExpriyDate;
    }

    public void setPpExpriyDate(String ppExpriyDate) {
        this.ppExpriyDate = ppExpriyDate;
    }
}
