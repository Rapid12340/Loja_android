package com.example.testebd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class login extends AppCompatActivity {

    EditText username, password;
    Button btnlogin;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = (EditText) findViewById(R.id.username1);
        password = (EditText) findViewById(R.id.password1);
        btnlogin = (Button) findViewById(R.id.btnsignin1);
        DB = new DBHelper(this);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                Cursor res = DB.getmoney(user);
                //Obter o montante pertencente ao utilizador
                List<String> moneyFrom = new ArrayList<String>();
                while(res.moveToNext()){
                    moneyFrom.add(res.getString(0));
                }
                String montante = moneyFrom.toString();
                montante = montante.replaceAll("[\\[\\]\\(\\)]", "");
                if(user.equals("")||pass.equals(""))
                    Toast.makeText(login.this, "Por favor introduz todos os coisos", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuserpass = DB.checkusernamepassword(user, pass);
                    if(checkuserpass){
                        Intent intent  = new Intent(getApplicationContext(), Loja.class);
                        intent.putExtra("username", user);
                        intent.putExtra("montante", montante);
                        startActivity(intent);
                    }else{
                        Toast.makeText(login.this, "Dados Inválidos", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}