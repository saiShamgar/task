package sairaa.org.task.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

public class DetailsViewModel extends BaseObservable {

   // private NormalScreenModel model=new NormalScreenModel();

    public String  surName;
    public String fullName;
    public String creationDate;
    public String gender;
    public String address;
    public String ppIssueDate;
    public String ppExpriyDate;
    public String bloodGroup;
    public String PassPortId;

    @Bindable
    public String getSurname(){
        return surName;
    }

    public void setSurname(String value){
            surName = value;
            // Notify observers of a new value.
        notifyChange();
            notifyPropertyChanged(BR.surname);

    }

    @Bindable
    public String getFullName(){
        return fullName;
    }

    public void setFullName(String value){
            fullName = value;
            // Notify observers of a new value.
        notifyChange();
            notifyPropertyChanged(BR.fullName);
    }

    @Bindable
    public String getCreationDate(){
        return creationDate;
    }

    public void setCreationDate(String value){
            creationDate = value;
            // Notify observers of a new value.
        notifyChange();
            notifyPropertyChanged(BR.creationDate);
    }

    @Bindable
    public String getGender(){
        return gender;
    }

    public void setGender(String value){
            gender = value;
            // Notify observers of a new value.
        notifyChange();
            notifyPropertyChanged(BR.gender);
    }

    @Bindable
    public String getAddress(){
        return address;
    }

    public void setAddress(String value){
            address = value;
            // Notify observers of a new value.
        notifyChange();
            notifyPropertyChanged(BR.address);
    }

    @Bindable
    public String getPpIssueDate(){
        return ppIssueDate;
    }

    public void setPpIssueDate(String value){
            ppIssueDate = value;
            // Notify observers of a new value.
        notifyChange();
            notifyPropertyChanged(BR.ppIssueDate);
    }

    @Bindable
    public String getPpExpriyDate(){
        return ppExpriyDate;
    }

    public void setPpExpriyDate(String value){
            ppExpriyDate = value;
            // Notify observers of a new value.
        notifyChange();
            notifyPropertyChanged(BR.ppExpriyDate);
    }

    @Bindable
    public String getBloodGroup(){
        return bloodGroup;
    }

    public void setBloodGroup(String value){
            bloodGroup = value;
            // Notify observers of a new value.
        notifyChange();
            notifyPropertyChanged(BR.bloodGroup);
    }

    @Bindable
    public String getPassPortId(){
        return PassPortId;
    }

    public void setPassPortId(String value){
            PassPortId = value;
            // Notify observers of a new value.
        notifyChange();
            notifyPropertyChanged(BR.passPortId);
    }
}
