package com.example.tarkovtreequest;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class PraporActivity extends AppCompatActivity {
    private CustomLinearLayout treeContainer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prapor);

        treeContainer = findViewById(R.id.treeContainer);

        TreeNode rootNode = new TreeNode("Проба пера", "Убить пять диких и передать два ружья МР-133");

        TreeNode childNode1 = new TreeNode("Проверка на вшивость", "Найти бронзовые часы и передать их Прапору");
        TreeNode childNode2 = new TreeNode("Поисковая миссия", "Найти пропавшую автоколонну и обнаружить временный лагерь USEC");

        TreeNode grandchildNode1 = new TreeNode("Пикник со стрельбой", "Уничтожить 15 Диких в Лесу");
        TreeNode grandchildNode2 = new TreeNode("Посылка из прошлого", "Найти кейс на Таможне и заложить на Заводе");

        TreeNode grandchildNode3 = new TreeNode("Нефтянка", "Пометить 4 наливняка на Таможне");

        rootNode.addChild(childNode1);
        rootNode.addChild(childNode2);
        childNode2.addChild(grandchildNode1);
        childNode2.addChild(grandchildNode2);
        grandchildNode2.addChild(grandchildNode3);

        TreeBuilder treeBuilder = new TreeBuilder(this, treeContainer);
        treeBuilder.buildTree(rootNode);
    }
}
