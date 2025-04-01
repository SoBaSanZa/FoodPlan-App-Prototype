package com.example.foodplan;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.BounceInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class Mainlayout extends AppCompatActivity {

    int selectedtab = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.mainlayout);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        final LinearLayout calenderlayout = findViewById(R.id.calenderlayout);
        final LinearLayout discountlayout = findViewById(R.id.discountlayout);
        final LinearLayout chatlayout = findViewById(R.id.chatlayout);
        final LinearLayout maplayout = findViewById(R.id.maplayout);
        final LinearLayout acclayout = findViewById(R.id.acclayout);

        final ImageView calendericon = findViewById(R.id.calandericon);
        final ImageView discounticon = findViewById(R.id.discounticon);
        final ImageView chaticon = findViewById(R.id.chaticon);
        final ImageView mapicon = findViewById(R.id.mapicon);
        final ImageView accicon = findViewById(R.id.accicon);

        final TextView calenderText = findViewById(R.id.calandertext);
        final TextView discountText = findViewById(R.id.discounttext);
        final TextView chatText = findViewById(R.id.chattext);
        final TextView mapText = findViewById(R.id.maptext);
        final TextView accText = findViewById(R.id.acctext);
        final TextView pagename = findViewById(R.id.pagename);

        if (selectedtab == 1){
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .replace(R.id.fragmentView, com.example.foodplan.calenderFragment.class,null)
                    .commit();


            calenderText.setVisibility(View.VISIBLE);
            calendericon.setImageResource(R.drawable.calander_c);
            calenderlayout.setBackgroundResource(R.drawable.calender_round);
        }

        if (selectedtab == 2){
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .replace(R.id.fragmentView, com.example.foodplan.DIscountFragment.class,null)
                    .commit();

            discountText.setVisibility(View.VISIBLE);
            discounticon.setImageResource(R.drawable.discont_c);
            discountlayout.setBackgroundResource(R.drawable.dicount_round);
        }

        if (selectedtab == 3){
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .replace(R.id.fragmentView, com.example.foodplan.chatFragment.class, null)
                    .commit();

            chatText.setVisibility(View.VISIBLE);
            chaticon.setImageResource(R.drawable.chat_c);
            chatlayout.setBackgroundResource(R.drawable.chat_round);
        }

        if (selectedtab == 4){
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .replace(R.id.fragmentView, com.example.foodplan.mapFragment.class,null)
                    .commit();

            mapText.setVisibility(View.VISIBLE);
            mapicon.setImageResource(R.drawable.map_c);
            maplayout.setBackgroundResource(R.drawable.map_round);
        }

        if (selectedtab == 5){
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .replace(R.id.fragmentView, com.example.foodplan.AccountFragment.class,null)
                    .commit();

            accText.setVisibility(View.VISIBLE);
            accicon.setImageResource(R.drawable.acc_c);
            acclayout.setBackgroundResource(R.drawable.acc_round);
        }


        calenderlayout.setOnClickListener(new View.OnClickListener() {
            @SuppressLint({"ResourceType", "SetTextI18n"})
            @Override
            public void onClick(View v) {
                if (selectedtab != 1 ){
                    getSupportFragmentManager().beginTransaction()
                            .setReorderingAllowed(true)
                            .replace(R.id.fragmentView, com.example.foodplan.calenderFragment.class,null)
                            .commit();

                    discountText.setVisibility(View.GONE);
                    chatText.setVisibility(View.GONE);
                    mapText.setVisibility(View.GONE);
                    accText.setVisibility(View.GONE);

                    discounticon.setImageResource(R.drawable.badge_percent);
                    chaticon.setImageResource(R.drawable.comment_alt);
                    mapicon.setImageResource(R.drawable.land_layer_location);
                    accicon.setImageResource(R.drawable.portrait);

                    discountlayout.setBackgroundResource(getResources().getColor(android.R.color.transparent));
                    chatlayout.setBackgroundResource(getResources().getColor(android.R.color.transparent));
                    maplayout.setBackgroundResource(getResources().getColor(android.R.color.transparent));
                    acclayout.setBackgroundResource(getResources().getColor(android.R.color.transparent));

                    calenderText.setVisibility(View.VISIBLE);
                    calendericon.setImageResource(R.drawable.calander_c);
                    calenderlayout.setBackgroundResource(R.drawable.calender_round);

                    AnimationSet animationSet = new AnimationSet(true);

                    ScaleAnimation scaleAnimation = new ScaleAnimation(
                            0f, 1f,
                            0f, 1f,
                            Animation.RELATIVE_TO_SELF, 0.5f,
                            Animation.RELATIVE_TO_SELF, 0.5f
                    );
                    scaleAnimation.setDuration(350);

                    AlphaAnimation alphaAnimation = new AlphaAnimation(0f, 1f);
                    alphaAnimation.setDuration(350);

                    animationSet.addAnimation(scaleAnimation);
                    animationSet.addAnimation(alphaAnimation);
                    animationSet.setInterpolator(new AccelerateDecelerateInterpolator());
                    scaleAnimation.setInterpolator(new BounceInterpolator());
                    animationSet.setFillAfter(true);
                    calenderlayout.startAnimation(scaleAnimation);

                    selectedtab = 1;

                    pagename.setText("CALENDAR");
                }
            }
        });

        discountlayout.setOnClickListener(new View.OnClickListener() {
            @SuppressLint({"ResourceType", "SetTextI18n"})
            @Override
            public void onClick(View v) {
                if (selectedtab != 2 ){
                    getSupportFragmentManager().beginTransaction()
                            .setReorderingAllowed(true)
                            .replace(R.id.fragmentView, com.example.foodplan.DIscountFragment.class,null)
                            .commit();

                    chatText.setVisibility(View.GONE);
                    mapText.setVisibility(View.GONE);
                    accText.setVisibility(View.GONE);
                    calenderText.setVisibility(View.GONE);

                    chaticon.setImageResource(R.drawable.comment_alt);
                    mapicon.setImageResource(R.drawable.land_layer_location);
                    accicon.setImageResource(R.drawable.portrait);
                    calendericon.setImageResource(R.drawable.calendar_day);

                    chatlayout.setBackgroundResource(getResources().getColor(android.R.color.transparent));
                    maplayout.setBackgroundResource(getResources().getColor(android.R.color.transparent));
                    acclayout.setBackgroundResource(getResources().getColor(android.R.color.transparent));
                    calenderlayout.setBackgroundResource(getResources().getColor(android.R.color.transparent));

                    discountText.setVisibility(View.VISIBLE);
                    discounticon.setImageResource(R.drawable.discont_c);
                    discountlayout.setBackgroundResource(R.drawable.dicount_round);

                    AnimationSet animationSet = new AnimationSet(true);

                    ScaleAnimation scaleAnimation = new ScaleAnimation(
                            0f, 1f,
                            0f, 1f,
                            Animation.RELATIVE_TO_SELF, 0.5f,
                            Animation.RELATIVE_TO_SELF, 0.5f
                    );
                    scaleAnimation.setDuration(350);

                    AlphaAnimation alphaAnimation = new AlphaAnimation(0f, 1f);
                    alphaAnimation.setDuration(350);

                    animationSet.addAnimation(scaleAnimation);
                    animationSet.addAnimation(alphaAnimation);
                    animationSet.setInterpolator(new AccelerateDecelerateInterpolator());
                    scaleAnimation.setInterpolator(new BounceInterpolator());
                    animationSet.setFillAfter(true);
                    discountlayout.startAnimation(scaleAnimation);

                    selectedtab = 2;
                    pagename.setText("DISCOUNT");
                }
            }
        });

        chatlayout.setOnClickListener(new View.OnClickListener() {
            @SuppressLint({"ResourceType", "SetTextI18n"})
            @Override
            public void onClick(View v) {
                if (selectedtab != 3 ){
                    getSupportFragmentManager().beginTransaction()
                            .setReorderingAllowed(true)
                            .replace(R.id.fragmentView, com.example.foodplan.chatFragment.class,null)
                            .commit();

                    mapText.setVisibility(View.GONE);
                    accText.setVisibility(View.GONE);
                    calenderText.setVisibility(View.GONE);
                    discountText.setVisibility(View.GONE);

                    mapicon.setImageResource(R.drawable.land_layer_location);
                    accicon.setImageResource(R.drawable.portrait);
                    calendericon.setImageResource(R.drawable.calendar_day);
                    discounticon.setImageResource(R.drawable.badge_percent);

                    maplayout.setBackgroundResource(getResources().getColor(android.R.color.transparent));
                    acclayout.setBackgroundResource(getResources().getColor(android.R.color.transparent));
                    calenderlayout.setBackgroundResource(getResources().getColor(android.R.color.transparent));
                    discountlayout.setBackgroundResource(getResources().getColor(android.R.color.transparent));

                    chatText.setVisibility(View.VISIBLE);
                    chaticon.setImageResource(R.drawable.chat_c);
                    chatlayout.setBackgroundResource(R.drawable.chat_round);

                    AnimationSet animationSet = new AnimationSet(true);

                    ScaleAnimation scaleAnimation = new ScaleAnimation(
                            0f, 1f,
                            0f, 1f,
                            Animation.RELATIVE_TO_SELF, 0.5f,
                            Animation.RELATIVE_TO_SELF, 0.5f
                    );
                    scaleAnimation.setDuration(350);

                    AlphaAnimation alphaAnimation = new AlphaAnimation(0f, 1f);
                    alphaAnimation.setDuration(350);

                    animationSet.addAnimation(scaleAnimation);
                    animationSet.addAnimation(alphaAnimation);
                    animationSet.setInterpolator(new AccelerateDecelerateInterpolator());
                    scaleAnimation.setInterpolator(new BounceInterpolator());
                    animationSet.setFillAfter(true);
                    chatlayout.startAnimation(scaleAnimation);

                    selectedtab = 3;
                    pagename.setText("CHAT");
                }
            }
        });

        maplayout.setOnClickListener(new View.OnClickListener() {
            @SuppressLint({"ResourceType", "SetTextI18n"})
            @Override
            public void onClick(View v) {
                if (selectedtab != 4 ){
                    getSupportFragmentManager().beginTransaction()
                            .setReorderingAllowed(true)
                            .replace(R.id.fragmentView, com.example.foodplan.mapFragment.class,null)
                            .commit();

                    accText.setVisibility(View.GONE);
                    calenderText.setVisibility(View.GONE);
                    discountText.setVisibility(View.GONE);
                    chatText.setVisibility(View.GONE);

                    accicon.setImageResource(R.drawable.portrait);
                    calendericon.setImageResource(R.drawable.calendar_day);
                    discounticon.setImageResource(R.drawable.badge_percent);
                    chaticon.setImageResource(R.drawable.comment_alt);

                    acclayout.setBackgroundResource(getResources().getColor(android.R.color.transparent));
                    calenderlayout.setBackgroundResource(getResources().getColor(android.R.color.transparent));
                    discountlayout.setBackgroundResource(getResources().getColor(android.R.color.transparent));
                    chatlayout.setBackgroundResource(getResources().getColor(android.R.color.transparent));


                    mapText.setVisibility(View.VISIBLE);
                    mapicon.setImageResource(R.drawable.map_c);
                    maplayout.setBackgroundResource(R.drawable.map_round);

                    AnimationSet animationSet = new AnimationSet(true);

                    ScaleAnimation scaleAnimation = new ScaleAnimation(
                            0f, 1f,
                            0f, 1f,
                            Animation.RELATIVE_TO_SELF, 0.5f,
                            Animation.RELATIVE_TO_SELF, 0.5f
                    );
                    scaleAnimation.setDuration(350);

                    AlphaAnimation alphaAnimation = new AlphaAnimation(0f, 1f);
                    alphaAnimation.setDuration(350);

                    animationSet.addAnimation(scaleAnimation);
                    animationSet.addAnimation(alphaAnimation);
                    animationSet.setInterpolator(new AccelerateDecelerateInterpolator());
                    scaleAnimation.setInterpolator(new BounceInterpolator());
                    animationSet.setFillAfter(true);
                    maplayout.startAnimation(scaleAnimation);

                    selectedtab = 4;
                    pagename.setText("MAP");
                }
            }
        });

        acclayout.setOnClickListener(new View.OnClickListener() {
            @SuppressLint({"ResourceType", "SetTextI18n"})
            @Override
            public void onClick(View v) {
                if (selectedtab != 5 ){
                    getSupportFragmentManager().beginTransaction()
                            .setReorderingAllowed(true)
                            .replace(R.id.fragmentView, com.example.foodplan.AccountFragment.class,null)
                            .commit();

                    calenderText.setVisibility(View.GONE);
                    discountText.setVisibility(View.GONE);
                    chatText.setVisibility(View.GONE);
                    mapText.setVisibility(View.GONE);

                    calendericon.setImageResource(R.drawable.calendar_day);
                    discounticon.setImageResource(R.drawable.badge_percent);
                    chaticon.setImageResource(R.drawable.comment_alt);
                    mapicon.setImageResource(R.drawable.land_layer_location);

                    maplayout.setBackgroundResource(getResources().getColor(android.R.color.transparent));
                    calenderlayout.setBackgroundResource(getResources().getColor(android.R.color.transparent));
                    discountlayout.setBackgroundResource(getResources().getColor(android.R.color.transparent));
                    chatlayout.setBackgroundResource(getResources().getColor(android.R.color.transparent));


                    accText.setVisibility(View.VISIBLE);
                    accicon.setImageResource(R.drawable.acc_c);
                    acclayout.setBackgroundResource(R.drawable.acc_round);

                    AnimationSet animationSet = new AnimationSet(true);

                    ScaleAnimation scaleAnimation = new ScaleAnimation(
                            0f, 1f,
                            0f, 1f,
                            Animation.RELATIVE_TO_SELF, 0.5f,
                            Animation.RELATIVE_TO_SELF, 0.5f
                    );
                    scaleAnimation.setDuration(350);

                    AlphaAnimation alphaAnimation = new AlphaAnimation(0f, 1f);
                    alphaAnimation.setDuration(350);

                    animationSet.addAnimation(scaleAnimation);
                    animationSet.addAnimation(alphaAnimation);
                    animationSet.setInterpolator(new AccelerateDecelerateInterpolator());
                    scaleAnimation.setInterpolator(new BounceInterpolator());
                    animationSet.setFillAfter(true);

                    acclayout.startAnimation(scaleAnimation);

                    selectedtab = 5;
                    pagename.setText("ACCOUNT");
                }
            }
        });

        ImageView notification = (ImageView) findViewById(R.id.mailbox);
        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(Mainlayout.this);
                View bottomSheetView = LayoutInflater.from(Mainlayout.this).inflate(R.layout.notification, null);
                bottomSheetDialog.setContentView(bottomSheetView);

                ImageView cancel = (ImageView) bottomSheetView.findViewById(R.id.cancel);
                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        bottomSheetDialog.dismiss();
                    }
                });
                bottomSheetDialog.show();
            }
        });


    }
}