package com.leenak0.swurent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class compare_building extends AppCompatActivity {

    Button com_insa;
    Button com_b_prev;
    String info_building, info_classroom, sen1;
    int info_floor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare_building);

        com_insa = (Button)findViewById(R.id.com_insa);
        com_b_prev = (Button)findViewById(R.id.com_b_prev);

        Intent intent = getIntent();
        info_building = intent.getStringExtra("info_building");
        info_floor = intent.getIntExtra("info_floor",0);
        info_classroom = intent.getStringExtra("info_classroom");
        sen1 = intent.getStringExtra("sen1");

        com_insa.setOnClickListener(new View.OnClickListener(){ //50주년

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(compare_building.this, compare_floor.class);
                intent.putExtra("info_building", info_building);
                intent.putExtra("info_floor",info_floor);
                intent.putExtra("info_classroom", info_classroom);
                intent.putExtra("sen1",sen1);
                intent.putExtra("com_building","인문사회관");
                startActivity(intent);
            }
        });

        com_b_prev.setOnClickListener(new View.OnClickListener(){ //뒤로

            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
