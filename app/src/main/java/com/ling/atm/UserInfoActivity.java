package com.ling.atm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class UserInfoActivity extends AppCompatActivity {
    private EditText edNickname;
    private EditText edTel;
    private static final String TAG = UserInfoActivity.class.getSimpleName();
    private Spinner ages;

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
        ages = (Spinner) findViewById(R.id.ages);
       /* ArrayList<String> data = new ArrayList<>();
        for(int i = 15;i<=40;i++){
            data.add(i+"");
        }*/
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.ages, android.R.layout.simple_list_item_1);
        ages.setAdapter(adapter);

    }
    public void addr(View view){
        startActivity(new Intent(this, CityActivity.class));
    }
    public void ok(View view){
        Log.d(TAG,"ok:" + ages.getSelectedItem().toString());
        int age = Integer.parseInt(ages.getSelectedItem().toString());
        String nickname = edNickname.getText().toString();
        String tel = edTel.getText().toString();
        getIntent().putExtra("EXTRA_USERNICKNAME",nickname);
        getIntent().putExtra("EXTRA_USERTEL",tel);
        setResult(RESULT_OK,getIntent());
        finish();


    }
}
