package org.example;

import java.util.*;
import java.io.*;

public class Game {
    private Character romeo, julieta;
    private CityMap harta;

    public Game(Character romeo, Character julieta, CityMap harta) {
        this.romeo = romeo;
        this.julieta = julieta;
        this.harta = harta;
    }

    public Character getRomeo() {
        return romeo;
    }

    public Character getJulieta() {
        return julieta;
    }

    public CityMap getHarta() {
        return harta;
    }

    public void joaca() throws Exception {
        PrintWriter pw = new PrintWriter(new File("maze.out"));
        int[][] timpRomeo = new int[harta.getN()][harta.getM()];
        int[][] timpJulieta = new int[harta.getN()][harta.getM()];
        bfs(timpRomeo, romeo.getX(), romeo.getY());
        bfs(timpJulieta, julieta.getX(), julieta.getY());
        int timpMinim = Integer.MAX_VALUE;
        int punctIntalnireX = -1;
        int punctIntalnireY = -1;
        for (int i = 0; i < harta.getN(); i++) {
            for (int j = 0; j < harta.getM(); j++) {
                if (timpRomeo[i][j] != 0 && timpRomeo[i][j] == timpJulieta[i][j] && timpRomeo[i][j] < timpMinim && harta.getHarta()[i][j] != '#') {
                    timpMinim = timpRomeo[i][j];
                    punctIntalnireX = i+1;
                    punctIntalnireY = j+1;
                }
            }
        }
        pw.println(timpMinim + " " + punctIntalnireX + " " + punctIntalnireY);
        pw.close();
    }

    private void bfs(int[][] timp, int x, int y) {
        int[] dx = {-1, 0, 1, 0, -1, -1, 1, 1};
        int[] dy = {0, 1, 0, -1, -1, 1, -1, 1};
        Queue<Integer> coada = new LinkedList<>();
        coada.add(x);
        coada.add(y);
        timp[x][y] = 1;
        while (!coada.isEmpty()) {
            int xCurent = coada.poll();
            int yCurent = coada.poll();
            for (int i = 0; i < 8; i++) {
                int xNou = xCurent + dx[i];
                int yNou = yCurent + dy[i];
                if (xNou >= 0 && xNou < harta.getN() && yNou >= 0 && yNou < harta.getM() && timp[xNou][yNou] == 0 && harta.getHarta()[xNou][yNou] != '#') {
                    timp[xNou][yNou] = timp[xCurent][yCurent] + 1;
                    coada.add(xNou);
                    coada.add(yNou);
                }
            }
        }
    }
}
