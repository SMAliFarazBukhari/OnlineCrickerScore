package io.gitub.afb.onlinecrickerscore;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

public class AddTeams extends Activity {

    private ImageView menuImage,SelectedImage;
    private String selectedImagePath;
    private Button browseBtn;
    private static final int SELECT_PICTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_teams);
        getActionBar().hide();
        SelectedImage = findViewById(R.id.imgflag);

        browseBtn= findViewById(R.id.browseBtn);
        browseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent,"Select Picture"), SELECT_PICTURE);
            }
        });

        //Dotted Menu Image Stuff
        menuImage = findViewById(R.id.menu3dotimage);
        menuImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuOnclick(v);
            }
        });



    }


    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == SELECT_PICTURE) {
                Uri selectedImageUri = data.getData();
                selectedImagePath = getPath(selectedImageUri);
                System.out.println("Image Path : " + selectedImagePath);
                SelectedImage.setImageURI(selectedImageUri);
            }
        }
    }

    public String getPath(Uri uri) {
        String[] projection = { MediaStore.Images.Media.DATA };
        Cursor cursor = managedQuery(uri, projection, null, null, null);
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        return cursor.getString(column_index);
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
