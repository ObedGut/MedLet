package com.example.medlet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.medlet.model.MedicineInfo;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class AgregarMed extends AppCompatActivity {

    EditText nombremed, preciomed, preciomed2;
    Button addMed;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_med);

        nombremed = (EditText)findViewById(R.id.nombremed);
        preciomed = (EditText)findViewById(R.id.preciomed);
        preciomed2 = (EditText)findViewById(R.id.preciomed2);
        addMed = (Button)findViewById(R.id.addMed);

        inicializarFirebase();

        addMed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nombremed.getText().toString();
                String price = preciomed.getText().toString();
                String priceu = preciomed2.getText().toString();

                MedicineInfo info = new MedicineInfo(name, price, priceu);
                info.setUid(UUID.randomUUID().toString());
                info.setNombre(name);
                info.setPrecio(price);
                info.setPrecioUnidad(priceu);
                databaseReference.child("Medicina").child(info.getUid()).setValue(info);
                Toast.makeText(AgregarMed.this, "Agregado", Toast.LENGTH_LONG).show();
                limpiarCajas();
            }
        });


    }

    private void inicializarFirebase(){
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }


    private void limpiarCajas(){
        nombremed.setText("");
        preciomed.setText("");
        preciomed2.setText("");
    }
}