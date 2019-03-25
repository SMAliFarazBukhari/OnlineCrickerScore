package io.gitub.afb.onlinecrickerscore;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class AdaptorMainPageListviewCustom extends BaseAdapter {

    Context context;
    LayoutInflater layoutInflater;

    //Dummy Data
    String[] CricketTeam1 = {"Pakistan","Australia","NewZealand"};
    String[] CricketTeam2={"India","England","South Africa"};
    String[] Score ={"200/3","132/1","45/0"};
    String[] Over={"12.1","9.4","3.1"};
    String[] MatchType={"T-20","ODI","Test"};

    public AdaptorMainPageListviewCustom(Context context)
    {
        this.context=context;
        layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }


    @Override
    public int getCount() {
        return CricketTeam1.length;
    }

    @Override
    public Object getItem(int position) {
        return CricketTeam1[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        view= layoutInflater.inflate(R.layout.mainpagelistviewlayout,null);

        TextView textViewCT1,textViewCT2, textViewScore,textViewOver,textViewMatchType;

        textViewCT1= view.findViewById(R.id.leftteam);
        textViewCT2= view.findViewById(R.id.rightteam);
        textViewScore= view.findViewById(R.id.scoretextview);
        textViewOver= view.findViewById(R.id.Overtextview);
        textViewMatchType=view.findViewById(R.id.MatchTypetextview);

        textViewCT1.setText(CricketTeam1[position]);
        textViewCT2.setText(CricketTeam2[position]);
        textViewScore.setText(Score[position]);
        textViewOver.setText(Over[position]);
        textViewMatchType.setText(MatchType[position]);


        return view;
    }
}
