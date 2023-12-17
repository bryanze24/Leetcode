package bryanze.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 假设 力扣（LeetCode）即将开始 IPO 。为了以更高的价格将股票卖给风险投资公司，
 * 力扣 希望在 IPO 之前开展一些项目以增加其资本。 由于资源有限，
 * 它只能在 IPO 之前完成最多 k 个不同的项目。帮助 力扣 设计完成最多 k 个不同项目后得到最大总资本的方式。
 * 给你 n 个项目。对于每个项目 i ，它都有一个纯利润 profits[i] ，和启动该项目需要的最小资本 capital[i] 。
 * 最初，你的资本为 w 。当你完成一个项目时，你将获得纯利润，且利润将被添加到你的总资本中。
 * 总而言之，从给定项目中选择 最多 k 个不同项目的列表，以 最大化最终资本 ，并输出最终可获得的最多资本。
 * 答案保证在 32 位有符号整数范围内。
 *
 * @author lizelin
 * @date 2023/12/17
 */
public class leetcode502 {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int length = capital.length;
        int[][] array = new int[length][2];

        for (int i = 0; i < length; i++) {
            array[i][0] = capital[i];
            array[i][1] = profits[i];
        }

        Arrays.sort(array, Comparator.comparingInt(a -> a[0]));

        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);

        int curr = 0;
        for (int i = 0; i < k; i++) {
            while (curr < length && array[curr][0] <= w) {
                queue.offer(array[curr][1]);
                curr++;
            }

            if (!queue.isEmpty()) {
                w += queue.poll();
            } else {
                break;
            }
        }

        return w;
    }


    public int findMaximizedCapital1(int k, int w, int[] profits, int[] capital){
        // 规范化一下 k，使其小于等于 n
        k = Math.min(k, profits.length);

        // 检测是否可以加速
        boolean canSpeedUp = canSpeedUp(w, capital);

        if (canSpeedUp) {
            // 可以加速，直接按利润排序取前 k 大的就可以了
            return speedUp(k, w, profits);
        }

        // 不能加速，每次取能力范围内的最大利润，取 k 轮
        return normal(k, w, profits, capital);
    }

    private boolean canSpeedUp(int w, int[] capital) {
        for (int j : capital) {
            // 如果拥有的资本不能投资所有项目，说明不能加速
            if (w < j) {
                return false;
            }
        }
        return true;
    }

    private int speedUp(int k, int w, int[] profits) {
        // 取前 k 大的利润
        Arrays.sort(profits);
        for (int i = profits.length - 1; i >= profits.length - k; i--) {
            w += profits[i];
        }
        return w;
    }

    private int normal(int k, int w, int[] profits, int[] capital) {
        // 共进行 K 轮投资
        for (int i = 0; i < k; i++) {
            int maxIndex = -1;
            int maxProfit = -1;

            for (int j = 0; j < profits.length; j++) {
                // 每次选能力范围内利润最大的
                if (w >= capital[j] && profits[j] > maxProfit) {
                    maxProfit = profits[j];
                    maxIndex = j;
                }
            }

            // 如果这一轮没有可投资的项目了，下一轮肯定也没有，直接退出循环
            if (maxIndex == -1) {
                break;
            }

            // 拥有的资本加上最大利润
            w += maxProfit;

            // 将投资过的项目的成本修改为无限大，这样下次就不会再投资了
            capital[maxIndex] = Integer.MAX_VALUE;

        }

        return w;
    }

    public static void main(String[] args) {
        int[] profits = new int[]{1, 2, 3};
        int[] capital = new int[]{0, 1, 1};
        System.out.println(new leetcode502().findMaximizedCapital(2, 0, profits, capital));
    }
}
