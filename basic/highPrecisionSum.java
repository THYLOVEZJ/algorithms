package com.algorithms.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * @Description: 高精度加法
 * @author: thy
 * @date: 2023年01月18日 9:34
 */

public class highPrecisionSum {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char[] A = reader.readLine().toCharArray();
        char[] B = reader.readLine().toCharArray();
        ArrayList<Integer> li = new ArrayList<>();
        int i = A.length - 1, j = B.length - 1, ll = 0;
        while (i >= 0 || j >= 0 || ll > 0) {
            int a = i < 0 ? 0 : A[i] - '0';
            int b = j < 0 ? 0 : B[j] - '0';
            int s = a + b + ll;
            ll = s / 10;
            li.add(s % 10);
            i--;
            j--;
        }
        for (int k = li.size() - 1; k >= 0; k--) {
            System.out.print(li.get(k));
        }
    }
}
