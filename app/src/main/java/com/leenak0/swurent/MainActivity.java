package com.leenak0.swurent;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton setting;
    Button main1;
    Button main2;
    Button main3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main1=(Button)findViewById(R.id.main1);
        main2=(Button)findViewById(R.id.main2);
        main3=(Button)findViewById(R.id.main3);
        setting = (ImageButton)findViewById(R.id.setting);

        main1.setOnClickListener(new View.OnClickListener(){ //강의실정보

            @Override
            public void onClick(View v) {
                //popup
                Intent intent = new Intent(MainActivity.this, info_building.class);
                startActivity(intent);
            }
        });

        main2.setOnClickListener(new View.OnClickListener(){ //강의실대여

            @Override
            public void onClick(View v) {
                //popup
                Intent intent = new Intent(MainActivity.this, reservation_building.class);
                startActivity(intent);
            }
        });

        main3.setOnClickListener(new View.OnClickListener(){ //예약내역

            @Override
            public void onClick(View v) {
                //popup
                Intent intent = new Intent(MainActivity.this, reservation_history.class);
                startActivity(intent);
            }
        });

        setting.setOnClickListener(new View.OnClickListener(){ //setting

            @Override
            public void onClick(View v) {
                //popup
                Intent intent = new Intent(MainActivity.this, Setting.class);
                startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==1){
            if(resultCode==RESULT_OK){

            }
        }
    }
}
