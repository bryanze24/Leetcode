package bryanze.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 你有 n 个工作和 m 个工人。给定三个数组： difficulty, profit 和 worker ，其中:
 * difficulty[i] 表示第 i 个工作的难度，profit[i] 表示第 i 个工作的收益。
 * worker[i] 是第 i 个工人的能力，即该工人只能完成难度小于等于 worker[i] 的工作。
 * 每个工人 最多 只能安排 一个 工作，但是一个工作可以 完成多次 。
 * 举个例子，如果 3 个工人都尝试完成一份报酬为 $1 的同样工作，那么总收益为 $3 。
 * 如果一个工人不能完成任何工作，他的收益为 $0 。
 * 返回 在把工人分配到工作岗位后，我们所能获得的最大利润
 *
 * @author lizelin
 * @date 2023/12/25
 */
public class Leetcode826 {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] workers) {
        int[][] difficultyProfit = new int[difficulty.length][2];

        for (int i = 0; i < difficulty.length; i++) {
            difficultyProfit[i][0] = difficulty[i];
            difficultyProfit[i][1] = profit[i];
        }

        Arrays.sort(difficultyProfit, Comparator.comparingInt(a -> a[0]));
        Arrays.sort(workers);

        int result = 0;

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        int curr = 0;
        for (int worker : workers) {
            for (; curr < difficultyProfit.length; curr++) {
                if (worker >= difficultyProfit[curr][0]) {
                    queue.offer(difficultyProfit[curr]);
                } else {
                    break;
                }
            }

            if (!queue.isEmpty()) {
                result += queue.peek()[1];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] difficulty = {68, 35, 52, 47, 86};
        int[] profit = {67, 17, 1, 81, 3};
        int[] worker = {92, 10, 85, 84, 82};
        System.out.println(new Leetcode826().maxProfitAssignment(difficulty, profit, worker));
    }
}
