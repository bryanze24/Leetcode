package bryanze.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author lizelin
 * @date 2024/04/01
 */
public class CodeFun1734 {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int m;
    static int n;
    static char[][] geo;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        geo = new char[n][m];
        for (int i = 0; i < n; i++) {
            geo[i] = sc.next().toCharArray();
        }

//        String[] split = sc.nextLine().split(" ");
        int sx = sc.nextInt() - 1;
        int sy = sc.nextInt() - 1;
        int mx = sc.nextInt() - 1;
        int my = sc.nextInt() - 1;
        int ex = sc.nextInt() - 1;
        int ey = sc.nextInt() - 1;

        int ans = bfs(sx, sy, mx, my) + bfs(mx, my, ex, ey);
        System.out.println(ans);

    }

    public static int bfs(int sx, int sy, int ex, int ey) {
        int[][] temp = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(temp[i], -1);
        }

        Queue<int[]> queue = new LinkedList<>();
        temp[sx][sy] = 0;
        queue.offer(new int[]{sx, sy});

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0], y = curr[1];

            if (x == ex && y == ey) {
                break;
            }

            for (int i = 0; i < 4; i++) {
                int dxx = x + dx[i];
                int dyy = y + dy[i];

                if (dxx >= 0 && dxx < n && dyy >= 0 && dyy < m
                        && temp[dxx][dyy] == -1 && geo[dxx][dyy] == '.') {
                    temp[dxx][dyy] = temp[x][y] + 1;
                    queue.offer(new int[]{dxx, dyy});
                }
            }

        }


        return temp[ex][ey];
    }
}
