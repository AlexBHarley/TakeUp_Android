package sot.hobbyapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;

//test
//hey this is test no2

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HttpClient httpClient = new DefaultHttpClient();

        HttpGet httpget = new HttpGet("http://api.trademe.co.nz/v1/Search/General.xml?search_string=iphone");
        httpget.addHeader("Authorization", GenerateOAuth.generateAuthorization());
        HttpResponse response;

        TextView s = (TextView) findViewById(R.id.thi);

        try {
            response = httpClient.execute(httpget);
            HttpEntity entity = response.getEntity();
            Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_LONG).show();
            s.setText(entity.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
