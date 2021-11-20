package com.example.girlfriend_renting_service;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.BiometricPrompt;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.concurrent.Executor;

public class Authentication extends AppCompatActivity {
    Executor  executor;
    BiometricPrompt biometricPrompt;
    BiometricPrompt.PromptInfo promptInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);

        executor = ContextCompat.getMainExecutor(this);

        biometricPrompt = new BiometricPrompt(this, executor, new BiometricPrompt.AuthenticationCallback() {
            @Override
            public void onAuthenticationSucceeded(@NonNull BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);
                Intent intent = new Intent(Authentication.this,SignUp.class);
                startActivity(intent);
            //    Toast.makeText(Authentication.this,"Success",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onAuthenticationError(int errorCode, @NonNull CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);

                Toast.makeText(Authentication.this,errString,Toast.LENGTH_LONG).show();
                Authentication.this.finish();
            }

            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();

                Toast.makeText(Authentication.this,"FAILED",Toast.LENGTH_LONG).show();
            }
        });


        promptInfo = new BiometricPrompt.PromptInfo.Builder()
                .setTitle("Touch id required")
                .setDescription("Touch the touch id sensor")
                .setNegativeButtonText("Exit")
                .build();

        biometricPrompt.authenticate(promptInfo);

    }
}