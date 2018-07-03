package galleryimages.galleryimages;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.View;

public class BitMapPractice extends View {
    // cache bitmap
    private Bitmap cacheBitmap;

    // cache canvas
    private Canvas cacheCanvas;

    private Paint mPaint;

    public BitMapPractice(Context context){
        super(context);

        mPaint = new Paint();
        mPaint.setColor(Color.RED);

    }


    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Bitmap cacheBitmap = resizeBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.keneedy));

        canvas.drawBitmap(cacheBitmap,30,30,mPaint);

    }
    static public Bitmap resizeBitmap(Bitmap original) {

        int resizeWidth = 800;

        double aspectRatio = (double) original.getHeight() / (double) original.getWidth();
        int targetHeight = (int) (resizeWidth * aspectRatio);
        Bitmap result = Bitmap.createScaledBitmap(original, resizeWidth, targetHeight, false);
        if (result != original) {
            original.recycle();
        }
        return result;
    }








}


