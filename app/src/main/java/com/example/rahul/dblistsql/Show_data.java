package com.example.rahul.dblistsql;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Show_data extends AppCompatActivity {
    DataBaseHelper mydb;
    TextView r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);
        mydb=new DataBaseHelper(this);
        r=(TextView)findViewById(R.id.idResult);
        Cursor res=mydb.getAllData();
        StringBuffer sb=new StringBuffer();
        if(res!=null && res.getCount()>0) {
            while (res.moveToNext()) {
                sb.append("CONUMBER: " + res.getString(1) + "\n");
                sb.append("NICKNAME: " + res.getString(2) + "\n");
            }
            r.setText(sb.toString());
            Toast.makeText(this, "Data Retrieved Successfully", Toast.LENGTH_SHORT).show();
            r.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Dialog dialog = new Dialog(Show_data.this);
                    dialog.setContentView(R.layout.nickname_update);
                    final EditText cn = (EditText) dialog.findViewById(R.id.edtcon);
                    final EditText et = (EditText) dialog.findViewById(R.id.edtname);
                    Button ins = (Button) dialog.findViewById(R.id.btnupdate);
                    ins.setOnClickListener(new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View v) {
                            DataBaseHelper myDb=new DataBaseHelper(Show_data.this);
                            String cnn = cn.getText().toString();
                            String ett = et.getText().toString();
                            Boolean result = myDb.updateData(cnn, ett);
                            if (result == true) {
                                cn.setText("");
                                et.setText("");
                                Toast.makeText(Show_data.this, "Data Updated Successfully", Toast.LENGTH_SHORT).show();
                                Intent i=new Intent(Show_data.this,MainPage.class);
                                startActivity(i);
                            } else {
                                Toast.makeText(Show_data.this, "No Rows Affected", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                    dialog.setCancelable(true);
                    dialog.setTitle("ListView");
                    dialog.show();
                }
            });
        }
        else
        {
            Toast.makeText(this, "No Data to Retrieve", Toast.LENGTH_SHORT).show();
        }
    }
}
