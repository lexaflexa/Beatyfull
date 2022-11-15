package com.lexass.aaaaaaaaaaaaa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class AppBeauty extends AppCompatActivity {
    public static final String EXTRA_NAME = "com.codinginflow.architectureexample.EXTRA_NAME";
    public static final String EXTRA_BEAUTYNAME = "com.codinginflow.architectureexample.EXTRA_BEAUTYNAME";
    public static final String EXTRA_CLIENT = "com.codinginflow.architectureexample.EXTRA_CLIENT";
    private EditText Name;
    private EditText Beautyname;
    private EditText Client;
    Button button;
    BeautyViewmodel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spisoc);
        Name = (EditText) findViewById(R.id.input_name);
        Beautyname = (EditText) findViewById(R.id.input_beautyname);
        Client = (EditText) findViewById(R.id.input_client);
        button = (Button) findViewById(R.id.add);
        String name = Name.getText().toString();
        String beautyname = Beautyname.getText().toString();
        String client = Client.getText().toString();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.trim().isEmpty()||beautyname.trim().isEmpty()|| client.trim().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Please add all",Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent data = new Intent();
                data.putExtra(EXTRA_NAME, name);
                data.putExtra(EXTRA_BEAUTYNAME, beautyname);
                data.putExtra(EXTRA_CLIENT,client);
                setResult(RESULT_OK,data);
                finish();
            }
        });
    }
}