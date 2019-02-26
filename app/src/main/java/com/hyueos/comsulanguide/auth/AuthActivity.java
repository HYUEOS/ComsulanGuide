package com.hyueos.comsulanguide.auth;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Collections;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public abstract class AuthActivity extends AppCompatActivity {

    private List<AuthUI.IdpConfig> mProviders = Collections.singletonList(new AuthUI.IdpConfig.GoogleBuilder().build());

    public static int RC_LOGIN = 1001;

    protected void startSignIn() {
        startActivityForResult(AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setAvailableProviders(mProviders)
                .build(), RC_LOGIN);
    }

    protected void checkAuthState(FirebaseAuth.AuthStateListener authStateListener) {
        FirebaseAuth.getInstance().addAuthStateListener(authStateListener);
    }
}
