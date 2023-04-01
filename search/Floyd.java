package com.algorithms.search;

import java.util.Map;
import java.util.Scanner;

/**
 * @Description:
 * @author: thy
 * @date: 2023年03月31日 23:35
 */

public class Floyd {

    public static int n, m, k;

    private static int[][] dis;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        int N = 20010;
        dis = new int[N][N];
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++)
                if (i == j) dis[i][j] = 0;
                else dis[i][j] = 0x3f3f3f;

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            dis[x][y] = Math.min(dis[x][y], z);
        }
        floyd();

        for (int i = 0; i < k; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            if (dis[x][y] > 0x3f3f3f / 2) System.out.println("impossible");
            else System.out.println(dis[x][y]);
        }
    }

    private static void floyd() {
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++)
                for (int k = 1; k <= m; k++)
                    dis[i][j] = Math.min(dis[i][j], dis[i][k] + dis[k][j]);
    }
}
