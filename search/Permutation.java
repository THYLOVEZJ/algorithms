package com.algorithms.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Description:
 * @author: thy
 * @date: 2023年03月15日 22:08
 */

public class Permutation {
    private static List<String> res = new ArrayList<>();
    private static boolean[] st;

    public static void dfs(int n, int index, StringBuilder sb) {
        if (index == n) {
            res.add(sb.toString());
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (st[i]) continue;
            sb.append(i);
            st[i] = true;
            dfs(n, index + 1, sb);
            st[i] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        st = new boolean[n+1];
        StringBuilder sb = new StringBuilder();
        dfs(n, 0, sb);
        for (String s : res) {
            for (int i = 0;i < s.length();i++){
                System.out.print(s.charAt(i)+" ");
            }
            System.out.println();
        }
    }
}
