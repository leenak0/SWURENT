package com.leenak0.swurent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class compare_floor extends AppCompatActivity {

    Button com_5f;
    Button com_f_prev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare_floor);

        com_5f = (Button)findViewById(R.id.com_5f);
        com_f_prev = (Button)findViewById(R.id.com_f_prev);

        com_5f.setOnClickListener(new View.OnClickListener(){ //50주년

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(compare_floor.this, compare_classroom.class);
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
