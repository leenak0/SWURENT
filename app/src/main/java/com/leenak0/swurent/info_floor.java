package com.leenak0.swurent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class info_floor extends AppCompatActivity {

    Button info_5f;
    Button info_f_prev;
    String info_building;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_floor);

        info_5f = (Button)findViewById(R.id.info_5f);
        info_f_prev = (Button)findViewById(R.id.info_f_prev);

        Intent intent = getIntent();
        info_building = intent.getStringExtra("info_building");

        info_5f.setOnClickListener(new View.OnClickListener(){ //50주년

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(info_floor.this, info_classroom.class);
                intent.putExtra("info_building", info_building);
                intent.putExtra("info_floor",5);
                startActivity(intent);
            }
        });

        info_f_prev.setOnClickListener(new View.OnClickListener(){ //뒤로

            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
