package com.algorithms.search;

import java.util.Scanner;

/**
 * @Description:
 * @author: thy
 * @date: 2023年03月15日 22:46
 */

public class EightQueue {
    private static String[][] graph;

    private static boolean[] col;
    private static boolean[] dig;
    private static boolean[] udig;

    private static int n;

    public static void dfs(int u) {
        if (u == n) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(graph[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println();
        }

        for (int i = 0; i < n; i++) {
            if (!col[i] && !dig[i + u] && !udig[n + i - u]){
                col[i] = dig[i + u] = udig[n + i - u] = true;
                graph[u][i] = "Q";
                dfs(u+1);
                col[i] = dig[i + u] = udig[n + i - u] = false;
                graph[u][i] = ".";
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        graph = new String[20][20];
        col = new boolean[20];
        dig = new boolean[20];
        udig = new boolean[20];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = ".";
            }
        }
        dfs(0);
    }
}
