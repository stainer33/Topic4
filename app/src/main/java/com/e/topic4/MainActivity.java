package com.e.topic4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String countries []={"Nepal", "Kathmandu",
            "India", "New Delhi",
            "China","Bejing",
            "Africa","Capetown"};
    Map<String,String> dictionay=new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        for(int i=0;i<countries.length;i+=2)
        {
            dictionay.put(countries[i],countries[i+1]);
        }

        ArrayAdapter countryAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,new ArrayList<>(dictionay.keySet()));
        listView.setAdapter(countryAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String country= parent.getItemAtPosition(position).toString();
                String capital = dictionay.get(country);
               // Toast.makeText(getApplicationContext(),capital.toString(),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, ShowActivity.class);
                intent.putExtra("capital",capital.toString());
                startActivity(intent);
            }
        });
    }
}
