package com.example.testebd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ContaUser extends AppCompatActivity {

    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conta_user);
        Bundle extras = getIntent().getExtras();
        //OBTER O USERNAME E MONTANTE DO UTILIZADOR
        String username = extras.getString("username");
        String money = extras.getString("dinheiro");
        TextView nomedogajo = findViewById(R.id.nomeuser);
        TextView moneydogajo = findViewById(R.id.dinheirouser);

        nomedogajo.setText("Username: " + username);
        moneydogajo.setText("Saldo Atual: " + money + "€");

    }
}