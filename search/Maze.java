package com.algorithms.search;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @Description:
 * @author: thy
 * @date: 2023年03月20日 22:25
 */

public class Maze {
    public static int[][] maze;
    public static int n, m;
    public static int[][] d;
    public static int[][] move = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    // 如果要看怎么走到终点的路径，我们只需要定义一个prev数组，每次记录之前的点
    public static int[][][] prev;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        maze = new int[n][m];
        d = new int[n][m];
        prev = new int[n][m][2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                maze[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            Arrays.fill(d[i], -1);
        }

        System.out.println(bfs(0, 0));

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(d[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int bfs(int x, int y) {
        d[x][y] = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] p = queue.poll();
                for (int j = 0; j < 4; j++) {
                    if (p[0] + move[j][0] >= 0 && p[0] + move[j][0] < n && p[1] + move[j][1] >= 0 && p[1] + move[j][1] < m &&
                            maze[p[0] + move[j][0]][p[1] + move[j][1]] != 1 && d[p[0] + move[j][0]][p[1] + move[j][1]] == -1) {
                        queue.add(new int[]{p[0] + move[j][0], p[1] + move[j][1]});
                        d[p[0] + move[j][0]][p[1] + move[j][1]] = d[p[0]][p[1]] + 1;
                        prev[p[0] + move[j][0]][p[1] + move[j][1]] = new int[]{p[0], p[1]};
                    }
                }
            }
        }

        int x1 = n - 1, y1 = m - 1;
        while (x1 != 0 || y1 != 0) {
            System.out.println(x1 + " " + y1);
            x1 = prev[x1][y1][0];
            y1 = prev[x1][y1][1];
        }
        return d[n - 1][m - 1];
    }
}
