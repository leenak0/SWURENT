package com.leenak0.swurent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class compare_floor extends AppCompatActivity {

    Button com_5f;
    Button com_f_prev;
    String info_building, info_classroom, sen1, com_building;
    int info_floor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare_floor);

        com_5f = (Button)findViewById(R.id.com_5f);
        com_f_prev = (Button)findViewById(R.id.com_f_prev);

        Intent intent = getIntent();
        info_building = intent.getStringExtra("info_building");
        info_floor = intent.getIntExtra("info_floor",0);
        info_classroom = intent.getStringExtra("info_classroom");
        sen1 = intent.getStringExtra("sen1");
        com_building = intent.getStringExtra("com_building");

        com_5f.setOnClickListener(new View.OnClickListener(){ //50주년

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(compare_floor.this, compare_classroom.class);
                intent.putExtra("info_building", info_building);
                intent.putExtra("info_floor",info_floor);
                intent.putExtra("info_classroom", info_classroom);
                intent.putExtra("sen1",sen1);
                intent.putExtra("com_building",com_building);
                intent.putExtra("com_floor",5);
                startActivity(intent);
            }
        });

        com_f_prev.setOnClickListener(new View.OnClickListener(){ //뒤로

            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
