package com.algorithms.search;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

/**
 * @Description:
 * @author: thy
 * @date: 2023年03月29日 15:58
 */


public class BellmanFord {

    private static int[][] edge;

    private static int[] dis;

    private static int n, m, k;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        int M = 100010;
        dis = new int[n + 1];
        edge = new int[M][3];
        Arrays.fill(dis, 0x3f3f3f3f);
        for (int i = 1; i <= m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            edge[i][0] = x;
            edge[i][1] = y;
            edge[i][2] = z;
        }
        dis[1] = 0;
        bellman_ford();
    }

    private static void bellman_ford() {
        for (int i = 0; i < k; i++) {
            int[] copy = Arrays.copyOf(dis, dis.length);
            for (int j = 1; j <= m; j++) {
                int a = edge[j][0];
                int b = edge[j][1];
                int w = edge[j][2];
                dis[b] = Math.min(dis[b], copy[a] + w);
            }
        }
        if (dis[n] > 0x3f3f3f / 2) System.out.println("impossible");
        else System.out.println(dis[n]);
    }
}
