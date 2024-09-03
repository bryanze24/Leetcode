package bryanze.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 牛牛现在在一个大小为N×M的网格中（用B代表牛牛的位置），
 * 现在牛牛打算到达网格中的*点，但是网格有些单元格中有许多围墙使牛牛无法通过。
 * 庆幸的是，牛牛有3个炸弹可以将墙炸毁以至于他可以通过此处，
 * 牛牛每一移动只能移动到没有围墙的单元格中且只能移动至相邻的格子中，
 * 每一移动只能移动一步，使用炸弹时也算作移动一步。
 * 现在牛牛想知道他最少移动多少步才能到达*点；
 * <p>
 * 输入描述
 * 输入的第一行给出网格的大小N，M(1≤ N,M≤20);
 * 随后N行M列输入网格的信息；
 * 网格中的墙使用W表示；
 * 可自由通过的单元格用“.”表示；“*”表示牛牛的目的地；B表示牛牛的起点;
 * 数据保证起点和目的地都只有一个。
 * <p>
 * 输出描述:
 * 输出最少移动多少步才能到达*点；若无法到达，输出-1
 *
 * @author lizelin
 * @date 2024/09/03
 */
public class DW_T3 {

    static class Niu {
        int x;
        int y;
        int step;
        int bombUsedNum;

        public Niu(int x, int y, int step, int bombUsedNum) {
            this.x = x;
            this.y = y;
            this.step = step;
            this.bombUsedNum = bombUsedNum;
        }
    }

    static int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();

        char[][] grid = new char[N][M];
        boolean[][][] visited = new boolean[N][M][4];
        Niu start = null;
        Niu des = null;
        for (int i = 0; i < N; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < M; j++) {
                grid[i][j] = str.charAt(j);
                if (grid[i][j] == 'B') {
                    start = new Niu(i, j, 0, 0);
                } else if (grid[i][j] == '*') {
                    des = new Niu(i, j, 0, 0);
                }
            }
        }

        LinkedList<Niu> queue = new LinkedList<>();
        queue.add(start);
        visited[start.x][start.y][0] = true;

        List<Integer> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            Niu cur = queue.poll();
            if (cur.x == des.x && cur.y == des.y) {
                ans.add(cur.step);
            }

            for (int i = 0; i < 4; i++) {
                int x = cur.x + dir[i][0];
                int y = cur.y + dir[i][1];
                if (x >= 0 && x < N && y >= 0 && y < M) {
                    if (grid[x][y] == '.' || grid[x][y] == '*') {
                        if (!visited[x][y][cur.bombUsedNum]) {
                            visited[x][y][cur.bombUsedNum] = true;
                            queue.offer(new Niu(x, y, cur.step + 1, cur.bombUsedNum));
                        }
                    } else if (grid[x][y] == 'W' && cur.bombUsedNum < 3) {
                        if (!visited[x][y][cur.bombUsedNum + 1]) {
                            visited[x][y][cur.bombUsedNum + 1] = true;
                            queue.offer(new Niu(x, y, cur.step + 2, cur.bombUsedNum + 1));
                        }
                    }
                }

            }
        }
        if (ans.isEmpty()) {
            System.out.println(-1);
        } else {
            int result = Integer.MAX_VALUE;
            for (int i = 0; i < ans.size(); i++) {
                result = Math.min(result, ans.get(i));
            }
            System.out.println(result);
        }

    }
}
