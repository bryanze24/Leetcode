package bryanze.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 给你一个区间数组 intervals ，其中 intervals[i] = [starti, endi] ，且每个 starti 都 不同 。
 * 区间 i 的 右侧区间 可以记作区间 j ，并满足 startj >= endi ，且 startj 最小化 。注意 i 可能等于 j 。
 * 返回一个由每个区间 i 的 右侧区间 在 intervals 中对应下标组成的数组。
 * 如果某个区间 i 不存在对应的 右侧区间 ，则下标 i 处的值设为 -1
 *
 * @author lizelin
 * @date 2023/12/12
 */
public class Leetcode436 {
    public int[] findRightInterval(int[][] intervals) {

        int length = intervals.length;
        int[] result = new int[length];

        int[][] startIntervals = new int[length][2];

        for (int i = 0; i < length; i++) {
            startIntervals[i][0] = intervals[i][0];
            startIntervals[i][1] = i;
        }

        Arrays.sort(startIntervals, Comparator.comparingInt(a -> a[0]));

        System.out.println(Arrays.deepToString(startIntervals));

        for (int i = 0; i < length; i++) {
            int left = 0;
            int right = length - 1;
            int target = -1;

            while (left <= right) {
                int mid = left + ((right - left) >> 1);
                if (startIntervals[mid][0] >= intervals[i][1]) {
                    target = startIntervals[mid][1];
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            result[i] = target;

        }

        return result;
    }

    public static void main(String[] args) {
        int[][] intervals = {{3, 4}, {2, 3}, {1, 2}};
        int[] interval = new Leetcode436().findRightInterval(intervals);

        System.out.println(Arrays.toString(interval));
    }
}
