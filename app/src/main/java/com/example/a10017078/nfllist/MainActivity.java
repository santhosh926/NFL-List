package com.example.a10017078.nfllist;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<Infoting> list;
    TextView pos, szn, description;
    public static int selectedPosition;
    public static CustomAdapter customAdapter;

    @Override
        protected void onSaveInstanceState(Bundle outState) {
            super.onSaveInstanceState(outState);
            outState.putSerializable("list", list);
            outState.putInt("selected", selectedPosition);
        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            listView = findViewById(R.id.id_listView);
            list = new ArrayList<>();

            szn = findViewById(R.id.id_exp);
            pos = findViewById(R.id.id_pos);
            description = findViewById(R.id.id_description);
            selectedPosition = 0;

            if(savedInstanceState != null) {
                list = (ArrayList<Infoting>) savedInstanceState.getSerializable("list");
                int position = savedInstanceState.getInt("selected");

                selectedPosition = position;

                    if(selectedPosition<list.size()) {
                        pos.setText(list.get(position).getPos());
                        szn.setText(list.get(position).getExp() + "");

                        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
                            description.setText(list.get(position).getDes());
                    }

            }

            else{
                list.add(new Infoting("Saquon Barkley", R.drawable.giants, 1, "RB", "The New York Giants are 4-8 this season. They have young and promising young offense, however their quarterback is old and losing his touch. On top of that, the play calling on defense has not been on par with opposing offenses", R.drawable.saquon, 954, 8));
                list.add(new Infoting("Antonio Brown", R.drawable.steelers, 9, "WR", "The Pittsburgh Steelers are 7-4-1 this season. They have strong offensive players and their defense is decent as well. However, their quarterback is old and is throwing many interceptions. Additionally, their effective play calling on offense is questionable", R.drawable.ab, 1028, 12));
                list.add(new Infoting("Odell Beckham Jr", R.drawable.giants, 5, "WR", "The New York Giants are 4-8 this season. They have young and promising young offense, however their quarterback is old and losing his touch. On top of that, the play calling on defense has not been on par with opposing offenses", R.drawable.obj, 1052, 6));
                list.add(new Infoting("Tom Brady", R.drawable.patriots, 19, "QB", "The New England Patriots are 9-3 this season. It is the usual great season for the patriots. However, their mvp quarterback is approaching retirement. He is still good, but lacks the skill he had in his prime. The patriots defense has been decent, but very overshadowed by their strong offense", R.drawable.tombrady, 3342, 20));
                list.add(new Infoting("Eli Manning", R.drawable.giants, 15, "QB", "The New York Giants are 4-8 this season. They have young and promising young offense, however their quarterback is old and losing his touch. On top of that, the play calling on defense has not been on par with opposing offenses", R.drawable.eli, 3263, 15));
                list.add(new Infoting("James Conner", R.drawable.steelers, 2, "RB", "The Pittsburgh Steelers are 7-4-1 this season. They have strong offensive players and their defense is decent as well. However, their quarterback is old and is throwing many interceptions. Additionally, their effective play calling on offense is questionable", R.drawable.conner, 909, 12));
                list.add(new Infoting("Rob Gronkowski", R.drawable.patriots, 9, "TE", "The New England Patriots are 9-3 this season. It is the usual great season for the patriots. However, their mvp quarterback is approaching retirement. He is still good, but lacks the skill he had in his prime. The patriots defense has been decent, but very overshadowed by their strong offense", R.drawable.gronk, 530, 2));
                list.add(new Infoting("Patrick Mahomes", R.drawable.chiefs, 2, "QB", "The Kansas City Chiefs are 10-2 this season. The Chiefs have a very threatening young offense that continues to score many points under their young quarterback who has impressed.", R.drawable.mahomes, 3923, 41));
                list.add(new Infoting("Tyreek Hill", R.drawable.chiefs, 3, "WR", "The Kansas City Chiefs are 10-2 this season. The Chiefs have a very threatening young offense that continues to score many points under their young quarterback who has impressed.", R.drawable.cheetah, 1119, 11));
                list.add(new Infoting("Juju Smith-Schuster", R.drawable.steelers, 2, "WR", "The Pittsburgh Steelers are 7-4-1 this season. They have strong offensive players and their defense is decent as well. However, their quarterback is old and is throwing many interceptions. Additionally, their effective play calling on offense is questionable", R.drawable.juju, 1104, 4));
            }

            customAdapter = new CustomAdapter(this, R.layout.custom_layout, list);

            listView.setAdapter(customAdapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    selectedPosition = position;
                    pos.setText(customAdapter.tingz.get(position).getPos());
                    szn.setText(customAdapter.tingz.get(position).getExp() + "");

                    startActivity(new Intent(MainActivity.this,PlayerProfile.class));

                    if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
                        description.setText(customAdapter.tingz.get(position).getDes());
                }
            });

        }

        public class CustomAdapter extends ArrayAdapter<Infoting> {

            Context context;
            List<Infoting> tingz;
            int resource;

            public CustomAdapter(Context context, int resource, List<Infoting> objects){
                super(context, resource, objects);

                this.context = context;
                tingz = objects;
                this.resource = resource;
            }

            @NonNull
            @Override
            public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
                View adapterLayout = layoutInflater.inflate(resource, null);

                ImageView img = adapterLayout.findViewById(R.id.id_img);
                TextView text = adapterLayout.findViewById(R.id.id_tv1);
                Button btn = adapterLayout.findViewById(R.id.id_btn);

                text.setText(tingz.get(position).getName());
                img.setImageResource(tingz.get(position).getImg());

                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tingz.remove(position);
                        pos.setText("NA");
                        szn.setText("0");
                        selectedPosition = 0;

                        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
                        description.setText("Select a player");

                        notifyDataSetChanged();
                    }
                });

                return adapterLayout;
            }
        }

    }