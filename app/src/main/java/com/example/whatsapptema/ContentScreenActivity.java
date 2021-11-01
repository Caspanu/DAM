package com.example.whatsapptema;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ContentScreenActivity extends AppCompatActivity {

    private ListView listView;
    private MeniuAdapter meniuAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_screen);

        meniuAdapter = new MeniuAdapter(getConversatie());
        listView = findViewById(R.id.listView);
        listView.setAdapter(meniuAdapter);
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