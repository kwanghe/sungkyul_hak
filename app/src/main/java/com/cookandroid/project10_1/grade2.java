package com.cookandroid.project10_1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.app.ProgressDialog;
import android.os.AsyncTask;

import android.util.Log;
import android.widget.EditText;
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

public class grade2 extends AppCompatActivity {
    private static String IP_ADDRESS = "34.64.237.34";
    private static String TAG = "platon backend";

    private EditText db_1subject1;
    private EditText db_1subject2;
    private EditText db_1subject3;
    private EditText db_1subject4;
    private EditText db_1subject5;
    private EditText db_1subject6;
    private EditText db_1subject7;
    private EditText db_1subject8;
    private EditText db_1jumsu1;
    private EditText db_1jumsu2;
    private EditText db_1jumsu3;
    private EditText db_1jumsu4;
    private EditText db_1jumsu5;
    private EditText db_1jumsu6;
    private EditText db_1jumsu7;
    private EditText db_1jumsu8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade2);
        TextView textView_list_id = findViewById(R.id.textView_list_id);
        setTitle("2학년");

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        int grade = intent.getIntExtra("grade", 0);

        db_1subject1 = (EditText) findViewById(R.id.db_1subject1);
        db_1subject2 = (EditText) findViewById(R.id.db_1subject2);
        db_1subject3 = (EditText) findViewById(R.id.db_1subject3);
        db_1subject4 = (EditText) findViewById(R.id.db_1subject4);
        db_1subject5 = (EditText) findViewById(R.id.db_1subject5);
        db_1subject6 = (EditText) findViewById(R.id.db_1subject6);
        db_1subject7 = (EditText) findViewById(R.id.db_1subject7);
        db_1subject8 = (EditText) findViewById(R.id.db_1subject8);
        db_1jumsu1 = (EditText) findViewById(R.id.db_1jumsu1);
        db_1jumsu2 = (EditText) findViewById(R.id.db_1jumsu2);
        db_1jumsu3 = (EditText) findViewById(R.id.db_1jumsu3);
        db_1jumsu4 = (EditText) findViewById(R.id.db_1jumsu4);
        db_1jumsu5 = (EditText) findViewById(R.id.db_1jumsu5);
        db_1jumsu6 = (EditText) findViewById(R.id.db_1jumsu6);
        db_1jumsu7 = (EditText) findViewById(R.id.db_1jumsu7);
        db_1jumsu8 = (EditText) findViewById(R.id.db_1jumsu8);

        Button btnReturn = (Button) findViewById(R.id.register);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String i = "";
                String subject1 = db_1subject1.getText().toString();
                String subject2 = db_1subject2.getText().toString();
                String subject3 = db_1subject3.getText().toString();
                String subject4 = db_1subject4.getText().toString();
                String subject5 = db_1subject5.getText().toString();
                String subject6 = db_1subject6.getText().toString();
                String subject7 = db_1subject7.getText().toString();
                String subject8 = db_1subject8.getText().toString();
                String jumsu1 = db_1jumsu1.getText().toString();
                String jumsu2 = db_1jumsu2.getText().toString();
                String jumsu3 = db_1jumsu3.getText().toString();
                String jumsu4 = db_1jumsu4.getText().toString();
                String jumsu5 = db_1jumsu5.getText().toString();
                String jumsu6 = db_1jumsu6.getText().toString();
                String jumsu7 = db_1jumsu7.getText().toString();
                String jumsu8 = db_1jumsu8.getText().toString();

                if (subject1.equals("")||jumsu1.equals("")) {}
                else{
                    InsertData task = new InsertData();
                    task.execute("http://" + IP_ADDRESS + "/work" + "/data_insert.php", id, String.valueOf(grade),"2", subject1, jumsu1);
                    db_1subject1.setText("");
                    db_1jumsu1.setText("");
                }
                if (subject2.equals("")||jumsu2.equals("")) {}
                else{
                    InsertData task = new InsertData();
                    task.execute("http://" + IP_ADDRESS + "/work" + "/data_insert.php", id, String.valueOf(grade),"2", subject2, jumsu2);
                    db_1subject2.setText("");
                    db_1jumsu2.setText("");
                }
                if (subject3.equals("")||jumsu3.equals("")) {}
                else{
                    InsertData task = new InsertData();
                    task.execute("http://" + IP_ADDRESS + "/work" + "/data_insert.php", id, String.valueOf(grade),"2", subject3, jumsu3);
                    db_1subject3.setText("");
                    db_1jumsu3.setText("");
                }
                if (subject4.equals("")||jumsu4.equals("")) {}
                else{
                    InsertData task = new InsertData();
                    task.execute("http://" + IP_ADDRESS + "/work" + "/data_insert.php", id, String.valueOf(grade),"2", subject4, jumsu4);
                    db_1subject4.setText("");
                    db_1jumsu4.setText("");
                }
                if (subject3.equals("")||jumsu5.equals("")) {}
                else{
                    InsertData task = new InsertData();
                    task.execute("http://" + IP_ADDRESS + "/work" + "/data_insert.php", id, String.valueOf(grade),"2", subject5, jumsu5);
                    db_1subject5.setText("");
                    db_1jumsu5.setText("");
                }
                if (subject6.equals("")||jumsu6.equals("")) {}
                else{
                    InsertData task = new InsertData();
                    task.execute("http://" + IP_ADDRESS + "/work" + "/data_insert.php", id, String.valueOf(grade),"2", subject6, jumsu6);
                    db_1subject6.setText("");
                    db_1jumsu6.setText("");
                }
                if (subject7.equals("")||jumsu7.equals("")) {}
                else{
                    InsertData task = new InsertData();
                    task.execute("http://" + IP_ADDRESS + "/work" + "/data_insert.php", id, String.valueOf(grade),"2", subject7, jumsu7);
                    db_1subject7.setText("");
                    db_1jumsu7.setText("");
                }
                if (subject8.equals("")||jumsu8.equals("")) {}
                else{
                    InsertData task = new InsertData();
                    task.execute("http://" + IP_ADDRESS + "/work" + "/data_insert.php", id, String.valueOf(grade),"2", subject8, jumsu8);
                    db_1subject8.setText("");
                    db_1jumsu8.setText("");
                }
                Intent intent = new Intent(grade2.this, grade3.class);
                intent.putExtra("id", id);
                intent.putExtra("grade", grade);
                startActivity(intent);


            }
        });

    }

    class InsertData extends AsyncTask<String, Void, String> {
        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = ProgressDialog.show(grade2.this,
                    "Please Wait", null, true, true);
        }


        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            progressDialog.dismiss();
            Log.d(TAG, "POST response  - " + result);
        }


        @Override
        protected String doInBackground(String... params) {

            String id = (String) params[1];
            String grade = (String) params[2];
            String grade1 = (String) params[3];
            String gamok = (String) params[4];
            String jumsu = (String) params[5];


            String serverURL = (String) params[0];
            String postParameters = "id=" + id + "&grade=" + grade + "&grade1=" + grade1 + "&gamok="+gamok+ "&jumsu="+jumsu;

            try {

                URL url = new URL(serverURL);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();


                httpURLConnection.setReadTimeout(5000);
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.connect();


                OutputStream outputStream = httpURLConnection.getOutputStream();
                outputStream.write(postParameters.getBytes("UTF-8"));
                outputStream.flush();
                outputStream.close();


                int responseStatusCode = httpURLConnection.getResponseCode();
                Log.d(TAG, "POST response code - " + responseStatusCode);

                InputStream inputStream;
                if (responseStatusCode == HttpURLConnection.HTTP_OK) {
                    inputStream = httpURLConnection.getInputStream();
                } else {
                    inputStream = httpURLConnection.getErrorStream();
                }


                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                StringBuilder sb = new StringBuilder();
                String line = null;

                while ((line = bufferedReader.readLine()) != null) {
                    sb.append(line);
                }


                bufferedReader.close();


                return sb.toString();


            } catch (Exception e) {

                Log.d(TAG, "InsertData: Error ", e);

                return new String("Error: " + e.getMessage());
            }
        }
    }
}