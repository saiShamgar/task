package sairaa.org.task.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavHostController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import sairaa.org.task.R;
import sairaa.org.task.databinding.FragmentMainScreenBinding;

public class MainScreen extends Fragment {

    private FragmentMainScreenBinding mainScreenBinding;
    private NavController navController;


    public MainScreen() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mainScreenBinding= DataBindingUtil.inflate(inflater,R.layout.fragment_main_screen,container,false);

        return mainScreenBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mainScreenBinding.normalScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_mainScreen_to_normalScreen);
            }
        });

        mainScreenBinding.dynamicScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_mainScreen_to_dynamicScreen);

            }
        });
    }
}
