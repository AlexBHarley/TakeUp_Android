package sot.hobbyapp;

/**
 * Created by David on 09-08-2015.
 */

public class ListingData {
    String title = null;
    String buyNowPrice= null;
    String pictureHref = null;

    public ListingData(String title, String buyNowPrice, String pictureHref) {
        super();
        this.title = title;
        this.buyNowPrice = buyNowPrice;
        this.pictureHref = pictureHref;
    }

    public String getTitle() {
        return title;
    }

    public String getBuyNowPrice() {
        return buyNowPrice;
    }

    public String getPictureHref() {
        return pictureHref;
    }

    @Override
    public String toString() {
        return "ListingData [title=" + title + ", buyNowPrice=" + buyNowPrice
                + ", pictureHref=" + pictureHref + "]";
    }
}
