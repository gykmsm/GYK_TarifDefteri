package com.merveakgormus.gyk_note_app.activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.merveakgormus.gyk_note_app.R;
import com.merveakgormus.gyk_note_app.model.User;

public class RegisterActivity extends AppCompatActivity {

    EditText edtEmail, edtPassword, edtConfirmPassword, edtName, edtSurname;
    Button btnRegister;


    private FirebaseAuth mAuth;
    FirebaseUser firebaseUser;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference dbRef;

    String email, password, confirm_password, name, surname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        firebaseDatabase = FirebaseDatabase.getInstance();
        dbRef = firebaseDatabase.getReference("Users");

        mAuth = FirebaseAuth.getInstance();
        /*firebaseUser = mAuth.getCurrentUser();

        if (firebaseUser != null){
            startActivity(new Intent(RegisterActivity.this, MainActivity.class));
        }  */
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        edtConfirmPassword = findViewById(R.id.edtconfirmPassword);
        edtName = findViewById(R.id.edtName);
        edtSurname = findViewById(R.id.edtSurname);

        btnRegister = findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = edtEmail.getText().toString();
                password = edtPassword.getText().toString();
                confirm_password = edtConfirmPassword.getText().toString();
                name = edtName.getText().toString();
                surname = edtSurname.getText().toString();

                if(!email.isEmpty() && !password.isEmpty() && !confirm_password.isEmpty()){
                    if(password.equals(confirm_password)){
                        Register(email, password, name, surname);
                    }
                }

            }
        });

    }

    private void Register(String email, String password, String name, String surname){

        final User user = new User(name, surname, email);

        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    firebaseUser = mAuth.getCurrentUser();
                    dbRef.child(firebaseUser.getUid()).setValue(user);
                    Toast.makeText(RegisterActivity.this, "Kayıt Başarılı", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                }
            }
        });
    }
}
