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

public class MainActivity extends Activity {

    private static String IP_ADDRESS = "34.64.237.34";
    private static String TAG = "platon backend";

//    TextView txtview;
    private EditText mEditTextId;
    private EditText mEditTextPw;

    private ArrayList<PersonalData> mArrayList;
    private UsersAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private String mJsonString;
    String a;
    int b;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("메인 액티비티");
//        txtview = (TextView)findViewById(R.id.textView2);
        mEditTextId = (EditText)findViewById(R.id.textId1);
        mEditTextPw = (EditText)findViewById(R.id.textpassward1);
        mArrayList = new ArrayList<>();
        mAdapter = new UsersAdapter(this, mArrayList);


        Button btnNewActivity = (Button) findViewById(R.id.button_login);
        btnNewActivity.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String i="";
                mArrayList.clear();
                mAdapter.notifyDataSetChanged();
                String id = mEditTextId.getText().toString();
                String pw = mEditTextPw.getText().toString();
                if(pw.equals(i)||id.equals(i)){
                    Toast.makeText(getApplicationContext(), "id, passward를 입력하세요.", Toast.LENGTH_SHORT).show();
                }
                else{
                    InsertData task = new InsertData();
                    task.execute("http://" + IP_ADDRESS +"/work"+"/loginCheck1.php", id, pw);
                    mEditTextId.setText("");
                    mEditTextPw.setText("");
                }
            }
        });
        Button btnNewActivity1 = (Button) findViewById(R.id.button_reg);
        btnNewActivity1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    startActivity(intent);
            }
        });


    }

    class InsertData extends AsyncTask<String, Void, String>{
        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = ProgressDialog.show(MainActivity.this,
                    "Please Wait", null, true, true);
        }


        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            progressDialog.dismiss();
//            txtview.setText(result);


            if(result.equals("")){
                Toast.makeText(getApplicationContext(), "id또는 passward 가 틀렸습니다.", Toast.LENGTH_SHORT).show();
            }
            else{

//            Toast.makeText(getApplicationContext(), "로그인 성공!"+result, Toast.LENGTH_SHORT).show();
            mJsonString = result;
            showResult();
                Intent intent = new Intent(MainActivity.this, grade1.class);
                intent.putExtra("id", a);
                intent.putExtra("grade", b);

                startActivity(intent);

            }


            Log.d(TAG, "POST response  - " + result+a);
        }


        @Override
        protected String doInBackground(String... params) {

            String id = (String)params[1];
            String pw = (String)params[2];


            String serverURL = (String)params[0];
            String postParameters = "id=" + id + "&pw=" + pw;

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
        String TAG_ID = "id";
        String TAG_NAME = "grade";



        try {

            JSONObject jsonObject = new JSONObject(mJsonString);
//            JSONArray jsonArray = jsonObject.getJSONArray(TAG_JSON);
//            Toast.makeText(getApplicationContext(), "로그인 성공!"+jsonObject, Toast.LENGTH_SHORT).show();
            for(int i=0;i<jsonObject.length();i++){

                JSONObject item = jsonObject;

                String id = item.getString(TAG_ID);
                String grade = item.getString(TAG_NAME);
                a=id;
                b= Integer.parseInt(grade);
                PersonalData personalData = new PersonalData();

                personalData.setMember_id(id);
                personalData.setMember_grade(grade);

                mArrayList.add(personalData);
                mAdapter.notifyDataSetChanged();
            }



        } catch (JSONException e) {

            Log.d(TAG, "showResult : ", e);
        }

    }

}
