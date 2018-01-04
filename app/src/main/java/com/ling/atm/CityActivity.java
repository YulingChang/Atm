package com.ling.atm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CityActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView city;
    private String[] cities;
    public static final String TAG = CityActivity.class.getSimpleName();
    public static final int REQUEST_LOGIN = 102;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);
        city = (ListView) findViewById(R.id.city);
        cities = new String[]{"基隆市","新北市","台北市"};
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,cities);
        city.setAdapter(adapter);
        city.setOnItemClickListener(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        Log.d(TAG, "onItemClick:  "+ position + "/" + cities[position]);
        Intent p = new Intent(this, AreaActivity.class);
        p.putExtra("area", cities[position] );
        startActivityForResult(p, REQUEST_LOGIN);

    }
}
