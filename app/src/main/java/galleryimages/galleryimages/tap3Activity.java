package galleryimages.galleryimages;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class tap3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tap3_layout);
        Button tap1 = (Button)findViewById(R.id.act3_tap1_btn);
        Button tap2 = (Button)findViewById(R.id.act3_tap2_btn);
        Button tap3 = (Button)findViewById(R.id.act3_tap3_btn);

        tap1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getApplicationContext(),tap1Activity.class);
                startActivity(myIntent);
                overridePendingTransition(R.anim.anim_slide_in_left,R.anim.anim_slide_out_right);
                finish();


            }
        });

        tap2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(myIntent);
                overridePendingTransition(R.anim.anim_slide_in_left,R.anim.anim_slide_out_right);
                finish();
            }
        });



        CustomView customView = new CustomView(this);




    }
    public class CustomView extends View {
        // '붓'에 해당하는 paint 클래스 변수 선언
        private Paint paint;
        private float x, y, r=5;

        // 위치 값들을 저장하기 위한 List 생성
        private List<Pos> data;

        public CustomView(Context context) {
            super(context);

            // paint 클래스 선언 및 초기값 설정
            paint = new Paint();
            paint.setColor(Color.CYAN);
            paint.setStrokeWidth(5f);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            // 저장된 포인트 그리기
            for (Pos p : data) {
                canvas.drawCircle(p.getX(), p.getY(), r, paint);
            }
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            // 터치한 위치 값 추출
            x = event.getX();
            y = event.getY();

            // Pos 클래스를 생성해 데이터 저장 후 List에 추가
            Pos pos = new Pos(x, y);
            data.add(pos);

            // 화면을 강제로 그리기 위해 호출하는 메소드
            invalidate();

            return true;
        }
    }

    /**
     * X, Y 좌표를 저장하기 위한 Pos 클래스
     */
    class Pos {
        float x, y;

        Pos(float x, float y) {
            this.x = x;
            this.y = y;
        }

        public float getX() {
            return x;
        }

        public float getY() {
            return y;
        }
    }

}
