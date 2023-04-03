package com.algorithms.search;

import java.util.*;

/**
 * @Description:
 * @author: thy
 * @date: 2023年04月03日 10:09
 */

public class Kruskal {
    public static int[] unionFind;

    static class Edge {
        public int a;
        public int b;
        public int w;

        public Edge(int a, int b, int w) {
            this.a = a;
            this.b = b;
            this.w = w;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Edge> list = new ArrayList<>();
        unionFind = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int w = sc.nextInt();
            list.add(new Edge(a, b, w));
        }
        for (int i = 1; i <= n; i++) {
            unionFind[i] = i;
        }
        list.sort(((o1, o2) -> o1.w - o2.w));
        kruscal(list, n, unionFind);
    }

    private static void kruscal(List<Edge> list, int n, int[] unionFind) {
        int cnt = 0;
        int res = 0;
        for (Edge e : list) {
            int a = e.a;
            int b = e.b;
            int w = e.w;
            if (find(a) != find(b)) {
                unionFind[find(a)] = find(b);
                cnt++;
                res += w;
            }
        }
        if (cnt < n-1) System.out.println("impossible");
        else System.out.println(res);
    }

    private static int find(int p) {
        if (unionFind[p] != p) unionFind[p] = find(unionFind[p]);
        return unionFind[p];
    }
}
