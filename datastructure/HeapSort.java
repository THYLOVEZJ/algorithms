package com.algorithms.datastructure;

import java.util.Scanner;

/**
 * @Description: 堆排序
 * @author: thy
 * @date: 2023年03月10日 10:00
 */

public class HeapSort {
    public static int[] heap;

    public static int size;

    public static void down(int idx) {
        int i = idx;
        if (idx * 2 + 1 <= size) {
            if (heap[idx * 2] < heap[idx]) {
                i = idx * 2;
            }
            if (heap[idx * 2 + 1] < heap[i]) {
                i = idx * 2 + 1;
            }
        } else if (idx * 2 <= size) {
            if (heap[idx * 2] < heap[idx]) {
                i = idx * 2;
            }
        }

        if (i == idx) {
            return;
        }

        int temp = heap[i];
        heap[i] = heap[idx];
        heap[idx] = temp;
        down(i);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        heap = new int[n + 1];
        size = n;

        for (int i = 1; i <= n; i++) {
            heap[i] = sc.nextInt();
        }

        for (int i = n / 2; i >= 1; i--) {
            down(i);
        }

        for (int i = 1; i <= m; i++) {
            System.out.println(heap[1]);
            heap[1] = heap[size];
            size--;
            down(1);
        }

    }
}
