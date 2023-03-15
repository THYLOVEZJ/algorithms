package com.algorithms.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 高精度乘法
 * @author: thy
 * @date: 2023年01月19日 9:47
 */

public class highPrecisionMul {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String A = reader.readLine();
        String B = reader.readLine();

        ArrayList<Integer> Aarr = new ArrayList<>();
        for (int i = A.length() - 1; i >= 0; i--) {
            Aarr.add(A.charAt(i) - '0');
        }
        int b = Integer.parseInt(B);

        mul(Aarr, b);
    }

    private static void mul(ArrayList<Integer> A, int B) {
        List<Integer> res = new ArrayList<>();
        // ll表示进位
        int ll = 0;
        for (int i = 0; i < A.size() || ll > 0; i++) {
            int sum = 0;
            if (i < A.size()) {
                sum = A.get(i) * B + ll;
            } else {
                sum = ll;
            }
            res.add(sum % 10);
            ll = sum / 10;
        }

        int s = res.size()-1;
        for (int i = res.size() - 1; i >= 0; i--) {
            if (i > 0 && res.get(i) != 0){
                break;
            }else{
                s = i;
            }
        }

        for (int i = s;i >= 0;i--){
            System.out.print(res.get(i));
        }
    }
}
