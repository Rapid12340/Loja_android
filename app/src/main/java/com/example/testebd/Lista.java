package com.example.testebd;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Lista extends AppCompatActivity {

    ListView lista;
    DBHelper DB2;

    public StringBuffer tets(){
        Cursor res = DB2.getdata();
        if(res.getCount()==0){
            Toast.makeText(Lista.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
        }
        StringBuffer buffer = new StringBuffer();
        while(res.moveToNext()){
            buffer.append("Name :"+res.getString(0)+"\n");
            buffer.append("Contact :"+res.getString(1)+"\n");
            buffer.append("Date of Birth :"+res.getString(2)+"\n\n");
        }


        AlertDialog.Builder builder = new AlertDialog.Builder(Lista.this);
        builder.setCancelable(true);
        builder.setTitle("User Entries");
        builder.setMessage(buffer.toString());
        builder.show();

        return buffer;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        lista = findViewById(R.id.listinha);
        DB2 = new DBHelper(this);

        List<String> list = new ArrayList<>();

        list.add(tets().toString());
        list.add("ole");


        ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, list);

        lista.setAdapter(arrayAdapter);


    }




}