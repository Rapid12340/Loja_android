package com.example.testebd;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.math.MathUtils;
import java.util.ArrayList;
import java.util.List;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class vercarrinho extends AppCompatActivity {
    DBHelper DB;
    MediaPlayer mp;

    //ISTO PODE SER MELHORADO AO COLOCAR TUDO DENTRO DUMA LISTA
    public String username(){
        Bundle extras = getIntent().getExtras();
        //OBTER O USERNAME E MONTANTE DO UTILIZADOR
        String username = extras.getString("username");
        return username;
    }

    //OBTER O MONTANTE DO UTILIZADOR
    public String usermoney(){
        Bundle extras = getIntent().getExtras();
        String montante = extras.getString("dinheiro");
        return montante;
    }


    //OBTER INFORMAÇÕES DA TABELA DO CARRINHO DE COMPRAS
    public List<String> ListaCarrinho(){
        DB = new DBHelper(this);
        Cursor res = DB.getdata();
        List<String> propel = new ArrayList<String>();
        while(res.moveToNext()){
            propel.add("Produto: "+res.getString(0)+"\n" +
                    "Preço: "+res.getString(1)+"\n" +
                    "Quantidade: "+res.getString(2)+"\n");
        }
        return propel;
    }

    //OBTER O TOTAL DOS ARTIGOS E CONVERTER PARA DOUBLE
    //OBTER O DOUBLE E SOMAR TUDO
    public Double testes(){
        DB = new DBHelper(this);
        Cursor res = DB.getdata();
        List<Double> totalista = new ArrayList<Double>();
        while(res.moveToNext()){
            totalista.add(res.getDouble(1));
        }
        double sum = 0;
        for(int i = 0; i < totalista.size(); i++)
            sum += totalista.get(i);
        return sum;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vercarrinho);
        ListView listadascompra = findViewById(R.id.lista);
        TextView mostratotal = findViewById(R.id.mostratotal);
        Button comprar = findViewById(R.id.comprar);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.activity_listview, R.id.textView, ListaCarrinho());
        mostratotal.setText("Total a Pagar: " + String.format("%.2f", testes()) +"€");
        listadascompra.setAdapter(arrayAdapter);



        listadascompra.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedFromList = (String) (listadascompra.getItemAtPosition(i));
                //Pokémon Region: Ifs
                //region IFs e Cenas

                if(selectedFromList.contains("PC 1"))
                {
                    //Criar uma caixa de texto a perguntar se o utilizador quer mesmo comprar o nº de artigos pelo preço que aparece calculado no ecra
                    AlertDialog.Builder builder = new AlertDialog.Builder(vercarrinho.this);
                    builder.setTitle("Apagar");
                    //saber qual dos botoes foi clicado
                    DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            switch(which){
                                // Clica em Confirmar
                                case DialogInterface.BUTTON_POSITIVE:
                                    String apaga = "PC 1";
                                    DB.digaum(apaga);
                                    String ee = username();
                                    String mm = usermoney();
                                    Intent intent = new Intent(getApplicationContext(), vercarrinho.class);
                                    intent.putExtra("username", ee);
                                    intent.putExtra("dinheiro", mm);
                                    finish();
                                    startActivity(intent);
                                    break;
                                //Clica em cancelar
                                case DialogInterface.BUTTON_NEGATIVE:
                                    break;
                            }
                        }
                    };

                    //OPCIONAL TER O VALOR COM DUAS CASAS DECIMAIS (verificar o valor de 5 limoes)
                    builder.setMessage("");
                    // botoes para o texto
                    builder.setPositiveButton("OK", dialogClickListener);
                    builder.setNegativeButton("Cancelar", dialogClickListener);
                    // cria e mostra o alert
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
                if(selectedFromList.contains("PC 2"))
                {
                    //Criar uma caixa de texto a perguntar se o utilizador quer mesmo comprar o nº de artigos pelo preço que aparece calculado no ecra
                    AlertDialog.Builder builder = new AlertDialog.Builder(vercarrinho.this);
                    builder.setTitle("Apagar");
                    //saber qual dos botoes foi clicado
                    DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            switch(which){
                                // Clica em Confirmar
                                case DialogInterface.BUTTON_POSITIVE:
                                    String apaga = "PC 2";
                                    DB.digaum(apaga);
                                    String ee = username();
                                    String mm = usermoney();
                                    Intent intent = new Intent(getApplicationContext(), vercarrinho.class);
                                    intent.putExtra("username", ee);
                                    intent.putExtra("dinheiro", mm);
                                    finish();
                                    startActivity(intent);
                                    break;
                                //Clica em cancelar
                                case DialogInterface.BUTTON_NEGATIVE:
                                    break;
                            }
                        }
                    };

                    //OPCIONAL TER O VALOR COM DUAS CASAS DECIMAIS (verificar o valor de 5 limoes)
                    builder.setMessage("");
                    // botoes para o texto
                    builder.setPositiveButton("OK", dialogClickListener);
                    builder.setNegativeButton("Cancelar", dialogClickListener);
                    // cria e mostra o alert
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
                if(selectedFromList.contains("PC 3"))
                {
                    //Criar uma caixa de texto a perguntar se o utilizador quer mesmo comprar o nº de artigos pelo preço que aparece calculado no ecra
                    AlertDialog.Builder builder = new AlertDialog.Builder(vercarrinho.this);
                    builder.setTitle("Apagar");
                    //saber qual dos botoes foi clicado
                    DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            switch(which){
                                // Clica em Confirmar
                                case DialogInterface.BUTTON_POSITIVE:
                                    String apaga = "PC 3";
                                    DB.digaum(apaga);
                                    String ee = username();
                                    String mm = usermoney();
                                    Intent intent = new Intent(getApplicationContext(), vercarrinho.class);
                                    intent.putExtra("username", ee);
                                    intent.putExtra("dinheiro", mm);
                                    finish();
                                    startActivity(intent);
                                    break;
                                //Clica em cancelar
                                case DialogInterface.BUTTON_NEGATIVE:
                                    break;
                            }
                        }
                    };
                    //OPCIONAL TER O VALOR COM DUAS CASAS DECIMAIS (verificar o valor de 5 limoes)
                    builder.setMessage("");
                    // botoes para o texto
                    builder.setPositiveButton("OK", dialogClickListener);
                    builder.setNegativeButton("Cancelar", dialogClickListener);
                    // cria e mostra o alert
                    AlertDialog dialog = builder.create();
                    dialog.show();


                }
                if(selectedFromList.contains("PC 3"))
                {
                    //Criar uma caixa de texto a perguntar se o utilizador quer mesmo comprar o nº de artigos pelo preço que aparece calculado no ecra
                    AlertDialog.Builder builder = new AlertDialog.Builder(vercarrinho.this);
                    builder.setTitle("Apagar");
                    //saber qual dos botoes foi clicado
                    DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            switch(which){
                                // Clica em Confirmar
                                case DialogInterface.BUTTON_POSITIVE:
                                    String apaga = "PC 3";
                                    DB.digaum(apaga);
                                    String ee = username();
                                    String mm = usermoney();
                                    Intent intent = new Intent(getApplicationContext(), vercarrinho.class);
                                    intent.putExtra("username", ee);
                                    intent.putExtra("dinheiro", mm);
                                    finish();
                                    startActivity(intent);
                                    break;
                                //Clica em cancelar
                                case DialogInterface.BUTTON_NEGATIVE:
                                    break;
                            }
                        }
                    };
                    //OPCIONAL TER O VALOR COM DUAS CASAS DECIMAIS (verificar o valor de 5 limoes)
                    builder.setMessage("");
                    // botoes para o texto
                    builder.setPositiveButton("OK", dialogClickListener);
                    builder.setNegativeButton("Cancelar", dialogClickListener);
                    // cria e mostra o alert
                    AlertDialog dialog = builder.create();
                    dialog.show();


                }
                if(selectedFromList.contains("PC Especial"))
                {
                    //Criar uma caixa de texto a perguntar se o utilizador quer mesmo comprar o nº de artigos pelo preço que aparece calculado no ecra
                    AlertDialog.Builder builder = new AlertDialog.Builder(vercarrinho.this);
                    builder.setTitle("Apagar");
                    //saber qual dos botoes foi clicado
                    DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            switch(which){
                                // Clica em Confirmar
                                case DialogInterface.BUTTON_POSITIVE:
                                    String apaga = "PC Especial";
                                    DB.digaum(apaga);
                                    String ee = username();
                                    String mm = usermoney();
                                    Intent intent = new Intent(getApplicationContext(), vercarrinho.class);
                                    intent.putExtra("username", ee);
                                    intent.putExtra("dinheiro", mm);
                                    finish();
                                    startActivity(intent);
                                    break;
                                //Clica em cancelar
                                case DialogInterface.BUTTON_NEGATIVE:
                                    break;
                            }
                        }
                    };
                    //OPCIONAL TER O VALOR COM DUAS CASAS DECIMAIS (verificar o valor de 5 limoes)
                    builder.setMessage("");
                    // botoes para o texto
                    builder.setPositiveButton("OK", dialogClickListener);
                    builder.setNegativeButton("Cancelar", dialogClickListener);
                    // cria e mostra o alert
                    AlertDialog dialog = builder.create();
                    dialog.show();


                }
                if(selectedFromList.contains("PC Corsair"))
                {
                    //Criar uma caixa de texto a perguntar se o utilizador quer mesmo comprar o nº de artigos pelo preço que aparece calculado no ecra
                    AlertDialog.Builder builder = new AlertDialog.Builder(vercarrinho.this);
                    builder.setTitle("Apagar");
                    //saber qual dos botoes foi clicado
                    DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            switch(which){
                                // Clica em Confirmar
                                case DialogInterface.BUTTON_POSITIVE:
                                    String apaga = "PC Corsair";
                                    DB.digaum(apaga);
                                    String ee = username();
                                    String mm = usermoney();
                                    Intent intent = new Intent(getApplicationContext(), vercarrinho.class);
                                    intent.putExtra("username", ee);
                                    intent.putExtra("dinheiro", mm);
                                    finish();
                                    startActivity(intent);
                                    break;
                                //Clica em cancelar
                                case DialogInterface.BUTTON_NEGATIVE:
                                    break;
                            }
                        }
                    };
                    //OPCIONAL TER O VALOR COM DUAS CASAS DECIMAIS (verificar o valor de 5 limoes)
                    builder.setMessage("");
                    // botoes para o texto
                    builder.setPositiveButton("OK", dialogClickListener);
                    builder.setNegativeButton("Cancelar", dialogClickListener);
                    // cria e mostra o alert
                    AlertDialog dialog = builder.create();
                    dialog.show();


                }
                if(selectedFromList.contains("PC Razer"))
                {
                    //Criar uma caixa de texto a perguntar se o utilizador quer mesmo comprar o nº de artigos pelo preço que aparece calculado no ecra
                    AlertDialog.Builder builder = new AlertDialog.Builder(vercarrinho.this);
                    builder.setTitle("Apagar");
                    //saber qual dos botoes foi clicado
                    DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            switch(which){
                                // Clica em Confirmar
                                case DialogInterface.BUTTON_POSITIVE:
                                    String apaga = "PC Razer";
                                    DB.digaum(apaga);
                                    String ee = username();
                                    String mm = usermoney();
                                    Intent intent = new Intent(getApplicationContext(), vercarrinho.class);
                                    intent.putExtra("username", ee);
                                    intent.putExtra("dinheiro", mm);
                                    finish();
                                    startActivity(intent);
                                    break;
                                //Clica em cancelar
                                case DialogInterface.BUTTON_NEGATIVE:
                                    break;
                            }
                        }
                    };
                    //OPCIONAL TER O VALOR COM DUAS CASAS DECIMAIS (verificar o valor de 5 limoes)
                    builder.setMessage("");
                    // botoes para o texto
                    builder.setPositiveButton("OK", dialogClickListener);
                    builder.setNegativeButton("Cancelar", dialogClickListener);
                    // cria e mostra o alert
                    AlertDialog dialog = builder.create();
                    dialog.show();


                }
                if(selectedFromList.contains("Portátil Gaming"))
                {
                    //Criar uma caixa de texto a perguntar se o utilizador quer mesmo comprar o nº de artigos pelo preço que aparece calculado no ecra
                    AlertDialog.Builder builder = new AlertDialog.Builder(vercarrinho.this);
                    builder.setTitle("Apagar");
                    //saber qual dos botoes foi clicado
                    DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            switch(which){
                                // Clica em Confirmar
                                case DialogInterface.BUTTON_POSITIVE:
                                    String apaga = "Portátil Gaming";
                                    DB.digaum(apaga);
                                    String ee = username();
                                    String mm = usermoney();
                                    Intent intent = new Intent(getApplicationContext(), vercarrinho.class);
                                    intent.putExtra("username", ee);
                                    intent.putExtra("dinheiro", mm);
                                    finish();
                                    startActivity(intent);
                                    break;
                                //Clica em cancelar
                                case DialogInterface.BUTTON_NEGATIVE:
                                    break;
                            }
                        }
                    };
                    //OPCIONAL TER O VALOR COM DUAS CASAS DECIMAIS (verificar o valor de 5 limoes)
                    builder.setMessage("");
                    // botoes para o texto
                    builder.setPositiveButton("OK", dialogClickListener);
                    builder.setNegativeButton("Cancelar", dialogClickListener);
                    // cria e mostra o alert
                    AlertDialog dialog = builder.create();
                    dialog.show();


                }
                if(selectedFromList.contains("PC Low Cost"))
                {
                    //Criar uma caixa de texto a perguntar se o utilizador quer mesmo comprar o nº de artigos pelo preço que aparece calculado no ecra
                    AlertDialog.Builder builder = new AlertDialog.Builder(vercarrinho.this);
                    builder.setTitle("Apagar");
                    //saber qual dos botoes foi clicado
                    DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            switch(which){
                                // Clica em Confirmar
                                case DialogInterface.BUTTON_POSITIVE:
                                    String apaga = "PC Low Cost";
                                    DB.digaum(apaga);
                                    String ee = username();
                                    String mm = usermoney();
                                    Intent intent = new Intent(getApplicationContext(), vercarrinho.class);
                                    intent.putExtra("username", ee);
                                    intent.putExtra("dinheiro", mm);
                                    finish();
                                    startActivity(intent);
                                    break;
                                //Clica em cancelar
                                case DialogInterface.BUTTON_NEGATIVE:
                                    break;
                            }
                        }
                    };
                    //OPCIONAL TER O VALOR COM DUAS CASAS DECIMAIS (verificar o valor de 5 limoes)
                    builder.setMessage("");
                    // botoes para o texto
                    builder.setPositiveButton("OK", dialogClickListener);
                    builder.setNegativeButton("Cancelar", dialogClickListener);
                    // cria e mostra o alert
                    AlertDialog dialog = builder.create();
                    dialog.show();


                }
                if(selectedFromList.contains("Mega PC"))
                {
                    //Criar uma caixa de texto a perguntar se o utilizador quer mesmo comprar o nº de artigos pelo preço que aparece calculado no ecra
                    AlertDialog.Builder builder = new AlertDialog.Builder(vercarrinho.this);
                    builder.setTitle("Apagar");
                    //saber qual dos botoes foi clicado
                    DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            switch(which){
                                // Clica em Confirmar
                                case DialogInterface.BUTTON_POSITIVE:
                                    String apaga = "Mega PC";
                                    DB.digaum(apaga);
                                    String ee = username();
                                    String mm = usermoney();
                                    Intent intent = new Intent(getApplicationContext(), vercarrinho.class);
                                    intent.putExtra("username", ee);
                                    intent.putExtra("dinheiro", mm);
                                    finish();
                                    startActivity(intent);
                                    break;
                                //Clica em cancelar
                                case DialogInterface.BUTTON_NEGATIVE:
                                    break;
                            }
                        }
                    };
                    //OPCIONAL TER O VALOR COM DUAS CASAS DECIMAIS (verificar o valor de 5 limoes)
                    builder.setMessage("");
                    // botoes para o texto
                    builder.setPositiveButton("OK", dialogClickListener);
                    builder.setNegativeButton("Cancelar", dialogClickListener);
                    // cria e mostra o alert
                    AlertDialog dialog = builder.create();
                    dialog.show();

                }
                if(selectedFromList.contains("Sal Grosso"))
                {
                    //Criar uma caixa de texto a perguntar se o utilizador quer mesmo comprar o nº de artigos pelo preço que aparece calculado no ecra
                    AlertDialog.Builder builder = new AlertDialog.Builder(vercarrinho.this);
                    builder.setTitle("Apagar");
                    //saber qual dos botoes foi clicado
                    DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            switch(which){
                                // Clica em Confirmar
                                case DialogInterface.BUTTON_POSITIVE:
                                    String apaga = "Sal Grosso";
                                    DB.digaum(apaga);
                                    String ee = username();
                                    String mm = usermoney();
                                    Intent intent = new Intent(getApplicationContext(), vercarrinho.class);
                                    intent.putExtra("username", ee);
                                    intent.putExtra("dinheiro", mm);
                                    finish();
                                    startActivity(intent);
                                    break;
                                //Clica em cancelar
                                case DialogInterface.BUTTON_NEGATIVE:
                                    break;
                            }
                        }
                    };
                    //OPCIONAL TER O VALOR COM DUAS CASAS DECIMAIS (verificar o valor de 5 limoes)
                    builder.setMessage("");
                    // botoes para o texto
                    builder.setPositiveButton("OK", dialogClickListener);
                    builder.setNegativeButton("Cancelar", dialogClickListener);
                    // cria e mostra o alert
                    AlertDialog dialog = builder.create();
                    dialog.show();

                }

                //endregion
            }

        });


        Bundle extras = getIntent().getExtras();
        //OBTER O NOME E MONTANTE DO UTILIZADOR PARA PODER USAR DEPOIS
        String douser = extras.getString("username");
        String montante = extras.getString("dinheiro");

        double montadonodinheiro = Double.parseDouble(montante);
        String mamas = String.format("%.2f", testes());
        double apostas = Double.parseDouble(mamas);
        double calculos = montadonodinheiro - apostas;
        String rabo = String.valueOf(calculos);
        mp= MediaPlayer.create(this, R.raw.metido);

        comprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (montadonodinheiro >= apostas)
                {
                    Boolean sucessonavida = DB.updateuserdata(douser, rabo);
                    if(sucessonavida) {
                        Boolean check = DB.apaga();
                        //verifica se apagou
                        if (check) {
                            Toast.makeText(vercarrinho.this, "Comprado", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), Loja.class);
                            intent.putExtra("username", douser);
                            intent.putExtra("montante", rabo);
                            mp.start();
                            startActivity(intent);
                        }
                        else
                            Toast.makeText(vercarrinho.this, "Não Comprado", Toast.LENGTH_SHORT).show();
                    }
                    else
                        Toast.makeText(vercarrinho.this, "Não Deu", Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(vercarrinho.this, "O seu saldo não é suficiente", Toast.LENGTH_SHORT).show();
            }
        });

    }
}