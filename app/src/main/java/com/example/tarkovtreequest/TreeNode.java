package com.example.tarkovtreequest;

import java.util.List;
import java.util.ArrayList;
public class TreeNode {
    private String name;
    private String description;
    private List<TreeNode> children;
    private int color;

    public TreeNode(String name, String description) {
        this.name = name;
        this.description = description;
        this.children = new ArrayList<>();
    }

    public void addChild(TreeNode child) {
        children.add(child);
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
