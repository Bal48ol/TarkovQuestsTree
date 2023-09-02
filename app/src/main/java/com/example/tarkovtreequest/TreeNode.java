package com.example.tarkovtreequest;

public class TreeNode {
    private boolean isBackgroundDone;

    public TreeNode(String name, String description) {
        this.isBackgroundDone = false;
    }


    public boolean isBackgroundDone() {
        return isBackgroundDone;
    }

    public void setBackgroundDone(boolean backgroundDone) {
        isBackgroundDone = backgroundDone;
    }
}

