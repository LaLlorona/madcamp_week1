package galleryimages.galleryimages;

import android.graphics.Bitmap;

public class Human {
    public String name;
    public String gender;
    public Bitmap image;

    Human(String name, String gender, Bitmap image){
        this.image = image;
        this.name =name;
        this.gender = gender;
    }
}

