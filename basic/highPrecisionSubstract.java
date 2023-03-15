package com.algorithms.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * @Description: 高精度减法
 * @author: thy
 * @date: 2023年01月18日 10:50
 */
public class highPrecisionSubstract {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char[] A = reader.readLine().toCharArray();
        char[] B = reader.readLine().toCharArray();
        ArrayList<Integer> res;
        if (cmp(A, B)) {
            res = sub(A, B);
        } else {
            res = sub(B, A);
            System.out.print("-");
        }

        // 用来删除前导0
        boolean flag = true;
        for (int i = res.size() - 1; i >= 0; i--) {
            int a = res.get(i);
            if (a != 0) {
                System.out.print(a);
                flag = false;
            } else {
                if (!flag || res.size() == 1) {
                    System.out.print(0);
                }
            }
        }
    }

    private static ArrayList<Integer> sub(char[] A, char[] B) {
        // ll 表示借位
        int ll = 0, i = A.length - 1, j = B.length - 1;
        ArrayList<Integer> li = new ArrayList<>();
        while (i >= 0) {
            int a = A[i] - '0';
            int b = j < 0 ? 0 : B[j] - '0';
            int res = a - b - ll;
            if (res >= 0) {
                ll = 0;
                li.add(res);
            } else {
                ll = 1;
                li.add(10 + res);
            }
            i--;
            j--;
        }
        return li;
    }

    private static boolean cmp(char[] a, char[] b) {
        if (a.length != b.length) {
            return a.length > b.length;
        } else {
            for (int i = 0; i < a.length; i++) {
                if (a[i] != b[i]) {
                    return a[i] > b[i];
                }
            }
            return true;
        }
    }
}

