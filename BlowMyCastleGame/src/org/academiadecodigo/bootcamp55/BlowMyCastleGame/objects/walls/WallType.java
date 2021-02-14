package org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects.walls;

public enum WallType {
    WOOD(1, "BROWN"),
    STEEL(2, "GREY"),
    BRICK(3, "RED");

    private int MaxDamage;
    private String color;

    WallType(int maxDamage, String color) {
        this.MaxDamage = maxDamage;
        this.color = color;
    }

    public int getMaxDamage() {
        return MaxDamage;

    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}