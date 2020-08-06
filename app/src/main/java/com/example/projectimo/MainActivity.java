package com.example.projectimo;

import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.util.Collection;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {


    AppBarConfiguration appBarConfiguration;
    NavController navController2;
    private FirebaseDatabase database;
    private DatabaseReference myRef;

  /*  public class Item {
       public int mPrice;
        public Item(){

        }
       public int getItem(){
            return mPrice;
        }
        public void setItem(Integer price){
            mPrice=price;
        }
        public Item(Integer price) {
            mPrice=price;
        }
    }*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
         Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
/*database=FirebaseDatabase.getInstance();
myRef=database.getReference("items");*/

        final HashMap<String, Object > map=new HashMap<>();
        map.put("Name", 1);

       final TextView price = findViewById(R.id.textView18);
   Button button=findViewById(R.id.button5);
        appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_company, R.id.navigation_rating)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment); //Навигация BottomView
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
/*
        NavigationUI.setupWithNavController(toolbar, navController, appBarConfiguration);
*/
       /* Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        BottomNavigationView bottomNav = findViewById(R.id.nav_view);
        bottomNav.setOnNavigationItemSelectedListener(navListener);*/
        //I added this if statement to keep the selected fragment when rotating the device
     /*   if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,
                    new HomeFragment()).commit();
        }*/
        navController2 = Navigation.findNavController(this, R.id.nav_host_fragment);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
Collection<Object> mod=map.values();

                price.setInputType(InputType.TYPE_CLASS_TEXT);
                    FirebaseDatabase.getInstance().getReference().child("Multy").updateChildren(map);
                price.setText("s "+mod);

            }

        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        NavigationUI.onNavDestinationSelected(item, navController2); // Навигация Menu Toolbar
        if(item.getItemId() ==android.R.id.home){ //Нажата Назад = Переход в Home
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
        /*Fragment selectedFragment = null;*/
     /*   switch(item.getItemId()){
            case R.id.subjectOne:
                navController.navigate(R.id.subjectOne);
                break;
            case R.id.navigation_home:
                *//*selectedFragment = new RatingFragment();*//*
                break;
        }*/
  /*      getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,
                selectedFragment).addToBackStack(null).commit();*/

       /* if(item.getItemId() ==android.R.id.home){
            onBackPressed();
        }*/


        /*return true;*/
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) { //Настрока меню
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.profile, menu);

        return true;
    }


    /*  private BottomNavigationView.OnNavigationItemSelectedListener navListener =
              new BottomNavigationView.OnNavigationItemSelectedListener() {
                  @Override
                  public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                      Fragment selectedFragment = null;
                      switch (item.getItemId()) {
                          case R.id.navigation_home:
                              selectedFragment = new HomeFragment();
                              break;
                          case R.id.navigation_company:
                              selectedFragment = new CompanyFragment();
                              break;
                          case R.id.navigation_rating:
                              selectedFragment = new RatingFragment();
                              break;
                      }
                      getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,
                              selectedFragment).addToBackStack(null).commit();
                      return true;
                  }
              };*/


}