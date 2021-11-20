package com.example.girlfriend_renting_service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class WhatsAppIntegration extends AppCompatActivity {
    Button mBtnSendMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whats_app_integration);
        mBtnSendMessage = findViewById(R.id.btnSendMessageWhatsApp);

        final String num = "+919354970077";
        final String text = "Hello";

        mBtnSendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean installed = isAppInstalled();
                if (installed) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("http://api.whatsapp.com/send?phone="+num+"&text="+ text));
                    startActivity(intent);
                }
                else{
                    Toast.makeText(WhatsAppIntegration.this, "Whatsapp is not installed!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private boolean isAppInstalled() {
        PackageManager packageManager = getPackageManager();
        boolean is_installed;
        try {
            packageManager.getPackageInfo("com.whatsapp", PackageManager.GET_ACTIVITIES);
            is_installed = true;
        }
        catch (PackageManager.NameNotFoundException e) {
            is_installed = false;
            e.printStackTrace();
        }
        return is_installed;
    }
}