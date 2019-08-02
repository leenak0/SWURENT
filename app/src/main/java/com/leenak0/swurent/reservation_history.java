package com.leenak0.swurent;

import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;

public class reservation_history extends AppCompatActivity {

    private TableLayout tableLayout;
    Button rh_prev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation_history);

        rh_prev=(Button)findViewById(R.id.rh_prev);
        tableLayout = (TableLayout) findViewById(R.id.table_layout);
        tableLayout.setShrinkAllColumns(true);

        rh_prev.setOnClickListener(new View.OnClickListener(){ //뒤로

            @Override
            public void onClick(View v) {
                //popup
                finish();
            }
        });
    }

    public void onBackPressed(View v) {
        Toast.makeText(this, "뒤로가기 버튼이 눌렸습니다.", Toast.LENGTH_SHORT).show();
        super.onBackPressed();
    }

    public void cancelButton(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("예약 취소").setMessage("예약을 취소하시겠습니까?.");

        builder.setPositiveButton("아니요", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                Toast.makeText(getApplicationContext(), "예약이 유지됩니다.", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("예", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                Toast.makeText(getApplicationContext(), "예약이 취소되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public void reservedButton(View v) {
        Toast.makeText(getApplicationContext(), "예약 중입니다.", Toast.LENGTH_SHORT).show();
    }

    public void representButton(View v) {
        Toast.makeText(getApplicationContext(), "대표자 성명 : 전세희", Toast.LENGTH_SHORT).show();
    }
}