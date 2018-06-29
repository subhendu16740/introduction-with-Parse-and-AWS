package com.parse.starter;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Switch;

import com.parse.GetCallback;
import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseAnalytics;
import com.parse.ParseAnonymousUtils;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import static com.google.android.gms.analytics.internal.zzy.e;


public class MainActivity extends AppCompatActivity {


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    //creating a column of data in the parse API
/*
    ParseObject score = new ParseObject("Score");
    score.put("username","subhendu");
    score.put("score",98);
    score.saveInBackground(new SaveCallback() {
      @Override
      public void done(ParseException e) {
        if (e == null) {
          Log.i("SaveInBackground", "successful");
        } else {
          Log.i("SaveInBackground", "Failed.Error:" + e.toString());
        }
      }
    });

    */
//modifying the data from the application after creation.
    ParseQuery<ParseObject> query = ParseQuery.getQuery("Score");

      query.getInBackground("t1I8rp2QpU", new GetCallback<ParseObject>() {
        @Override
        public void done(ParseObject object, ParseException e) {
          if (e == null && object != null) {
            object.put("score",200);
            object.saveInBackground();

            Log.i("ObjectValue", object.getString("username"));
            Log.i("ObjectValue", Integer.toString(object.getInt("score")));
          }
        }
      });


      ParseAnalytics.trackAppOpenedInBackground(getIntent());

  }
}
