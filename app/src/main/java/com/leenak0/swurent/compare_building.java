package com.leenak0.swurent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class compare_building extends AppCompatActivity {

    Button com_50;
    Button com_b_prev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare_building);

        com_50 = (Button)findViewById(R.id.com_50);
        com_b_prev = (Button)findViewById(R.id.com_b_prev);

        com_50.setOnClickListener(new View.OnClickListener(){ //50주년

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(compare_building.this, compare_floor.class);
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
