package sot.hobbyapp;

import android.app.Activity;
import android.app.DownloadManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;

/**
 * Created by alex on 8/08/15.
 */
public class HobbyActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        HttpClient httpClient = new DefaultHttpClient();

        HttpGet httpget = new HttpGet("http://api.trademe.co.nz/v1/Search/General.xml?search_string=iphone");
        httpget.addHeader("Authorization", GenerateOAuth.generateAuthorization());
        HttpResponse response;

        try {
            response = httpClient.execute(httpget);
            HttpEntity entity = response.getEntity();
            Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_LONG).show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
