package com.example.jongtest2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class hospital extends AppCompatActivity {
    private ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital);
        setTitle("병원 목록");

        final String[] hospital={"가톨릭대학교 서울성모병원","건국대학교병원","경희의료원","고려대학교의료원 안암병원","서울대병원","서울아산병원","세브란스병원","순천향대학교 서울병원","아주대학교병원","인하대학교 부속병원",
        "중앙대학교병원"};

        ListView list = (ListView)findViewById(R.id.hospital_list);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,hospital);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), hospital[position], Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(hospital.this, Hospital_Page.class);
                intent.putExtra("text",hospital[position]);
                startActivity(intent);
            }
        });
    }
}