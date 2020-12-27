package org.techtown.tab;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;

    Fragment1 fragment1;
    Fragment2 fragment2;
    Fragment3 fragment3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);

        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();
        Intent intent = getIntent();
        String userID = intent.getStringExtra("userID");
        String userName = intent.getStringExtra("userName");
        String userAge = intent.getStringExtra("userAge");
        String userHak = intent.getStringExtra("userHak");
        String userMajor = intent.getStringExtra("userMajor");

        Bundle bundle = new Bundle();
        bundle.putString("id",userID);
        bundle.putString("name",userName);
        bundle.putString("age",userAge);
        bundle.putString("hak",userHak);
        bundle.putString("major",userMajor);

        fragment2.setArguments(bundle);

        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment1).commit();

        TabLayout tabs = findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setText("쇼핑"));
        tabs.addTab(tabs.newTab().setText("마이페이지"));
        tabs.addTab(tabs.newTab().setText("설정"));
        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                Log.d("MainActivity", "선택된 탭 : " + position);

                Fragment selected = null;
                if (position == 0) {
                    selected = fragment1;
                } else if (position == 1) {
                    selected = fragment2;
                } else if(position==2){
                    selected = fragment3;
                }

                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, selected).commit();
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