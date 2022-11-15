package com.lexass.aaaaaaaaaaaaa.ui.dashboard;

import static android.app.Activity.RESULT_OK;
import static com.lexass.aaaaaaaaaaaaa.ui.notification.NotificationsFragment.ADD_NOTE_REQUEST;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.List;
import com.lexass.aaaaaaaaaaaaa.AppBeauty;
import com.lexass.aaaaaaaaaaaaa.Beauty;
import com.lexass.aaaaaaaaaaaaa.BeautyAdapter;
import com.lexass.aaaaaaaaaaaaa.BeautyViewmodel;
import com.lexass.aaaaaaaaaaaaa.databinding.FragmentDashboardBinding;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;
    BeautyViewmodel model;
    Button mButton;
    public Context mContext;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        model = new ViewModelProvider(this).get(BeautyViewmodel.class);
        binding.tutorialRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.tutorialRecycler.setHasFixedSize(true);
        BeautyAdapter beautyAdapter = new BeautyAdapter();
        binding.tutorialRecycler.setAdapter(beautyAdapter);
        model.getAllBeautis().observe(getViewLifecycleOwner(), new Observer<List<Beauty>>() {
            @Override
            public void onChanged(List<Beauty> beauties) {
                beautyAdapter.setBeauty(beauties);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode,int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if (requestCode == ADD_NOTE_REQUEST && resultCode == RESULT_OK){
            String name = data.getStringExtra(AppBeauty.EXTRA_NAME);
            String beautyname = data.getStringExtra(AppBeauty.EXTRA_BEAUTYNAME);
            String recept = data.getStringExtra(AppBeauty.EXTRA_CLIENT);

            Beauty beauty = new Beauty(0,name,beautyname,recept);
            model.insert(beauty);
            Toast.makeText(getContext(),"Notesavcd",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getContext(),"цфвфц",Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}