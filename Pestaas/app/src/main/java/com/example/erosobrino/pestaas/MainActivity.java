package com.example.erosobrino.pestaas;

import android.os.Build;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Adaptador adaptador = new Adaptador(getSupportFragmentManager());
        adaptador.addFragment(new UnoFragment(), "Uno");
        adaptador.addFragment(new DosFragment(), "Dos");
        adaptador.addFragment(new TresFragment(), "Tres");

        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(adaptador);

        tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(android.R.drawable.ic_menu_add);
        tabLayout.getTabAt(1).setIcon(android.R.drawable.ic_lock_lock);
        tabLayout.getTabAt(2).setIcon(android.R.drawable.ic_dialog_email);

        TresFragment nuevaTab;
        String[] tabs = {"Cuatro", "Cinco", "Seis", "Siete", "Ocho",
                "Nueve", "Diez", "Once", "Doce"};
        for (String t : tabs) {
            nuevaTab = new TresFragment();
            nuevaTab.setContenido("Fragment " + t);
            adaptador.addFragment(nuevaTab, t);
        }
        adaptador.notifyDataSetChanged();

        Toolbar toolbar = findViewById(R.id.toolBar);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            toolbar.setTitle("Componentes ToolBar");
        }

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
            }

            @Override
            public void onPageSelected(int i) {
                Log.i("cambio", "ViewPager: pestaña " + i);
            }

            @Override
            public void onPageScrollStateChanged(int i) {
            }
        });

        tabLayout.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Log.i("cambio", "TabLayout pestaña " + tab.getPosition() + " " + tab.getText());
                AppBarLayout appBarLayout = findViewById(R.id.appbar);
                appBarLayout.setExpanded(true, true);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }
}
