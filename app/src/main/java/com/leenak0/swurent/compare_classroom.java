package com.leenak0.swurent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class compare_classroom extends AppCompatActivity {

    Button com_c2;
    Button com_c_prev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare_classroom);

        com_c2 = (Button)findViewById(R.id.com_c2);
        com_c_prev = (Button)findViewById(R.id.com_c_prev);

        com_c2.setOnClickListener(new View.OnClickListener(){ //50주년

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(compare_classroom.this, compare.class);
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
