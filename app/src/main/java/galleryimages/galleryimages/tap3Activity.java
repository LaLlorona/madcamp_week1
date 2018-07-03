package galleryimages.galleryimages;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

public class tap3Activity extends AppCompatActivity {

    private ImageView imageView;
    private Bitmap bitmap;
    private TextView color_number;
    private TextView pos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tap3_layout);
        Button tap1 = (Button) findViewById(R.id.act3_tap1_btn);
        Button tap2 = (Button) findViewById(R.id.act3_tap2_btn);
        Button tap3 = (Button) findViewById(R.id.act3_tap3_btn);
        color_number = (TextView) findViewById(R.id.color_scheme);
        pos = (TextView) findViewById(R.id.position);


        tap1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getApplicationContext(), tap1Activity.class);
                startActivity(myIntent);
                overridePendingTransition(R.anim.anim_slide_in_left, R.anim.anim_slide_out_right);
                finish();


            }
        });

        tap2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(myIntent);
                overridePendingTransition(R.anim.anim_slide_in_left, R.anim.anim_slide_out_right);
                finish();
            }
        });

        /*
        BitMapPractice myView2 = new BitMapPractice (this);
        setContentView(myView2);
        PaintBoard myView = new PaintBoard (this);
        setContentView(myView);
        */
        imageView = (ImageView) findViewById(R.id.face);
        imageView.setDrawingCacheEnabled(true);
        imageView.buildDrawingCache(true);

        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN || motionEvent.getAction() == MotionEvent.ACTION_MOVE){
                    bitmap = imageView.getDrawingCache();
                    int pixel = bitmap.getPixel((int)motionEvent.getX(),(int)motionEvent.getY());
                    int r = Color.red(pixel);
                    int g = Color.blue(pixel);
                    int b = Color.green(pixel);

                    color_number.setText("R: "+Integer.toString(r)+", G: "+Integer.toString(g)+", B:"+Integer.toString(b));
                    pos.setText("X coordinate is " + Integer.toString((int)motionEvent.getX())+" and Y coordinate is" + Integer.toString((int)motionEvent.getY()));



                }
                return true;
            }
        });









        /*
        FrameLayout stage = (FrameLayout) findViewById(R.id.stage);

        // Stage(FrameLayout)에 CustomView 추가
        CustomView customView = new CustomView(this);
        stage.addView(customView);

        */




        /*
        LinearLayout drawlinear = (LinearLayout) findViewById(R.id.drawing_pan);
        drawlinear.addView(customView);
        */


    }


}


