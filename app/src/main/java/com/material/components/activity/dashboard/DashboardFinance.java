package com.material.components.activity.dashboard;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.material.components.R;
import com.material.components.activity.MainMenu;
import com.material.components.activity.gridlist.GridSingleLine;
import com.material.components.activity.settings.SettingFlat;
import com.material.components.activity.settings.SettingProfile;
import com.material.components.activity.settings.SettingProfileLight;
import com.material.components.activity.timeline.TimelineSimple;
import com.material.components.utils.Tools;

import org.checkerframework.checker.linear.qual.Linear;

public class DashboardFinance extends AppCompatActivity {

    private TabLayout tab_layout;
    private LinearLayout scan_screw_card;
    private LinearLayout my_account_card;
    private LinearLayout photo_album_card;
    private LinearLayout my_history_card;
    private NestedScrollView nested_scroll_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_finance);

        scan_screw_card = (LinearLayout) findViewById(R.id.scan_screw);
        my_account_card = (LinearLayout) findViewById(R.id.my_account_settings);
        photo_album_card = (LinearLayout) findViewById(R.id.photo_album_load);
        my_history_card = (LinearLayout) findViewById(R.id.my_scan_history);

        scan_screw_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // comment this out, this is just for browsing.
                startActivity(new Intent(v.getContext(), MainMenu.class));
            }
        });

        my_account_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), SettingProfile.class));
            }
        });

        photo_album_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), GridSingleLine.class));
            }
        });

        my_history_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), TimelineSimple.class));
            }
        });



        initComponent();
    }

    private void initComponent() {
        nested_scroll_view = (NestedScrollView) findViewById(R.id.nested_scroll_view);
        tab_layout = (TabLayout) findViewById(R.id.tab_layout);

        tab_layout.addTab(tab_layout.newTab().setIcon(R.drawable.ic_home), 0);
        tab_layout.addTab(tab_layout.newTab().setIcon(R.drawable.ic_data_usage), 1);
        tab_layout.addTab(tab_layout.newTab().setIcon(R.drawable.ic_chat), 2);
        tab_layout.addTab(tab_layout.newTab().setIcon(R.drawable.ic_menu), 3);

        // set icon color pre-selected
        tab_layout.getTabAt(0).getIcon().setColorFilter(getResources().getColor(R.color.blue_grey_400), PorterDuff.Mode.SRC_IN);
        tab_layout.getTabAt(1).getIcon().setColorFilter(getResources().getColor(R.color.grey_20), PorterDuff.Mode.SRC_IN);
        tab_layout.getTabAt(2).getIcon().setColorFilter(getResources().getColor(R.color.grey_20), PorterDuff.Mode.SRC_IN);
        tab_layout.getTabAt(3).getIcon().setColorFilter(getResources().getColor(R.color.grey_20), PorterDuff.Mode.SRC_IN);

        tab_layout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(getResources().getColor(R.color.blue_grey_400), PorterDuff.Mode.SRC_IN);
                onTabClicked(tab);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(getResources().getColor(R.color.grey_20), PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                onTabClicked(tab);
            }
        });

        Tools.setSystemBarColor(this, R.color.grey_5);
        Tools.setSystemBarLight(this);
    }

    private void onTabClicked(TabLayout.Tab tab){
        switch (tab.getPosition()) {
            case 0:
                Toast.makeText(getApplicationContext(), "Home", Toast.LENGTH_SHORT).show();
                break;
            case 1:
                Toast.makeText(getApplicationContext(), "Statistics", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(getApplicationContext(), "Communication", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, TimelineSimple.class));
                break;
            case 3:
                Toast.makeText(getApplicationContext(), "History", Toast.LENGTH_SHORT).show();
                break;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search_setting, menu);
        Tools.changeMenuIconColor(menu, getResources().getColor(R.color.grey_60));
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        } else {
            Toast.makeText(getApplicationContext(), item.getTitle(), Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

}