package com.example.tarkovtreequest;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;

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

                // Уменьшение масштаба изображения
                int buttonSize = Math.min(imageButton.getWidth(), imageButton.getHeight());
                int newButtonSize = (int) (buttonSize / 1.1); // Уменьшение в 3 раза

                // Создание нового Bitmap с сглаживанием
                Bitmap scaledBitmap = Bitmap.createBitmap(newButtonSize, newButtonSize, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(scaledBitmap);
                Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
                paint.setFilterBitmap(true);
                canvas.drawBitmap(bitmap, null, new Rect(0, 0, newButtonSize, newButtonSize), paint);

                // Установка нового Bitmap в качестве изображения для кнопки
                imageButton.setImageBitmap(scaledBitmap);
            }
        }
    }

}