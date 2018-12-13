package com.android.yashika.andropedia.Activity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.yashika.andropedia.Fragment.HomeFragment;
import com.android.yashika.andropedia.R;

public class MainActivity extends AppCompatActivity {

    NavigationView navigationView;
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        handler = new Handler();
        drawerLayout =  findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        setUpNavigationView();
        loadHomeFragment();

    }
    private void setUpNavigationView() {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_home:
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.nav_reference:
                        Toast.makeText(MainActivity.this, "nav_reference clicked!", Toast.LENGTH_SHORT).show();
                        Button close_ref;
                        final AlertDialog.Builder alert_ref;
                        LayoutInflater li_ref = LayoutInflater.from(MainActivity.this);
                        View view = li_ref.inflate(R.layout.references, null);
                        alert_ref = new AlertDialog.Builder(MainActivity.this);
                        alert_ref.setView(view);
                        final AlertDialog dialog;
                        dialog = alert_ref.create();
                        close_ref = (Button) view.findViewById(R.id.close_btn_ref);
                        close_ref.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                dialog.dismiss();
                            }
                        });
                        dialog.show();
                        dialog.setCancelable(true);

                        break;
                    case R.id.nav_feedback:
                        //Toast.makeText(MainActivity.this, "nav_feedback clicked!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(android.content.Intent.ACTION_SEND);
                        intent.setPackage("com.google.android.gm");
                        intent.setData(Uri.parse("email"));
                        String email_id[] = {"yashika.singhal96@gmail.com"};
                        intent.putExtra(Intent.EXTRA_EMAIL,email_id);
                        intent.putExtra(Intent.EXTRA_SUBJECT,"Feedback");
                        intent.setType("plain/text");
                        //Intent chooser = Intent.createChooser(intent,"Launch Email");
                        try {
                            startActivity(intent);
                        }
                        catch (Exception e){
                            Toast.makeText(MainActivity.this, "Gmail app is not present", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case R.id.nav_about_us:
                        //Toast.makeText(MainActivity.this, "nav_about_us clicked!", Toast.LENGTH_SHORT).show();
                        Button close;
                        final AlertDialog.Builder alert;
                        LayoutInflater li = LayoutInflater.from(MainActivity.this);
                        View popView = li.inflate(R.layout.about_me, null);
                        alert = new AlertDialog.Builder(MainActivity.this);
                        alert.setView(popView);
                        final AlertDialog Alert1;
                        Alert1 = alert.create();
                        close = (Button) popView.findViewById(R.id.close_about_me_btn);
                        close.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Alert1.dismiss();
                            }
                        });
                        Alert1.show();
                        Alert1.setCancelable(true);
                        break;
                    case R.id.nav_share:
                        //Toast.makeText(MainActivity.this, "nav_share clicked!", Toast.LENGTH_SHORT).show();
                        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                        sharingIntent.setType("text/plain");
                        String shareBody = "http://play.google.com/store/apps/details?id=" + getPackageName();
                        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "I would like to recommend Android Wave app to you.");
                        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                        startActivity(Intent.createChooser(sharingIntent, "Share via"));
                        break;
                    case R.id.nav_rate:
                        //Toast.makeText(MainActivity.this, "nav_rate clicked!", Toast.LENGTH_SHORT).show();
                        Uri uri = Uri.parse("market://details?id=" + getPackageName());
                        Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
                        goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                                Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
                                Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                        try {
                            startActivity(goToMarket);
                        } catch (ActivityNotFoundException e) {
                            startActivity(new Intent(Intent.ACTION_VIEW,
                                    Uri.parse("http://play.google.com/store/apps/details?id=" + getPackageName())));
                        }
                        break;
                    /*case R.id.privacy_policy:
                        Toast.makeText(MainActivity.this, "privacy_policy clicked!", Toast.LENGTH_SHORT).show();*/
                    default:
                        break;
                }
                drawerLayout.closeDrawers();
                return  true;
            }
        });

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout,toolbar,R.string.openDrawer,R.string.closeDrawer){
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();

    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawers();
            return;
        }
        else {
            finish();
        }

    }

    private void loadHomeFragment() {
        navigationView.getMenu().getItem(0).setChecked(true);
        getSupportActionBar().setTitle("Andropedia");
        Fragment fragment = new HomeFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
        transaction.replace(R.id.frame,fragment);
        transaction.commit();
        drawerLayout.closeDrawers();
    }

}
