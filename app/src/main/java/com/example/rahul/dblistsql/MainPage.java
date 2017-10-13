package com.example.rahul.dblistsql;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainPage extends AppCompatActivity {
    Button a,u;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        a=(Button)findViewById(R.id.add);
        u=(Button)findViewById(R.id.show);

        a.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainPage.this,MainActivity.class);
                startActivity(i);
            }
        });
        u.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainPage.this,Show_data.class);
                startActivity(i);
            }
        });
    }
}
