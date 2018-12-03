package me.mafrans.adventofcode.day3;

public class Claim {
    private int id;
    private int leftMargin;
    private int topMargin;
    private int width;
    private int height;

    public Claim(int id, int leftMargin, int topMargin, int width, int height) {
        this.id = id;
        this.leftMargin = leftMargin;
        this.topMargin = topMargin;
        this.width = width;
        this.height = height;
    }
    public Claim(String id, String leftMargin, String topMargin, String width, String height) {
        this.id = Integer.parseInt(id);
        this.leftMargin = Integer.parseInt(leftMargin);
        this.topMargin = Integer.parseInt(topMargin);
        this.width = Integer.parseInt(width);
        this.height = Integer.parseInt(height);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLeftMargin() {
        return leftMargin;
    }

    public void setLeftMargin(int leftMargin) {
        this.leftMargin = leftMargin;
    }

    public int getTopMargin() {
        return topMargin;
    }

    public void setTopMargin(int topMargin) {
        this.topMargin = topMargin;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Claim:{id:" + id + ", leftMargin:" + leftMargin + ", topMargin:" + topMargin + ", width:" + width + ", height:" + height + "}";
    }
}
