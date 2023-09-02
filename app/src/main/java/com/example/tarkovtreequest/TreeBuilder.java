package com.example.tarkovtreequest;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class TreeBuilder {

    private Context context;
    private LinearLayout rootLayout;

    public TreeBuilder(Context context) {
        this.context = context;
        rootLayout = new LinearLayout(context);
        rootLayout.setOrientation(LinearLayout.VERTICAL);
    }

    public TreeBuilder addChild(View child) {
        rootLayout.addView(child);
        return this;
    }

    public TreeBuilder addChildToParent(View child, View parent) {
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).addView(child);
        }
        return this;
    }

    public LinearLayout build() {
        return rootLayout;
    }
}
