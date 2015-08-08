package sot.hobbyapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Craig on 8/08/2015.
 */

public class HobbyActivity extends Activity{
    private HobbyClass hobbyName = new HobbyClass();
    private List<HobbyObject> categories = new ArrayList<>();
    private SwipeMenu

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hobby);
        Intent hobby_name = getIntent();

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
}
