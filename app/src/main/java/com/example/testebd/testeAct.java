package com.example.testebd;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class testeAct extends AppCompatActivity {

    TextView textobusca;
    Button view2;
    DBHelper DB2;

    public String tets(){
        Cursor res = DB2.getdata();
        if(res.getCount()==0){
            Toast.makeText(testeAct.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
        }
        StringBuffer buffer = new StringBuffer();
        while(res.moveToNext()){
            buffer.append("Name :"+res.getString(0)+"\n");
            buffer.append("Contact :"+res.getString(1)+"\n");
            buffer.append("Date of Birth :"+res.getString(2)+"\n\n");
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(testeAct.this);
        builder.setCancelable(true);
        builder.setTitle("User Entries");
        builder.setMessage(buffer.toString());
        builder.show();

        String ola = res.getString(0);

        return ola;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teste);

        view2 = findViewById(R.id.btnView2);
        DB2 = new DBHelper(this);
        textobusca = findViewById(R.id.texttitle3);
        textobusca.setText(tets());

    }
}