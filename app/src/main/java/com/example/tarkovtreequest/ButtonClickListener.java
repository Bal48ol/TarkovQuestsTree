package com.example.tarkovtreequest;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.core.content.ContextCompat;


public class ButtonClickListener implements View.OnClickListener {
    private final LinearLayout traderLayout;
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
    private boolean isAnimating = false;
    private boolean flag = false;
    private final Context context;

    // Конструктор, принимающий ссылку на родительский элемент макета
    public ButtonClickListener(LinearLayout traderLayout, Context context) {
        this.traderLayout = traderLayout;
        this.context = context;
        initializeButtons();
    }

    // Метод для инициализации кнопок
    private void initializeButtons() {
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

        // Установите обработчик нажатия для каждой кнопки
        burgerImageButton.setOnClickListener(this);
        praporImageButton.setOnClickListener(this);
        terapevtImageButton.setOnClickListener(this);
        skupshikImageButton.setOnClickListener(this);
        lijnikImageButton.setOnClickListener(this);
        mirImageButton.setOnClickListener(this);
        mechanikImageButton.setOnClickListener(this);
        baraholImageButton.setOnClickListener(this);
        egerImageButton.setOnClickListener(this);
        smotritelImageButton.setOnClickListener(this);
        resetImageButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.burgerImageButton) {
            if (isAnimating) {
                return;
            }
            animateClick(burgerImageButton);
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (!flag) {
                        moveButtonsToLeft();
                        flag = true;
                    } else {
                        moveButtonsToRight();
                        flag = false;
                    }
                    isAnimating = false;
                }
            }, 200);
            isAnimating = true;
        }
        else if (view.getId() == R.id.praporImageButton) {
            animateClick(praporImageButton);
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (!(context instanceof PraporActivity)) {
                        Intent intent = new Intent(context, PraporActivity.class);
                        context.startActivity(intent);
                    }
                }
            }, 200);
        }
        else if (view.getId() == R.id.terapevtImageButton) {
            animateClick(terapevtImageButton);
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (!(context instanceof PraporActivity)) {
                        Intent intent = new Intent(context, PraporActivity.class);
                        context.startActivity(intent);
                    }
                }
            }, 200);
        }
        else if (view.getId() == R.id.skupshikImageButton) {
            animateClick(skupshikImageButton);
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (!(context instanceof PraporActivity)) {
                        Intent intent = new Intent(context, PraporActivity.class);
                        context.startActivity(intent);
                    }

                }
            }, 200);
        }
        else if (view.getId() == R.id.lijnikImageButton) {
            animateClick(lijnikImageButton);
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (!(context instanceof PraporActivity)) {
                        Intent intent = new Intent(context, PraporActivity.class);
                        context.startActivity(intent);
                    }
                }
            }, 200);
        }
        else if (view.getId() == R.id.mirImageButton) {
            animateClick(mirImageButton);
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (!(context instanceof PraporActivity)) {
                        Intent intent = new Intent(context, PraporActivity.class);
                        context.startActivity(intent);
                    }
                }
            }, 200);
        }
        else if (view.getId() == R.id.mechanikImageButton) {
            animateClick(mechanikImageButton);
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (!(context instanceof PraporActivity)) {
                        Intent intent = new Intent(context, PraporActivity.class);
                        context.startActivity(intent);
                    }
                }
            }, 200);
        }
        else if (view.getId() == R.id.baraholImageButton) {
            animateClick(baraholImageButton);
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (!(context instanceof PraporActivity)) {
                        Intent intent = new Intent(context, PraporActivity.class);
                        context.startActivity(intent);
                    }
                }
            }, 200);
        }
        else if (view.getId() == R.id.egerImageButton) {
            animateClick(egerImageButton);
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (!(context instanceof PraporActivity)) {
                        Intent intent = new Intent(context, PraporActivity.class);
                        context.startActivity(intent);
                    }
                }
            }, 200);
        }
        else if (view.getId() == R.id.smotritelImageButton) {
            animateClick(smotritelImageButton);
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (!(context instanceof PraporActivity)) {
                        Intent intent = new Intent(context, PraporActivity.class);
                        context.startActivity(intent);
                    }
                }
            }, 200);
        }
        else if (view.getId() == R.id.resetImageButton) {
            animateClick(resetImageButton);
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                }
            }, 200);
        }
    }

    private void animateClick(View view) {
        Animation animation = new ScaleAnimation(1.0f, 0.9f, 1.0f, 0.9f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        animation.setDuration(100);
        animation.setRepeatCount(1);
        animation.setRepeatMode(Animation.REVERSE);
        view.startAnimation(animation);
    }

    private void moveButtonsToLeft() {
        int translationX = -200; // Смещение кнопок влево на 200 пикселей
        praporImageButton.animate().translationXBy(translationX);
        terapevtImageButton.animate().translationXBy(translationX);
        skupshikImageButton.animate().translationXBy(translationX);
        lijnikImageButton.animate().translationXBy(translationX);
        mirImageButton.animate().translationXBy(translationX);
        mechanikImageButton.animate().translationXBy(translationX);
        baraholImageButton.animate().translationXBy(translationX);
        egerImageButton.animate().translationXBy(translationX);
        smotritelImageButton.animate().translationXBy(translationX);
        resetImageButton.animate().translationXBy(translationX);
    }

    private void moveButtonsToRight() {
        int translationX = 200; // Смещение кнопок вправо на 200 пикселей
        praporImageButton.animate().translationXBy(translationX);
        terapevtImageButton.animate().translationXBy(translationX);
        skupshikImageButton.animate().translationXBy(translationX);
        lijnikImageButton.animate().translationXBy(translationX);
        mirImageButton.animate().translationXBy(translationX);
        mechanikImageButton.animate().translationXBy(translationX);
        baraholImageButton.animate().translationXBy(translationX);
        egerImageButton.animate().translationXBy(translationX);
        smotritelImageButton.animate().translationXBy(translationX);
        resetImageButton.animate().translationXBy(translationX);
    }
}


