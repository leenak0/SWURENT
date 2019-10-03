package com.leenak0.swurent;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.firebase.auth.FirebaseAuth;

public class Setting extends AppCompatActivity {

   Button close_setting;
   Button change_theme;
   Button review;
   Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        //UI 객체생성
        close_setting = (Button)findViewById(R.id.close_setting);
        change_theme = (Button)findViewById(R.id.change_theme);
        review = (Button)findViewById(R.id.review);
        logout = (Button)findViewById(R.id.logout);
    }

    //X 버튼 클릭
    public void close(View v){
        //데이터 전달하기
        Intent intent = new Intent();
        setResult(RESULT_OK, intent);

        //액티비티(팝업) 닫기
        finish();
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
