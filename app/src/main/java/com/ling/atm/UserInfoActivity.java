package com.ling.atm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class UserInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
    }
    public void back(View view){
        EditText edNickname = (EditText) findViewById(R.id.nickname);
        EditText edTel = (EditText) findViewById(R.id.tel);
        String nickname = edNickname.getText().toString();
        String tel = edTel.getText().toString();
        getIntent().putExtra("EXTRA_USERNICKNAME",nickname);
        getIntent().putExtra("EXTRA_USERTEL",tel);
        setResult(RESULT_OK,getIntent());
        finish();


    }
}
