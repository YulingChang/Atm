package com.ling.atm;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import static android.app.Activity.RESULT_OK;

public class LoginActivity extends AppCompatActivity {
    private EditText edUserid;
    private EditText edPasswd;
    private String uid;
    private String pw;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edUserid = (EditText) findViewById(R.id.userid);
        edPasswd = (EditText) findViewById(R.id.passwd);
        String userid = getSharedPreferences("atm", MODE_PRIVATE)
                 .getString("USERID", " ");
        edUserid.setText(userid);

    }
    public void Login(View view) {
        setContentView(R.layout.activity_login);
        EditText edUserid = (EditText) findViewById(R.id.userid);
        EditText edPasswd = (EditText) findViewById(R.id.passwd);
        uid = edUserid.getText().toString();
        pw = edPasswd.getText().toString();
        // http://atm201605.appspot.com/login?uid=jack&pw=1234


//        if (uid.equals("jack") && pw.equals("1234")){
//            Toast.makeText(this,"登入成功",Toast.LENGTH_LONG).show();
//            getIntent().putExtra("LOGIN_USERID",uid);
//            getIntent().putExtra("LOGIN_PASSWD",pw);
//            setResult(RESULT_OK,getIntent());
//            finish();
//        }else{
//            new AlertDialog.Builder(this)
//                    .setTitle("Atm")
//                    .setMessage("登入失敗")
//                    .setPositiveButton("OK",null)
//                    .show();
//        }
//    }
    }}
    public class LoginTask extends AsyncTask<String, Void ,Integer>{

        @Override
        protected Integer doInBackground(String... strings) {
            int data = 0;

            try {
                URL url = new URL(strings[0]);
                InputStream is = url.openStream();
                data = is.read();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return data;
        }
        @Override
        protected void onPostExecute(Integer integer) {
            if (integer == 49){

                getIntent().putExtra("EXRA_USERID", uid);
                setResult(RESULT_OK, getIntent());
                finish();
            }else{
                new AlertDialog.Builder(LoginActivity.this)
                        .setTitle("登入")
                        .setMessage("登入失敗")
                        .setPositiveButton("OK", null)
                        .show();
            }
        }
    }

        public void cancel(View view){

        }
    }

    }

