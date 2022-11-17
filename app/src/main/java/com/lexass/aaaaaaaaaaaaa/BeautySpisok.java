package com.lexass.aaaaaaaaaaaaa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import android.widget.Button;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class BeautySpisok  extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spisoc);

        setContentView(R.layout.activity_spisoc);
        Button button2 = (Button)findViewById(R.id.addBeauty);




    }

    public void toAddBeauty(View view) {
        Intent intent = new Intent(BeautySpisok.this, MainActivity.class);
        startActivity(intent);
    }

}
