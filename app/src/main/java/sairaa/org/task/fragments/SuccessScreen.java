package sairaa.org.task.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import sairaa.org.task.R;
import sairaa.org.task.databinding.FragmentSuccessScreenBinding;

public class SuccessScreen extends Fragment {

    private FragmentSuccessScreenBinding successScreenBinding;


    public SuccessScreen() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        successScreenBinding= DataBindingUtil.inflate(inflater,R.layout.fragment_success_screen, container, false);

        return successScreenBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        successScreenBinding.successScreenBackToHomeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_successScreen_to_mainScreen2);
            }
        });
    }
}
