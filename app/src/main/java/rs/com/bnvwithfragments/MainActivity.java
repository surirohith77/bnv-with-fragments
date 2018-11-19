package rs.com.bnvwithfragments;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bnv= findViewById(R.id.bnv);
        bnv.setOnNavigationItemReselectedListener(navlistenr);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new hotel_fragment()).commit();

    }



    private BottomNavigationView.OnNavigationItemReselectedListener navlistenr= new BottomNavigationView.OnNavigationItemReselectedListener() {
        @Override
        public void onNavigationItemReselected(@NonNull MenuItem menuItem) {

            Fragment selectedFragment = null;

            switch (menuItem.getItemId()){

                case R.id.m1:
                    selectedFragment = new home_fragment();
                    break;

                case R.id.m2:
                    selectedFragment = new hotel_fragment();
                    break;

                case R.id.m3:
                    selectedFragment = new person_fragment();
                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();
        }
    };
}
