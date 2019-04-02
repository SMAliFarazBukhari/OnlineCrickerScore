package io.gitub.afb.onlinecrickerscore;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class AddPlayerDetail extends Activity {

    private ImageView menuImage;
    private TextView DateTv;
    private Spinner PlayerTypeSp,BowlerTypeSp;
    private String SelectedPlayerType;


    private String PlayerDOB;
    private DatePickerDialog.OnDateSetListener  DateSelectorListener;
    LinearLayout LL4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_player_detail);
        getActionBar().hide();
        LL4=findViewById(R.id.LL4);
        LL4.setVisibility(View.INVISIBLE);


        //Player & Bowler Spinner Stuff
        PlayerTypeSp=findViewById(R.id.PlayerTypeSpinner);
        BowlerTypeSp=findViewById(R.id.BowlerTypeSpinner);




       PlayerTypeSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

               SelectedPlayerType=parent.getItemAtPosition(position).toString().trim();

               if(SelectedPlayerType.equals("All Rounder")||SelectedPlayerType.equals("Bowler"))
               {
                   Toast.makeText(AddPlayerDetail.this,SelectedPlayerType,Toast.LENGTH_SHORT).show();
                   LL4.setVisibility(View.VISIBLE);
               }
               else{
                   LL4.setVisibility(View.INVISIBLE);
               }
              // Toast.makeText(AddPlayerDetail.this,SelectedItem,Toast.LENGTH_SHORT).show();

           }

           @Override
           public void onNothingSelected(AdapterView<?> parent) {

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



        //Date Picking Stuff
        DateTv = findViewById(R.id.SelectDateTv);

        DateTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar= Calendar.getInstance();
                int year,month,day;

                year = calendar.get(Calendar.YEAR);
                month = calendar.get(Calendar.MONTH);
                day=calendar.get(Calendar.DAY_OF_MONTH);


                DatePickerDialog dialog= new DatePickerDialog(AddPlayerDetail.this,
                        android.R.style.Theme_DeviceDefault_Dialog_MinWidth,
                       // android.R.style.Theme_DeviceDefault_Light_Dialog_MinWidth,
                       // android.R.style.Theme_Holo_Dialog_MinWidth,
                        DateSelectorListener,
                        year,month,day);

                //dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        DateSelectorListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                month++;
                PlayerDOB=dayOfMonth+"/"+month+"/"+year;
                DateTv.setText(PlayerDOB);

            }
        };





    }

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
