package com.algorithms.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @Description: 单链表
 * @author: thy
 * @date: 2023年03月04日 12:29
 */

public class SingleLinkedList {
    public static int[] val;
    public static int[] ne;
    public static int head;
    public static int idx;

    static {
        val = new int[100010];
        ne = new int[100010];
        head = -1;
        idx = 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(reader.readLine());
        for (int i = 0; i < M; i++) {
            String s = reader.readLine();
            String[] arr = s.split(" ");
            if (arr[0].equals("H")) {
                int x = Integer.parseInt(arr[1]);
                insertHead(x);
            } else if (arr[0].equals("I")) {
                int k = Integer.parseInt(arr[1]);
                int x = Integer.parseInt(arr[2]);
                insertNode(k - 1, x);
            } else {
                int k = Integer.parseInt(arr[1]);
                if (k == 0) {
                    head = ne[head];
                } else {
                    deleteNode(k - 1);
                }
            }
        }

        for (int i = head; i != -1; i = ne[i]) {
            System.out.print(val[i] + " ");
        }
    }

    // 将x插入到第k个数后面
    private static void insertNode(int k, int x) {
        val[idx] = x;
        ne[idx] = ne[k];
        ne[k] = idx;
        idx++;
    }

    private static void deleteNode(int k) {
        ne[k] = ne[ne[k]];
    }

    private static void insertHead(int x) {
        val[idx] = x;
        ne[idx] = head;
        head = idx++;
    }

}
