package bryanze.leetcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author lizelin
 * @date 2024/09/12
 */
public class TYY_T2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] heights = new int[n];
        for (int i = 0; i < n; ++i) {
            heights[i] = scanner.nextInt();
        }
        System.out.println(minChaosDegree(heights));
    }

    private static int minChaosDegree(int[] heights) {
        int n = heights.length;
        if (n <= 2) return 0; // 如果只有1或2个鱼缸，则混乱度总是0

        // 计算原始混乱度
        int originalChaos = 0;
        for (int i = 1; i < n; ++i) {
            originalChaos += Math.abs(heights[i] - heights[i - 1]);
        }

        // 寻找两个最大的高度差
        int[] diffs = new int[n - 1];
        for (int i = 1; i < n; ++i) {
            diffs[i - 1] = Math.abs(heights[i] - heights[i - 1]);
        }
        Arrays.sort(diffs);

        // 尝试消除两个最大的高度差
        int chaosAfterAdjustment = originalChaos - diffs[n - 2] - diffs[n - 3];

        return chaosAfterAdjustment;
    }
}
