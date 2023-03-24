package com.algorithms.search;

import java.util.*;

/**
 * @Description:
 * @author: thy
 * @date: 2023年03月23日 22:01
 */

public class TopSort {

    private static int n, m, idx;

    private static int[] e, ne, h, d;

    private static int size;

    private static List<Integer> res = new ArrayList();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        idx = 0;
        int N = 100010;
        e = new int[2 * N];
        ne = new int[2 * N];
        h = new int[2 * N];
        d = new int[2 * N];
        size = 0;
        Arrays.fill(d, 0);
        Arrays.fill(h,-1);
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            add(a, b);
        }

        boolean b = topSort();
        if (!b){
            System.out.println(-1);
        }else{
            for (Integer e : res){
                System.out.print(e + " ");
            }
        }
    }

    private static boolean topSort() {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (d[i] == 0) {
                q.add(i);
                size++;
            }
        }

        while (!q.isEmpty()) {
            Integer t = q.poll();
            res.add(t);
            for (int i = h[t];i != -1;i = ne[i]){
                int u = e[i];
                d[u]--;
                if (d[u] == 0){
                    q.add(u);
                    size++;
                }
            }
        }
        return size == n;
    }

    private static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
        d[b]++;
    }
}
