package com.example.testebd;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.testebd.databinding.ActivityLojaBinding;

import java.util.ArrayList;
import java.util.List;

public class Loja extends AppCompatActivity {
    ActivityLojaBinding binding;
    DrawerLayout DL;

    //DESATIVA o botao de voltar atrás
    @Override
    public void onBackPressed() {}

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
        String montante = extras.getString("montante");
        return montante;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loja);
        binding = ActivityLojaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        DL = findViewById(R.id.dl);
        String[] nomefruta = {"PC 1", "PC 2", "PC 3", "PC Especial", "PC Corsair" , "PC Razer", "Portátil Gaming", "PC Low Cost", "Mega PC", "Sal Grosso"};
        double[] precofruta = {500, 600, 700, 800, 750, 800, 650, 400, 2000, 5};
        int[] imagemfruta = {R.drawable.pc1, R.drawable.pc2, R.drawable.pc3, R.drawable.pc_especial, R.drawable.pc_corsair, R.drawable.pc_razer, R.drawable.pc_portatil, R.drawable.pc_low_cost, R.drawable.pc_mega, R.drawable.sal_grosso};

        GridView gridView = new GridView(Loja.this, nomefruta, imagemfruta);
        binding.gridView.setAdapter(gridView);
        binding.gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent i = new Intent(Loja.this, passar.class);
                //passar parametros
                i.putExtra("nomefruta", nomefruta[position]);
                i.putExtra("preco", precofruta[position]);
                i.putExtra("image", imagemfruta[position]);
                startActivity(i);
            }
        });

    }

    public void ClickMenu(View view){
        opendrawer(DL);
    }

    public static void opendrawer(DrawerLayout DL) {
        DL.openDrawer(GravityCompat.START);
    }

    public void ClickLogo(View view){
        closedrawer(DL);
    }

    public void closedrawer(DrawerLayout dl) {
        if(DL.isDrawerOpen(GravityCompat.START)){
            DL.closeDrawer(GravityCompat.START);
        }
    }


    public void ClickConta(MenuItem item){
        Intent a = new Intent(Loja.this, ContaUser.class);
        a.putExtra("username", username());
        a.putExtra("dinheiro", usermoney());
        //finish();
        startActivity(a);
        //redirectActivity(this,Loja.class);
    }

    public void ClickCarrinho(MenuItem item){
        //Criar intent novo para mostrar o carrinho
        Intent a = new Intent(Loja.this, vercarrinho.class);
        a.putExtra("username", username());
        a.putExtra("dinheiro", usermoney());
        //finish();
        startActivity(a);
    }

    public void ClickFundos(MenuItem item){
        Intent a = new Intent(Loja.this, adicionarFundos.class);
        a.putExtra("username", username());
        a.putExtra("dinheiro", usermoney());
        //finish();
        startActivity(a);
    }

    public void ClickAboutUs(MenuItem item){
        Intent a = new Intent(Loja.this, sobrenos.class);
        startActivity(a);
    }

    public void ClickSignOut(MenuItem item){
        Intent a = new Intent(Loja.this, MainActivity.class);
        startActivity(a);
        Toast.makeText(getApplicationContext(), "Saiu da sessão", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause(){
        super.onPause();
        closedrawer(DL);
    }

}