package com.example.mdjubairayeshi.myapplicationdatabase;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    DataBase dbclass;
    SQLiteDatabase db;
    Button b1,b2;
    EditText et1,et2;
    TextView tv1,tv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.btn);
        b2=(Button)findViewById(R.id.btn2);
        et1=(EditText)findViewById(R.id.Name);
        et2=(EditText)findViewById(R.id.pass);
        tv1=(TextView)findViewById(R.id.tvName);
        tv2=(TextView)findViewById(R.id.tvpass);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbclass.setdata(et1.getText().toString(),et2.getText().toString());
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor=dbclass.getData();
                while(cursor.moveToNext())
                {
                tv1.setText(cursor.getString(1));
                tv2.setText(cursor.getString(2));
            }
            }
        });
    }

}
