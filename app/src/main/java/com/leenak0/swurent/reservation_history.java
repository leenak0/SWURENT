package com.leenak0.swurent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.Source;

public class reservation_history extends AppCompatActivity {

    TextView sampletxt, sampletxt2;
    Button rh_prev;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    String message;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation_history);

        rh_prev=(Button)findViewById(R.id.rh_prev);
        sampletxt = (TextView)findViewById(R.id.sampletxt);
        sampletxt2 = (TextView)findViewById(R.id.sampletxt2);

        //파이어베이스에서부터 값을 받아오기



        db.collection("회원예약내역")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                message = document.getId()+document.getData().toString();
                                sampletxt.setText(message);
                            }
                        }
                    }
                });


        DocumentReference docRef = db.collection("회원예약내역").document("2017111320");
        Source source = Source.CACHE;

        docRef.get(source).addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    String i = document.toString();
                    //sampletxt2.setText(i);
                }
            }
        });

        //쿼리문 예시
        //컬렉션 레퍼런스 생성
        CollectionReference memberRef = db.collection("회원예약내역");
        //컬렉션 쿼리
        Query query = memberRef.whereArrayContains("2019년9월29일_11","50주년 기념관");
        String result = query.toString();
        sampletxt2.setText(result);
        //com.google.firebase.firestore.Query@45658ceb

        rh_prev.setOnClickListener(new View.OnClickListener(){ //뒤로

            @Override
            public void onClick(View v) {
                //popup
                finish();
            }
        });
    }
}