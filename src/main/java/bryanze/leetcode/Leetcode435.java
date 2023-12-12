package bryanze.leetcode;

import java.util.Arrays;

/**
 * 给定一个区间的集合 intervals ，其中 intervals[i] = [starti, endi] 。
 * 返回 需要移除区间的最小数量，使剩余区间互不重叠 。
 * @author lizelin
 * @date 2023/12/12
 */
public class Leetcode435 {
    public int eraseOverlapIntervals(int[][] intervals) {

        if (intervals.length == 1) {
            return 0;
        }

        Arrays.sort(intervals, (a, b) -> {
            return a[1] - b[1];
        });


        int length = intervals.length;
        int right = intervals[0][1];
        int count = 1;

        for (int i = 1; i < length; i++) {
            if (intervals[i][0] >= right) {
                right = intervals[i][1];
                count++;
            }
        }

        return length - count;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {1, 2}, {1, 2}, {1, 2}};
        System.out.println(new Leetcode435().eraseOverlapIntervals(intervals));
    }
}
