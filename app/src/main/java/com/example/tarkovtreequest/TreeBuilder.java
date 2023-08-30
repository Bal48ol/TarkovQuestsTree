package com.example.tarkovtreequest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TreeBuilder {
    private Context context;
    private CustomLinearLayout treeContainer;
    private int defaultColor;

    public TreeBuilder(Context context, CustomLinearLayout treeContainer) {
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
        buildTreeNode(rootNode, treeContainer, 0);
    }

    private void buildTreeNode(TreeNode node, LinearLayout parentLayout, int level) {
        View nodeView = LayoutInflater.from(context).inflate(R.layout.tree_node_layout, parentLayout, false);

        TextView nameTextView = nodeView.findViewById(R.id.nameTextView);
        TextView descriptionTextView = nodeView.findViewById(R.id.descriptionTextView);
        LinearLayout rootLayout = nodeView.findViewById(R.id.rootLayout);
        LinearLayout childrenLayout = nodeView.findViewById(R.id.childrenLayout);

        rootLayout.setBackgroundColor(getDefaultColor());

        nameTextView.setText(node.getName());
        descriptionTextView.setText(node.getDescription());

        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) nodeView.getLayoutParams();
        layoutParams.setMargins(level * 100, 0, 0, 0); // Отступы для отображения уровней

        parentLayout.addView(nodeView);

        for (TreeNode child : node.getChildren()) {
            LinearLayout childLayout = new LinearLayout(context);
            childLayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            childLayout.setOrientation(LinearLayout.HORIZONTAL);
            childrenLayout.addView(childLayout);

            buildTreeNode(child, childLayout, level + 1);
        }
    }
}

