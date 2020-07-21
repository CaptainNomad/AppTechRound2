package com.example.apptechround2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    LinearLayout sliderDotspanel;
    private int dotscount;
    private ImageView[] dots;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = findViewById(R.id.image);
        sliderDotspanel = (LinearLayout) findViewById(R.id.Slider);
        ImageAdapter adapter = new ImageAdapter(this);
        viewPager.setAdapter(adapter);
        dotscount = adapter.getCount();
        dots = new ImageView[dotscount];

        for(int i = 0; i< dotscount; i++)
        {
            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.non_active_dot));
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(8,0,8,0);
            sliderDotspanel.addView(dots[i], params);
        }
        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) { }

            @Override
            public void onPageSelected(int position) {

                for (int i = 0; i< dotscount; i++){
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.non_active_dot));
                }
                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));
            }

            @Override
            public void onPageScrollStateChanged(int state) { }
        });

        ArrayList<Events> eventList = new ArrayList<>();
        eventList.add(new Events(R.drawable.image1, "The NCPA National Jazz Festival- The Latination and Kevin Davy Quintet", "Tata Theatre: The NCPA", "Rs 269"));
        eventList.add(new Events(R.drawable.image9, "Sanjeeta Bhattacharya Live at The Finch", "Tata Theatre: The NCPA", "Rs 389"));
        eventList.add(new Events(R.drawable.image3, "The NCPA International Jazz Festival - Greg Banaszak Quintet and Jam Session", "Tata Theatre: The NCPA", "Rs 269"));
        eventList.add(new Events(R.drawable.image4, "Nomadic Jazz with David Soin Tapesser's [working title]", "The Bandra Base", "Rs 400"));
        eventList.add(new Events(R.drawable.image5, "Xandor Naylor with Vinay Kaushal and Shreyas Iyengar", "Skinny Mo's Jazz Club", "Rs 400"));

        RecyclerView mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        Adapter mAdapter = new Adapter(eventList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);


    }
}


