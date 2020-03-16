package ru.embersoft.saveposition;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Item> items = new ArrayList<>();
    private int lastPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new RvAdapter(items,this));
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //retrieve last position on start
        SharedPreferences getPrefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        lastPosition = getPrefs.getInt("lastPos", 0);
        recyclerView.scrollToPosition(lastPosition);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                lastPosition = layoutManager.findFirstVisibleItemPosition();
            }
        });


        items.add(new Item(R.drawable.pic01));
        items.add(new Item(R.drawable.pic02));
        items.add(new Item(R.drawable.pic03));
        items.add(new Item(R.drawable.pic04));
        items.add(new Item(R.drawable.pic05));
        items.add(new Item(R.drawable.pic06));
        items.add(new Item(R.drawable.pic07));
        items.add(new Item(R.drawable.pic08));
        items.add(new Item(R.drawable.pic09));
        items.add(new Item(R.drawable.pic10));
        items.add(new Item(R.drawable.pic11));
        items.add(new Item(R.drawable.pic12));
        items.add(new Item(R.drawable.pic13));
        items.add(new Item(R.drawable.pic14));
        items.add(new Item(R.drawable.pic15));
        items.add(new Item(R.drawable.pic16));

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //save position in sharedpreferenses on destroy
        SharedPreferences getPrefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        SharedPreferences.Editor e = getPrefs.edit();
        e.putInt("lastPos", lastPosition);
        e.apply();
    }
}
