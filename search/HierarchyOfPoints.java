package com.algorithms.search;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @Description: 图中点的层次
 * @author: thy
 * @date: 2023年03月22日 19:42
 */

public class HierarchyOfPoints {
    private static int n, m, idx;

    private static int[] e, ne, h, d;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int N = 100010;
        h = new int[N];
        e = new int[N];
        ne = new int[N];
        idx = 0;
        d = new int[N];
        Arrays.fill(h, -1);
        Arrays.fill(d, -1);
        d[1] = 0;
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            add(a, b);
        }
        bfs(1);
        System.out.println(d[n]);
    }

    private static void bfs(int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        while (!queue.isEmpty()) {
            int x1 = queue.poll();
            for (int j = h[x1]; j != -1; j = ne[j]) {
                int k = e[j];
                if (d[k] == -1) {
                    d[k] = d[x1] + 1;
                    queue.add(k);
                }
            }
        }
    }

    private static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }
}
