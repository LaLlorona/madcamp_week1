package galleryimages.galleryimages;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class first_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button tap1 = (Button)findViewById(R.id.main_tap1_btn);
        Button tap2 = (Button)findViewById(R.id.main_tap2_btn);
        Button tap3 = (Button)findViewById(R.id.main_tap3_btn);
        tap1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getApplicationContext(),tap1Activity.class);
                startActivity(myIntent);


            }
        });

        tap2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(myIntent);


            }
        });
        tap3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getApplicationContext(),tap3Activity.class);
                startActivity(myIntent);


        }
        });
    }

}
