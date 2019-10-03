package com.leenak0.swurent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class reservation_building extends AppCompatActivity {

    Button reserv_50;
    Button reserv_b_prev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation_building);



        reserv_50 = (Button)findViewById(R.id.reserv_50);
        reserv_b_prev = (Button)findViewById(R.id.reserv_b_prev);

        reserv_50.setOnClickListener(new View.OnClickListener(){ //50주년

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(reservation_building.this, reservation_floor.class);
                intent.putExtra("building_name", "50주년 기념관");
                startActivity(intent);
            }
        });

        reserv_b_prev.setOnClickListener(new View.OnClickListener(){ //뒤로

            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
