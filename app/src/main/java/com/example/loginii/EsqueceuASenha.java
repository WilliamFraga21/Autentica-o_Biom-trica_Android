package com.example.loginii;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EsqueceuASenha extends AppCompatActivity {
    private EditText emailEditText;
    private Button resetButton;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esqueceu_asenha);




        emailEditText = findViewById(R.id.editTextEmail);
        resetButton = findViewById(R.id.button3);

        mAuth = FirebaseAuth.getInstance();

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obter o email digitado pelo usuário
                String email = emailEditText.getText().toString();

                // Enviar um email de redefinição de senha para o usuário
                mAuth.sendPasswordResetEmail(email)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    // Email de redefinição de senha enviado com sucesso
                                    Toast.makeText(EsqueceuASenha.this, "Um email de redefinição de senha foi enviado para o seu endereço de email.", Toast.LENGTH_SHORT).show();
                                    // Você pode redirecionar o usuário de volta para a tela de login ou executar outra ação aqui.
                                } else {
                                    // Falha ao enviar o email de redefinição de senha
                                    Toast.makeText(EsqueceuASenha.this, "Falha ao enviar o email de redefinição de senha. Verifique o endereço de email.", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
    }
}