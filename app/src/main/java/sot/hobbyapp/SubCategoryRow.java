package sot.hobbyapp;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Created by alex on 9/08/15.
 */
public class SubCategoryRow {
    private ListingData row1;

    public String getSubcat() {
        return subcat;
    }

    private String subcat;


    public ListingData getRow2() {
        return row2;
    }

    public ListingData getRow1() {
        return row1;
    }

    private ListingData row2;

    public SubCategoryRow(Collection<ListingData> row, String subcat){
        this.subcat = subcat;
        Iterator<ListingData> iterator = row.iterator();
        this.row1 = iterator.next();
        this.row2 = iterator.next();
    }
}
