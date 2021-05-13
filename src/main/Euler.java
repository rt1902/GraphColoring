package main;

import java.util.Random;

public class Euler {
    public static int[][] genGraphWithEuler(int n, int b) {
        int[][] result = new int[n][n];
        Random rand = new Random();

//clear graph
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                result[i][j] = 0;

//generate graph with given n and b
        for (int i = 1; i < n; i++)
            for (int j = 0; j < i; j++)
                if (rand.nextInt(100) < b) {
                    result[i][j] = 1;
                    result[j][i] = 1;
                }

//modify to have EULER
        for (int i = 0; i < n - 1; i++) {
//calculate degree
            int deg = 0;
            for (int j = 0; j < n; j++)
                if (result[i][j] > 0)
                    deg++;
//check if degree is even
            if (deg % 2 != 0) {
                int x = rand.nextInt(n - i - 1) + i + 1;
                if (result[i][x] > 0) {
                    result[i][x] = 0;
                    result[x][i] = 0;
                } else {
                    result[i][x] = 1;
                    result[x][i] = 1;
                }
            }
        }

        return result;
    }
}
