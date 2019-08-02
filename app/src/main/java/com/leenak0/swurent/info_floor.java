package com.leenak0.swurent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class info_floor extends AppCompatActivity {

    Button info_5f;
    Button info_f_prev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_floor);

        info_5f = (Button)findViewById(R.id.info_5f);
        info_f_prev = (Button)findViewById(R.id.info_f_prev);

        info_5f.setOnClickListener(new View.OnClickListener(){ //50주년

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(info_floor.this, info_classroom.class);
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
