package galleryimages.galleryimages;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;

/**
 * Created by deepshikha on 20/3/17.
 */

public class PhotosActivity extends AppCompatActivity {
    int int_position;
    private GridView gridView;
    GridViewAdapter adapter;
    ImageView myImage;
    Bitmap myBitmap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_gallery);
        myImage = (ImageView) findViewById(R.id.ivPoster);
        gridView = (GridView) findViewById(R.id.gv_folder);

        int_position = getIntent().getIntExtra("value", 0);
        adapter = new GridViewAdapter(this, MainActivity.al_images, int_position);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                View dialogView = (View) View.inflate(PhotosActivity.this, R.layout.dialog, null);

                AlertDialog.Builder dlg = new AlertDialog.Builder(PhotosActivity.this);

                ImageView Poster = (ImageView) dialogView.findViewById(R.id.ivPoster);


                Toast.makeText(getApplicationContext(), MainActivity.al_images.get(int_position).al_imagepath.get(i), Toast.LENGTH_SHORT).show();


                File imgFile = new File(MainActivity.al_images.get(int_position).al_imagepath.get(i));

                if (imgFile.exists()) {
                    Bitmap myBitmap = BitmapFactory.decodeFile(MainActivity.al_images.get(int_position).al_imagepath.get(i));


                    Poster.setImageBitmap(myBitmap);


                }

                dlg.setView(dialogView);


                dlg.setNegativeButton("닫기", null);
                dlg.show();


            }
        });
    }
}
