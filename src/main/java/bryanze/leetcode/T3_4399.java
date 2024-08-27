package bryanze.leetcode;

import com.sun.imageio.plugins.gif.GIFImageReader;

import javax.xml.transform.Source;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author lizelin
 * @date 2024/08/26
 */
public class T3_4399 {

    static int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int count = 0;
    static int result = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        String substring = string.substring(15, string.length() - 1);
        String[] split = substring.split(",");
        int[][] navalBattle = new int[split.length][];
        boolean flag = true;
        for (int i = 0; i < split.length; i++) {
            String[] splitStr = split[i].substring(0, split[i].length() - 1).split(", ");
            for (int j = 0; j < splitStr.length; j++) {
                int num = Integer.parseInt(splitStr[j]);
                if (num == 0) {
                    flag = false;
                }
                navalBattle[i][j] = num;
            }
        }

        int n = navalBattle.length;
        boolean[][] visit = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j] && navalBattle[i][j] == 1) {
                    count = 0;
                    BFS(navalBattle, visit, i, j);
                    result = Math.max(result, count);
                }

            }

        }

        if (flag) {
            System.out.println(result);
        } else {
            System.out.println(result + 1);
        }

    }

    private static void BFS(int[][] navalBattle, boolean[][] visit, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        visit[i][j] = true;
        count++;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int k = 0; k < 4; k++) {
                int nextX = cur[0] + dir[k][0];
                int nextY = cur[1] + dir[k][1];
                if (nextX >= 0 && nextX < navalBattle.length && nextY >= 0
                        && nextY < navalBattle.length
                        && !visit[nextX][nextY] && navalBattle[nextX][nextY] == 1) {
                    queue.offer(new int[]{nextX, nextY});
                    visit[nextX][nextY] = true;
                    BFS(navalBattle, visit, nextX, nextY);
                }

            }

        }

    }

}
