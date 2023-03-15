package com.algorithms.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description: 二分查找
 * @author: thy
 * @date: 2023年01月15日 12:33
 */

public class rangeOfNumber {


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = reader.readLine().split(" ");
        int n = 0, q = 0;
        for (int i = 0; i < 2; i++) {
            n = Integer.parseInt(s[0]);
            q = Integer.parseInt(s[1]);
        }

        int[] arr = new int[n];

        String[] s1 = reader.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s1[i]);
        }

        while (q-- > 0) {
            int num = Integer.parseInt(reader.readLine());

            int l = 0, r = n - 1;
            while (l < r) {
                int mid = (l + r) >> 1;
                if (arr[mid] >= num) r = mid;
                else l = mid + 1;
            }
            if (arr[l] == num) System.out.print(l + " ");
            else System.out.print(-1 + " ");

            l = 0;
            r = n - 1;
            while (l < r) {
                int mid = (l + r + 1) >> 1;
                if (arr[mid] <= num) l = mid;
                else r = mid - 1;
            }
            if (arr[l] == num) System.out.println(l + " ");
            else System.out.println(-1 + " ");
        }
    }
}
