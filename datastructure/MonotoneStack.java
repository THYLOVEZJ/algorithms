package com.algorithms.datastructure;
import java.util.Scanner;
import java.util.Stack;

/**
 * @Description: 单调栈
 * @author: thy
 * @date: 2023年03月04日 16:35
 */

public class MonotoneStack {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Stack<Integer> stack = new Stack<>();

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            while (!stack.isEmpty() && stack.peek() >= x) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                System.out.print(-1+" ");
            }else{
                System.out.print(stack.peek()+" ");
            }
            stack.push(x);
        }
    }

}

