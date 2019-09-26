package sairaa.org.task.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import sairaa.org.task.Model.NormalScreenModel;
import sairaa.org.task.R;
import sairaa.org.task.databinding.FragmentDetailsScreenBinding;

public class DetailsScreen extends Fragment {

    private FragmentDetailsScreenBinding detailsScreenBinding;
    private NormalScreenModel data;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        detailsScreenBinding= DataBindingUtil.inflate(inflater,R.layout.fragment_details_screen, container, false);

        return detailsScreenBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        data= (NormalScreenModel) getArguments().getSerializable("data");

        if (data!=null){
           detailsScreenBinding.surname.setText(data.getSurName());
           detailsScreenBinding.fullname.setText(data.getFullName());
           detailsScreenBinding.dob.setText(data.getCreationDate());
           detailsScreenBinding.gender.setText(data.getGender());
           detailsScreenBinding.address.setText(data.getAddress());
           detailsScreenBinding.passportId.setText(data.getPassPortId());
           detailsScreenBinding.ppIssueDate.setText(data.getPpIssueDate());
           detailsScreenBinding.ppExpiryDate.setText(data.getPpExpriyDate());
           detailsScreenBinding.bloodGroup.setText(data.getBloodGroup());
        }


        detailsScreenBinding.detailsConfirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_detailsScreen_to_successScreen);
            }
        });
    }
}
