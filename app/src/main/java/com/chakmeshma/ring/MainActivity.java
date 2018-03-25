package com.chakmeshma.ring;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.TooltipCompat;
import android.view.Gravity;
import android.view.View;

import com.chakmeshma.ring.data.DataManager;

import java.util.ArrayList;

import static android.view.View.FIND_VIEWS_WITH_CONTENT_DESCRIPTION;
import static android.view.View.FIND_VIEWS_WITH_TEXT;

public class MainActivity extends AppCompatActivity {
    private Toolbar actionbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupActionBar();
        DataManager.initInstance();


        for (int i = 0; i < items.length; i++)
            items[i] = "ZXCVZXERW";

        setupMainList(items);
    }

    private void setupMainList(String[] items) {


        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(new MainListRecyclerView.RecyclerViewAdapter(items));
    }

    private void setupActionBar() {


        setSupportActionBar((Toolbar) findViewById(R.id.actionbar));

        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.action_bar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        final SearchView searchView = findViewById(R.id.search);
        final AppCompatTextView countTextView = findViewById(R.id.count);

        ArrayList<View> innerViews = new ArrayList<>();

        searchView.findViewsWithText(innerViews, "Search", FIND_VIEWS_WITH_TEXT | FIND_VIEWS_WITH_CONTENT_DESCRIPTION);
        if (innerViews.size() == 1 && innerViews.get(0) instanceof AppCompatImageView)
            TooltipCompat.setTooltipText(innerViews.get(0), null);

        findViewById(R.id.overflow_icon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((DrawerLayout) findViewById(R.id.drawer_layout)).openDrawer(Gravity.START);

                ((Toolbar) findViewById(R.id.actionbar)).showOverflowMenu();
            }
        });


        searchView.setOnQueryTextFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    countTextView.setVisibility(View.GONE);
                } else {
                    countTextView.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
