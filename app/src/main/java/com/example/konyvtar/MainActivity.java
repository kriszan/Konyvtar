package com.example.konyvtar;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Konyv> konyvek = new ArrayList<>();
    private EnAdapterem enAdapterem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();
    }

    private void init() {
        EditText szerzo = findViewById(R.id.szerzoEdittext);
        EditText oldalszam = findViewById(R.id.oldalszamEdittext);
        EditText cim = findViewById(R.id.cimEdittext);
        Button hozzaad = findViewById(R.id.hozzaadasGomb);
        ListView listView = findViewById(R.id.myListView);

        this.enAdapterem = new EnAdapterem(this, konyvek);
        listView.setAdapter(enAdapterem);

        hozzaad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //szerzo.getEditableText().toString().isEmpty() && cim.getEditableText().toString().isEmpty() && Integer.parseInt(oldalszam.getEditableText().toString()) >= 50
                if (!szerzo.getEditableText().toString().isEmpty() && !cim.getEditableText().toString().isEmpty()&& Integer.parseInt(oldalszam.getEditableText().toString()) >= 50) {
                    konyvek.add(new Konyv(cim.getText().toString(), szerzo.getText().toString(), Integer.parseInt(oldalszam.getText().toString())));
                    enAdapterem.notifyDataSetChanged();
                    szerzo.setText(null);
                    oldalszam.setText(null);
                    cim.setText(null);


                    Toast.makeText(getBaseContext(), "Sikeres hozzáadás",
                            Toast.LENGTH_LONG).show();

                } else {
                    Toast.makeText(getBaseContext(), "Sikertelen hozzáadás",
                            Toast.LENGTH_LONG).show();
                }
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                intent.putExtra("cim", konyvek.get(position).getCim());
                intent.putExtra("oldalszam", konyvek.get(position).getOldalszam());
                intent.putExtra("szerzo", konyvek.get(position).getSzerzo());
                startActivity(intent);
            }
        });
    }
}