package com.leenak0.swurent;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.StringTokenizer;


public class side extends AppCompatActivity {

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    Intent intent;
    String date, classnum, building_name, message, message2;
    TextView txt, txt2, txt3, txt4, txt5, txt6;
    Button btn;

    int [] time = {0,0,0,0,0,0,0,0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_side);

        txt = (TextView)findViewById(R.id.txt);
        txt2 = (TextView)findViewById(R.id.txt2);
        txt3 = (TextView)findViewById(R.id.txt3);
        txt4 = (TextView)findViewById(R.id.txt4);
        txt5 = (TextView)findViewById(R.id.txt5);
        txt6 = (TextView)findViewById(R.id.txt6);
        intent = getIntent();
        date = intent.getStringExtra("date");
        classnum = intent.getStringExtra("classnum");
        building_name = intent.getStringExtra("building_name");


        DocumentReference docRef = db.collection("예시").document(date+"_"+building_name +"_"+ classnum);

        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>(){
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if(task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        /*Map aMap = document.getData();
                        String astring = "a";
                        for (Iterator it = aMap.keySet().iterator(); it.hasNext(); ) {
                            astring += it.toString();
                        }
                        txt6.setText(astring);
                         */
                        message2 = document.getData().toString();
                        txt2.setText(message2);

                        ////////////////
                        int cnt = 0;

                        for (int i = 0; i<message2.length();i++){
                            if(message2.charAt(i)=='=') cnt++;
                        }

                        StringTokenizer st = new StringTokenizer(message2, "{|}|[|]|,|=|");
                        int i = 0;
                        String []abc = new String[100];
                        while(st.hasMoreTokens()) {
                            abc[i]=st.nextToken();
                            abc[i]=abc[i].trim();
                            i++;

                        }
                        txt3.setText(abc[0]);
                        txt4.setText(abc[6]);


                        for (int j = 0; j < cnt*6; j+=6) {
                            //time[(Integer.parseInt(abc[j]))-9] = 1;
                            Log.e("TAG",abc[j]);
                            int n = Integer.parseInt(abc[j]); //java.lang.NumberFormatException: For input string: " 10"
                            int k = n-9;
                            Log.e("TAG",k+"");
                            time[k]=1;
                        }

                        txt5.setText(""+time[0]);
                        txt6.setText(""+time[1]);

                    }
                }
            }
        });

        btn = (Button)findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), reservation.class);
                intent.putExtra("classnum", classnum);
                intent.putExtra("date", date);
                intent.putExtra("building_name", building_name);
                intent.putExtra("time", time);
                startActivity(intent);
            }
        });
    }
}
