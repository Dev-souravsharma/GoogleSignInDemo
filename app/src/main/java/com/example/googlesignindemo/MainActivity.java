package com.example.googlesignindemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.edtLogout);
        TextView textView = findViewById(R.id.edtName);
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        if (account != null)
            textView.setText(account.getGivenName());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(), SignInActivity.class);
                startActivity(intent);

            }
        });
        finish();
    }
}