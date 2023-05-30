package org.example;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("maze.in"));
        String[] linie = br.readLine().split(" ");
        int n = Integer.parseInt(linie[0]);
        int m = Integer.parseInt(linie[1]);
        char[][] harta = new char[n][m];
        int xRomeo = -1, yRomeo = -1, xJulieta = -1, yJulieta = -1;
        for (int i = 0; i < n; i++) {
            String linieHarta = br.readLine();
            for (int j = 0; j < m; j++) {
                if(j >= linieHarta.length()) {
                    harta[i][j] = ' ';
                }
                else {
                    harta[i][j] = linieHarta.charAt(j);
                }
                if (harta[i][j] == 'R') {
                    xRomeo = i;
                    yRomeo = j;
                } else if (harta[i][j] == 'J') {
                    xJulieta = i;
                    yJulieta = j;
                }
            }
        }
        br.close();
        Character romeo = new Character("Romeo", xRomeo, yRomeo);
        Character julieta = new Character("Julieta", xJulieta, yJulieta);
        CityMap hartaOras = new CityMap(n, m, harta);
        Game joc = new Game(romeo, julieta, hartaOras);
        joc.joaca();
    }
}
