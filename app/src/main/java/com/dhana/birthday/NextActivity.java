package com.dhana.birthday;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class NextActivity extends AppCompatActivity {

    private ViewPager2 viewPager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        viewPager2 = findViewById(R.id.MainImageSlider);

        List<SliderItem> sliderItems = new ArrayList<>();
        sliderItems.add(new SliderItem(R.drawable.hacker_four));
        sliderItems.add(new SliderItem(R.drawable.hacker_two));
        sliderItems.add(new SliderItem(R.drawable.android_one));
        sliderItems.add(new SliderItem(R.drawable.android_two));
        sliderItems.add(new SliderItem(R.drawable.android_three));
        sliderItems.add(new SliderItem(R.drawable.sql_one));
        sliderItems.add(new SliderItem(R.drawable.googlefirebase_one));
        sliderItems.add(new SliderItem(R.drawable.googlefirebase_two));
        sliderItems.add(new SliderItem(R.drawable.hacker_three));
        sliderItems.add(new SliderItem(R.drawable.hacker_one));

        viewPager2.setAdapter(new SlideAdapter(sliderItems,viewPager2));
        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(3);
        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 - Math.abs(position);
                page.setScaleY((float) (0.85 + r * 0.15f));
            }
        });
        viewPager2.setPageTransformer(compositePageTransformer);
    }
}