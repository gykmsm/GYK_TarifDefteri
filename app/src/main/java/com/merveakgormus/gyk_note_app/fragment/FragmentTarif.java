package com.merveakgormus.gyk_note_app.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.merveakgormus.gyk_note_app.R;
import com.merveakgormus.gyk_note_app.model.Tarif;

public class FragmentTarif extends Fragment {

    EditText edtTarifAdi, edtMalzemeler, edtYapilisi;
    Button btnSave;

    String tarifadi, malzemeler, yapilisi;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference dbRef;

    FirebaseUser firebaseUser;
    FirebaseAuth mAuth;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tarif, container, false);

        firebaseDatabase = FirebaseDatabase.getInstance();
        dbRef = firebaseDatabase.getReference("Tariflerim");
        mAuth = FirebaseAuth.getInstance();
        firebaseUser = mAuth.getCurrentUser();

        edtTarifAdi = view.findViewById(R.id.edtTarifAdi);
        edtMalzemeler = view.findViewById(R.id.edtMalzemeler);
        edtYapilisi = view.findViewById(R.id.edtTarifYapilisi);

        btnSave = view.findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tarifadi = edtTarifAdi.getText().toString();
                malzemeler = edtMalzemeler.getText().toString();
                yapilisi = edtYapilisi.getText().toString();

                Save(tarifadi, malzemeler, yapilisi);
            }
        });
        return  view;
    }

    private void Save(String tarifadi, String malzemeler, String yapilisi){
        Tarif tarif = new Tarif(tarifadi, malzemeler, yapilisi);
        String tarifID = dbRef.push().getKey();

        dbRef.child(firebaseUser.getUid()).child(tarifID).setValue(tarif);
    }
}
