package com.five5.taskcompete;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.five5.taskcompete.Adapters.CompetitionAdapter;
import com.five5.taskcompete.Data.User_data;
import com.five5.taskcompete.Data.competition_data;
import com.five5.taskcompete.Fragments.HomeFragment;
import com.five5.taskcompete.Fragments.NotificationsFragment;
import com.five5.taskcompete.Fragments.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class navigator_home extends AppCompatActivity {
    BottomNavigationView bottomnav;
    Fragment curr=null;
    ImageButton addComp;
    PopupWindow pop;
    RelativeLayout rel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigator_home);
        bottomnav=(BottomNavigationView) findViewById(R.id.bottomNavigationBar);
        bottomnav.setOnNavigationItemSelectedListener(navLis);
        getSupportFragmentManager().beginTransaction().replace(R.id.frag_container,new HomeFragment()).commit();
        addComp=(ImageButton) findViewById(R.id.addCompetitionButton);
        addComp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(navigator_home.this,Popup.class));

            }
        });

    }


    private BottomNavigationView.OnNavigationItemSelectedListener navLis= new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedItem=null;
            switch (item.getItemId()){

                case R.id.home_menu :
                    selectedItem = new HomeFragment();

                    break;

                case R.id.Notification_menu:
                    selectedItem =new NotificationsFragment();
                    break;
                case R.id.Profile_menu:
                    selectedItem=new ProfileFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.frag_container,selectedItem).commit();
            return true;
        }

    };

}