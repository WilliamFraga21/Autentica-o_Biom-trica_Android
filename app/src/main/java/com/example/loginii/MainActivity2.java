package com.example.loginii;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.AuthResult;
import android.os.Bundle;

public class MainActivity2 extends AppCompatActivity {

    private EditText emailEditText;
    private EditText senhaEditText;
    private EditText csenhaEditText;
    private Button cadastrarButton;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        emailEditText = findViewById(R.id.editTextemail);
        senhaEditText = findViewById(R.id.editTextsenha);
        csenhaEditText = findViewById(R.id.editTextcsenha);
        cadastrarButton = findViewById(R.id.button);

        cadastrarButton.setEnabled(false);

        mAuth = FirebaseAuth.getInstance();



        CheckBox ConcordoCheckBox1 = findViewById(R.id.checkBoxTermo);
        ConcordoCheckBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // Habilita o botão de cadastro se a caixa de seleção estiver marcada
                cadastrarButton.setEnabled(isChecked);
                cadastrarButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // Obter o email e a senha dos campos de entrada
                        String email = emailEditText.getText().toString();
                        String senha = senhaEditText.getText().toString();
                        String csenha = csenhaEditText.getText().toString();



                        if (senha.equals(csenha)){

//                    CheckBox concordoCheckBox = findViewById(R.id.textViewTermo);

//                    CheckBox ConcordoCheckBox1 = findViewById(R.id.checkBoxTermo);
//                    ConcordoCheckBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//                        @Override
//                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                            // Habilita o botão de cadastro se a caixa de seleção estiver marcada
//                            cadastrarButton.setEnabled(isChecked);
//                        }
//                    });

                            mAuth.createUserWithEmailAndPassword(email, senha)
                                    .addOnCompleteListener(MainActivity2.this, new OnCompleteListener<AuthResult>() {
                                        @Override
                                        public void onComplete(@NonNull Task<AuthResult> task) {
                                            if (task.isSuccessful()) {
                                                // Registro bem-sucedido
                                                FirebaseUser user = mAuth.getCurrentUser();
                                                Toast.makeText(MainActivity2.this, "Cadastro realizado com sucesso!", Toast.LENGTH_SHORT).show();
                                                // Você pode redirecionar o usuário para a próxima atividade aqui, se desejar.
                                            } else {
                                                // Falha no registro
                                                Toast.makeText(MainActivity2.this, "Falha ao cadastrar. Tente novamente.", Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    });

                        } else {
                            Toast.makeText(MainActivity2.this, "Comfimer Sua senha", Toast.LENGTH_SHORT).show();
                        }
                        // Criar um novo usuário com email e senha

                    }
                });
            }
        });










    }












}

