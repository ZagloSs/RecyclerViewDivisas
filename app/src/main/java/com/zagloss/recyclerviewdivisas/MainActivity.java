package com.zagloss.recyclerviewdivisas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<DvModel> dvModels = new ArrayList<DvModel>();
    EditText editDivisa;
    Button enviar;
    Switch vip;
    DvRvAdapter adapter;
    TextView conversion;

    View v;


    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rv = findViewById(R.id.recyclerdivisas);
        setDvModels();

        adapter = new DvRvAdapter(this, dvModels);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(this));

        editDivisa = findViewById(R.id.eurosTxt);
        enviar = findViewById(R.id.enviar);
        vip = findViewById(R.id.switchVip);
        conversion = findViewById(R.id.conversion);

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turnText();
            }
        });



    }

    public void turnText(){

        if(!editDivisa.getText().toString().isEmpty()){
            float dvsa = Float.parseFloat(editDivisa.getText().toString());
            float convers;

            if(vip.isChecked()){
                convers = adapter.divisaSelec.getCantidad() * dvsa;
            }else{
                convers = adapter.divisaSelec.getCantidad() * dvsa * 1.02f;
            }
            String conv = String.valueOf(convers);
            conversion.setText(conv + " " + adapter.divisaSelec.getMoneda());
        }else{
            Toast.makeText(this, "Porfavor, introduce una cantidad", Toast.LENGTH_SHORT).show();
        }
    }
    private void setDvModels(){
        String[] dvNames =getResources().getStringArray(R.array.divisas);
        String[] dvValores =getResources().getStringArray(R.array.valor);
        String[] dvMonedas = getResources().getStringArray(R.array.moneda);

        for(int i = 0; i<dvNames.length; i++){
            dvModels.add(new DvModel(dvNames[i], Float.parseFloat(dvValores[i]), dvMonedas[i]));
        }
    }
}