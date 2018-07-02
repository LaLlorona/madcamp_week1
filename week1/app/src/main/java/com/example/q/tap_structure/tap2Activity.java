package com.example.q.tap_structure;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

public class tap2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tap2_layout);
        Button tap1 = (Button)findViewById(R.id.act2_tap1_btn);
        Button tap2 = (Button)findViewById(R.id.act2_tap2_btn);
        Button tap3 = (Button)findViewById(R.id.act2_tap3_btn);
        tap1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getApplicationContext(),tap1Activity.class);
                startActivity(myIntent);
                finish();


            }
        });

        tap3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getApplicationContext(),tap3Activity.class);
                startActivity(myIntent);
                finish();


            }
        });

        final GridView gv =(GridView) findViewById(R.id.gridView1);

    }

}



