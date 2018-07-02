package com.example.q.tap_structure;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

/**
 * Created by deepshikha on 20/3/17.
 */

public class PhotosActivity extends AppCompatActivity {
    int int_position;
    private GridView gridView;
    GridViewAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tap2_layout);
        gridView = (GridView)findViewById(R.id.gv_folder);
        int_position = getIntent().getIntExtra("value", 0);
        adapter = new GridViewAdapter(this,MainActivity.al_images,int_position);
        gridView.setAdapter(adapter);
    }
}
