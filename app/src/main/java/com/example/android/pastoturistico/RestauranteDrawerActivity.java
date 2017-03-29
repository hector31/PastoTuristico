package com.example.android.pastoturistico;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class RestauranteDrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    String usuario="",correo="";
    Intent intent;
    TextView tUsername,tCorreo;
    SharedPreferences prefers;
    SharedPreferences.Editor editor;

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurante_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Bundle extras = getIntent().getExtras();
        usuario=extras.getString("usuario");
        correo=extras.getString("correo");

        prefers= getSharedPreferences("MisPreferencias",MODE_PRIVATE);
        editor= prefers.edit();

        setTitle( getResources().getString(R.string.restaurantetittle));
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);


        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs2);
        tabLayout.setupWithViewPager(mViewPager);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View header=navigationView.getHeaderView(0);
        tUsername = (TextView)header.findViewById(R.id.perfilmenu);
        tCorreo= (TextView)header.findViewById(R.id.correomenu);
        tUsername.setText(extras.getString("usuario"));
        tCorreo.setText(extras.getString("correo"));
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




    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id) {
            case R.id.mbares:
                intent = new Intent(RestauranteDrawerActivity.this, BarDrawerActivity.class);
                intent.putExtra("usuario", usuario);
                intent.putExtra("correo", correo);

                startActivity(intent);

                break;
            case R.id.mrestaurante:
                intent = new Intent(RestauranteDrawerActivity.this, RestauranteDrawerActivity.class);
                intent.putExtra("usuario", usuario);
                intent.putExtra("correo", correo);
                startActivity(intent);
                finish();
                break;
            case R.id.mhoteles:
                intent = new Intent(RestauranteDrawerActivity.this, HotelDrawerActivity.class);
                intent.putExtra("usuario", usuario);
                intent.putExtra("correo", correo);

                startActivity(intent);

                break;
            case R.id.mPrincipal:
                intent = new Intent(RestauranteDrawerActivity.this, MainDrawerActivity.class);
                intent.putExtra("usuario", usuario);
                intent.putExtra("correo", correo);

                startActivity(intent);
                break;
            case R.id.mextras:
                intent = new Intent(RestauranteDrawerActivity.this, ExtraDrawerActivity.class);
                intent.putExtra("usuario", usuario);
                intent.putExtra("correo", correo);

                startActivity(intent);
                break;

            case R.id.mPerfil:
                intent = new Intent(RestauranteDrawerActivity.this, PerfilDrawerActivity.class);
                intent.putExtra("usuario", usuario);
                intent.putExtra("correo", correo);

                startActivity(intent);

                break;
            case R.id.mLogOut:
                intent = new Intent(RestauranteDrawerActivity.this, LoginActivity.class);
                intent.putExtra("usuario", usuario);
                intent.putExtra("correo", correo);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                editor.putInt("login",-1);//1 loggeado 0 sin loggear nadie
                editor.commit();
                startActivity(intent);
                finish();

                break;

        }




        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            switch (position){
                case 0:RestauranteUnoFragment tab1=new RestauranteUnoFragment();
                    return tab1;
                case 1: RestauranteDosFragment tab2=new RestauranteDosFragment();
                    return tab2;
                case 2:RestauranteTresFragment tab3 = new RestauranteTresFragment();
                    return  tab3;
                case 3:RestauranteMapFragment tab4 = new RestauranteMapFragment();
                    return  tab4;

                default:return null;

            }
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "RESTAURANTE 1";
                case 1:
                    return "RESTAURANTE 2";
                case 2:
                    return "RESTAURANTE 3";
                case 3:
                    return "MAPA";
            }
            return null;
        }
    }
}
