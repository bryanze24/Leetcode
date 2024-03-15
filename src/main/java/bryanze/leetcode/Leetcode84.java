package bryanze.leetcode;

import java.util.LinkedList;

/**
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 * @author lizelin
 * @date 2024/03/15
 */
public class Leetcode84 {
    public int largestRectangleArea(int[] heights) {

        int length = heights.length;
        int[] newHeights = new int[length + 2];
        newHeights[0] = 0;
        newHeights[length + 1] = 0;
        System.arraycopy(heights, 0, newHeights, 1, length);

        heights = newHeights;

        LinkedList<Integer> stack = new LinkedList<>();

        int ans = 0;
        for (int i = 0; i < length + 2; i++) {
            if (stack.isEmpty() || heights[i] > heights[stack.peek()]) {
                stack.push(i);
            } else if (heights[i] == heights[stack.peek()]) {
                stack.pop();
                stack.push(i);
            } else {
                while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                    int mid = stack.pop();
                    int left = stack.peek();
                    int w = i - left - 1;
                    int h = heights[mid];
                    ans = Math.max(ans, w * h);
                }

                stack.push(i);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] heights = new int[]{2, 1, 5, 6, 2, 3};
        System.out.println(new Leetcode84().largestRectangleArea(heights));
    }

}
