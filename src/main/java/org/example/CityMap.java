package org.example;

public class CityMap {
    private int n, m;
    private char[][] harta;

    public CityMap(int n, int m, char[][] harta) {
        this.n = n;
        this.m = m;
        this.harta = harta;
    }

    public int getN() {
        return n;
    }

    public int getM() {
        return m;
    }

    public char[][] getHarta() {
        return harta;
    }
}
