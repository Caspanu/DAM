package com.example.whatsapptema;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    private Button btnRegister;
    private EditText etEmail;
    private EditText etPhone;
    private EditText etPass;
    private EditText etPassConf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btnRegister = findViewById(R.id.btnRegisterReg);
        etEmail = findViewById(R.id.etEmailReg);
        etPhone = findViewById(R.id.etPhoneReg);
        etPass = findViewById(R.id.etPassReg);
        etPassConf = findViewById(R.id.etPassConfirmationReg);
        btnRegister.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (isValid()) {
                    User u1 = new User();
                    u1.setEmail(etEmail.getText().toString());
//                    u1.setPhone(Integer.parseInt(etPhone.getText().toString()));
                    u1.setPhone(etPhone.getText().toString());
                    u1.setPass(etPass.getText().toString());
                    u1.setPassConf(etPassConf.getText().toString());
                    Toast.makeText(MainActivity2.this, u1.toString(), Toast.LENGTH_SHORT).show();
                    Bundle wrapperObject = new Bundle();
                    wrapperObject.putSerializable("user", u1);
                    Intent intent = new Intent();
                    intent.putExtra("raspunsBundle", wrapperObject);
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        });
    }

    boolean isEmailValid(CharSequence email){
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private boolean isValid(){
        if(etEmail.getText().toString().isEmpty()){
            Toast.makeText(MainActivity2.this, "Fill in the email address!", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(!(isEmailValid(etEmail.getText().toString()))) {
            Toast.makeText(MainActivity2.this, "Invalid email address!", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(etPhone.getText().toString().isEmpty()){
            Toast.makeText(MainActivity2.this, "Fill in the phone number!", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(etPass.getText().toString().isEmpty()){
            Toast.makeText(MainActivity2.this, "Fill in the password!", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(etPassConf.getText().toString().isEmpty()){
            Toast.makeText(MainActivity2.this, "Confirm your password!", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(!etPass.getText().toString().equals(etPassConf.getText().toString())){
            Toast.makeText(MainActivity2.this, "Passwords do not match!", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}