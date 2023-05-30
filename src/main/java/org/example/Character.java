package org.example;

public class Character {
    private String nume;
    private int x, y;

    public Character(String nume, int x, int y) {
        this.nume = nume;
        this.x = x;
        this.y = y;
    }

    public String getNume() {
        return nume;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
