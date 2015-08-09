package sot.hobbyapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Created by Craig on 8/08/2015.
 */

public class HobbyActivity extends Activity{

    HobbyClass hobbyName = new HobbyClass();
    List<HobbyObject> categories = new ArrayList<>();
    final List<SubCategoryRow> listings = new ArrayList<>();
    ListView listView;
    final static String consumerKey = "D878095ABE608E6AA6E5C47EBAFAC669";
    static final String consumerSecret = "8745D63A410A399375192C6960298D49%26";
    String search_string;
    ListViewAdapter adapter;

    String s = "https://api.trademe.co.nz/v1/Search/General.json?oauth_consumer_key=" + consumerKey + "&oauth_signature_method=PLAINTEXT&oauth_signature=" + consumerSecret + "&"
            + "search_string=" + search_string + "&buy=BuyNow&";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hobby);
        listView = (ListView) findViewById(R.id.listView);
        Intent hobby_name = getIntent();
        adapter = new ListViewAdapter(this, R.layout.hobby_list, listings);
        listView.setAdapter(adapter);

        //Create up button in action bar
        getActionBar().setDisplayHomeAsUpEnabled(true);

        listings.clear();
        //new DownloadWebPageTask().execute("golf");
        switch (hobby_name.getStringExtra("hobby_name")){
            case "Golf":
                new DownloadWebPageTask("Clubs").execute("Callaway Golf Clubs");
                new DownloadWebPageTask("Shoes").execute("Nike Golf Shoes");
                new DownloadWebPageTask("Bags").execute("Callaway Golf Bag");
                new DownloadWebPageTask("Balls").execute("Titleist Golf Balls");
                break;
            case "Wind Surfing":
                new DownloadWebPageTask("Boards").execute("Fanatic WindSurfing Board");
                new DownloadWebPageTask("Sails").execute("NeilPryde windsurfing sail");
                break;
            case "Boxing":
                new DownloadWebPageTask("Gloves").execute("Kango Boxing Gloves");
                new DownloadWebPageTask("Bags").execute("Madison Punching Bag");
                new DownloadWebPageTask("Protective Gear").execute("Boxing Head Gear");
                break;
            case "Paddle Boarding":
                new DownloadWebPageTask("Board").execute("SUP Paddle Board");
                new DownloadWebPageTask("Paddle").execute("Carbon SUP Paddle shaft Adjustable");
                new DownloadWebPageTask("Leash").execute("SUP Leash");
                break;

            case "Scuba Diving":
                new DownloadWebPageTask("BCD").execute("Aeris BCD");
                new DownloadWebPageTask("Tank").execute("Steel SCUBA diving tank");
                new DownloadWebPageTask("Regulator").execute("Atlantis Regulator");
                new DownloadWebPageTask("Fins").execute("Cressi SCUBA Fins");
                new DownloadWebPageTask("Mask & Snorkel").execute("Omer SCUBA Mask");
                new DownloadWebPageTask("Weight Belt").execute("Atlantis Weight belt");
        }

        //Create new Action bar
        getActionBar().setTitle(hobby_name.getStringExtra("hobby_name"));

        hobbyName.setName(hobby_name.getStringExtra("hobby_name"));


    }

    private class DownloadWebPageTask extends AsyncTask<String, Void, List<SubCategoryRow>> {
        private String subcat;
        public DownloadWebPageTask(String subcategory) {
            this.subcat = subcategory;
        }

        @Override
        protected List<SubCategoryRow> doInBackground(String... searchStrings) {
            ArrayList<SubCategoryRow> listingDatas = new ArrayList<>();
            for(String search : searchStrings){
                DefaultHttpClient client = new DefaultHttpClient();
                HttpGet httpGet = new HttpGet(getUrl(search));
                try {
                    HttpResponse execute = client.execute(httpGet);
                    InputStream content = execute.getEntity().getContent();
                    SubCategoryRow s = new SubCategoryRow(RunQueryOnXml.getListings(content), subcat);
                    listingDatas.add(s);

                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
            return listingDatas;

        }

        @Override
        protected void onPostExecute(List<SubCategoryRow> li) {
            updateData(li);
        }

        private String getUrl(String search){

            String url = "?oauth_consumer_key=" + consumerKey + "&oauth_signature_method=PLAINTEXT&oauth_signature=" + consumerSecret + "&"
                    + "search_string=" + URLEncoder.encode(search) + "&";
            return "https://api.trademe.co.nz/v1/Search/General.xml" + url;

        }
    }

    private void updateData(List<SubCategoryRow> newListings) {
        listings.addAll(newListings);
        adapter.notifyDataSetChanged();
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return false;
    }

    public void buynow(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("http://www.trademe.co.nz/sports/surfing/stand-up-paddle-boards/auction-930232398.htm"));
        startActivity(intent);
    }
}
