package com.cookandroid.project10_1;

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


import org.w3c.dom.Text;

public class SecondActivity extends Activity {
    private static String IP_ADDRESS = "34.64.237.34";
    private static String TAG = "platon backend";

    private EditText mEditTextId;
    private EditText mEditTextPw;
    private EditText mEditTextPwcheck;
    private EditText mEditgrade;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        setTitle("Second 액티비티");
        Intent getIntent = getIntent();

        mEditTextId = (EditText)findViewById(R.id.db_Id);
        mEditTextPw = (EditText)findViewById(R.id.db_Passward);
        mEditTextPwcheck = (EditText)findViewById(R.id.db_Passwardcheck);
        mEditgrade = (EditText)findViewById(R.id.db_grade);

        Button btnReturn = (Button) findViewById(R.id.register);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String i="";
                String id = mEditTextId.getText().toString();
                String pw = mEditTextPw.getText().toString();
                String pwcheck = mEditTextPwcheck.getText().toString();
                String grade = mEditgrade.getText().toString();
                if(pw.equals(pwcheck)){
                    if(pw.equals(i)||id.equals(i)){Toast.makeText(getApplicationContext(), "id, passward를 입력하세요.", Toast.LENGTH_SHORT).show();}
                    else {
                        InsertData task = new InsertData();
                        task.execute("http://" + IP_ADDRESS + "/work" + "/create.php", id, pw, grade);
                        mEditTextId.setText("");
                        mEditTextPw.setText("");
                        mEditTextPwcheck.setText("");
                        mEditgrade.setText("");
                        finish();
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(), "비밀번호가 틀립니다.", Toast.LENGTH_SHORT).show();
                    mEditTextPw.setText("");
                    mEditTextPwcheck.setText("");
                }

            }
        });

    }

    class InsertData extends AsyncTask<String, Void, String>{
        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = ProgressDialog.show(SecondActivity.this,
                    "Please Wait", null, true, true);
        }


        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            progressDialog.dismiss();
            Toast.makeText(getApplicationContext(), "회원가입 성공!", Toast.LENGTH_SHORT).show();
            Log.d(TAG, "POST response  - " + result);
        }


        @Override
        protected String doInBackground(String... params) {

            String id = (String)params[1];
            String pw = (String)params[2];
            String grade = (String)params[3];


            String serverURL = (String)params[0];
            String postParameters = "id=" + id + "&pw=" + pw + "&grade="+ grade;

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
                if(responseStatusCode == HttpURLConnection.HTTP_OK) {
                    inputStream = httpURLConnection.getInputStream();
                }
                else{
                    inputStream = httpURLConnection.getErrorStream();
                }


                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                StringBuilder sb = new StringBuilder();
                String line = null;

                while((line = bufferedReader.readLine()) != null){
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