package com.algorithms.search;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description:
 * @author: thy
 * @date: 2023年04月05日 13:05
 */

public class HungarianAlgorithm {
    private static int n1, n2, m, idx;

    private static int[] e, ne, h, match, st;

    private static int N = 100010;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int res = 0;
        n1 = sc.nextInt();
        n2 = sc.nextInt();
        m = sc.nextInt();
        idx = 0;
        e = new int[N];
        ne = new int[N];
        h = new int[N];
        match = new int[N];
        st = new int[N];
        Arrays.fill(h, -1);
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            add(a, b);
        }

        for (int i = 1;i <= n1;i++){
            Arrays.fill(st,0);
            if (find(i)){
                res++;
            }
        }

        System.out.println(res);
    }

    private static boolean find(int x) {
        for (int i = h[x];i != -1;i = ne[i]){
            int p = e[i];
            if (st[p] == 0){
                st[p] = 1;
                if (match[p] == 0 || find(match[p])){
                    match[p] = x;
                    return true;
                }
            }
        }
        return false;
    }

    private static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }
}
