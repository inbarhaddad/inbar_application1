package com.example.inbar_application1.ui;

public class Clue {
    private int num;
    private String description;
    private int icon;
    private float x0;
    private float y0;
    private float x1;
    private float y1;
    private boolean isCollected;

    public float getY1() {
        return y1;
    }

    public float getX1() {
        return x1;
    }

    public Clue(int num, String description, int icon, float x0, float y0, float x1, float y1) {
        this.num = num;
        this.description = description;
        this.icon = icon;
        this.x0 = x0;
        this.y0 = y0;
        this.x1 = x1;
        this.y1 = y1;
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

    public float getX0() {
        return x0;
    }

    public float getY0() {
        return y0;
    }
}
