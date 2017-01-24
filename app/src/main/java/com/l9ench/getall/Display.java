package com.l9ench.getall;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Display extends AppCompatActivity {
    Databasehelper databasehelper;
    SQLiteDatabase sqLiteDatabase;
    String name,number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
         name=getIntent().getStringExtra("NAME");

         number=getIntent().getStringExtra("NUMBER");
        TextView t3=(TextView) findViewById(R.id.textView3);
        TextView t4=(TextView) findViewById(R.id.textView4);
        t3.setText(name);
        t4.setText(number);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    public void deletecontanct(View view){
        databasehelper= new Databasehelper((getApplicationContext()));
        sqLiteDatabase=databasehelper.getReadableDatabase();
        databasehelper.onDelete(name,sqLiteDatabase);
        Toast.makeText(getBaseContext(),"Contact dleted",Toast.LENGTH_SHORT).show();

    }
}
