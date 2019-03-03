package com.hyueos.comsulanguide.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.hyueos.comsulanguide.R;
import com.hyueos.comsulanguide.auth.AuthActivity;

public class MainActivity extends AuthActivity {

    private Button mBtnLogin;
    private TextView mTvEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnLogin = findViewById(R.id.main_btn_login);
        mTvEmail = findViewById(R.id.main_tv_email);

        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startSignIn();
            }
        });

        checkAuthState(new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser() == null) {
                    mTvEmail.setText("로그인 상태가 아닙니다.");
                } else {
                    mTvEmail.setText(firebaseAuth.getCurrentUser().getEmail());
                }
            }
        });
    }
}
