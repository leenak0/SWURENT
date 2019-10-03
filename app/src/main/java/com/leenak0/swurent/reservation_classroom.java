package com.leenak0.swurent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class reservation_classroom extends AppCompatActivity implements View.OnClickListener {

    Button btn_choice_date, btn_move_back_classroom;
    TextView textview_date;
    String building_name;
    private DatePickerDialog.OnDateSetListener callbackMethod;
    private ListView m_oListView = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation_classroom);

        Intent intent = getIntent();
        building_name = intent.getStringExtra("building_name");

        this.InitializeView();
        this.InitializeListener();

        m_oListView = (ListView)findViewById(R.id.Listview);

        //데이터 생성
        String[] strTitle = {"601호", "602호", "603호", "604호", "605호"};
        String[] strLimitnum = {"정원 40명, 최소인원 5명", "정원 40명, 최소인원 5명", "정원 40명, 최소인원 5명", "정원 40명, 최소인원 5명", "정원 40명, 최소인원 5명" };
        String[] strTexttime = {"9시-10시, 10시-11시, 11시-12시, 12시-13시, 13시-14시, 14시-15시, 15시-16시, 16시-17시",
                "9시-10시, 10시-11시, 11시-12시, 12시-13시, 13시-14시, 14시-15시, 15시-16시, 16시-17시",
                "9시-10시, 10시-11시, 11시-12시, 12시-13시, 13시-14시, 14시-15시, 15시-16시, 16시-17시",
                "9시-10시, 10시-11시, 11시-12시, 12시-13시, 13시-14시, 14시-15시, 15시-16시, 16시-17시",
                "9시-10시, 10시-11시, 11시-12시, 12시-13시, 13시-14시, 14시-15시, 15시-16시, 16시-17시"};
        int nDatCnt = 0;
        final ArrayList<ListVO> oData = new ArrayList<>();
        for (int i = 0; i<5; ++i) {
            ListVO oItem = new ListVO();
            oItem.strTitle = strTitle[nDatCnt];
            oItem.strLimitnum = strLimitnum[nDatCnt];
            oItem.strTexttime = strTexttime[nDatCnt++];
            oItem.onClickListener=this;
            oData.add(oItem);
            if(nDatCnt>=strLimitnum.length) nDatCnt=0;
        }

        //ListView, Adpater 생성, 연결
        //m_oListView = (ListView)findViewById(R.id.Listview);
        reservation_list oAdapter = new reservation_list(oData);
        m_oListView.setAdapter(oAdapter);

        m_oListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), reservation2.class);
                intent.putExtra("classnum", oData.get(position).strTitle);
                intent.putExtra("date", textview_date.getText().toString());
                intent.putExtra("building_name", building_name);
                startActivity(intent);
            }
        });
    }

    public void onClick (View v) {
        View oParentView = (View) v.getParent();
        TextView oTextTitle = (TextView) oParentView.findViewById(R.id.texttitle);
        String position = (String) oParentView.getTag();

        //Intent intent = new Intent(reservation_classroom.this, reservation.class);
        // intent.putExtra("date", textview_date.getText().toString());
        // startActivity(intent);
    }

    public void InitializeView() {
        textview_date = (TextView) findViewById(R.id.textview_date);
    }

    public void InitializeListener() {
        callbackMethod = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                textview_date.setText(year + "년" + (monthOfYear+1) + "월" + dayOfMonth + "일");

                //Intent intent2 = new Intent(reservation_classroom.this, reservation2.class);
                //intent2.putExtra("date", textview_date.getText().toString());
                //startActivity(intent2);
            }
        };
    }

    //오늘 날짜로부터 +1주의 날짜 범위만 선택 가능하도록
    public void OnClickHandler(View view) {

        DatePickerDialog dialog = new DatePickerDialog(this, callbackMethod, 2019, 8, 1);

        Calendar maxDate = Calendar.getInstance();
        dialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
        dialog.getDatePicker().setMaxDate(System.currentTimeMillis() + 604800000);

        dialog.show();
    }
}
