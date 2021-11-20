package com.example.girlfriend_renting_service;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
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
                    regAdhar.setError("Aadhar Number is required");
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
                    regAdhar.setError("Your aadhar number length should be 12 characters");
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

//                UserHelperClass helperClass = new UserHelperClass(name, email,adhar,age,password);
//                reference.setValue(helperClass);

                //***************************************************************
                final AlertDialog.Builder alert = new AlertDialog.Builder(SignUp.this);
                View mView = getLayoutInflater().inflate(R.layout.dialogue_data_saved_confirmation,null);
                ImageButton btn_cancel = (ImageButton)mView.findViewById(R.id.btn_cancel_Dialogue_SaveData);
                Button btn_okay = (Button)mView.findViewById(R.id.btn_OK_saveData);
                alert.setView(mView);
                final AlertDialog alertDialog = alert.create();
                alertDialog.setCanceledOnTouchOutside(false);
                btn_cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                    }
                });
                btn_okay.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        UserHelperClass helperClass = new UserHelperClass(name, email,adhar,age,password);
                        reference.setValue(helperClass);
                        Toast.makeText(getApplicationContext(), "Data saved successfully", Toast.LENGTH_LONG).show();
                        alertDialog.dismiss();
                    }
                });
                alertDialog.show();
            }
        });
        mBtnAdharValidation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String adharNumber = regAdhar.getEditText().getText().toString();
                boolean checkResult = Verhoeff.validateVerhoeff(adharNumber);
                String msg = String.valueOf(checkResult);
                if (msg.equals("true")){
                    Toast.makeText(getApplicationContext(), "true", Toast.LENGTH_LONG).show();
                }
                else {
                    regAdhar.setError("Enter valid Aadhar Number");
                    regAdhar.requestFocus();
                    //    Toast.makeText(getApplicationContext(), "Enter valid Adhar Number", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}