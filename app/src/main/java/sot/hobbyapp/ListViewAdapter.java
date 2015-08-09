package sot.hobbyapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.io.InputStream;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

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

        TextView subcatName = (TextView) convertView.findViewById(R.id.subcat_name);

        TextView name1 = (TextView) convertView.findViewById(R.id.itemone_name);
        TextView price1 = (TextView) convertView.findViewById(R.id.itemone_price);

        TextView name2 = (TextView) convertView.findViewById(R.id.itemtwo_name);
        TextView price2 = (TextView) convertView.findViewById(R.id.itemtwo_price);

        CircleImageView img1 = (CircleImageView) convertView.findViewById(R.id.itemone_image);
        CircleImageView img2 = (CircleImageView) convertView.findViewById(R.id.itemtwo_image);

        subcatName.setText(subCategoryRow.getSubcat());

        name1.setText(subCategoryRow.getRow1().getTitle());
        price1.setText(subCategoryRow.getRow1().getBuyNowPrice());

        name2.setText(subCategoryRow.getRow2().getTitle());
        price2.setText(subCategoryRow.getRow2().getBuyNowPrice());

        new DownloadImageTask(img1)
                .execute(subCategoryRow.getRow1().getPictureHref());
        new DownloadImageTask(img2)
                .execute(subCategoryRow.getRow2().getPictureHref());

        return convertView;
    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        CircleImageView bmImage;

        public DownloadImageTask(CircleImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }
}
