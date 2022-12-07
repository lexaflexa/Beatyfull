package com.lexass;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.lexass.View.APIFragment;
import com.lexass.View.ComputersFragment;
import com.lexass.View.RoomsFragment;
import com.lexass.R;
import com.lexass.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new RoomsFragment());

        ServiceLocator.init(getApplicationContext());

        binding.bottomNavigation.setOnNavigationItemSelectedListener(item -> {

            switch (item.getItemId()){
                case R.id.home:
                    replaceFragment(new RoomsFragment());
                    break;
                case R.id.people:
                    replaceFragment(new APIFragment());
                    break;
                case R.id.computer:
                    replaceFragment(new ComputersFragment());
                    break;

            }
            return true;
        });
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_content, fragment);
        fragmentTransaction.commit();
    }

}