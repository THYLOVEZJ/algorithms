package com.algorithms.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description: 归并排序
 * @author: thy
 * @date: 2023年01月14日 18:22
 */

public class mergeSort {
    public static int n;
    public static int[] tmp;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());
        int[] arr = new int[n];
        tmp = new int[n];
        String[] s = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        merge_sort(arr, 0, n - 1);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void merge_sort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }

        int mid = l + (r - l) / 2;
        merge_sort(arr, l, mid);
        merge_sort(arr, mid + 1, r);

        int k = 0, left = l, right = mid + 1;
        while (left <= mid && right <= r) {
            if (arr[left] <= arr[right]) {
                tmp[k++] = arr[left++];
            } else {
                tmp[k++] = arr[right++];
            }
        }
        while (left <= mid) {
            tmp[k++] = arr[left++];
        }
        while (right <= r) {
            tmp[k++] = arr[right++];
        }

        for (int i = l, j = 0; i <= r && j < k; i++, j++) {
            arr[i] = tmp[j];
        }
    }
}
