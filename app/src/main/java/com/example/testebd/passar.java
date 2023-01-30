package com.example.testebd;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

public class passar extends AppCompatActivity {
    int minteger = 1 ;
    //TabelaCarrinho DB;
    DBHelper BD;
    MediaPlayer mp;

    private void display(int number) {
        TextView displayInteger = (TextView) findViewById(R.id.integer_number);
        displayInteger.setText("" + number);
    }
    public void increaseInteger(View view) {
        minteger = minteger + 1;
        display(minteger);
    }

    public void decreaseInteger(View view) {
        Button diminuis = findViewById(R.id.decrease);
        if(minteger == 1)
        {
            diminuis.setEnabled(true);
            display(minteger);
        }
        else
        {
            diminuis.setEnabled(true);
            minteger = minteger - 1;
            display(minteger);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passar);
        //initializer do Media Player
        mp=MediaPlayer.create(this,R.raw.sal_grosso);
        //contexto da tabela
        //DB = new TabelaCarrinho(this);
        BD = new DBHelper(this);
        Button adiionarCarro = findViewById(R.id.addCarrinho);

        //tem que ser criado no oncreate devido a passagem de parametros
        TextView textinho = findViewById(R.id.textinho);
        TextView preco = findViewById(R.id.preco);
        ImageView imagemzinha = findViewById(R.id.grid_image);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value = extras.getString("nomefruta");
            double value2 = extras.getDouble("preco");
            int value3 = extras.getInt("image");
            //converter para string para aparecer na textview
            String nom =String.valueOf(value);
            String prec =String.valueOf(value2);
            textinho.setText(nom);
            preco.setText("Preço: " + prec + "€");
            imagemzinha.setImageResource(value3);
        }


        adiionarCarro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Criar uma caixa de texto a perguntar se o utilizador quer mesmo comprar o nº de artigos pelo preço que aparece calculado no ecra
                AlertDialog.Builder builder = new AlertDialog.Builder(passar.this);
                builder.setTitle("Confirmar");

                //Multiplicar o valor do preço individual pela quantidade escolhida pelo user
                double precomod = extras.getDouble("preco");
                double somapro = precomod * minteger;
                String nomeproduto = textinho.getText().toString();
                String somaproString = String.valueOf(somapro);
                String quantidade = String.valueOf(minteger);

                //saber qual dos botoes foi clicado
                DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch(which){
                            // Clica em Confirmar
                            case DialogInterface.BUTTON_POSITIVE:
                                if(nomeproduto.contains("Sal Grosso"))
                                {
                                    //toca musica
                                    mp.start();


                                    Boolean checkinsertdata = BD.insertuserdata(nomeproduto, somaproString, quantidade);
                                    if(checkinsertdata)
                                        Toast.makeText(passar.this, "Adicionado ao Carrinho", Toast.LENGTH_SHORT).show();
                                    else
                                        Toast.makeText(passar.this, "Não adicionado ao Carrinho", Toast.LENGTH_SHORT).show();

                                }
                                else{
                                    Boolean checkinsertdata = BD.insertuserdata(nomeproduto, somaproString, quantidade);
                                    if(checkinsertdata)
                                        Toast.makeText(passar.this, "Adicionado ao Carrinho", Toast.LENGTH_SHORT).show();
                                    else
                                        Toast.makeText(passar.this, "Não adicionado ao Carrinho", Toast.LENGTH_SHORT).show();

                                }

                                break;
                            //Clica em cancelar
                            case DialogInterface.BUTTON_NEGATIVE:
                                Toast.makeText(passar.this, "Operação Cancelada", Toast.LENGTH_SHORT).show();
                                break;
                        }
                    }
                };

                //OPCIONAL TER O VALOR COM DUAS CASAS DECIMAIS (verificar o valor de 5 limoes)
                builder.setMessage("Adicionar " + quantidade + " " + nomeproduto + " no valor de " + somaproString + "€?");
                // botoes para o texto
                builder.setPositiveButton("OK", dialogClickListener);
                builder.setNegativeButton("Cancelar", dialogClickListener);
                // cria e mostra o alert
                AlertDialog dialog = builder.create();
                dialog.show();

            }
        });



    }
}