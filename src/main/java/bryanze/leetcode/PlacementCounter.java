package bryanze.leetcode;

import java.util.Scanner;

/**
 * @author lizelin
 * @date 2024/04/06
 */
public class PlacementCounter {

    public static int countPlacements(int x, int y) {
        int[][] matrix = new int[3][3];
        return placeAnimals(matrix, 0, x, y);
    }

    private static int placeAnimals(int[][] matrix, int pos, int dogs, int cats) {
        if (dogs < 0 || cats < 0) return 0; // 如果狗或猫的数量小于0，则返回0
        if (pos == 9) return dogs == 0 && cats == 0 ? 1 : 0; // 如果已遍历完所有位置，并且狗和猫都放完，则找到一种方案

        int row = pos / 3;
        int col = pos % 3;
        int placements = placeAnimals(matrix, pos + 1, dogs, cats); // 尝试不在当前位置放置动物

        // 尝试放置狗
        if (isValid(matrix, row, col, 1)) {
            matrix[row][col] = 1;
            placements += placeAnimals(matrix, pos + 1, dogs - 1, cats);
            matrix[row][col] = 0; // 回溯
        }

        // 尝试放置猫
        if (isValid(matrix, row, col, 2)) {
            matrix[row][col] = 2;
            placements += placeAnimals(matrix, pos + 1, dogs, cats - 1);
            matrix[row][col] = 0; // 回溯
        }

        return placements;
    }

    private static boolean isValid(int[][] matrix, int row, int col, int animal) {
        int[] dirs = {-1, 0, 1, 0, -1}; // 上、右、下、左
        for (int i = 0; i < 4; i++) {
            int newRow = row + dirs[i];
            int newCol = col + dirs[i + 1];
            if (newRow >= 0 && newRow < 3 && newCol >= 0 && newCol < 3 && matrix[newRow][newCol] == animal) {
                return false; // 相邻位置已有相同动物
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt(); // 狗的数量
        int y = sc.nextInt(); // 猫的数量
        System.out.println(countPlacements(x, y));
    }
}

