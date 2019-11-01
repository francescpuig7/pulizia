package com.example.my_task;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CalendarView;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Fes click al dia en el calendari per consultar les tasques", Snackbar.LENGTH_LONG).show();
            }
        });

        CalendarView calendarView2 = findViewById(R.id.calendarView2);
        calendarView2.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                List<String> adata = getDate(year, month, dayOfMonth);
                String message = "";
                for (int i=0; i<adata.size(); i++){
                    String m = adata.get(i);
                    message = message.concat(m);
                }

                Snackbar.make(view, message, 25000).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public List getDate(int year, int month, int day){
        List<String> users = new ArrayList<>();
        String year_ = Integer.toString(year);
        String month_ = Integer.toString(month);
        String day_ = Integer.toString(day);

        String ymd = "";
        ymd = ymd.concat(year_);
        ymd = ymd.concat(month_);
        ymd = ymd.concat(day_);

        //String tsd = new SimpleDateFormat("yyyyMMdd").format(ymd);
        users.add(ymd);
        users.add(":    ");
        users.add("Victor: Menjador,  ");
        users.add("Torne: Cuina,  ");
        users.add("Puig: Basura");

        return users;
    }
}
