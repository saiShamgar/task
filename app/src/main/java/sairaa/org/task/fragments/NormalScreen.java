package sairaa.org.task.fragments;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Objects;

import sairaa.org.task.Model.NormalScreenModel;
import sairaa.org.task.R;
import sairaa.org.task.Utils.AppUtils;
import sairaa.org.task.Utils.Constants;
import sairaa.org.task.databinding.FragmentNormalScreenBinding;


public class NormalScreen extends Fragment implements Constants {

    private FragmentNormalScreenBinding normalScreenBinding;
    private String stringDate;
    private boolean validate ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        normalScreenBinding= DataBindingUtil.inflate(inflater,R.layout.fragment_normal_screen, container, false);

        return normalScreenBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        normalScreenBinding.normalScnSbtButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (doValidation()){
                    NormalScreenModel data=new NormalScreenModel();
                    data.setSurName(normalScreenBinding.surname.getText().toString().trim());
                    data.setFullName(normalScreenBinding.fullName.getText().toString().trim());
                    data.setCreationDate(normalScreenBinding.selectDate.getText().toString().trim());
                    data.setBloodGroup(normalScreenBinding.bloodGroup.getText().toString().trim());
                    data.setGender(radioGroupSelectedText(normalScreenBinding.genderRadioGroup));
                    data.setAddress(normalScreenBinding.address.getText().toString().trim());
                    data.setPassPortId(normalScreenBinding.passportId.getText().toString().trim());
                    data.setPpIssueDate(normalScreenBinding.selectPpIssueDate.getText().toString());
                    data.setPpExpriyDate(normalScreenBinding.selectPpExpiryDate.getText().toString().trim());

                    Bundle bundle=new Bundle();
                    bundle.putSerializable("data",data);

                    Navigation.findNavController(view).navigate(R.id.action_normalScreen_to_detailsScreen,bundle);
                }
              //
            }
        });

        normalScreenBinding.selectDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showDatePicker(view);

            }
        });

        normalScreenBinding.selectPpIssueDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePicker(view);
            }
        });

        normalScreenBinding.selectPpExpiryDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePicker(view);
            }
        });
    }

    private   void showDatePicker(final View view1) {
        final Calendar currentDate = Calendar.getInstance();
        Calendar date;
        date = Calendar.getInstance();
        final Calendar finalDate = date;
        new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                finalDate.set(year, monthOfYear, dayOfMonth);
                stringDate=finalDate.getTime().toString();

                if (view1.getId()==R.id.selectDate){
                    normalScreenBinding.selectDate.setText(AppUtils.covertGSTTonormalDateFormat(stringDate));

                }else if (view1.getId()==R.id.select_pp_issue_date){
                    normalScreenBinding.selectPpIssueDate.setText(AppUtils.covertGSTTonormalDateFormat(stringDate));
                }
                else if (view1.getId()==R.id.select_pp_expiry_date){
                    normalScreenBinding.selectPpExpiryDate.setText(AppUtils.covertGSTTonormalDateFormat(stringDate));

                }

            }
        }, currentDate.get(Calendar.YEAR), currentDate.get(Calendar.MONTH), currentDate.get(Calendar.DATE)).show();

    }

    private String radioGroupSelectedText(RadioGroup id){
        int radioButtonID = id.getCheckedRadioButtonId();
        RadioButton radioButton =  id.findViewById(radioButtonID);
        String selectedtext = (String) radioButton.getText();
        Log.e("selectedtext",selectedtext);

        return selectedtext;
    }

    boolean doValidation(){
        validate=true;
        if (normalScreenBinding.surname.getText().length()==0){
            validate=false;
            normalScreenBinding.surname.requestFocus();
            normalScreenBinding.surname.setError("Surname can't be Empty");
        }else if (normalScreenBinding.fullName.getText().length()==0){
            validate=false;
            normalScreenBinding.fullName.requestFocus();
            normalScreenBinding.fullName.setError("Name can't be Empty");
        }else if(normalScreenBinding.selectDate.getText().equals(SELECT)){
            validate=false;
            Toast.makeText(getActivity(),"Please select date of birth",Toast.LENGTH_SHORT).show();
        }else if (normalScreenBinding.bloodGroup.getText().length()==0){
            validate=false;
            normalScreenBinding.bloodGroup.requestFocus();
            normalScreenBinding.bloodGroup.setError("Blood Group can't be empty");
        }
        else if (!normalScreenBinding.radioBtnMale.isChecked() && !normalScreenBinding.radioBtnFemale.isChecked()){
            validate=false;
            Toast.makeText(getActivity(),"Please select Gender",Toast.LENGTH_SHORT).show();
        }else if (normalScreenBinding.address.getText().length()==0){
            validate=false;
            normalScreenBinding.address.requestFocus();
            normalScreenBinding.address.setError("Address can't be Empty");
        }else if (normalScreenBinding.passportId.getText().length()==0){
            validate=false;
            normalScreenBinding.passportId.requestFocus();
            normalScreenBinding.passportId.setError("PassPort Id Can't be empty");
        }
        else if (normalScreenBinding.selectPpIssueDate.getText().equals(SELECT)){
            validate=false;
            Toast.makeText(getActivity(),"Please select PassPort Issue Date",Toast.LENGTH_SHORT).show();
        }else if (normalScreenBinding.selectPpExpiryDate.getText().equals(SELECT)){
            validate=false;
            Toast.makeText(getActivity(),"Please select PassPort Expiry Date",Toast.LENGTH_SHORT).show();
        }

        return validate;
    }


}
