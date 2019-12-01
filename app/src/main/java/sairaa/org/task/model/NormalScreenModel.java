package sairaa.org.task.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

import java.io.Serializable;

public class NormalScreenModel extends BaseObservable implements Serializable {

    public String surName;
    public String fullName;
    public String creationDate;
    public String gender;
    public String address;
    public String ppIssueDate;
    public String ppExpriyDate;
    public String bloodGroup;
    public String PassPortId;

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
