package com.algorithms.basic;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description: 快速排序代码
 * @author: thy
 * @date: 2023年01月06日 12:21
 * 1.确定分界点
 * 2.调整区间 使得左边的全部小于x，右边的全部大于分界点
 * 3.递归处理左右两段
 */

public class quickSort {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(reader.readLine());
            int[] arr = new int[n];
            String[] str = reader.readLine().split(" ");

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }

            quick_sort(arr, 0, n - 1);

            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void quick_sort(int[] arr, int l, int r) {
        if (l >= r) return;

        int left = l - 1, right = r + 1;
        int x = arr[l + (r - l) / 2];


        while (left < right) {
            do {
                ++left;
            } while (arr[left] < x);
            do {
                --right;
            } while (arr[right] > x);
            if (left < right) {
                int t = arr[left];
                arr[left] = arr[right];
                arr[right] = t;
            }
        }

        quick_sort(arr, l, right);
        quick_sort(arr, right + 1, r);
    }
}
