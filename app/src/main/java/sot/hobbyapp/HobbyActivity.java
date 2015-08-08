package sot.hobbyapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Craig on 8/08/2015.
 */
public class HobbyActivity extends Activity{
    TextView hobbyName;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_hobby);
        super.onCreate(savedInstanceState);
        Intent hobby_name = getIntent();
        hobbyName.setText(hobby_name.getStringExtra("hobby_name"));


    }
}
