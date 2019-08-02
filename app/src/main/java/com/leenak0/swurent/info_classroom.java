package com.leenak0.swurent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class info_classroom extends AppCompatActivity {

    Button info_c1;
    Button info_c_prev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_classroom);

        info_c1 = (Button)findViewById(R.id.info_c1);
        info_c_prev = (Button)findViewById(R.id.info_c_prev);

        info_c1.setOnClickListener(new View.OnClickListener(){ //50주년

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(info_classroom.this, info.class);
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
