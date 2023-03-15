package com.algorithms.datastructure;

import java.util.Scanner;

/**
 * @Description: 并查集
 * @author: thy
 * @date: 2023年03月08日 22:36
 */

public class UnionFind {
    public static int[] p;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();


        p = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            p[i] = i;
        }

        int m = sc.nextInt();

        for (int i = 0; i < m; i++) {
            String s = sc.next();
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (s.equals("M")) {
                p[find(a)] = find(b);
            } else {
                if (find(a) == find(b)) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            }
        }
    }

    private static int find(int x) {
        if (p[x] != x) p[x] = find(p[x]);
        return p[x];
    }
}
