package com.leenak0.swurent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.api.Distribution;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class reservation_history extends AppCompatActivity {

    Button rh_prev;
    String text, currentuser;
    private RecyclerAdapter adapter;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    String []reservation_date = new String[10];
    String []reservation_time = new String[10];
    String []reservation_building = new String[10];
    String []reservation_classroom = new String[10];
    String []reservation_usernum = new String[10];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation_history);

        rh_prev = (Button)findViewById(R.id.rh_prev);

        currentuser = FirebaseAuth.getInstance().getCurrentUser().getEmail();
        DocumentReference docRef3 = db.collection("회원예약내역").document(currentuser);

        docRef3.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>(){
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if(task.isSuccessful()) {
                    DocumentSnapshot document2 = task.getResult();
                    if (document2.exists()) {

                        text = document2.getData().toString();

                        ////////////////
                        int cnt = 0;

                        for (int i = 0; i < text.length(); i++) {
                            if (text.charAt(i) == '=') cnt++;
                        }

                        StringTokenizer st = new StringTokenizer(text, "{|}|[|]|,|=|_|");
                        int i = 0;

                        String[] def = new String[100];
                        while (st.hasMoreTokens()) {
                            def[i] = st.nextToken();
                            def[i] = def[i].trim();
                            i++;
                        }

                        //Log.e("TAG", def[0]);
                        //Log.e("TAG", def[1]);
                        //Log.e("TAG", def[3]);
                        //Log.e("TAG", def[4]);


                        for (int j = 0; j < cnt; j++) {
                            reservation_date[j] = def[j * 5];
                            reservation_time[j] = def[j * 5 + 1] + "시";
                            reservation_building[j] = def[j * 5 + 2];
                            reservation_classroom[j] = def[j * 5 + 3];
                            reservation_usernum[j] = def[j * 5 + 4];

                        }

                        //Log.e("TAG", reservation_date[0]);
                        //Log.e("TAG", reservation_time[0]);
                        //Log.e("TAG", reservation_building[0]);
                        //Log.e("TAG", reservation_classroom[0]);

                        init();
                        getData();

                    }
                }
            }
        });

        rh_prev.setOnClickListener(new View.OnClickListener(){ //뒤로

            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //init();
        //getData();
    }

    private void init() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new RecyclerAdapter();
        recyclerView.setAdapter(adapter);
    }

    private void getData() {

        ArrayList<String> dateList = new ArrayList<>();
        for(String temp:reservation_date){
            dateList.add(temp);
        }

        ArrayList<String> timeList = new ArrayList<>();
        for(String temp:reservation_time){
            timeList.add(temp);
        }

        ArrayList<String> buildingList = new ArrayList<>();
        for(String temp:reservation_building){
            buildingList.add(temp);
        }

        ArrayList<String> classroomList = new ArrayList<>();
        for(String temp:reservation_classroom){
            classroomList.add(temp);
        }


        for (int i = 0; i<dateList.size(); i++) {
            Data_recyclerview data = new Data_recyclerview();
            data.setDate(dateList.get(i));
            data.setTime(timeList.get(i));
            data.setBuilding(buildingList.get(i));
            data.setClassroom(classroomList.get(i));
            //Log.e("TAG", reservation_date[i]);

            //data.setResId(listResId.get(i));
            adapter.addItem(data);
        }


        adapter.notifyDataSetChanged();
    }


}
