package com.example.tarkovtreequest;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

public class PraporActivity extends AppCompatActivity {
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
    private Context context;
    private DatabaseHelper dbhelp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prapor);

        LinearLayout traderLayoutPrapor = findViewById(R.id.traderLayoutPrapor);
        LinearLayout yourParentView = findViewById(R.id.your_parent_view);
        FrameLayout praporLayout = findViewById(R.id.praporLayout);

        context = this;
        dbhelp = new DatabaseHelper(this);

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

        // Создаем экземпляр TreeBuilder для добавления дочерних элементов
        TreeBuilder treeBuilder = new TreeBuilder(context);

        // Создаем дочерние элементы и добавляем их к соответствующим родительским элементам
        LinearLayout root = createChildView("Проба пера", "Убить пять диких и передать два ружья МР-133", true);

        LinearLayout child1 = createChildView("Проверка на вшивость", "Найти бронзовые часы и передать их Прапору", false);
        LinearLayout child2 = createChildView("Поисковая миссия", "Найти пропавшую автоколонну и обнаружить временный лагерь USEC", false);

        LinearLayout child3 = createChildView("Пикник со стрельбой", "Уничтожить 15 Диких в Лесу", false);
        LinearLayout child4 = createChildView("Посылка из прошлого", "Найти кейс на Таможне и заложить на Заводе", false);

        LinearLayout child5 = createChildView("Нефтянка", "Пометить 4 наливняка на Таможне", false);

        LinearLayout child6 = createChildView("Компромат", "Найти папку во времянке на Таможне и передать её Прапору", false);
        LinearLayout child7 = createChildView("Рожки для мороженого", "Найти в рейде 3 магазина на 60 патронов для АК для Прапора", false);
        LinearLayout child12 = createChildView("Почтальон Печкин", "Найти письмо на Заводе и передать Терапевту (Почтальон Печкин. Часть 2)", false);

        LinearLayout child13 = createChildView("Тряхнуть кассира", "Найти на Таможне в комнате 203 кейс и передать Прапору", false);
        LinearLayout child19 = createChildView("Идеальный переговорщик", "Прокачать всех торговцев до 4 уровня кроме Скупщика и Егеря", false);
        LinearLayout child20 = createChildView("Гренадёр", "Ликвидировать 8 операторов ЧВК с помощью гранат", false);

        LinearLayout child21 = createChildView("Каратель. Часть 1", "Уничтожить 15 Диких на Побережье используя автоматы серии АКМ", false);
        LinearLayout child34 = createChildView("Каратель. Часть 2", "Уничтожить 12 Диких на Побережье используя глушитель", false);
        LinearLayout child35 = createChildView("Каратель. Часть 3", "Уничтожить 25 Диких на Таможне из АКСУ", false);
        LinearLayout child36 = createChildView("Простая задача. Часть 1", "Необходимо пометить вертолёт на базе Отступников", false);
        LinearLayout child37 = createChildView("Простая задача. Часть 2", "Необходимо уничтожить 20 Отступников на территории водоочистной станции на Маяке", false);
        LinearLayout child38 = createChildView("Разведка", "Посетить три крыши зданий с номерными знаками", false);

        LinearLayout child39 = createChildView("Каратель. Часть 4", "Убить 10 Диких в Лесу из 12 калибра. Уничтожить 10 ЧВК на Берегу в спец одежде", false);
        LinearLayout child40 = createChildView("Каратель. Часть 5", "Убить 10 ЧВК одевшись в PACA и 6Б47", false);
        LinearLayout child41 = createChildView("Своя Земля", "Убить 20 бойцов ЧВК USEC на локации Маяк и принести жетоны торговцу", false);
        LinearLayout child42 = createChildView("Короли высоток", "Убить снайперов на крышах Улиц Таркова", false);
        LinearLayout child43 = createChildView("Каратель. Часть 6", "Уничтожить 15 бойцов ЧВК из СВД", false);
        LinearLayout child44 = createChildView("Устрашитель", "Убить 40 Диких выстрелом в голову", false);
        LinearLayout child45 = createChildView("Захват аванпоста", "Убить по 8 бойцов ЧВК в определённых местах на Берегу, в Лесу и на Таможне", false);
        LinearLayout child46 = createChildView("Конвоир", "Убить по 4 ЧВК на всех локациях не умирая", false);

        LinearLayout child22 = createChildView("Анестезия", "Пометить три места торговли на Берегу", false);
        LinearLayout child23 = createChildView("Тест-драйв. Часть 1", "Из выданного Прапором оружия убить 5 операторов ЧВК", false);
        LinearLayout child24 = createChildView("Тест-драйв. Часть 2", "Убить 20 ЧВК с СР-2М \"Вереск\" с глушителем и коллиматором", false);
        LinearLayout child25 = createChildView("Игра на верняк", "Пометить три медконтейнера на Берегу", false);
        LinearLayout child27 = createChildView("Ночная прогулка", "Найти в рейде и передать 12 ножей сектантов", false);
        LinearLayout child26 = createChildView("Кабинет химии", "Посетить комнату 110 восточного крыла санатория на Берегу", false);
        LinearLayout child28 = createChildView("Коллеги. Часть 3", "Не убивать Санитара. Принести 10 лаб ключей", false);
        LinearLayout child29 = createChildView("Путь охотника. Садист", "Убить Санитара", false);
        LinearLayout child30 = createChildView("Пристрелка", "Убить 20 бойцов ЧВК с расстояния не менее 100 метров", false);
        LinearLayout child31 = createChildView("Ловкач", "Убить 15 бойцов ЧВК, не используя броню и шлемы на локации Лес", false);
        LinearLayout child32 = createChildView("Сотрудник Terragroup", "Найти флешку в комнате Санитара в Лаборатории и передать её Миротворцу", false);
        LinearLayout child33 = createChildView("Курьер", "Заложить два тепловизора на Таможне", false);

        LinearLayout child14 = createChildView("Почтальон Печкин. Часть 2", "Найти письмо на Заводе и передать Терапевту", false);
        LinearLayout child16 = createChildView("Энергетический кризис", "Необходимо пометить три бензовоза и одну группу цистерн на Маяке", false);

        LinearLayout child15 = createChildView("Вам посылка", "Найти и доставить письмо", false);
        LinearLayout child17 = createChildView("Слава КПСС", "Найти квартиру на локации Улицы Таркова", false);
        LinearLayout child18 = createChildView("Лучшая работа на свете", "Убить Диких из автоматов АК-74 с расстояния более 100 метров", false);

        LinearLayout child8 = createChildView("Бункер. Часть 1", "Найти комнату управления в подземном бункере на Резерве", false);
        LinearLayout child9 = createChildView("Бункер. Часть 2", "Найти все входы в подземный бункер", false);
        LinearLayout child10 = createChildView("Ренегатам тут не место", "Уничтожить пять рейдеров в бункере Резерва", false);
        LinearLayout child11 = createChildView("Документы", "Найти три военных документа на Резерве и передать их Прапору", false);

        // Создаем корневой элемент
        LinearLayout rootContainer = new TreeBuilder(context)
                .addChild(child2)
                .addChild(child1)
                .build();

        LinearLayout child1Container = new TreeBuilder(context)
                .addChild(child3)
                .addChild(child4)
                .build();

        LinearLayout child5Container = new TreeBuilder(context)
                .addChild(child8)
                .addChild(child6)
                .build();

        LinearLayout child7Container = new TreeBuilder(context)
                .addChild(child12)
                .addChild(child13)
                .build();

        LinearLayout child12Container = new TreeBuilder(context)
                .addChild(child14)
                .addChild(child15)
                .build();

        LinearLayout child13Container = new TreeBuilder(context)
                .addChild(child19)
                .addChild(child20)
                .addChild(child22)
                .addChild(child21)
                .build();

        LinearLayout child22Container = new TreeBuilder(context)
                .addChild(child25)
                .addChild(child26)
                .build();

        LinearLayout child26Container = new TreeBuilder(context)
                .addChild(child28)
                .addChild(child29)
                .addChild(child30)
                .build();

        LinearLayout child34Container = new TreeBuilder(context)
                .addChild(child36)
                .addChild(child35)
                .build();

        LinearLayout child36Container = new TreeBuilder(context)
                .addChild(child37)
                .addChild(child38)
                .build();

        LinearLayout child39Container = new TreeBuilder(context)
                .addChild(child41)
                .addChild(child42)
                .addChild(child40)
                .build();

        LinearLayout child43Container = new TreeBuilder(context)
                .addChild(child44)
                .addChild(child45)
                .addChild(child46)
                .build();

        treeBuilder.addChildToParent(rootContainer, root)
                .addChildToParent(child5, child4)
                .addChildToParent(child1Container, child1)
                .addChildToParent(child5Container, child5)
                .addChildToParent(child7, child6)
                .addChildToParent(child7Container, child7)
                .addChildToParent(child9, child8)
                .addChildToParent(child10, child9)
                .addChildToParent(child11, child10)
                .addChildToParent(child12Container, child12)
                .addChildToParent(child16, child14)
                .addChildToParent(child17, child15)
                .addChildToParent(child18, child17)
                .addChildToParent(child13Container, child13)
                .addChildToParent(child23, child20)
                .addChildToParent(child24, child20)
                .addChildToParent(child22Container, child22)
                .addChildToParent(child27, child25)
                .addChildToParent(child26Container, child26)
                .addChildToParent(child31, child28)
                .addChildToParent(child32, child29)
                .addChildToParent(child33, child30)
                .addChildToParent(child34, child21)
                .addChildToParent(child34Container, child34)
                .addChildToParent(child36Container, child36)
                .addChildToParent(child39, child35)
                .addChildToParent(child39Container, child39)
                .addChildToParent(child43, child40)
                .addChildToParent(child43Container, child43);

        hideArrowImageView(rootContainer);
        hideArrowImageView(child1Container);
        hideArrowImageView(child5Container);
        hideArrowImageView(child7Container);
        hideArrowImageView(child12Container);
        hideArrowImageView(child13Container);
        hideArrowImageView(child22Container);
        hideArrowImageView(child26Container);
        hideArrowImageView(child34Container);
        hideArrowImageView(child36Container);
        hideArrowImageView(child39Container);
        hideArrowImageView(child43Container);

        // Добавляем корневой элемент в вашу иерархию представлений
        yourParentView.addView(root);
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
                @SuppressLint("DiscouragedApi") int resourceId = getResources().getIdentifier("img" + (i + 1), "drawable", getPackageName());
                @SuppressLint("UseCompatLoadingForDrawables") Drawable drawable = getResources().getDrawable(resourceId);
                Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();

                int buttonSize = Math.min(imageButton.getWidth(), imageButton.getHeight());
                int newButtonSize = (int) (buttonSize / 1.5);

                Bitmap scaledBitmap = Bitmap.createBitmap(newButtonSize, newButtonSize, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(scaledBitmap);
                Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
                paint.setFilterBitmap(true);
                canvas.drawBitmap(bitmap, null, new Rect(0, 0, newButtonSize, newButtonSize), paint);

                imageButton.setImageBitmap(scaledBitmap);
            }
        }
    }

    private void hideArrowImageView(LinearLayout container) {
        int childCount = ((ViewGroup) container).getChildCount();
        for (int i = 1; i < childCount; i++) {
            View child = ((ViewGroup) container).getChildAt(i);
            LinearLayout childContainer = (LinearLayout) child;
            ImageView arrowImageView = childContainer.findViewById(R.id.arrowImageView);
            arrowImageView.setVisibility(View.GONE);
            ImageView cornerArrowImageView = childContainer.findViewById(R.id.cornerArrowImageView);
            cornerArrowImageView.setVisibility(View.VISIBLE);
        }
    }

    private LinearLayout createChildView(String name, String description, boolean isFirstItem) {
        LayoutInflater inflater = LayoutInflater.from(context);
        @SuppressLint("InflateParams") LinearLayout childView = (LinearLayout) inflater.inflate(R.layout.child_view, null);

        LinearLayout childLayout = childView.findViewById(R.id.childLayout); // Получаем ссылку на childLayout из раздутого представления

        ImageView onWorkImageView = childLayout.findViewById(R.id.onWorkImageView);
        ImageView doneImageView = childLayout.findViewById(R.id.doneImageView);

        TextView titleTextView = childLayout.findViewById(R.id.titleTextView);
        titleTextView.setText(name);

        TextView descriptionTextView = childLayout.findViewById(R.id.descriptionTextView);
        descriptionTextView.setText(description);

        childLayout.setBackground(ContextCompat.getDrawable(context, R.drawable.background));

        ImageView arrowImageView = childView.findViewById(R.id.arrowImageView);
        if (isFirstItem) {
            arrowImageView.setVisibility(View.GONE);
        }

        Child child = new Child(name, 0);

        int backgroundState = dbhelp.getBackgroundState(name);
        Log.d("createChild", "backgroundState: " + backgroundState);

        Child existingChild = dbhelp.getChildByName(name);
        if (existingChild == null) {
            dbhelp.insertChildName(child);
        }

        if (backgroundState == 1) {
            childLayout.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#535353")));
            onWorkImageView.setVisibility(View.GONE);
            doneImageView.setVisibility(View.VISIBLE);
            child.setBackgroundState(1);
        } else {
            childLayout.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#5C613B")));
            onWorkImageView.setVisibility(View.VISIBLE);
            doneImageView.setVisibility(View.GONE);
            child.setBackgroundState(0);
        }

        childLayout.setOnClickListener(v -> {
            int currentBackgroundState = child.getBackgroundState();

            if (currentBackgroundState == 1) {
                childLayout.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#5C613B")));
                onWorkImageView.setVisibility(View.VISIBLE);
                doneImageView.setVisibility(View.GONE);
                child.setBackgroundState(0);
            } else {
                childLayout.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#535353")));
                onWorkImageView.setVisibility(View.GONE);
                doneImageView.setVisibility(View.VISIBLE);
                child.setBackgroundState(1);
            }

            dbhelp.updateBackgroundState(child);
        });

        return childView;
    }
}
