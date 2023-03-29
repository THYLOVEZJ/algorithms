package com.algorithms.search;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @Description:
 * @author: thy
 * @date: 2023年03月29日 22:31
 */

public class SPFA {
    private static int[] dis, e, ne, h, w;

    private static int n, m, idx;

    private static boolean[] st;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int N = 100010;
        e = new int[N];
        ne = new int[N];
        h = new int[N];
        w = new int[N];
        st = new boolean[N];
        idx = 0;
        dis = new int[N];
        Arrays.fill(h, -1);
        Arrays.fill(dis, 0x3f3f3f3f);
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            add(a, b, c);
        }
        spfa();
    }

    private static void spfa() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        st[1] = true;
        dis[1] = 0;
        while (!queue.isEmpty()) {
            Integer p = queue.poll();
            st[p] = false;
            for (int i = h[p]; i != -1; i = ne[i]) {
                int q = e[i];
                if (dis[q] > dis[p] + w[i]) {
                    dis[q] = dis[p] + w[i];
                    if (!st[q]) {
                        queue.add(q);
                        st[q] = true;
                    }
                }
            }
        }
        if (dis[n] == 0x3f3f3f3f) System.out.println("impossible");
        else System.out.println(dis[n]);
    }

    private static void add(int a, int b, int c) {
        e[idx] = b;
        ne[idx] = h[a];
        w[idx] = c;
        h[a] = idx++;
    }
}
