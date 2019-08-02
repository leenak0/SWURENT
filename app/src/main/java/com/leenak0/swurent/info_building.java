package com.leenak0.swurent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class info_building extends AppCompatActivity {

    Button info_50;
    Button info_b_prev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_building);

        info_50 = (Button)findViewById(R.id.info_50);
        info_b_prev = (Button)findViewById(R.id.info_b_prev);

        info_50.setOnClickListener(new View.OnClickListener(){ //50주년

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(info_building.this, info_floor.class);
                startActivity(intent);
            }
        });

        info_b_prev.setOnClickListener(new View.OnClickListener(){ //뒤로

            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
