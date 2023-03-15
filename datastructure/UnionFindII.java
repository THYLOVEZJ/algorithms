package com.algorithms.datastructure;

import java.util.Scanner;

/**
 * @Description: 并查集II
 * @author: thy
 * @date: 2023年03月09日 21:59
 */

public class UnionFindII {
    public static int[] p;

    public static int[] size;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();


        p = new int[n + 1];
        size = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            p[i] = i;
            size[i] = 1;
        }

        int m = sc.nextInt();

        for (int i = 0; i < m; i++) {
            String s = sc.next();

            if (s.equals("C")) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                // 容易出BUG，这里如果不判断
                if (find(a) != find(b))
                // 这里需要注意，应该是先加然后再将a的根节点加到b的根节点上
                size[find(b)] += size[find(a)];
                p[find(a)] = find(b);
            } else if (s.equals("Q1")) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                if (find(a) == find(b)) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            } else if (s.equals("Q2")) {
                int a = sc.nextInt();
                System.out.println(size[find(a)]);
            }
        }
    }

    private static int find(int x) {
        if (p[x] != x) p[x] = find(p[x]);
        return p[x];
    }
}
