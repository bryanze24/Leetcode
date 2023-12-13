package bryanze.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 有一些球形气球贴在一堵用 XY 平面表示的墙面上。墙面上的气球记录在整数数组 points ，
 * 其中points[i] = [xstart, xend] 表示水平直径在 xstart 和 xend之间的气球。
 * 你不知道气球的确切 y 坐标。一支弓箭可以沿着 x 轴从不同点 完全垂直 地射出。在坐标 x 处射出一支箭，
 * 若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足  xstart ≤ x ≤ xend，则该气球会被 引爆 。
 * 可以射出的弓箭的数量 没有限制 。 弓箭一旦被射出之后，可以无限地前进。
 * 给你一个数组 points ，返回引爆所有气球所必须射出的 最小 弓箭数 。
 * @author lizelin
 * @date 2023/12/13
 */
public class Leetcode452 {
    public int findMinArrowShots(int[][] points) {

        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });

        System.out.println(Arrays.deepToString(points));

        int count = 1;
        int prev = points[0][1];

        for (int i = 1; i < points.length; i++) {

            if (points[i][0] <= prev) {
                prev = Math.min(prev, points[i][1]);
            } else {
                prev = points[i][1];
                count++;
            }

        }

        return count;
    }

    public static void main(String[] args) {
//        int[][] points = {{1, 6}, {2, 8}, {3, 8}, {7, 12}, {6, 12}, {10, 16}, {7, 11}};
        int[][] points = {{-2147483646, -2147483645}, {2147483646, 2147483647}};
        System.out.println(new Leetcode452().findMinArrowShots(points));
    }
}
