package com.example.foodplan;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DIscountFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DIscountFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DIscountFragment() {
        // Required empty public constructor
    }

    ViewPager viewPager;
    TabLayout tabLayout;
    List<Integer> drawableList;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DIscountFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DIscountFragment newInstance(String param1, String param2) {
        DIscountFragment fragment = new DIscountFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_d_iscount, container, false);

        // ผูก ViewPager และ TabLayout จาก view ที่ถูก inflate
        viewPager = view.findViewById(R.id.view_paper);  // ผูก ViewPager กับ view ที่ถูกสร้างขึ้น

        // กำหนด drawableList (รูปภาพจาก drawable)
        drawableList = new ArrayList<>();
        drawableList.add(R.drawable.recom);
        drawableList.add(R.drawable.muhong);  // ตัวอย่างภาพจาก drawable
        drawableList.add(R.drawable.discontfood);
        drawableList.add(R.drawable.indiefood);

        // ตรวจสอบว่า drawableList ไม่ใช่ null และไม่ว่าง
        if (drawableList != null && !drawableList.isEmpty()) {
            // กำหนด adapter สำหรับ ViewPager
            viewPager.setAdapter(new Adapter(requireContext(), drawableList));
        }

        autoImageSlide();

        return view;
    }

    private void autoImageSlide() {
        final long DELAY_MS = 3000;
        final long PERIOD_MS = 3000;

        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if (viewPager != null && drawableList != null && !drawableList.isEmpty()) {
                    int currentItem = viewPager.getCurrentItem();
                    if (currentItem == drawableList.size() - 1) {
                        viewPager.setCurrentItem(0);
                    } else {
                        viewPager.setCurrentItem(currentItem + 1, true);
                    }
                }
            }
        };

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(runnable);
            }
        }, DELAY_MS, PERIOD_MS);
    }
}
