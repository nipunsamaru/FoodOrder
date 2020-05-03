package com.research.foodorder.Seller;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.Menu;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.research.foodorder.Buyer.Buyer;
import com.research.foodorder.R;
import com.research.foodorder.Seller.ui.food.FoodSeller;

public class Seller extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller);

        Toolbar toolbar = findViewById(R.id.toolbar_seller);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = findViewById(R.id.drawer_layout_seller);
        NavigationView navigationView = findViewById(R.id.nav_view_seller);

        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home_seller, R.id.nav_newfd_seller,
                R.id.nav_tools_seller)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_seller_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);



        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {
                if (destination.getId() == R.id.nav_home_seller) {

              //      arguments.putString("shopID","thilina");
               //     destination.a
              //      FoodSeller fragInfo = new FoodSeller();
                 //   fragInfo.setArguments(arguments);

                    Toast.makeText(Seller.this, "Food List", Toast.LENGTH_LONG).show();
                }
                if (destination.getId() == R.id.nav_newfd_seller) {
                    Toast.makeText(Seller.this, "New Food", Toast.LENGTH_LONG).show();
                }
                if (destination.getId() == R.id.nav_tools_seller) {
                    Toast.makeText(Seller.this, "nav_tools", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
       getMenuInflater().inflate(R.menu.buyer, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_seller_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

}
