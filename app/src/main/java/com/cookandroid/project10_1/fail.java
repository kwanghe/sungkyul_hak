package com.cookandroid.project10_1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.app.ProgressDialog;
import android.os.AsyncTask;

import android.util.Log;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedReader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import android.widget.Toast;
import java.net.HttpURLConnection;
import java.net.URL;
import android.os.Bundle;

import org.w3c.dom.Text;

public class fail extends AppCompatActivity {
    private TextView want_hak;
    private TextView all_hak;
    private TextView all_pang;
    private TextView all_jun;
    private TextView pang_jum_1;
    private TextView pang_jum_2;
    private TextView pang_jum_3;
    private TextView pang_jum_4;
    private TextView jun_jum_1;
    private TextView jun_jum_2;
    private TextView jun_jum_3;
    private TextView jun_jum_4;
    private TextView result_jun1;
    private TextView result_njun;
    private TextView result_all;
    private TextView result_all1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fail);
        final GridView gv = (GridView) findViewById(R.id.gridView1);
        setTitle("결과");
        Intent intent = getIntent();
        String id = intent.getStringExtra("id1");
        int pil = intent.getIntExtra("pil", 171);
        String nowpil = intent.getStringExtra("nowpil");
        String nowhak1 = intent.getStringExtra("nowhak1");
        String nowhak2 = intent.getStringExtra("nowhak2");
        String nowhak3 = intent.getStringExtra("nowhak3");
        String nowhak4 = intent.getStringExtra("nowhak4");
        String nownhak1 = intent.getStringExtra("nownhak1");
        String nownhak2 = intent.getStringExtra("nownhak2");
        String nownhak3 = intent.getStringExtra("nownhak3");
        String nownhak4 = intent.getStringExtra("nownhak4");
        String result_jun = intent.getStringExtra("result_jun");
        String result_juns = intent.getStringExtra("result_juns");
        String result1 = intent.getStringExtra("result");
        want_hak = (TextView) findViewById(R.id.want_hak);
        all_hak = (TextView) findViewById(R.id.all_hak);
        all_pang = (TextView) findViewById(R.id.all_pang);
        all_jun = (TextView) findViewById(R.id.all_jun);
        pang_jum_1= (TextView) findViewById(R.id.pang_jum_1);
        pang_jum_2= (TextView) findViewById(R.id.pang_jum_2);
        pang_jum_3= (TextView) findViewById(R.id.pang_jum_3);
        pang_jum_4= (TextView) findViewById(R.id.pang_jum_4);
        jun_jum_1= (TextView) findViewById(R.id.jun_jum_1);
        jun_jum_2= (TextView) findViewById(R.id.jun_jum_2);
        jun_jum_3= (TextView) findViewById(R.id.jun_jum_3);
        jun_jum_4= (TextView) findViewById(R.id.jun_jum_4);
        result_jun1= (TextView) findViewById(R.id.result_jun1);
        result_njun =(TextView) findViewById(R.id.result_njun);
        result_all=(TextView) findViewById(R.id.result_all);
        result_all1 = (TextView) findViewById(R.id.result_all1);

        want_hak.setText(String.valueOf(pil));
        all_hak.setText(nowpil);
        all_pang.setText(String.valueOf(String.format("%.2f", (float)((float)Float.parseFloat(nownhak1)+(float)Float.parseFloat(nownhak2)+(float)Float.parseFloat(nownhak3)+(float)Float.parseFloat(nownhak4))/(float)4.0f)));
        all_jun.setText(String.valueOf(String.format("%.2f", (float)((float)Float.parseFloat(nowhak1)+(float)Float.parseFloat(nowhak2)+(float)Float.parseFloat(nowhak3)+(float)Float.parseFloat(nowhak4))/(float)4.0f)));
        pang_jum_1.setText(String.format("%.2f",Float.parseFloat(nownhak1)));
        pang_jum_2.setText(String.format("%.2f",Float.parseFloat(nownhak2)));
        pang_jum_3.setText(String.format("%.2f",Float.parseFloat(nownhak3)));
        pang_jum_4.setText(String.format("%.2f",Float.parseFloat(nownhak4)));
        jun_jum_1.setText(String.format("%.2f",Float.parseFloat(nowhak1)));
        jun_jum_2.setText(String.format("%.2f",Float.parseFloat(nowhak2)));
        jun_jum_3.setText(String.format("%.2f",Float.parseFloat(nowhak3)));
        jun_jum_4.setText(String.format("%.2f",Float.parseFloat(nowhak4)));
        result_jun1.setText(result_jun);
        result_njun.setText(result_juns);
        result_all.setText(id);
        if(Integer.parseInt(result1)==1){
            result_all1.setText("님은 졸업이 불가능 합니다.");
        }
        else if(Integer.parseInt(result1)==0){
            result_all1.setText("님은 졸업이 가능 합니다.");
        }


        MyGridAdapter gAdapter = new MyGridAdapter(this);
        gv.setAdapter(gAdapter);
    }
        public class MyGridAdapter extends BaseAdapter {
            Context context;

            public MyGridAdapter(Context c) {
                context = c;
            }

            public int getCount() {
                return posterID.length;
            }

            public Object getItem(int position) {
                // TODO Auto-generated method stub
                return null;
            }

            public long getItemId(int position) {
                // TODO Auto-generated method stub
                return 0;
            }

            Integer[] posterID = { R.drawable.a2018, };

            public View getView(int position, View convertView, ViewGroup parent) {
                ImageView imageview = new ImageView(context);
                imageview.setLayoutParams(new GridView.LayoutParams(200, 300));
                imageview.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageview.setPadding(5, 5, 5, 5);

                imageview.setImageResource(posterID[position]);

                final int pos = position;
                imageview.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        View dialogView = (View) View.inflate(
                                fail.this, R.layout.dialog, null);
                        AlertDialog.Builder dlg = new AlertDialog.Builder(
                                fail.this);
                        ImageView ivPoster = (ImageView) dialogView
                                .findViewById(R.id.ivPoster);
                        ivPoster.setImageResource(posterID[pos]);
                        dlg.setTitle("학과");
                        dlg.setIcon(R.drawable.ic_launcher);
                        dlg.setView(dialogView);
                        dlg.setNegativeButton("닫기", null);
                        dlg.show();
                    }
                });

                return imageview;
            }

        }


}