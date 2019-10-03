package com.leenak0.swurent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class reservation extends AppCompatActivity implements View.OnClickListener {


    //Accesss a Cloud Firestore instance from your Activity
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    private Spinner spinner1;
    ArrayList<String> arrayList;
    ArrayAdapter<String> arrayAdapter;

    private TextView building_txt, classroom_txt, notice, notice_content, choice_time, usercnt_txt, username_txt, purpose_txt, other_txt, txt_date;
    private EditText usercnt_edit, usernumber_edit, username_edit, userphone_edit;
    private Button btn_reservation, cancel_reservation;
    private CheckBox check9, check10, check11, check12, check13, check14, check15, check16;

    Intent intent;
    String date, classnum, building_name, username, userphone, usernumber, usercnt, object;
    int [] result_time = new int[8];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);

        btn_reservation = (Button)findViewById(R.id.btn_reservation);
        cancel_reservation = (Button)findViewById(R.id.cancel_reservation);


        //날짜선택표시
        intent = getIntent();
        date = intent.getStringExtra("date");
        txt_date = (TextView) findViewById(R.id.txt_date);
        txt_date.setText(date);
        //날짜선택표시끝


        //건물, 호수 선택 액티비티로 전환
        building_txt = (TextView) findViewById(R.id.building_txt);
        building_name = intent.getStringExtra("building_name");
        building_txt.setOnClickListener(this);

        //호수 정보 넘겨받기
        classroom_txt = (TextView) findViewById(R.id.classroom_txt);
        classnum = intent.getStringExtra("classnum");
        classroom_txt.setText(classnum);
        classroom_txt.setOnClickListener(this);


        //스피너 관련 코드
        arrayList = new ArrayList<>();
        arrayList.add("팀 프로젝트");
        arrayList.add("스터디");
        arrayList.add("대회 진행");
        arrayList.add("강연");


        arrayAdapter = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_spinner_dropdown_item,
                arrayList);

        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner1.setAdapter(arrayAdapter);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), arrayList.get(i) + "가 선택되었습니다.",
                        Toast.LENGTH_SHORT).show();

                object = spinner1.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        //스피너 관련 코드 종료

        //체크박스 관련 코드
        CheckBox check9 = (CheckBox) findViewById(R.id.check9);
        CheckBox check10 = (CheckBox) findViewById(R.id.check10);
        CheckBox check11 = (CheckBox) findViewById(R.id.check11);
        CheckBox check12 = (CheckBox) findViewById(R.id.check12);
        CheckBox check13 = (CheckBox) findViewById(R.id.check13);
        CheckBox check14 = (CheckBox) findViewById(R.id.check14);
        CheckBox check15 = (CheckBox) findViewById(R.id.check15);
        CheckBox check16 = (CheckBox) findViewById(R.id.check16);

        check9.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) result_time[0] = 1;
                else result_time[0] = 0;
            }
        });
        check10.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) result_time[1] = 1;
                else result_time[1] = 0;
            }
        });
        check11.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) result_time[2] = 1;
                else result_time[2] = 0;
            }
        });
        check12.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) result_time[3] = 1;
                else result_time[3] = 0;
            }
        });
        check13.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) result_time[4] = 1;
                else result_time[4] = 0;
            }
        });
        check14.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) result_time[5] = 1;
                else result_time[5] = 0;
            }
        });
        check15.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) result_time[6] = 1;
                else result_time[6] = 0;
            }
        });
        check16.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) result_time[7] = 1;
                else result_time[7] = 0;
            }
        });

        //edittext 관련 코드
        usernumber_edit = (EditText)findViewById(R.id.usernumber_edit);
        //usernumber = usernumber_edit.getText().toString();
        username_edit = (EditText)findViewById(R.id.username_edit);
        //username = username_edit.getText().toString();
        userphone_edit = (EditText)findViewById(R.id.userphone_edit);
        //userphone = userphone_edit.getText().toString();
        usercnt_edit = (EditText)findViewById(R.id.usercnt_edit);
        //usercnt = usercnt_edit.getText().toString();


        //예약하기 버튼 눌렀을 때 파이어스토어에 값 저장
        btn_reservation.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Toast.makeText(getApplicationContext(), usernumber_edit.getText().toString(), Toast.LENGTH_LONG).show();

                Map<String, Object> quote = new HashMap<>();
                Map<String, Object> quote2 = new HashMap<>();

                for (int i = 0; i<8; i++) {
                    if (result_time[i] == 1) {
                        String time = Integer.toString(i+9);
                        quote.put(time, Arrays.asList(usernumber_edit.getText().toString(), username_edit.getText().toString(), userphone_edit.getText().toString(), usercnt_edit.getText().toString(), object));
                        db.collection("예시").document(txt_date.getText().toString() +"_"+building_name +"_"+ classnum)
                                .set(quote, SetOptions.merge());

                        quote2.put(txt_date.getText().toString()+"_"+time, Arrays.asList(building_name, classnum));
                        db.collection("회원예약내역").document(usernumber_edit.getText().toString())
                                .set(quote2, SetOptions.merge());
                    }
                }
                Toast.makeText(getApplicationContext(), "예약되었습니다.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(reservation.this, MainActivity.class);
                startActivity(intent);
            }
        });

        cancel_reservation.setOnClickListener(new View.OnClickListener(){ //예약취소

            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "예약이 취소되었습니다.", Toast.LENGTH_SHORT).show();
                finish();
            }
        });


    }

    //OnClickListner
    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.building_txt:
                Intent intent_building = new Intent(this, reservation_building.class);
                startActivity(intent_building);
                break;
            case R.id.classroom_txt:
                Intent intent_classroom = new Intent (this, reservation_classroom.class);
                startActivity(intent_classroom);
                break;

        }
    }

}
