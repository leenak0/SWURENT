package com.leenak0.swurent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity implements View.OnClickListener {

    TextView gosignup;
    TextView gofindpw;
    Button login;
    FirebaseAuth mAuth;
    EditText loginid;
    EditText loginpw;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

        if(mAuth.getCurrentUser() != null){
            //이미 로그인 되었다면 이 액티비티를 종료함
            finish();
            //그리고 메인액티비티를 연다.
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }

        gosignup=(TextView)findViewById(R.id.gosignup);
        login=(Button)findViewById(R.id.login);
        gofindpw=(TextView)findViewById(R.id.gofindpw);
        loginid=(EditText)findViewById(R.id.loginid);
        loginpw=(EditText)findViewById(R.id.loginpw);
        progressDialog = new ProgressDialog(this);

//        SpannableString content = new SpannableString(signup.getText().toString());
//        content.setSpan(new UnderlineSpan(), 0, content.length(),0);
//        signup.setText(content);
        gosignup.setPaintFlags(gosignup.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        gofindpw.setPaintFlags(gofindpw.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        login.setOnClickListener(this);
        gosignup.setOnClickListener(this);
        gofindpw.setOnClickListener(this);
    }

    //firebase userLogin method
    private void userLogin(){
        String email = loginid.getText().toString().trim();
        String password = loginpw.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            Toast.makeText(this, "email을 입력해 주세요.", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(this, "password를 입력해 주세요.", Toast.LENGTH_SHORT).show();
            return;
        }

        progressDialog.setMessage("로그인중입니다. 잠시 기다려 주세요...");
        progressDialog.show();

        //logging in the user
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if(task.isSuccessful()) {
                            finish();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        } else {
                            Toast.makeText(getApplicationContext(), "로그인 실패!", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

    @Override
    public void onClick(View view) {
        if(view == login) {
            userLogin();
        }
        if(view == gosignup) {
            finish();
            startActivity(new Intent(this, Signup.class));
        }
        if(view == gofindpw) {
            finish();
            startActivity(new Intent(this, Findpwd.class));
        }
    }
}
