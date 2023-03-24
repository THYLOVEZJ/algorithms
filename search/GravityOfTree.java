package com.algorithms.search;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

/**
 * @Description: 树的重心
 * @author: thy
 * @date: 2023年03月21日 22:55
 */

public class GravityOfTree {

    private static int N, idx;
    private static int[] e, ne, head;

    private static boolean[] isVisted;

    private static int ans;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        idx = 0;
        e = new int[2*(N + 1)];
        ne = new int[2 * (N + 1)];
        head = new int[2 * (N + 1)];
        isVisted = new boolean[N + 1];
        ans = N;
        Arrays.fill(head, -1);
        for (int i = 0; i < N - 1; i++) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            add(m, n);
            add(n, m);
        }
        dfs(1);
        System.out.println(ans);
    }

    // 该递归函数返回值为以其节点为子树的最大连通点数
    private static int dfs(int u) {
        isVisted[u] = true;

        int sum = 1, res = 0;
        for (int i = head[u]; i != -1; i = ne[i]) {
            int j = e[i];
            if (!isVisted[j]) {
                int t = dfs(j);
                res = Math.max(res, t);
                sum += t;
            }
        }
        res = Math.max(res, N - sum);
        ans = Math.min(ans, res);

        return sum;
    }

    private static void add(int m, int n) {
        e[idx] = n;
        ne[idx] = head[m];
        head[m] = idx++;
    }
}
