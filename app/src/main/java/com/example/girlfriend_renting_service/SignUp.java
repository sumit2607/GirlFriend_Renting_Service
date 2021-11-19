package com.example.girlfriend_renting_service;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity {
    TextInputLayout regName, regEmail,regAdhar, regAge, regPassword;
    Button regBtn;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        regName = findViewById(R.id.reg_name);
        regEmail = findViewById(R.id.reg_email);
        regAdhar = findViewById(R.id.reg_adhar);
        regAge = findViewById(R.id.reg_age);
        regPassword = findViewById(R.id.reg_password);
        regBtn = findViewById(R.id.reg_btn);
        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("users");
                //Get all the values
                String name = regName.getEditText().getText().toString();
                String email = regEmail.getEditText().getText().toString();
                String adhar = regAdhar.getEditText().getText().toString();
                String age = regAge.getEditText().getText().toString();
                String password = regPassword.getEditText().getText().toString();
                UserHelperClass helperClass = new UserHelperClass(name, email,adhar,age,password);
              reference.setValue(helperClass);
            }
        });
    }
}