package com.example.rahul.dblistsql;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by RAHUL on 8/11/2017.
 */

public class Cst extends BaseAdapter {
    Context context;
    DataBaseHelper myDb;
    int res;
    String [] in;
    LayoutInflater ly;
    ViewHolder vh;
    public Cst(Context context, int css, String[] in) {
        this.context=context;
        this.res=css;
        this.in=in;
        ly=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return in.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    public class ViewHolder {

        TextView tk;
        EditText et;
        Button ins;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null) {
            vh = new ViewHolder();
            convertView = ly.inflate(res, parent, false);
            vh.tk = (TextView) convertView.findViewById(R.id.txtv);
            vh.tk.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final Dialog dialog = new Dialog(context);
                    dialog.setContentView(R.layout.nickname_insert);
                    dialog.setTitle("Title...");
                }
            });
//            vh.et = (EditText) convertView.findViewById(R.id.edtname);
//            vh.ins = (Button) convertView.findViewById(R.id.btninsert);
//            vh.ins.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    String conum = vh.tk.getText().toString();
//                    String nicknm = vh.et.getText().toString();
//                    Boolean result = myDb.insertData(conum, nicknm);
//                    if (result == true) {
//                        Toast.makeText(context, "Data Inserted Successfully", Toast.LENGTH_SHORT).show();
////            Intent i=new Intent(MainActivity.this,FirstScreen.class);
////            startActivity(i);
//                    } else {
//                        Toast.makeText(context, "Data Insertion Failed", Toast.LENGTH_SHORT).show();
//                    }
//                }
//            });
            vh.tk.setText(in[position]);
            convertView.setTag(vh);
        }
        else
        {
            vh=(ViewHolder)convertView.getTag();
        }
            return convertView;
    }
}
