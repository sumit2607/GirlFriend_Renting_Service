package com.example.girlfriend_renting_service;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.BiometricPrompt;
import androidx.core.content.ContextCompat;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import java.util.concurrent.Executor;

public class Authentication extends AppCompatActivity{
    Executor  executor;
    BiometricPrompt biometricPrompt;
    BiometricPrompt.PromptInfo promptInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        executor = ContextCompat.getMainExecutor(this);
        biometricPrompt = new BiometricPrompt(this, executor, new BiometricPrompt.AuthenticationCallback() {
            @Override
            public void onAuthenticationSucceeded(@NonNull BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);
                Intent intent = new Intent(Authentication.this,mobile.class);
                Toast.makeText(Authentication.this,"Authentication Success",Toast.LENGTH_LONG).show();
                startActivity(intent);
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

                Toast.makeText(Authentication.this,"Authentication Failed",Toast.LENGTH_LONG).show();
            }
        });
        promptInfo = new BiometricPrompt.PromptInfo.Builder()
                .setTitle("Verify your identity")
                .setDescription("Confirm your fingerprint so\nthis app can identify you")
                .setNegativeButtonText("Exit")
                .build();
        biometricPrompt.authenticate(promptInfo);
    }
}