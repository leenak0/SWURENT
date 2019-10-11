package com.leenak0.swurent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class compare_classroom extends AppCompatActivity {

    Button com_c2;
    Button com_c_prev;
    String info_building, info_classroom, sen1, com_building;
    int info_floor, com_floor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare_classroom);

        com_c2 = (Button)findViewById(R.id.com_c2);
        com_c_prev = (Button)findViewById(R.id.com_c_prev);

        Intent intent = getIntent();
        info_building = intent.getStringExtra("info_building");
        info_floor = intent.getIntExtra("info_floor",0);
        info_classroom = intent.getStringExtra("info_classroom");
        sen1 = intent.getStringExtra("sen1");
        com_building = intent.getStringExtra("com_building");
        com_floor = intent.getIntExtra("com_floor",0);

        com_c2.setOnClickListener(new View.OnClickListener(){ //502호

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(compare_classroom.this, compare.class);
                intent.putExtra("info_building", info_building);
                intent.putExtra("info_floor",info_floor);
                intent.putExtra("info_classroom", info_classroom);
                intent.putExtra("sen1",sen1);
                intent.putExtra("com_building",com_building);
                intent.putExtra("com_floor",com_floor);
                intent.putExtra("com_classroom", "502호");
                intent.putExtra("sen2","b2");
                startActivity(intent);
            }
        });

        com_c_prev.setOnClickListener(new View.OnClickListener(){ //뒤로

            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
