package com.l9ench.getall;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    EditText et1,et2;
    Button b1 ,b2;
    ImageButton btn ;
    int year_x,date_x,month_x;
    static final int DILOG_ID =0;
    TextView t1;
    String s1,s2,s3;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showDialogButtonClick();


        et1=(EditText)findViewById(R.id.editText);
        et2=(EditText)findViewById(R.id.editText2);
        b1=(Button)findViewById(R.id.button);
        t1=(TextView)findViewById(R.id.textView3);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1=et1.getText().toString();
                s2=et2.getText().toString();
                s3=t1.getText().toString();
                insertme(s1,s2,s3);



            }
        });

        b2=(Button)findViewById(R.id.button3);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Main3Activity.class);
                startActivity(intent);
            }
        });

    }
    public void showDialogButtonClick(){
        btn = (ImageButton)findViewById(R.id.imageButton);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(DILOG_ID);

            }
        });
    }
    protected Dialog onCreateDialog(int id){
        if(id==DILOG_ID){
            return new DatePickerDialog(this, dpickerListener ,date_x ,month_x,year_x);}
        return null;
    }
    private DatePickerDialog.OnDateSetListener dpickerListener=new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int date, int month, int year) {

            date_x=date;
            month_x=month + 1;
            year_x=year;

    t1.setText(year_x +"/" +month_x + "/"+date_x );

        }
    };
    public void insertme(final String s1,final String s2,final String s3)
    {
        StringRequest stringRequest=new StringRequest(Request.Method.POST, "http://lavanya1369.tk/myapp.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            protected Map<String,String> getParams() throws AuthFailureError{
                Map<String,String> params =new HashMap<String, String>();
                params.put("na",s1);
                params.put("xx",s2);
                params.put("dd",s3);
                return params;

            }
        };
        Secondclass.getInstance().addToRequestQueue(stringRequest);

    }







}
