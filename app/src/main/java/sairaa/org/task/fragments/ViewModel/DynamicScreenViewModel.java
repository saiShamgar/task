package sairaa.org.task.fragments.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import sairaa.org.task.Model.ScreenFields;

public class DynamicScreenViewModel extends ViewModel {

    private MutableLiveData<List<ScreenFields>> mutableLiveData=new MutableLiveData<>();

   public void setScreenFields(List<ScreenFields> screenFields){
        mutableLiveData.setValue(screenFields);

    }

   public LiveData<List<ScreenFields>> getScreenFields(){
        return mutableLiveData;
    }
}
