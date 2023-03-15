package com.algorithms.datastructure;

import java.util.Scanner;

/**
 * @Description: Trie
 * @author: thy
 * @date: 2023年03月08日 18:55
 */

public class Trie {
    /**
     *
     */
    public static int[][] son = new int[100010][26];

    public static int[] cnt = new int[100010];
    /**
     * 编号唯一的节点
     */
    public static int idx = 0;

    public static void insert(String s) {
        int p = 0;
        for (int i = 0; i < s.length(); i++) {
            int n = s.charAt(i) - 'a';
            if (son[p][n] == 0) son[p][n] = ++idx;
            p = son[p][n];
        }
        cnt[p]++;
    }

    public static int search(String s) {
        int p = 0;
        for (int i = 0; i < s.length(); i++) {
            int n = s.charAt(i) - 'a';
            if (son[p][n] == 0) return 0;
            else p = son[p][n];
        }
        return cnt[p];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0;i < n;i++){
            String op = sc.next();
            String s = sc.next();
            if (op.equals("I")){
                insert(s);
            }else{
                System.out.println(search(s));
            }
        }
    }
}
