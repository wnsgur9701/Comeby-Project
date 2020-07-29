package com.example.come_by;




import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends FragmentActivity {

    private BottomNavigationView bottomNavigationView;
    private FragmentManager fm;
    private FragmentTransaction ft;
    private Frag1 frag1;
    private Frag2 frag2;
    private Frag3 frag3;
    private Frag4 frag4;
    private Frag5 frag5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = bottomNavigationView.findViewById(R.id.bottomNavi);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.bottom_home:
                        setFrag(0);
                        break;
                    case R.id.bottom_saved:
                        setFrag(1);
                        break;
                    case R.id.bottom_like:
                        setFrag(2);
                        break;
                    case R.id.bottom_map:
                        setFrag(3);
                        break;
                    case R.id.bottom_profile:
                        setFrag(4);
                        break;

                }
                return true;
            }
        });

        frag1 = new Frag1();
        frag2 = new Frag2();
        frag3 = new Frag3();
        frag4 = new Frag4();
        frag5 = new Frag5();
        setFrag(0);

    }

    public void setFrag(int n) {
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        switch (n) {
            case 0:
                ft.replace(R.id.main_frame, frag1);
                ft.addToBackStack(null);
                ft.commit();
            case 1:
                ft.replace(R.id.main_frame, frag2);
                ft.addToBackStack(null);
                ft.commit();
            case 2:
                ft.replace(R.id.main_frame, frag3);
                ft.addToBackStack(null);
                ft.commit();
            case 3:
                ft.replace(R.id.main_frame, frag4);
                ft.addToBackStack(null);
                ft.commit();
            case 4:
                ft.replace(R.id.main_frame, frag5);
                ft.addToBackStack(null);
                ft.commit();
        }
    }
}
