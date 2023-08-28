package com.example.tarkovtreequest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
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
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
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
    private boolean flag = false;
    private boolean isAnimating = false;
    private CustomLinearLayout treeLayout;
    private float initialTouchX;
    private float initialTouchY;
    private float initialTranslationX;
    private float initialTranslationY;
    private ScaleGestureDetector scaleGestureDetector;
    private static final int REQUEST_CODE_ADD_PASSWORD = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        burgerImageButton = findViewById(R.id.burgerImageButton);
        praporImageButton = findViewById(R.id.praporImageButton);
        terapevtImageButton = findViewById(R.id.terapevtImageButton);
        skupshikImageButton = findViewById(R.id.skupshikImageButton);
        lijnikImageButton = findViewById(R.id.lijnikImageButton);
        mirImageButton = findViewById(R.id.mirImageButton);
        mechanikImageButton = findViewById(R.id.mechanikImageButton);
        baraholImageButton = findViewById(R.id.baraholImageButton);
        egerImageButton = findViewById(R.id.egerImageButton);
        smotritelImageButton = findViewById(R.id.smotritelImageButton);
        resetImageButton = findViewById(R.id.resetImageButton);

        treeLayout = findViewById(R.id.treeLayout);

        burgerImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
        });

        treeLayout = findViewById(R.id.treeLayout);
        treeLayout.setOnTouchListener(new View.OnTouchListener() {
            private boolean isScaling = false;
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                scaleGestureDetector.onTouchEvent(event);

                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        if (!scaleGestureDetector.isInProgress()) {
                            initialTouchX = event.getRawX();
                            initialTouchY = event.getRawY();
                            initialTranslationX = treeLayout.getTranslationX();
                            initialTranslationY = treeLayout.getTranslationY();
                        }
                        break;
                    case MotionEvent.ACTION_MOVE:
                        if (event.getPointerCount() > 1 || scaleGestureDetector.isInProgress()) {
                            isScaling = true;
                            // Если масштабируется или используются несколько пальцев, сбросьте смещение
                            treeLayout.setTranslationX(initialTranslationX);
                            treeLayout.setTranslationY(initialTranslationY);
                        }
                        else if (!isScaling) {
                            float offsetX = event.getRawX() - initialTouchX;
                            float offsetY = event.getRawY() - initialTouchY;

                            treeLayout.setTranslationX(initialTranslationX + offsetX);
                            treeLayout.setTranslationY(initialTranslationY + offsetY);
                        }
                        break;
                    case MotionEvent.ACTION_UP:
                        isScaling = false;
                        // Здесь можно выполнить дополнительные действия при отпускании пальца
                        break;
                }

                return true;
            }
        });


        praporImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animateClick(praporImageButton);
                // Очистите CustomLinearLayout перед добавлением нового содержимого
                CustomLinearLayout treeLayout = findViewById(R.id.treeLayout);
                treeLayout.removeAllViews();

                // Включите макет из PraporActivity в CustomLinearLayout
                View praporLayout = getLayoutInflater().inflate(R.layout.activity_prapor, null);
                treeLayout.addView(praporLayout);
            }
        });

        terapevtImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animateClick(terapevtImageButton);
            }
        });

        skupshikImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animateClick(skupshikImageButton);
            }
        });

        lijnikImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animateClick(lijnikImageButton);
            }
        });

        mirImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animateClick(mirImageButton);
            }
        });

        mechanikImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animateClick(mechanikImageButton);
            }
        });

        baraholImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animateClick(baraholImageButton);
            }
        });

        egerImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animateClick(egerImageButton);
            }
        });

        smotritelImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animateClick(smotritelImageButton);
            }
        });

        resetImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animateClick(resetImageButton);
            }
        });

        scaleGestureDetector = new ScaleGestureDetector(this, new ScaleGestureDetector.OnScaleGestureListener() {
            private float scaleFactor = 1.0f;
            private float maxScale = 1.2f;
            private float minScale = 0.5f;

            @Override
            public boolean onScale(ScaleGestureDetector detector) {
                scaleFactor *= detector.getScaleFactor();
                // Ограничьте масштабирование в заданных пределах
                scaleFactor = Math.max(minScale, Math.min(scaleFactor, maxScale));

                // Примените масштабирование к treeLayout
                treeLayout.setScaleX(scaleFactor);
                treeLayout.setScaleY(scaleFactor);

                return true;
            }

            @Override
            public boolean onScaleBegin(ScaleGestureDetector detector) {
                return true;
            }

            @Override
            public void onScaleEnd(ScaleGestureDetector detector) {
                // Код, который нужно выполнить после завершения масштабирования
            }
        });

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

