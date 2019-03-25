package io.gitub.afb.onlinecrickerscore;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

public class AddTeams extends Activity {

    ImageView menuImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_teams);
        getActionBar().hide();



        //Dotted Menu Image Stuff
        menuImage = findViewById(R.id.menu3dotimage);
        menuImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuOnclick(v);
            }
        });



    }


    //Stuff For Dotted Menu
    public void menuOnclick(View v) {

        PopupMenu popup= new PopupMenu(getBaseContext(),v);

        popup.getMenuInflater().inflate(R.menu.menu,popup.getMenu());

        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                int itemid=item.getItemId();
                if(itemid==R.id.exititem)
                {
                    finish();
                    System.exit(0);
                }
                else if(itemid==R.id.aboutitem)
                {
                    Intent i = new Intent(getApplicationContext(),AbooutActivity.class);
                    startActivity(i);
                }


                Toast.makeText(getBaseContext(),"You Selected:"+ item.getTitle(),Toast.LENGTH_LONG).show();
                return true;
            }
        });

        popup.show();




    }
}
