package com.zagloss.recyclerviewdivisas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<DvModel> dvModels = new ArrayList<DvModel>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rv = findViewById(R.id.recyclerdivisas);
        setDvModels();

        DvRvAdapter adapter = new DvRvAdapter(this, dvModels);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(this));
    }



    private void setDvModels(){
        String[] dvNames =getResources().getStringArray(R.array.divisas);
        String[] dvValores =getResources().getStringArray(R.array.valor);

        for(int i = 0; i<dvNames.length; i++){
            dvModels.add(new DvModel(dvNames[i], Float.parseFloat(dvValores[i])));
        }
    }
}