package bryanze.leetcode;

import java.util.Random;

/**
 * 给定一个由非重叠的轴对齐矩形的数组 rects ，其中 rects[i] = [ai, bi, xi, yi] 表示 (ai, bi)
 * 是第 i 个矩形的左下角点，(xi, yi) 是第 i 个矩形的右上角点。设计一个算法来随机挑选一个被某一矩形覆盖的整数点。
 * 矩形周长上的点也算做是被矩形覆盖。所有满足要求的点必须等概率被返回。
 * 在给定的矩形覆盖的空间内的任何整数点都有可能被返回。
 * 请注意 ，整数点是具有整数坐标的点。
 * 实现 Solution 类:
 * Solution(int[][] rects) 用给定的矩形数组 rects 初始化对象。
 * int[] pick() 返回一个随机的整数点 [u, v] 在给定的矩形所覆盖的空间内
 *
 * @author lizelin
 * @date 2024/03/27
 */
public class Leetcode497 {

    private int[][] rects;
    private int[] sum;
    Random random = new Random();
    private int length;

    public Leetcode497(int[][] rects) {
        this.rects = rects;
        length = rects.length;
        sum = new int[length + 1];
        for (int i = 1; i < length + 1; i++) {
            sum[i] = sum[i - 1] +
                    (rects[i - 1][2] - rects[i - 1][0] + 1) * (rects[i - 1][3] - rects[i - 1][1] + 1);


        }
    }

    public int[] pick() {
        int val = random.nextInt(sum[length]) + 1; // [0, sum(length)) -> [1, sum(length) + 1)
        int left = 0, right = length;
        while (left < right) {
            int mid = ((right - left) >> 1) + left;
            if (sum[mid] >= val) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        int[] cur = rects[right - 1];
        int x = random.nextInt(cur[2] - cur[0] + 1) + cur[0];
        int y = random.nextInt(cur[3] - cur[1] + 1) + cur[1];
        return new int[]{x, y};
    }

}
