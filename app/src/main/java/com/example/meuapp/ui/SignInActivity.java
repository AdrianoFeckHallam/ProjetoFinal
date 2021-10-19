package com.example.meuapp.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.meuapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignInActivity extends AppCompatActivity {


    private static final String TAG = "loginFIREBASE";
    EditText mSenha, mRepeteSenha, emailCompara;
    Button mResgitroBtn;
    TextView mLoginLink;
    ProgressBar progressBar;

    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        mSenha = findViewById(R.id.senha);
        mRepeteSenha = findViewById(R.id.senha_repete);
        emailCompara = findViewById(R.id.email);
        mResgitroBtn = findViewById(R.id.btn_registrar);
        mLoginLink = findViewById(R.id.tv_ja_cadastrado);
        progressBar = findViewById(R.id.progress_bar_registrar);

        /*if(mAuth.getCurrentUser()!=null){
            startActivity(new Intent(getApplicationContext(),ListaFilmesActivity.class));
            finish();
        }*/


        mResgitroBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String senha = mSenha.getText().toString().trim();
                String repeteSenha = mRepeteSenha.getText().toString().trim();
                String email = emailCompara.getText().toString().trim();


                if(email.isEmpty()){
                    emailCompara.setError("Email é necessário");
                    return;
                }

                if(senha.length()<6){
                    mSenha.setError("Senha precisa ter 6 ou mais caracteres");
                    mRepeteSenha.setError("Senha precisa ter 6 ou mais caracteres");
                    return;
                }

                if(!senha.equals(repeteSenha)){
                    mSenha.setError("Senhas incompativeis ou em branco");
                    mRepeteSenha.setError("Senhas incompativeis ou em branco");
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);
                mAuth.createUserWithEmailAndPassword(email, senha)
                .addOnCompleteListener(SignInActivity.this, new OnCompleteListener<AuthResult>(){
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                                startActivity(new Intent(getApplicationContext(),ListaFilmesActivity.class));
                        }
                        else
                        {
                            Toast.makeText(SignInActivity.this, "Falha ao cadastrar!"
                                            +task.getException().getMessage(),
                                    Toast.LENGTH_LONG).show();
                            updateUI(null);
                        }
                    }
                });
            }
        });

// ...
// Initialize Firebase Auth

        mAuth = FirebaseAuth.getInstance();

    }

    private void updateUI(FirebaseUser currentUser) {
    }


}