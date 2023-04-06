package com.algorithms.search;


import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description:
 * @author: thy
 * @date: 2023年04月04日 11:08
 */

public class BipartiteGraph {

    private static int[] e, ne, h, color;
    private static int n, m, idx;

    private static int N = 100010;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        h = new int[N + 1];
        e = new int[N + 1];
        ne = new int[N + 1];
        Arrays.fill(h, -1);
        color = new int[N];
        idx = 0;
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            add(u, v);
            add(v, u);
        }
        boolean flag = true;
        for (int i = 1; i <= n; i++) {
            if (color[i] == 0) {
                if (!dfs(i, 1)) {
                    flag = false;
                    break;
                }
            }
        }
        if (flag) System.out.println("Yes");
        else System.out.println("No");
    }

    private static boolean dfs(int u, int c) {
        color[u] = c;
        for (int i = h[u]; i != -1; i = ne[i]) {
            int p = e[i];
            if (color[p] == 0) {
                if (!dfs(p,3-c)) return false;
            }else if (color[p] == c) return false;
        }
        return true;
    }

    private static void add(int u, int v) {
        e[idx] = v;
        ne[idx] = h[u];
        h[u] = idx++;
    }
}
