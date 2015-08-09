package sot.hobbyapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by alex on 9/08/15.
 */
public class ListViewAdapter extends ArrayAdapter<SubCategoryRow> {

    public ListViewAdapter(Context context, int resource, List objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater;
        inflater = LayoutInflater.from(getContext());
        convertView = inflater.inflate(R.layout.hobby_list, null);

        SubCategoryRow subCategoryRow = getItem(position);

        TextView name1 = (TextView) convertView.findViewById(R.id.itemone_name);
        TextView price1 = (TextView) convertView.findViewById(R.id.itemone_price);

        TextView name2 = (TextView) convertView.findViewById(R.id.itemtwo_name);
        TextView price2 = (TextView) convertView.findViewById(R.id.itemtwo_price);

        name1.setText(subCategoryRow.getRow1().getTitle());
        price1.setText(subCategoryRow.getRow1().getBuyNowPrice());

        name2.setText(subCategoryRow.getRow2().getTitle());
        price2.setText(subCategoryRow.getRow2().getBuyNowPrice());


        return convertView;
    }
}
