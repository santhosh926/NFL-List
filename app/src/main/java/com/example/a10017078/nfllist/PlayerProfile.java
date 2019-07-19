package com.example.a10017078.nfllist;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.TextView;

import static com.example.a10017078.nfllist.MainActivity.customAdapter;
import static com.example.a10017078.nfllist.MainActivity.selectedPosition;

public class PlayerProfile extends Activity {

        TextView name, tds, yds;
        ImageView img;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.playerwindow);

            ConstraintLayout window = findViewById(R.id.id_window);
            window.setBackgroundColor(Color.LTGRAY);

            DisplayMetrics dm = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(dm);

            int w = dm.widthPixels;
            int h = dm.heightPixels;

            img = findViewById(R.id.id_pimg);
            name = findViewById(R.id.id_name);
            tds = findViewById(R.id.id_tds);
            yds = findViewById(R.id.id_yds);

            img.setImageResource(customAdapter.tingz.get(selectedPosition).getFace());
            name.setText(customAdapter.tingz.get(selectedPosition).getName());
            tds.setText(customAdapter.tingz.get(selectedPosition).getTds() +  " touchdowns" );
            yds.setText(customAdapter.tingz.get(selectedPosition).getYds() + " yards");

            getWindow().setLayout((int)(w * .6), (int)(h *.4));

        }
    }
