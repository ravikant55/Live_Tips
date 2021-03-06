package com.example.affwlcom.live_tips;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.affwlcom.live_tips.Fragment.CommodityFragment;
import com.example.affwlcom.live_tips.Fragment.IntradayFragment;
import com.example.affwlcom.live_tips.Fragment.LongTermFragment;
import com.example.affwlcom.live_tips.Fragment.NIftyCallsFragment;
import com.example.affwlcom.live_tips.Fragment.PastPerfomanceFragment;
import com.example.affwlcom.live_tips.Fragment.PivotLevelFragment;
import com.example.affwlcom.live_tips.Fragment.PostionalFragment;
import com.example.affwlcom.live_tips.Fragment.RealTimeDataFragment;
import com.example.affwlcom.live_tips.Fragment.ShortTermFragment;
import com.example.affwlcom.live_tips.Fragment.ViewTerminalFragment;

public class Live_Tips extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setContentView(R.layout.activity_live__tips);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.live__tips, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
//        Bundle data = new Bundle();
//        Intraday first = new Intraday();
        if (id == R.id.nav_intraday) {
            setTitle("Intraday");
            Live_Tips.this.getSupportFragmentManager().beginTransaction().replace(R.id.containerID, IntradayFragment.newInstance()).commit();
        } else if (id == R.id.nav_postional) {
            setTitle("Positional");
            Live_Tips.this.getSupportFragmentManager().beginTransaction().replace(R.id.containerID, PostionalFragment.newInstance()).commit();
        } else if (id == R.id.nav_nifty_calls) {
            setTitle("Nifty Calls");
            Live_Tips.this.getSupportFragmentManager().beginTransaction().replace(R.id.containerID, NIftyCallsFragment.newInstance()).commit();
        } else if (id == R.id.nav_short_term) {
            setTitle("Short Term");
            Live_Tips.this.getSupportFragmentManager().beginTransaction().replace(R.id.containerID, ShortTermFragment.newInstance()).commit();
        } else if (id == R.id.nav_long_term) {
            setTitle("Long Term");
            Live_Tips.this.getSupportFragmentManager().beginTransaction().replace(R.id.containerID, LongTermFragment.newInstance()).commit();
        }
        else if (id == R.id.nav_pivot_levels) {
            setTitle("Pivot Levels");
            Live_Tips.this.getSupportFragmentManager().beginTransaction().replace(R.id.containerID, PivotLevelFragment.newInstance()).commit();

        } else if (id == R.id.nav_real_time_data) {
            setTitle("Real Time Data");
            Live_Tips.this.getSupportFragmentManager().beginTransaction().replace(R.id.containerID, RealTimeDataFragment.newInstance()).commit();
        }
        else if (id == R.id.nav_commodity) {
            setTitle("Commodities");
            Live_Tips.this.getSupportFragmentManager().beginTransaction().replace(R.id.containerID, CommodityFragment.newInstance()).commit();

        } else if (id == R.id.nav_viewterminal) {
            setTitle("View Terminal");
            Live_Tips.this.getSupportFragmentManager().beginTransaction().replace(R.id.containerID, ViewTerminalFragment.newInstance()).commit();

        } else if (id == R.id.nav_past_performance) {
            setTitle("Past Performance");
            Live_Tips.this.getSupportFragmentManager().beginTransaction().replace(R.id.containerID, PastPerfomanceFragment.newInstance()).commit();
        }
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        first.setArguments(data);
//        fragmentManager.beginTransaction().replace(R.id.fragment, first).commit();

//        displaySelectedScreen(id);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
