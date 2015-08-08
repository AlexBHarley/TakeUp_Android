package sot.hobbyapp;

import android.graphics.drawable.Drawable;

/**
 * Created by alex on 8/08/15.
 */

public class HobbyObject {
    private String nameOne;
    private String nameTwo;
    private String priceOne;
    private String priceTwo;
    private Drawable imageOne;
    private Drawable imageTwo;

    public Drawable getImageOne() {
        return imageOne;
    }

    public void setImageOne(Drawable imageOne) {
        this.imageOne = imageOne;
    }

    public Drawable getImageTwo() {
        return imageTwo;
    }

    public void setImageTwo(Drawable imageTwo) {
        this.imageTwo = imageTwo;
    }

    public String getNameOne() {
        return nameOne;
    }

    public void setNameOne(String nameOne) {
        this.nameOne = nameOne;
    }

    public String getNameTwo() {
        return nameTwo;
    }

    public void setNameTwo(String nameTwo) {
        this.nameTwo = nameTwo;
    }

    public String getPriceOne() {
        return priceOne;
    }

    public void setPriceOne(String priceOne) {
        this.priceOne = priceOne;
    }

    public String getPriceTwo() {
        return priceTwo;
    }

    public void setPriceTwo(String priceTwo) {
        this.priceTwo = priceTwo;
    }
}
