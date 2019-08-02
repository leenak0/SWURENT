package com.leenak0.swurent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class info extends AppCompatActivity {

    Button info_prev;
    //Button info_reserv;
    Button info_com;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        info_prev = (Button)findViewById(R.id.info_prev);
        //info_reserv = (Button)findViewById(R.id.info_reserv);
        info_com=(Button)findViewById(R.id.info_com);

        info_com.setOnClickListener(new View.OnClickListener(){ //50주년

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(info.this, compare_building.class);
                startActivity(intent);
            }
        });

        info_prev.setOnClickListener(new View.OnClickListener(){ //뒤로

            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
