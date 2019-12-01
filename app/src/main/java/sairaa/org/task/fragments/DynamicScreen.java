package sairaa.org.task.fragments;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Pattern;

import sairaa.org.task.model.DetailsViewModel;
import sairaa.org.task.model.NormalScreenModel;
import sairaa.org.task.model.ScreeResponse;
import sairaa.org.task.model.ScreenFields;
import sairaa.org.task.R;
import sairaa.org.task.utils.AppUtils;
import sairaa.org.task.databinding.FragmentDynamicScreenBinding;
import sairaa.org.task.fragments.viewModel.DynamicScreenViewModel;

public class DynamicScreen extends Fragment {

    private FragmentDynamicScreenBinding dynamicScreenBinding;
    private DynamicScreenViewModel dynamicScreenViewModel;
    public static final String TAG="DynamicScreen";
    private LinearLayout rootLayout;
    private String stringDate;
    private Button button;
    private EditText surname,givnName,address;
    private TextView dob;
    private Spinner spinner_gender,spinner_bloodGropu;
    private String gender,bloodGroup;
    private boolean validate;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

         ViewGroup.LayoutParams lparams1 = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        rootLayout=new LinearLayout(getActivity());

        rootLayout.setLayoutParams(lparams1);
        rootLayout.setOrientation(LinearLayout.VERTICAL);



        return rootLayout;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dynamicScreenViewModel= ViewModelProviders.of(this)
                .get(DynamicScreenViewModel.class);

        retrieveScreenFields();

