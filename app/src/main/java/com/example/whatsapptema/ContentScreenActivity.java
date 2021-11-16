package com.example.whatsapptema;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ContentScreenActivity extends AppCompatActivity {

    private ListView listView;
    private MeniuAdapter meniuAdapter;
    private Button btnUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_screen);

        meniuAdapter = new MeniuAdapter(getConversatie());
        listView = findViewById(R.id.listView);
        listView.setAdapter(meniuAdapter);
        btnUpdate = findViewById(R.id.btnUpdate);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JSONReader reader = new JSONReader();
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        reader.read("https://jsonkeeper.com/b/9ZUD", new IResponse() {
                            @Override
                            public void onSuccess(List<Conversatie> conversatie) {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        //Toast.makeText(ContentScreenActivity.this, conversatie.toString(), Toast.LENGTH_LONG).show();
                                        meniuAdapter.update_list(conversatie);
                                    }
                                });
                            }

                            @Override
                            public void onError(String mesaj) {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(ContentScreenActivity.this, mesaj, Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }
                        });
                    }
                });
                thread.start();
            }
        });
    }

    private List<Conversatie> getConversatie() {
        List<Conversatie> lst = new ArrayList<>();
        lst.add(new Conversatie("Andrei", "ce mai zici frate?", "1 nov, 11:32"));
        lst.add(new Conversatie("Mama", "Sa iei si tu o paine, te rog!", "30 oct, 08:55"));
        lst.add(new Conversatie("Vasilache Alex", "Da, ramane cum am discutat.", "25 oct, 12:00"));
        lst.add(new Conversatie("Varu'", "Adu si tu ala de ti-am zis", "23 oct, 13:09"));
        return lst;
    }
}