package com.example.girlfriend_renting_service;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity {
    TextInputLayout regName, regEmail,regAdhar, regAge, regPassword;
    Button regBtn;
    ImageView mBtnAdharValidation;
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
        mBtnAdharValidation = findViewById(R.id.btnAdharValidation);
        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("users");
                String name = regName.getEditText().getText().toString();
                String email = regEmail.getEditText().getText().toString();
                String adhar = regAdhar.getEditText().getText().toString();
                String age = regAge.getEditText().getText().toString();
        //        int numAge = Integer.parseInt(regAge.getEditText().getText().toString()+"");
                String password = regPassword.getEditText().getText().toString();
                if (name.isEmpty()){
                    regName.setError("Enter full name");
                    regName.requestFocus();
                    return;
                }
                if (adhar.isEmpty()){
                    regAdhar.setError("Adhar Number is required");
                    regAdhar.requestFocus();
                    return;
                }
                if (age.isEmpty()){
                    regAge.setError("Please enter your age");
                    regAge.requestFocus();
                    return;
                }
                if (email.isEmpty()){
                    regEmail.setError("Email is mandatory");
                    regEmail.requestFocus();
                    return;
                }
                if (adhar.length() < 12){
                    regAdhar.setError("Your adhar length should be 12 characters");
                    regAdhar.requestFocus();
                    return;
                }
                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    regEmail.setError("Enter a valid email address");
                    regEmail.requestFocus();
                    return;
                }
                if (password.isEmpty()){
                    regPassword.setError("Password is required");
                    regPassword.requestFocus();
                    return;
                }
                if (password.length() < 6){
                    regPassword.setError("Min password length should be 6 characters");
                    regPassword.requestFocus();
                    return;
                }
//                if (numAge < 18){
//                    regAge.setError("Your age should be atleast 18 years");
//                    regAge.requestFocus();
//                    return;
//                }
                UserHelperClass helperClass = new UserHelperClass(name, email,adhar,age,password);
                reference.setValue(helperClass);
            }
        });
        mBtnAdharValidation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String adharNumber = regAdhar.getEditText().getText().toString();
                boolean checkResult = Verhoeff.validateVerhoeff(adharNumber);
                String msg = String.valueOf(checkResult);
                if (msg == "true"){
                    Toast.makeText(getApplicationContext(), "true", Toast.LENGTH_LONG).show();
                }
                else {
                    regAdhar.setError("Enter valid Adhar Number");
                    regAdhar.requestFocus();
                    return;
                    //    Toast.makeText(getApplicationContext(), "Enter valid Adhar Number", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}