package com.ling.atm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class AreaActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView areas;
    private String[] area1;
    private String[] area2;
    private String[] area3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area);
        Intent p = getIntent();
        String position = p.getStringExtra("area");
        areas = (ListView)findViewById(R.id.areas);
            if (position.equals("基隆市")){
                area1 = new String[]{"中正區","暖暖區","八堵區"};
                ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,area1);
                areas.setAdapter(adapter);
    }else if (position.equals("新北市")){
                area2 = new String[]{"永和區","板橋區","新莊區"};
                ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,area2);
                areas.setAdapter(adapter);
            }else if (position.equals("台北市")){
                area2 = new String[]{"信義區","大安區","士林區"};
                ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,area3);
                areas.setAdapter(adapter);
}
areas.setOnItemClickListener(this);

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
            getIntent().putExtra("Area", area1[position]);
            getIntent().putExtra("Area", area2[position]);
            getIntent().putExtra("Area", area3[position]);
            setResult(RESULT_OK,getIntent());
            finish();
        }}

    }