package com.algorithms.search;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @Description: 堆优化版迪杰斯特拉
 * @author: thy
 * @date: 2023年03月26日 23:29
 */

public class HeapDijkstra {
    private static int[] e, ne, w, h, d;

    private static int n, m, idx;

    private static boolean[] st;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int N = 1000000;
        h = new int[N];
        e = new int[N];
        ne = new int[N];
        w = new int[N];
        d = new int[N];
        st = new boolean[N];
        Arrays.fill(d, 0x3f3f3f3f);
        Arrays.fill(h, -1);
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            add(a, b, c);
        }

        int res = dijkstra();
        System.out.println(res);
    }

    private static int dijkstra() {
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        queue.add(new int[]{0, 1});
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            int dis = p[0];
            int number = p[1];
            st[number] = true;
            for (int j = h[number]; j != -1; j = ne[j]) {
                int k = e[j];
                if (d[k] > dis + w[j]) {
                    d[k] = dis + w[j];
                    queue.add(new int[]{dis + w[j], k});
                }
            }
        }
        return d[n] == 0x3f3f3f3f ? -1 : d[n];
    }

    private static void add(int a, int b, int c) {
        e[idx] = b;
        ne[idx] = h[a];
        w[idx] = c;
        h[a] = idx++;
    }
}
