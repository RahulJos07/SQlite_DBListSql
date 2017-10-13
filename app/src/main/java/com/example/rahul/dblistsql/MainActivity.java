package com.example.rahul.dblistsql;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ListView lw=(ListView)findViewById(R.id.lww);

        String [] in={"2001", "2002", "2003", "2004", "2005", "2006","2007","2008","2009","2010"};
        ArrayAdapter adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, in);
        lw.setAdapter(adapter);

        lw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.nickname_insert);
                final TextView t = (TextView) dialog.findViewById(R.id.txtv);
                String str=lw.getItemAtPosition(position).toString();
                t.setText(str);
                final EditText et = (EditText) dialog.findViewById(R.id.edtname);
                Button ins = (Button) dialog.findViewById(R.id.btninsert);
                ins.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v) {
                        DataBaseHelper myDb=new DataBaseHelper(MainActivity.this);
                        String conum =  t.getText().toString();
                        String nicknm = et.getText().toString();
                        Toast.makeText(context, ""+conum+""+nicknm, Toast.LENGTH_SHORT).show();
                        Boolean result = myDb.insertData(conum, nicknm);
                        if (result == true) {
                            Toast.makeText(context, "Data Inserted Successfully", Toast.LENGTH_SHORT).show();
                            Intent i=new Intent(MainActivity.this,MainPage.class);
                            startActivity(i);
                        } else {
                            Toast.makeText(context, "Data Insertion Failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                dialog.setCancelable(true);
                dialog.setTitle("ListView");
                dialog.show();
            }
        });
    }
}
