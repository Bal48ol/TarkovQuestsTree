package com.example.tarkovtreequest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private FrameLayout mainLayout;
    private ImageButton burgerImageButton;
    private ImageButton praporImageButton;
    private ImageButton terapevtImageButton;
    private ImageButton skupshikImageButton;
    private ImageButton lijnikImageButton;
    private ImageButton mirImageButton;
    private ImageButton mechanikImageButton;
    private ImageButton baraholImageButton;
    private ImageButton egerImageButton;
    private ImageButton smotritelImageButton;
    private ImageButton resetImageButton;
    private LinearLayout traderLayoutMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainLayout = findViewById(R.id.mainLayout);
        traderLayoutMain = findViewById(R.id.traderLayoutMain);

        View traderLayout = getLayoutInflater().inflate(R.layout.trader_layout, traderLayoutMain, false);
        traderLayoutMain.addView(traderLayout);
        burgerImageButton = traderLayout.findViewById(R.id.burgerImageButton);
        praporImageButton = traderLayout.findViewById(R.id.praporImageButton);
        terapevtImageButton = traderLayout.findViewById(R.id.terapevtImageButton);
        skupshikImageButton = traderLayout.findViewById(R.id.skupshikImageButton);
        lijnikImageButton = traderLayout.findViewById(R.id.lijnikImageButton);
        mirImageButton = traderLayout.findViewById(R.id.mirImageButton);
        mechanikImageButton = traderLayout.findViewById(R.id.mechanikImageButton);
        baraholImageButton = traderLayout.findViewById(R.id.baraholImageButton);
        egerImageButton = traderLayout.findViewById(R.id.egerImageButton);
        smotritelImageButton = traderLayout.findViewById(R.id.smotritelImageButton);
        resetImageButton = traderLayout.findViewById(R.id.resetImageButton);

        ButtonClickListener buttonClickListener = new ButtonClickListener(traderLayoutMain, this);
        burgerImageButton.setOnClickListener(buttonClickListener);
        praporImageButton.setOnClickListener(buttonClickListener);
        terapevtImageButton.setOnClickListener(buttonClickListener);
        skupshikImageButton.setOnClickListener(buttonClickListener);
        lijnikImageButton.setOnClickListener(buttonClickListener);
        mirImageButton.setOnClickListener(buttonClickListener);
        mechanikImageButton.setOnClickListener(buttonClickListener);
        baraholImageButton.setOnClickListener(buttonClickListener);
        egerImageButton.setOnClickListener(buttonClickListener);
        smotritelImageButton.setOnClickListener(buttonClickListener);
        resetImageButton.setOnClickListener(buttonClickListener);

        AnimationDrawable animationDrawable = (AnimationDrawable) mainLayout.getBackground();
        animationDrawable.setEnterFadeDuration(3000);
        animationDrawable.setExitFadeDuration(3000);
        animationDrawable.start();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        List<ImageButton> imageButtons = new ArrayList<>();
        imageButtons.add(burgerImageButton);
        imageButtons.add(praporImageButton);
        imageButtons.add(terapevtImageButton);
        imageButtons.add(skupshikImageButton);
        imageButtons.add(lijnikImageButton);
        imageButtons.add(mirImageButton);
        imageButtons.add(mechanikImageButton);
        imageButtons.add(baraholImageButton);
        imageButtons.add(egerImageButton);
        imageButtons.add(smotritelImageButton);
        imageButtons.add(resetImageButton);

        if (hasFocus) {
            for (int i = 0; i < imageButtons.size(); i++) {
                ImageButton imageButton = imageButtons.get(i);
                int resourceId = getResources().getIdentifier("img" + (i + 1), "drawable", getPackageName());
                Drawable drawable = getResources().getDrawable(resourceId);
                Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();

                int buttonSize = Math.min(imageButton.getWidth(), imageButton.getHeight());
                int newButtonSize = (int) (buttonSize / 1.3);

                Bitmap scaledBitmap = Bitmap.createBitmap(newButtonSize, newButtonSize, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(scaledBitmap);
                Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
                paint.setFilterBitmap(true);
                canvas.drawBitmap(bitmap, null, new Rect(0, 0, newButtonSize, newButtonSize), paint);

                imageButton.setImageBitmap(scaledBitmap);
            }
        }
    }
}

