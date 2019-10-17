package com.leenak0.swurent;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Setting extends AppCompatActivity {

    Button close_setting;
    //메인세팅
    Button change_theme, review, logout;
    //테마변경
    TextView txt_change_theme;
    RadioGroup group_change_theme;
    RadioButton wine_change_theme, pink_change_theme, blue_change_theme;
    Button btn_change_theme;
    //만족도제출
    TextView txt_review;
    LinearLayout layout_star;
    RatingBar star;
    Button submit_star;

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    String currentuser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        close_setting = (Button)findViewById(R.id.close_setting);
        //메인화면
        change_theme = (Button)findViewById(R.id.change_theme);
        review = (Button)findViewById(R.id.review);
        logout = (Button)findViewById(R.id.logout);
        //테마변경
        txt_change_theme=(TextView)findViewById(R.id.txt_change_theme);
        group_change_theme=(RadioGroup)findViewById(R.id.group_change_theme);
        wine_change_theme=(RadioButton)findViewById(R.id.wine_change_theme);
        pink_change_theme=(RadioButton)findViewById(R.id.pink_change_theme);
        blue_change_theme=(RadioButton)findViewById(R.id.blue_change_theme);
        btn_change_theme=(Button)findViewById(R.id.btn_change_theme);
        //만족도제출
        txt_review=(TextView)findViewById(R.id.txt_review);
        layout_star=(LinearLayout)findViewById(R.id.layout_star);
        star=(RatingBar)findViewById(R.id.star);
        submit_star=(Button)findViewById(R.id.submit_star);

        //테마변경 관련 UI 숨기기
        txt_change_theme.setVisibility(View.INVISIBLE);
        group_change_theme.setVisibility(View.INVISIBLE);
        wine_change_theme.setVisibility(View.INVISIBLE);
        pink_change_theme.setVisibility(View.INVISIBLE);
        blue_change_theme.setVisibility(View.INVISIBLE);
        btn_change_theme.setVisibility(View.INVISIBLE);
        //만족도제출 관련 UI 숨기기
        txt_review.setVisibility(View.INVISIBLE);
        layout_star.setVisibility(View.INVISIBLE);
        star.setVisibility(View.INVISIBLE);
        submit_star.setVisibility(View.INVISIBLE);
    }

    //x 버튼 클릭
    public void close_setting(View v){
        //데이터 전달하기
        Intent intent = new Intent();
        setResult(RESULT_OK, intent);

        //액티비티(팝업) 닫기
        finish();
    }

    //테마변경 버튼 클릭
    public void change_theme(View v){
        //메인세팅버튼3개 숨기기
        change_theme.setVisibility(View.INVISIBLE);
        review.setVisibility(View.INVISIBLE);
        logout.setVisibility(View.INVISIBLE);
        //테마변경 UI 보이기
        txt_change_theme.setVisibility(View.VISIBLE);
        group_change_theme.setVisibility(View.VISIBLE);
        wine_change_theme.setVisibility(View.VISIBLE);
        pink_change_theme.setVisibility(View.VISIBLE);
        blue_change_theme.setVisibility(View.VISIBLE);
        btn_change_theme.setVisibility(View.VISIBLE);

        btn_change_theme.setOnClickListener(new View.OnClickListener(){ //테마 변경

            @Override
            public void onClick(View v) {
                if(wine_change_theme.isChecked()){
                    getApplication().setTheme(R.style.wineTheme);
                }else if(pink_change_theme.isChecked()){
                    getApplication().setTheme(R.style.pinkTheme);
                }else if(blue_change_theme.isChecked()){
                    getApplication().setTheme(R.style.blueTheme);
                }else{
                    Toast.makeText(getApplicationContext(), "테마를 선택해주세요", Toast.LENGTH_SHORT).show();
                }

                //데이터 전달하기
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);

                //액티비티(팝업) 닫기
                finish();
            }
        });
    }

    //만족도제출 버튼 클릭
    public void review(View v){
        //메인세팅버튼3개 숨기기
        change_theme.setVisibility(View.INVISIBLE);
        review.setVisibility(View.INVISIBLE);
        logout.setVisibility(View.INVISIBLE);
        //만족도제출 UI 보이기
        txt_review.setVisibility(View.VISIBLE);
        layout_star.setVisibility(View.VISIBLE);
        star.setVisibility(View.VISIBLE);
        submit_star.setVisibility(View.VISIBLE);

        submit_star.setOnClickListener(new View.OnClickListener(){ //만족도제출

            @Override
            public void onClick(View v) {
                //만족도 저장
                Map<String, Object> quote = new HashMap<>();
                currentuser = FirebaseAuth.getInstance().getCurrentUser().getEmail();
                quote.put("star", star.getRating());
                db.collection("review").document(currentuser).set(quote, SetOptions.merge());

                //데이터 전달하기
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);

                //액티비티(팝업) 닫기
                finish();
            }
        });
    }

    //로그아웃 버튼 클릭
    public void logout(View v){
        //로그아웃 후 재시작
        FirebaseAuth.getInstance().signOut();
        ActivityCompat.finishAffinity(this);
        startActivity(new Intent(this, Login.class));
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //바깥레이어 클릭시 안닫히게
        if(event.getAction()== MotionEvent.ACTION_OUTSIDE){
            return false;
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        //안드로이드 백버튼 막기
        return;
    }
}
