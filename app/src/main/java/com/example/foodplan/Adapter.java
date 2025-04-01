package com.example.foodplan;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class Adapter extends PagerAdapter {



    Context context;
    List<Integer> drawableList;

    public Adapter(Context context, List<Integer> drawableList) {
        this.context = context;
        this.drawableList = drawableList;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        Context context = container.getContext();
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(drawableList.get(position));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

        // เพิ่ม ImageView ลงใน container
        container.addView(imageView);
        return imageView;
    }

    @Override
    public int getCount() {
        if (drawableList != null) {
            return drawableList.size();
        }
        return 0;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