        dynamicScreenViewModel.getScreenFields().observe(this, new Observer<List<ScreenFields>>() {
            @Override
            public void onChanged(List<ScreenFields> screenFields) {
                setDynamicFields(screenFields);
            }
        });

    }
    private   void showDatePicker(final View view1) {
        final Calendar currentDate = Calendar.getInstance();
        final Calendar date;
        date = Calendar.getInstance();
        final Calendar finalDate = date;
        new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                finalDate.set(year, monthOfYear, dayOfMonth);
                stringDate=finalDate.getTime().toString();
                dob.setText(AppUtils.covertGSTTonormalDateFormat(stringDate));
            }
        }, currentDate.get(Calendar.YEAR), currentDate.get(Calendar.MONTH), currentDate.get(Calendar.DATE)).show();

    }


    InputFilter filter = new InputFilter() {
        @Override
        public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
            for (int i = start; i < end; ++i)
            {
                if (!Pattern.compile("[ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890]*").matcher(String.valueOf(source.charAt(i))).matches())
                {
                    return "";
                }
            }

            return null;
        }
    };
    private void setDynamicFields(List<ScreenFields> screenFields) {
        final LinearLayout.LayoutParams lparams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lparams.setMargins(50, 8, 50, 8);

        final LinearLayout.LayoutParams lparams2 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lparams2.setMargins(20, 200, 20, 8);
        lparams2.gravity=Gravity.BOTTOM;


        for (int i=0;i<screenFields.size();i++){

            if (screenFields.get(i).getType().equals("EditText")){
                EditText editText=new EditText(getActivity());
               editText.setLayoutParams(lparams);
                editText.setTag(screenFields.get(i).getFieldName());
                editText.setPadding(8,20,8,20);
                editText.setText(screenFields.get(i).getDisplayName());
               // editText.setFilters(new InputFilter[]{filter,new InputFilter.LengthFilter(screenFields.get(i).getMaxLength())});
                editText.setTextSize(16);
               rootLayout.addView(editText);
            }else if (screenFields.get(i).getType().equals("DatePicker")){
                TextView textView=new TextView(getActivity());
                textView.setLayoutParams(lparams);
               textView.setText("select Date Of Birth(YYYY/DD/MM)");
                textView.setTag(screenFields.get(i).getFieldName());
                textView.setPadding(20,20,8,20);
                textView.setBackgroundResource(R.drawable.background_curve);
                rootLayout.addView(textView);
            }else if (screenFields.get(i).getType().equals("Spinner")){
                Spinner spinner=new Spinner(getActivity());
                ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(getActivity(),R.layout.spinner_layout,screenFields.get(i).getValues());
               spinner.setLayoutParams(lparams);
               spinner.setTag(screenFields.get(i).getFieldName());
               spinner.setAdapter(arrayAdapter);
                spinner.setPadding(8,20,8,20);
                rootLayout.addView(spinner);
            }

        }


        surname=rootLayout.findViewWithTag("surname");
        givnName=rootLayout.findViewWithTag("givenname");
        address=rootLayout.findViewWithTag("address");
         spinner_gender=rootLayout.findViewWithTag("gender");
        spinner_bloodGropu=rootLayout.findViewWithTag("bloodgroup");
        dob=rootLayout.findViewWithTag("dob");

        surname.setImeOptions(EditorInfo.IME_ACTION_NEXT);
        givnName.setImeOptions(EditorInfo.IME_ACTION_DONE);
        address.setImeOptions(EditorInfo.IME_ACTION_DONE);
        givnName.setFilters(new InputFilter[]{filter,new InputFilter.LengthFilter(15)});
        surname.setFilters(new InputFilter[]{filter,new InputFilter.LengthFilter(15)});
        address.setFilters(new InputFilter[]{filter,new InputFilter.LengthFilter(30)});


        spinner_gender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
               gender=adapterView.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinner_bloodGropu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                bloodGroup=adapterView.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePicker(view);
            }
        });

        button=new Button(getActivity());
        button.setText("Submit");
       button.setBackgroundColor(getActivity().getResources().getColor(R.color.colorPrimaryDark));
       button.setLayoutParams(lparams2);
       button.setTextColor(getActivity().getResources().getColor(R.color.white));
       rootLayout.addView(button);



       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               if(!validate){
                   if (surname.getText().length()==0 || TextUtils.equals(surname.getText().toString(),"Surname")){
                       surname.requestFocus();
                       surname.setError("Please Enter Surname");
                       return;
                   }else if (givnName.getText().length()==0 || TextUtils.equals(givnName.getText().toString(),"Given Name")){
                       givnName.requestFocus();
                       givnName.setError("Please Enter Name");
                       return;
                   }else if (gender.equals("Select")){
                       Toast.makeText(getActivity(),"Please select Gender",Toast.LENGTH_SHORT).show();
                       return;
                   }
                   else if (dob.getText().equals("select Date Of Birth(YYYY/DD/MM)")){
                       Toast.makeText(getActivity(),"Please select dob",Toast.LENGTH_SHORT).show();
                       return;
                   }else if (bloodGroup.equals("Select")){
                       Toast.makeText(getActivity(),"Please select Blood Group",Toast.LENGTH_SHORT).show();
                       return;
                   }else if (TextUtils.equals(address.getText().toString(),"Address")||address.getText().length()==0){
                       address.requestFocus();
                       address.setError("Please Enter Name");
                       return;
                   }

               }

               DetailsViewModel data=new DetailsViewModel();
               data.setSurname(surname.getText().toString());
               data.setFullName(givnName.getText().toString());
               data.setCreationDate(dob.getText().toString());
               data.setBloodGroup(bloodGroup);
               data.setGender(gender);
               data.setAddress(address.getText().toString());
               data.setPassPortId("--");
               data.setPpIssueDate("--");
               data.setPpExpriyDate("--");

//               Bundle bundle=new Bundle();
//               bundle.putSerializable("data",data);
               Navigation.findNavController(view).navigate(R.id.action_dynamicScreen_to_detailsScreen);
           }
       });


    }


    private void retrieveScreenFields() {
                StringBuilder builder = new StringBuilder();
                InputStream in = this.getResources().openRawResource(R.raw.screen_fields);
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                String line;
                String lineX = "";
                try {
                    while ((line = reader.readLine()) != null) {
                        builder.append(line);
                        lineX = lineX.concat(line);
                    }
                    JSONObject json = new JSONObject(builder.toString());

                } catch (IOException | JSONException exception) {
                    exception.printStackTrace();
                }

                ScreeResponse screeResponse = new Gson().fromJson(lineX,ScreeResponse.class);
                screeResponse.getInputFields();

                dynamicScreenViewModel.setScreenFields(screeResponse.getInputFields());

                Log.e(TAG,""+new Gson().toJson(screeResponse));

    }

}
