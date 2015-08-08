package sot.hobbyapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by alex on 8/08/15.
 */
public class HobbyTest extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent i = getIntent();
        i.getStringExtra("name");

        Toast.makeText(this, i.getStringExtra("name"), Toast.LENGTH_LONG).show();
    }
}
