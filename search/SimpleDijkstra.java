package com.algorithms.search;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description: 朴素版迪杰斯特拉
 * @author: thy
 * @date: 2023年03月24日 21:42
 */

public class SimpleDijkstra {

    private static int[][] graph;

    private static int n, m;

    private static boolean[] st;

    private static int[] d;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        // 这里分配太大会MLE
        int N = 1010;
        graph = new int[N][N];
        for (int i = 0; i < N; i++) {
            // 这里注意不要分配Integer.MAXVALUE,否则graph[t][j] + d[t]可能会超出Integer范围而出错
            Arrays.fill(graph[i], 0x3f);
        }
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph[a][b] = Math.min(graph[a][b], c);
        }
        d = new int[N];
        st = new boolean[N];
        Arrays.fill(d, 10000);
        int res = dijkstra();
        System.out.println(res);
    }

    private static int dijkstra() {
        d[1] = 0;
        for (int i = 0; i < n; i++) {
            int t = -1;
            for (int j = 1; j <= n; j++) {
                if (!st[j] && (t == -1 || d[t] > d[j])) {
                    t = j;
                }
            }
            st[t] = true;
            for (int j = 1; j <= n; j++) {
                d[j] = Math.min(d[j], graph[t][j] + d[t]);
            }
        }
        return d[n] == 10000 ? -1 : d[n];
    }
}
