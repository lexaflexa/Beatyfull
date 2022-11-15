package com.lexass.aaaaaaaaaaaaa.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.lexass.aaaaaaaaaaaaa.BeautyViewmodel;
import com.lexass.aaaaaaaaaaaaa.databinding.FragmentHomeBinding;
import org.jetbrains.annotations.NotNull;

public class HomeFragment extends Fragment  {

    private FragmentHomeBinding binding;
    BeautyViewmodel model;
    Button mButton;
    TextView textView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}