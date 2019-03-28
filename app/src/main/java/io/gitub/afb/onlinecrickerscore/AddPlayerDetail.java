package io.gitub.afb.onlinecrickerscore;

import android.app.Activity;
import android.os.Bundle;

public class AddPlayerDetail extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_player_detail);
        getActionBar().hide();
    }
}
