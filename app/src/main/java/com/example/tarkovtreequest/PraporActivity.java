package com.example.tarkovtreequest;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class PraporActivity extends AppCompatActivity {
    private FrameLayout praporLayout;
    private RelativeLayout treeLayout;
    private float initialTouchX;
    private float initialTouchY;
    private float initialTranslationX;
    private float initialTranslationY;
    private ScaleGestureDetector scaleGestureDetector;
    private LinearLayout traderLayoutPrapor;
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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prapor);

        praporLayout = findViewById(R.id.praporLayout);
        treeLayout = findViewById(R.id.treeLayout);
        // Установка начального масштаба
        float initialScale = 0.5f;
        treeLayout.setScaleX(initialScale);
        treeLayout.setScaleY(initialScale);

        traderLayoutPrapor = findViewById(R.id.traderLayoutPrapor);

        View traderLayout = getLayoutInflater().inflate(R.layout.trader_layout, traderLayoutPrapor, false);
        traderLayoutPrapor.addView(traderLayout);
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

        ButtonClickListener buttonClickListener = new ButtonClickListener(traderLayoutPrapor, this);
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

        AnimationDrawable animationDrawable = (AnimationDrawable) praporLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2500);
        animationDrawable.setExitFadeDuration(5000);
        animationDrawable.start();

        TreeNode rootNode = new TreeNode("Проба пера", "Убить пять диких и передать два ружья МР-133");

        TreeNode childNode1 = new TreeNode("Проверка на вшивость", "Найти бронзовые часы и передать их Прапору");
        TreeNode childNode2 = new TreeNode("Поисковая миссия", "Найти пропавшую автоколонну и обнаружить временный лагерь USEC");

        TreeNode grandchildNode1 = new TreeNode("Пикник со стрельбой", "Уничтожить 15 Диких в Лесу");
        TreeNode grandchildNode2 = new TreeNode("Посылка из прошлого", "Найти кейс на Таможне и заложить на Заводе");

        TreeNode grandchildNode3 = new TreeNode("Нефтянка", "Пометить 4 наливняка на Таможне");

        rootNode.addChild(childNode1);
        rootNode.addChild(childNode2);
        childNode1.addChild(grandchildNode1);
        childNode1.addChild(grandchildNode2);
        grandchildNode2.addChild(grandchildNode3);

        TreeBuilder treeBuilder = new TreeBuilder(this, treeLayout);
        treeBuilder.setDefaultColor(getResources().getColor(R.color.prapor));
        treeBuilder.buildTree(rootNode);

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
                        //действия при отпускании пальца
                        break;
                }

                return true;
            }
        });

        scaleGestureDetector = new ScaleGestureDetector(this, new ScaleGestureDetector.OnScaleGestureListener() {

            private float scaleFactor = 1.0f;
            private float maxScale = 2.0f;
            private float minScale = 0.3f;

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
}
