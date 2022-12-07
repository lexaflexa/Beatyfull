package com.lexass.View;


import static java.util.stream.Collectors.toList;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.lexass.Model.Beauty;
import com.lexass.View.adapters.APIAdapter;
import com.lexass.ViewModels.APIViewModel;
import com.lexass.databinding.FragmentPeopleBinding;


public class APIFragment extends Fragment {
    private APIViewModel mViewModel;
    private FragmentPeopleBinding binding;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPeopleBinding.inflate(inflater, container, false);

        mViewModel = new ViewModelProvider(this).get(APIViewModel.class);

        View v = binding.getRoot();
        mViewModel.getAllBeauties().observe(getViewLifecycleOwner(), games -> {
            binding.peopleRecyclerView.setAdapter(
                    new APIAdapter(
                            this,
                            games.stream().map(Beauty::getName).collect(toList()),
                            games.stream().map(Beauty::getBackground_img).collect(toList())
                    )
            );
        });

        binding.peopleRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return v;
    }
}