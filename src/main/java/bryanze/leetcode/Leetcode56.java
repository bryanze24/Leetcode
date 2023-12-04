package bryanze.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 * @author lizelin
 * @date 2023/12/01
 */
public class Leetcode56 {
    public int[][] merge(int[][] intervals) {

        if (intervals.length == 1) {
            return intervals;
        }

        Arrays.sort(intervals, (int[] a, int[] b) -> {
            return a[0] - b[0];
        });
//        System.out.println(Arrays.deepToString(intervals));


        List<int[]> list = new ArrayList<>();

        for (int[] interval : intervals) {
            int left = interval[0];
            int right = interval[1];

            if (list.isEmpty() || list.get(list.size() - 1)[1] < left) {
                list.add(new int[]{left, right});

            } else {
                list.get(list.size() - 1)[1] = Math.max(list.get(list.size() - 1)[1], right);
            }
        }

        return list.toArray(new int[list.size()][]);

    }


    public int[][] merge1(int[][] intervals) {

        if (intervals.length == 1) {
            return intervals;
        }

        Arrays.sort(intervals, (int[] a, int[] b) -> {
            return a[0] - b[0];
        });

        List<int[]> list = new ArrayList<>();

        int j;
        for (int i = 0; i < intervals.length; i = j) {
            int temp = intervals[i][1];
            j = i + 1;

            while (j < intervals.length && intervals[j][0] <= temp) {
                temp = Math.max(temp, intervals[j][1]);
                j++;
            }

            list.add(new int[]{intervals[i][0], temp});
//            i = j;

        }

        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] merge = new Leetcode56().merge1(intervals);
        System.out.println(Arrays.deepToString(merge));
    }
}
