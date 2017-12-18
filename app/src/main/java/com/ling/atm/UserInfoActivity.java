package com.ling.atm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class UserInfoActivity extends AppCompatActivity {
    private EditText edNickname;
    private EditText edTel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        EditText edNickname = (EditText) findViewById(R.id.nickname);
        EditText edTel = (EditText) findViewById(R.id.tel);
        String nickname = getSharedPreferences("info", MODE_PRIVATE).getString("NAME","");
        String tel = getSharedPreferences("info", MODE_PRIVATE).getString("PHONE","");
        edNickname.setText(nickname);
        edTel.setText(tel);
    }
    public void back(View view){
       
        String nickname = edNickname.getText().toString();
        String tel = edTel.getText().toString();
        getIntent().putExtra("EXTRA_USERNICKNAME",nickname);
        getIntent().putExtra("EXTRA_USERTEL",tel);
        setResult(RESULT_OK,getIntent());
        finish();


    }
}
