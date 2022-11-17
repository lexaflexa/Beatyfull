package com.lexass.aaaaaaaaaaaaa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.room.Room;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    EditText Beautyname;
    EditText BeautyClient;
    EditText Name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BeautyClient = (EditText) findViewById(R.id.BeautyClient);
        Beautyname = (EditText) findViewById(R.id.Beautyname);
        Name = (EditText) findViewById(R.id.Name);



        BeautyViewmodel viewmodel = ViewModelProviders.of(this).get(BeautyViewmodel.class);

        BeautyDatabase db = Room.databaseBuilder(getApplicationContext(),
                BeautyDatabase.class, "beauty-database").allowMainThreadQueries().build();

        Beauty kate = new Beauty("Kate", "Lexa", "nails");
        Button button = findViewById(R.id.addButton);

        button.setOnClickListener(view ->  {
            String BEAUTY_NAME = Beautyname.getText().toString();
            String BEAUTY_CLIENT = BeautyClient.getText().toString();
            String NAME = Name.getText().toString();
            Beauty lexa = new Beauty(NAME,BEAUTY_NAME, BEAUTY_CLIENT);
            viewmodel.insert(lexa);

            Intent intent = new Intent(MainActivity.this, BeautySpisok.class);
            startActivity(intent);

            Context context = getApplicationContext();
            CharSequence text = "Вы успешно записались!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
            addEvent();

            Toast.makeText(context, text, duration).show();

        });






        viewmodel.getAllBeautis().observe(this, beautyList -> {

            // if(beautyList == null){
            //   return;
            //}

            for (Beauty list : beautyList) {
                Log.d("beautis", list.name + " " + list.beauty_name + " " + list.client);

            }
        });
    }
    public void addEvent(){
        Log.d("Calendar", "Begin func");
        Intent calendarIntent = new Intent(Intent.ACTION_INSERT, CalendarContract.Events.CONTENT_URI);

        Calendar cal = Calendar.getInstance();
        long startTime = cal.getTimeInMillis() + 24*60*60*1000;
        long endTime = startTime + 60 * 180 * 1000;
        calendarIntent.putExtra(CalendarContract.Events.TITLE, "Запись на ноготочки");
        calendarIntent.putExtra(CalendarContract.Events.EVENT_LOCATION, "Место для ноготочков");
        calendarIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, startTime);
        calendarIntent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime);

        startActivity(calendarIntent);
        Log.d("Calendar", "End func");

    }
}