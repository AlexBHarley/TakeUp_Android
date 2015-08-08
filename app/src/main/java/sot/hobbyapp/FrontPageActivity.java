package sot.hobbyapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * Created by Galvin and Alex on 8/08/2015.
 */

public class FrontPageActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front_page);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_front_page, menu);
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

    public void launchHobby(View view){
        switch (view.getId()){
            case R.id.golf:
                Intent a = new Intent(this, HobbyActivity.class);
                a.putExtra("hobby_name", "Golf");
                startActivity(a);
                break;
            case R.id.wind_surfing:
                Intent b = new Intent(this, HobbyActivity.class);
                b.putExtra("hobby_name", "Wind Surfing");
                startActivity(b);
                break;
            case R.id.boxing:
                Intent c = new Intent(this, HobbyActivity.class);
                c.putExtra("hobby_name", "Boxing");
                startActivity(c);
                break;
            case R.id.paddle:
                Intent d = new Intent(this, HobbyActivity.class);
                d.putExtra("hobby_name", "Paddle Boarding");
                startActivity(d);
                break;

        }
    }
}
