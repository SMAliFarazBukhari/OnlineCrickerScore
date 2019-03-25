package io.gitub.afb.onlinecrickerscore;

import android.app.Activity;
import android.os.Bundle;

public class AbooutActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboout);
        getActionBar().hide();
    }
}
