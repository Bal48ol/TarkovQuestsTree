package com.example.tarkovtreequest;

public class Child {
    private String name;
    private int backgroundState;

    public Child(String name, int backgroundState) {
        this.name = name;
        this.backgroundState = backgroundState;
    }

    public String getName() {
        return name;
    }

    public int getBackgroundState() {
        return backgroundState;
    }

    public void setBackgroundState(int backgroundState) {
        this.backgroundState = backgroundState;
    }
}

