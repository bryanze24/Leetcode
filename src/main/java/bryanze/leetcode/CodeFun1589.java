package bryanze.leetcode;

import java.util.*;

/**
 * @author lizelin
 * @date 2024/04/10
 */
public class CodeFun1589 {

    static class Pair{
        int x;
        int y;
        int path;

        public Pair(int x, int y, int path) {
            this.x = x;
            this.y = y;
            this.path = path;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }

        public void setPath(int path) {
            this.path = path;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getPath() {
            return path;
        }
    }

    static int[][] array;
    static int res = Integer.MAX_VALUE;
    static int[][] direction = new int[][]{{0, 1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        array = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                array[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            if (array[i][0] == 1) {
                bfs(i, m, n);
            }
        }

        res = res == Integer.MAX_VALUE ? -1 : res;
        System.out.println(res);
    }

    private static void bfs(int i, int m, int n) {
        boolean[][] vis = new boolean[n][m];
        Pair pair = new Pair(i, 0, 0);
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(pair);
        vis[i][0] = true;

        while (!queue.isEmpty()) {
            Pair poll = queue.poll();
            int x = poll.getX();
            int y = poll.getY();
            int path = poll.getPath();

            if (y == m - 1 && array[x][y] == 1){
                res = Math.min(res, path);
            }

            for (int j = 0; j < 3; j++) {
                int xx = x + direction[j][0];
                int yy = y + direction[j][1];
                if (xx >= 0 && xx < n && yy >= 0 && yy < m && !vis[xx][yy] && array[xx][yy] == 1) {
                    queue.offer(new Pair(xx, yy, path + 1));
                    vis[xx][yy] = true;
                }
            }

        }
    }
}
