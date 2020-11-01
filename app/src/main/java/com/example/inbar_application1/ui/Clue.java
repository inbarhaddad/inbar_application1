package com.example.inbar_application1.ui;

public class Clue {
    private int num;
    private String description;
    private int icon;

    public Clue(int num, String description, int icon) {
        this.num = num;
        this.description = description;
        this.icon = icon;
    }

    public int getNum() {
        return num;
    }

    public String getDescription() {
        return description;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
