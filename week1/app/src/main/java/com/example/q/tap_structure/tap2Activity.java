package com.example.q.tap_structure;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class tap2Activity extends AppCompatActivity {

    private static boolean hasPermissions(Context context, String... permissions) {
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && context != null && permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED)
                    return false;
            }
        }
        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tap2_layout);

        Button tap1 = (Button) findViewById(R.id.act2_tap1_btn);
        Button tap2 = (Button) findViewById(R.id.act2_tap2_btn);
        Button tap3 = (Button) findViewById(R.id.act2_tap3_btn);

        int PERMISSION_ALL = 1;

        String[] PERMISSIONS = {Manifest.permission.READ_CONTACTS};
        ActivityCompat.requestPermissions(this, PERMISSIONS, PERMISSION_ALL);

        tap1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getApplicationContext(), tap1Activity.class);
                startActivity(myIntent);
                finish();


            }
        });

        tap3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getApplicationContext(), tap3Activity.class);
                startActivity(myIntent);
                finish();


            }
        });

        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), "MyCameraApp");

        if (!mediaStorageDir.exists()) {
            if (!mediaStorageDir.mkdirs()) {
                Log.d("MyCameraApp", "failed to create directory");
            }
        }

        String basePath = mediaStorageDir.getPath(); //사진 폴더를 가져옴
        File directory = new File(basePath);
        File[] files = directory.listFiles();


        ArrayList<String> filesNameList = new ArrayList<>();

        for (int i = 0; i < files.length; i++) {
            filesNameList.add(files[i].getName());
        }
        //fileNameList 라는 ArrayList 에 파일 이름들이 들어있는 String을 저장함


        class MyAdapter extends BaseAdapter {
            Context context;
            int layout;
            int posterID[] = {
                    R.drawable.c, R.drawable.e, R.drawable.j, R.drawable.q, R.drawable.c, R.drawable.e, R.drawable.j, R.drawable.q, R.drawable.c, R.drawable.e, R.drawable.j, R.drawable.q, R.drawable.c, R.drawable.e, R.drawable.j, R.drawable.q, R.drawable.c, R.drawable.e, R.drawable.j, R.drawable.q, R.drawable.c, R.drawable.e, R.drawable.j, R.drawable.q,
                    R.drawable.c, R.drawable.e, R.drawable.j, R.drawable.q, R.drawable.c, R.drawable.e, R.drawable.j, R.drawable.q, R.drawable.c, R.drawable.e, R.drawable.j, R.drawable.q, R.drawable.c, R.drawable.e, R.drawable.j, R.drawable.q, R.drawable.c, R.drawable.e, R.drawable.j, R.drawable.q, R.drawable.c, R.drawable.e, R.drawable.j, R.drawable.q,
            };
            String basePath;
            ArrayList<String> files;

            public MyAdapter(Context c, String mBasePath, ArrayList<String> file_names) {
                //public MyAdapter(Context c) {
                context = c;
                basePath = mBasePath;
                files.addAll(file_names);
            }

            @Override
            public int getCount() {
                return posterID.length;
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {



                /*
                ImageView imageview = new ImageView(context);
                imageview.setImageResource(posterID[position]);
                imageview.setLayoutParams(new GridView.LayoutParams(200, 300));
                imageview.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageview.setPadding(5, 5, 5, 5);
                */
                /*

                final int pos = position;


                imageview.setOnClickListener(new View.OnClickListener() {

                    public void onClick(View v) {
                        View dialogView = (View) View.inflate(tap2Activity.this, R.layout.dialog, null);
                        AlertDialog.Builder dlg = new AlertDialog.Builder(tap2Activity.this);
                        ImageView ivPoster = (ImageView) dialogView.findViewById(R.id.ivPoster);
                        ivPoster.setImageResource(posterID[pos]);
                        dlg.setTitle("큰 사진");
                        dlg.setIcon(R.drawable.ic_launcher_foreground);
                        dlg.setView(dialogView);
                        dlg.setNegativeButton("닫기", null);
                        dlg.show();

                    }


                });

                return imageview;
                */


                ImageView imageView;
                if (convertView == null) {
                    // if it's not recycled, initialize some attributes
                    imageView = new ImageView(context);
                } else {
                    imageView = (ImageView) convertView;
                }
                Bitmap bm = BitmapFactory.decodeFile(basePath + File.separator + files.get(position));
                Bitmap mThumbnail = ThumbnailUtils.extractThumbnail(bm, 300, 300);
                imageView.setPadding(8, 8, 8, 8);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setLayoutParams(new GridView.LayoutParams(GridView.LayoutParams.MATCH_PARENT, GridView.LayoutParams.MATCH_PARENT));
                imageView.setImageBitmap(mThumbnail);
                return imageView;


            }

        }//end of base adapter


        // 커스텀 아답타 생성
        /*
        final GridView mGridView = (GridView) findViewById(R.id.imageView1); // .xml의 GridView와 연결
        MyAdapter mCustomImageAdapter = new MyAdapter(this, basePath); // 앞에서 정의한 Custom Image Adapter와 연결
        mGridView.setAdapter(mCustomImageAdapter); // GridView가 Custom Image Adapter에서 받은 값을 뿌릴 수 있도록 연결
        */

        final GridView gv = (GridView) findViewById(R.id.imageView1);
        MyAdapter adapter = new MyAdapter(this, basePath, filesNameList);  // 데이터


        gv.setAdapter(adapter);  // 커스텀 아답타를 GridView 에 적용

    }

}





