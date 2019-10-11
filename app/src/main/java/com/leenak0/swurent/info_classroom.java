package com.leenak0.swurent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class info_classroom extends AppCompatActivity {

    Button info_c1;
    Button info_c_prev;
    String info_building;
    int info_floor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_classroom);

        info_c1 = (Button)findViewById(R.id.info_c1);
        info_c_prev = (Button)findViewById(R.id.info_c_prev);

        Intent intent = getIntent();
        info_building = intent.getStringExtra("info_building");
        info_floor = intent.getIntExtra("info_floor",0);

        info_c1.setOnClickListener(new View.OnClickListener(){ //501호

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(info_classroom.this, info.class);
                intent.putExtra("info_building", info_building);
                intent.putExtra("info_floor",info_floor);
                intent.putExtra("info_classroom", "501호");
                intent.putExtra("sen1","b1");
                startActivity(intent);
            }
        });

        info_c_prev.setOnClickListener(new View.OnClickListener(){ //뒤로

            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
