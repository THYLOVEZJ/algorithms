package com.algorithms.search;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @Description:
 * @author: thy
 * @date: 2023年03月30日 16:39
 */

public class NegativeLoop {
    private static int n, m, idx;

    private static int[] e, ne, w, h, dis, cnt;

    private static boolean[] st;

    private static int N = 10010;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        e = new int[N];
        ne = new int[N];
        w = new int[N];
        dis = new int[N];
        cnt = new int[N];
        h = new int[N];
        st = new boolean[N];
        idx = 0;
        Arrays.fill(h, -1);
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
        for (int i = 1; i <= n; i++) {
            queue.add(i);
            st[i] = true;
        }

        while (!queue.isEmpty()) {
            Integer p = queue.poll();
            st[p] = false;
            for (int j = h[p]; j != -1; j = ne[j]) {
                int q = e[j];
                if (dis[q] > dis[p] + w[j]) {
                    dis[q] = dis[p] + w[j];
                    cnt[q] = cnt[p] + 1;
                    if (cnt[q] >= n) {
                        System.out.println("Yes");
                        return;
                    }
                    if (!st[q]) {
                        queue.add(q);
                        st[q] = true;
                    }
                }
            }
        }

        System.out.println("No");
    }

    private static void add(int a, int b, int c) {
        e[idx] = b;
        ne[idx] = h[a];
        w[idx] = c;
        h[a] = idx++;
    }
}
