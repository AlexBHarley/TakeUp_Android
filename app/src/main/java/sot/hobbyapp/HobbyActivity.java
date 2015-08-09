package sot.hobbyapp;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
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
            + "search_string=" + search_string + "&";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hobby);
        listView = (ListView) findViewById(R.id.listView);
        Intent hobby_name = getIntent();
        adapter = new ListViewAdapter(this, R.layout.hobby_list, listings);
        listView.setAdapter(adapter);


        //getActionBar().setDisplayHomeAsUpEnabled(true);
        listings.clear();
        //new DownloadWebPageTask().execute("golf");
        switch (hobby_name.getStringExtra("hobby_name")){
            case "Golf":
                new DownloadWebPageTask("Clubs").execute("Callaway Golf Clubs");
                new DownloadWebPageTask("Shoes").execute("Nike Golf Shoes");
                break;
            case "Paddle Boarding":
                break;
        }
        /*
        Clubs
        "Callaway Golf Clubs"
        "TaylorMade Golf Clubs"
        Shoes
        "Nike Golf Shoes"
        "Puma Golf Shoes"
        Bag
        "Callaway Golf Bag"
        "Nike Golf Bag"
        Balls
        "Titleist Golf Balls"
        "Nike Golf Balls"

   */


        //Create new Action bar
        getActionBar().setTitle(hobby_name.getStringExtra("hobby_name"));

        hobbyName.setName(hobby_name.getStringExtra("hobby_name"));

        HobbyObject PaddleBoard = new HobbyObject();
        HobbyObject Paddle = new HobbyObject();
        HobbyObject Leash = new HobbyObject();
        /* All of these will be calls to the website
        Each for Title, Price, Picture
         */
        PaddleBoard.setNameOne("Starboard Atlas Paddle");
        PaddleBoard.setPriceOne("from $899");
        //PaddleBoard.setImageOne();
        PaddleBoard.setNameTwo("Skull Paddleboard");
        PaddleBoard.setPriceTwo("from $1299");
       //PaddleBoard.setImageTwo();

        Paddle.setNameOne("Bote Axe Paddle");
        Paddle.setPriceOne("from $499");
        //Paddle.setImageOne();
        Paddle.setNameTwo("Pacific Paddle");
        Paddle.setPriceTwo("from $299");
        //Paddle.setImageTwo();

        Leash.setNameOne("Keeper Combo Kit");
        Leash.setPriceOne("from $29");
        //Leash.setImageOne();
        Leash.setNameTwo("SUP Surf Leash");
        Leash.setPriceTwo("from $49");
        //Leash.setImageTwo();

        categories.add(PaddleBoard);
        categories.add(Paddle);
        categories.add(Leash);
        hobbyName.setSubCategories(categories);

        /* Some loop of getView
        hobbyName.getCategories(categories).getView();



        */
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
        Toast.makeText(getApplicationContext(), String.valueOf(listings.size()), Toast.LENGTH_LONG).show();
    }
}
