package com.leenak0.swurent;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class reservation extends AppCompatActivity {

    TextView selected_time;
    TextView selected_object;
    TextView textDate;
    Spinner spinner_time;
    Spinner spinner_object;

    Intent intent2;
    String date;

    Button btn_reservation, btn_move_back_reservation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);

        intent2 = getIntent();
        date = intent2.getStringExtra("date");
        textDate = (TextView) findViewById(R.id.date);
        textDate.setText(date);

        selected_time = (TextView) findViewById(R.id.selected_time);
        selected_object = (TextView) findViewById(R.id.selected_object);

        spinner_time = (Spinner)findViewById(R.id.spinner_time);
        spinner_object = (Spinner)findViewById(R.id.spinner_object);


        btn_reservation = (Button)findViewById(R.id.btn_reservation);
        btn_move_back_reservation = (Button)findViewById(R.id.btn_move_back_reservation);

        btn_move_back_reservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        btn_reservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show();
            }
        });


        spinner_time.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                selected_time.setText("9시 ~ " + adapterView.getItemAtPosition(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        spinner_object.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }


    void show() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("예약완료");
        builder.setMessage("예약이 완료 되었습니다.");
        builder.setPositiveButton("확인",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "예약완료", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(reservation.this, MainActivity.class);
                        startActivity(intent);
                    }
                });
        builder.show();
    }

}
