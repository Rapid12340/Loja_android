package com.example.testebd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class adicionarFundos extends AppCompatActivity {

    DBHelper DB;
    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //initializer do Media Player
        mp= MediaPlayer.create(this,R.raw.calma);
        setContentView(R.layout.activity_adicionar_fundos);
        EditText inserir = findViewById(R.id.inserirquanto);
        DB = new DBHelper(this);
        Bundle extras = getIntent().getExtras();
        //OBTER O USERNAME E MONTANTE DO UTILIZADOR
        String username = extras.getString("username");
        String money = extras.getString("dinheiro");

        Button enviar = findViewById(R.id.enviaporra);
        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Recebido Original
                double montadonodinheiro = Double.parseDouble(money);

                //Dinheiro Introduzido pelo user para adicionar a conta
                double introduzido = Double.parseDouble(inserir.getText().toString());
                if(introduzido <= 5000)
                {
                    String cu = String.format("%.2f", introduzido);
                    double sport = Double.parseDouble(cu);
                    double calculos = montadonodinheiro + sport;
                    String rabo = String.valueOf(calculos);

                    Boolean vamosdar = DB.updateuserdata(username, rabo);
                    if(vamosdar) {
                        Toast.makeText(adicionarFundos.this, "Fundos Adicionados!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), Loja.class);
                        intent.putExtra("username", username);
                        intent.putExtra("montante", rabo);
                        startActivity(intent);
                        //toca musica
                        mp.start();
                    }
                    else
                        Toast.makeText(adicionarFundos.this, "Não foi possivel adicionar mais fundos a sua conta", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(adicionarFundos.this, "Introduza uma quantia até 5000 €", Toast.LENGTH_SHORT).show();

            }
        });

    }
}