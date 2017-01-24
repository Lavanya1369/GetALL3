package com.l9ench.getall;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {
    Button b,b1;

    String str;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main3);
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            b=(Button) findViewById(R.id.button);
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    EditText a = (EditText) findViewById(R.id.editText);
                    str = a.getText().toString();
                    EditText c = (EditText) findViewById(R.id.editText2);
                    String d = c.getText().toString();
                    Intent i = new Intent(Main3Activity.this,Display.class);
                    Toast.makeText(Main3Activity.this,d,Toast.LENGTH_SHORT).show();
                    i.putExtra("NAME", str);

                    i.putExtra("NUMBER", d);

                    Toast.makeText(Main3Activity.this,d,Toast.LENGTH_SHORT).show();
                    Toast.makeText(Main3Activity.this,str,Toast.LENGTH_SHORT).show();
                    startActivity(i);
                }
            });
            b1=(Button) findViewById(R.id.button2);
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(Main3Activity.this,MainActivity.class);
                    startActivity(intent);
                }
            });

        }
        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_main, menu);
            return true;
        }
        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();

            //noinspection SimplifiableIfStatement
            if (id == R.id.action_settings) {
                return true;
            }

            return super.onOptionsItemSelected(item);
        }


}
