package com.leenak0.swurent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class reservation_floor extends AppCompatActivity {

    Button reserv_6f;
    Button reserv_f_prev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation_floor);

        reserv_6f = (Button)findViewById(R.id.reserv_6f);
        reserv_f_prev = (Button)findViewById(R.id.reserv_f_prev);

        reserv_6f.setOnClickListener(new View.OnClickListener(){ //6층

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(reservation_floor.this, reservation_classroom.class);
                startActivity(intent);
            }
        });

        reserv_f_prev.setOnClickListener(new View.OnClickListener(){ //뒤로

            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}