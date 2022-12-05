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
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import java.io.BufferedReader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class success extends Activity {

    private static String IP_ADDRESS = "34.64.237.34";
    private static String TAG = "platon backend";

    //    TextView txtview;

    private ArrayList<result_data> mArrayList;
    private UsersAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private String mJsonString;

    String id1;
    String pil;
    String nowpil;
    String nowhak1;
    String nowhak2;
    String nowhak3;
    String nowhak4;
    String nownhak1;
    String nownhak2;
    String nownhak3;
    String nownhak4;
    String result_jun;
    String result_juns;
    String result1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        int grade = intent.getIntExtra("grade", 0);

//        txtview = (TextView)findViewById(R.id.textView2);
        mArrayList = new ArrayList<>();

        Button btnNewActivity = (Button) findViewById(R.id.button_result);
        btnNewActivity.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                    InsertData task = new InsertData();
                    task.execute("http://" + IP_ADDRESS +"/work"+"/check.php", id, String.valueOf(grade));

            }
        });


    }

    class InsertData extends AsyncTask<String, Void, String>{
        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = ProgressDialog.show(success.this,
                    "Please Wait", null, true, true);
        }


        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            progressDialog.dismiss();
//            txtview.setText(result);

                mJsonString = result;
                showResult();

                Intent intent = new Intent(success.this, fail.class);
                intent.putExtra("id1", id1);
                intent.putExtra("pil", pil);
                intent.putExtra("nowpil", nowpil);
                intent.putExtra("nowhak1", nowhak1);
                intent.putExtra("nowhak2", nowhak2);
                intent.putExtra("nowhak3", nowhak3);
                intent.putExtra("nowhak4", nowhak4);
                intent.putExtra("nownhak1", nownhak1);
                intent.putExtra("nownhak2", nownhak2);
                intent.putExtra("nownhak3", nownhak3);
                intent.putExtra("nownhak4", nownhak4);
                intent.putExtra("result_jun", result_jun);
                intent.putExtra("result_juns", result_juns);
                intent.putExtra("result", result1);
                startActivity(intent);
            Log.d(TAG, "POST response  - " + result);
        }


        @Override
        protected String doInBackground(String... params) {

            String id = (String)params[1];
            String pw = (String)params[2];


            String serverURL = (String)params[0];
            String postParameters = "id=" + id + "&grade=" + pw;

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
    private void showResult(){
        String TAG_ID = "result";
        String TAG_NAME = "grade";



        try {
            JSONObject jsonObject = new JSONObject(mJsonString);

//            Toast.makeText(getApplicationContext(), "로그인 성공!"+jsonObject, Toast.LENGTH_SHORT).show();


                JSONObject item = jsonObject;

                id1 = item.getString("id");
                pil = item.getString("pil");
                nowpil = item.getString("nowpil");
                nowhak1 = item.getString("nowhak1");
                nowhak2 = item.getString("nowhak2");
                nowhak3 = item.getString("nowhak3");
                nowhak4 = item.getString("nowhak4");
                nownhak1 = item.getString("nownhak1");
                nownhak2 = item.getString("nownhak2");
                nownhak3 = item.getString("nownhak3");
                nownhak4 = item.getString("nownhak4");
                result_jun = item.getString("result_jun");
                result_juns = item.getString("result_juns");
                result1 = item.getString("result1");


        } catch (JSONException e) {

            Log.d(TAG, "showResult : ", e);
        }

    }

}
