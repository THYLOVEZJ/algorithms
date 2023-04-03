package com.algorithms.search;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description:
 * @author: thy
 * @date: 2023年04月01日 16:42
 */

public class Prime {
    static int[][] graph;
    static final int N = 510;
    static boolean[] st;
    static int[] dis;
    static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new int[N][N];
        for (int i = 0;i < graph.length;i++){
            Arrays.fill(graph[i],0x3f3f3f);
        }
        st = new boolean[N];
        dis = new int[N];
        for (int i = 1; i <= m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph[a][b] = graph[b][a] = Math.min(graph[a][b], c);
        }

        Arrays.fill(dis, 0x3f3f);
        int res = prime();
        if (res == 0x3f3f) {
            System.out.println("impossible");
        } else {
            System.out.println(res);
        }
    }

    private static int prime() {
        int res = 0;
        dis[1] = 0;
        for (int i = 1; i <= n; i++) {
            int t = -1;
            for (int j = 1; j <= n; j++) {
                if (!st[j] && (t == -1 || dis[t] > dis[j])) {
                    t = j;
                }
            }
            if (dis[t] == 0x3f3f) {
                return 0x3f3f;
            }
            res += dis[t];
            st[t] = true;
            for (int j = 1; j <= n; j++) {
                if (!st[j]){
                    dis[j] = Math.min(dis[j], graph[t][j]);
                }
            }
        }
        return res;
    }
}