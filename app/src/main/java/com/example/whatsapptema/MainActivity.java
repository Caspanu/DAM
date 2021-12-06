package com.example.whatsapptema;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button btnRegister;
    private Button btnLogin;
    private EditText etEmailLog;
    private EditText etPassLog;
    private final int mainActivityRequest = 100;
    private UserDAO userDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Toast.makeText(this, "WhatsApp", Toast.LENGTH_SHORT).show();

        Log.v("lifecycle", "onCreate");

        btnRegister = findViewById(R.id.btnRegisterLog);
        btnLogin = findViewById(R.id.btnLogin);
        etEmailLog = findViewById(R.id.etEmailLog);
        etPassLog = findViewById(R.id.etPassLog);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this, "A reusit!", Toast.LENGTH_SHORT).show();
                Intent registerScreen = new Intent(MainActivity.this, MainActivity2.class);
                //startActivity(registerWindow);
                startActivityForResult(registerScreen, mainActivityRequest);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent contentScreen = new Intent (MainActivity.this,ContentScreenActivity.class);
                //startActivity(contentScreen);
                startActivity(contentScreen);
            }
        });

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                userDAO = Database.getInstance(MainActivity.this).getDatabase().userDAO();
                List<User> lista = getUsers();
                userDAO.deleteAll();
                for(int i=0; i<lista.size();i++){
                    userDAO.insertAll(lista.get(i));
                }
            }
        });
        thread.start();
    }

    public List<User> getUsers(){
        User u1 = new User("IonAndrei@yahoo.com", "0745254524", "parola123", "parola123");
        User u2 = new User("AlexStanciu@yahoo.com", "0763423423", "ParolaGREa", "ParolaGREa");
        List<User> lista = new ArrayList<>();
        lista.add(u1);
        lista.add(u2);
        return lista;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == mainActivityRequest) {
            if (resultCode == RESULT_OK) {
                if (data != null) {
                    Bundle newBundle = data.getBundleExtra("raspunsBundle");
                    User user = (User) newBundle.getSerializable("user");
                    etEmailLog.setText(user.getEmail());
                    etPassLog.setText(user.getPass());
                }
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.v("lifecycle", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.v("lifecycle", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.v("lifecycle", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.v("lifecycle", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.v("lifecycle", "onDestroy");
    }
}