package bryanze.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 给你一个长度为 n 的整数数组 score ，其中 score[i] 是第 i 位运动员在比赛中的得分。所有得分都 互不相同 。
 * 运动员将根据得分 决定名次 ，其中名次第 1 的运动员得分最高，名次第 2 的运动员得分第 2 高，依此类推。
 * 运动员的名次决定了他们的获奖情况：
 * 名次第 1 的运动员获金牌 "Gold Medal" 。
 * 名次第 2 的运动员获银牌 "Silver Medal" 。
 * 名次第 3 的运动员获铜牌 "Bronze Medal" 。
 * 从名次第 4 到第 n 的运动员，只能获得他们的名次编号（即，名次第 x 的运动员获得编号 "x"）。
 * 使用长度为 n 的数组 answer 返回获奖，其中 answer[i] 是第 i 位运动员的获奖情况。
 * @author lizelin
 * @date 2023/12/05
 */
public class Leetcode506 {
    public String[] findRelativeRanks(int[] score) {

        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return -(a[1] - b[1]);
            }
        });

        for (int i = 0; i < score.length; i++) {
            queue.offer(new int[]{i, score[i]});
        }

        String[] result = new String[score.length];

        int count = 0;
        while (!queue.isEmpty()) {
            count++;
            int[] polled = queue.poll();
//            System.out.printf("%d %d", polled[0], polled[1]);
//            System.out.println();
            if (count == 1) {
                result[polled[0]] = "Gold Medal";
            } else if (count == 2) {
                result[polled[0]] = "Silver Medal";

            } else if (count == 3) {
                result[polled[0]] = "Bronze Medal";

            } else {
                result[polled[0]] = count + "";
            }

        }

        return result;
    }

    public static void main(String[] args) {
        int[] score = {10, 3, 8, 9, 4};
        String[] result = new Leetcode506().findRelativeRanks(score);

        for (String str : result) {
            System.out.println(str);
        }
    }
}
