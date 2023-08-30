package com.example.tarkovtreequest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class TreeBuilder {
    private Context context;
    private RelativeLayout treeContainer;
    private int defaultColor;

    public TreeBuilder(Context context, RelativeLayout treeContainer) {
        this.context = context;
        this.treeContainer = treeContainer;
    }

    public void setDefaultColor(int color) {
        defaultColor = color;
    }

    private int getDefaultColor() {
        return defaultColor;
    }

    public void buildTree(TreeNode rootNode) {
        treeContainer.removeAllViews();
        LinearLayout childLayout = new LinearLayout(context); // Создаем контейнер один раз за пределами цикла
        childLayout.setId(R.id.childLayout);
        RelativeLayout.LayoutParams childLayoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        childLayoutParams.addRule(RelativeLayout.BELOW, R.id.rootLayout);
        treeContainer.addView(childLayout, childLayoutParams);
        buildTreeNode(rootNode, childLayout, 0);
    }

    private void buildTreeNode(TreeNode node, LinearLayout parentLayout, int level) {
        View nodeView = LayoutInflater.from(context).inflate(R.layout.tree_node_layout, parentLayout, false);

        TextView nameTextView = nodeView.findViewById(R.id.nameTextView);
        TextView descriptionTextView = nodeView.findViewById(R.id.descriptionTextView);
        RelativeLayout rootLayout = nodeView.findViewById(R.id.rootLayout);
        TextView childrenTextView = nodeView.findViewById(R.id.childrenTextView);

        rootLayout.setBackgroundColor(getDefaultColor());

        nameTextView.setText(node.getName());
        descriptionTextView.setText(node.getDescription());

        StringBuilder stringBuilder = new StringBuilder();
        appendChildren(node, stringBuilder, level + 1);
        childrenTextView.setText(stringBuilder.toString());

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(100, 0, 0, 0); // Отступы для отображения уровней

        nodeView.setLayoutParams(layoutParams);

        parentLayout.addView(nodeView);

        LinearLayout childLayout = nodeView.findViewById(R.id.childLayout);
        if (childLayout == null) {
            childLayout = new LinearLayout(context);
            childLayout.setId(R.id.childLayout);
            childLayout.setOrientation(LinearLayout.HORIZONTAL);
            parentLayout.addView(childLayout);
        }

        for (TreeNode child : node.getChildren()) {
            buildTreeNode(child, childLayout, level + 1);
        }
    }

    private void appendChildren(TreeNode node, StringBuilder stringBuilder, int level) {
        for (TreeNode child : node.getChildren()) {
            stringBuilder.append("\n");
            for (int i = 0; i < level; i++) {
                stringBuilder.append("\t");
            }
            stringBuilder.append("- ");
            stringBuilder.append(child.getName());
        }
    }

}
