package bryanze.leetcode;

import java.util.Arrays;

/**
 * 给你一个二维整数数组 envelopes ，其中 envelopes[i] = [wi, hi] ，表示第 i 个信封的宽度和高度。
 * 当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 * 请计算 最多能有多少个 信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 * 注意：不允许旋转信封。
 *
 * @author lizelin
 * @date 2023/12/06
 */
public class Leetcode354 {
    public int maxEnvelopes(int[][] envelopes) {

        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return -(a[1] - b[1]);
            }
        });

//        for (int[] envelope : envelopes) {
//            System.out.print(Arrays.toString(envelope) + "\t");
//        }
//        System.out.println();

//        int count = 1;
//        int j;

//        for (int i = 0; i < envelopes.length; i = j) {
//
//            for (j = i + 1; j < envelopes.length; j++) {
//                if (envelopes[j][0] > envelopes[i][0] && envelopes[j][1] > envelopes[i][1]) {
//                    count++;
//                    break;
//                }
//            }

//        }
        int[] height = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            height[i] = envelopes[i][1];
        }

        return lengthOfLIS(height);

    }

    /**
     * 返回数组中最长递增子序列的长度(LIS)
     *
     * @param height 数组
     * @return 返回数组中最长递增子序列的长度(LIS)
     */
    private int lengthOfLIS(int[] height) {

        int piles = 0, n = height.length;
        int[] top = new int[n];

        for (int i = 0; i < n; i++) {

            // 要处理的扑克牌
            int poker = height[i];
            int left = 0, right = piles;

            // 二分查找插入位置
            while (left < right) {

                int mid = (left + right) / 2;

                if (top[mid] >= poker) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            if (left == piles) {
                piles++;
            }
            // 把这张牌放到牌堆顶
            top[left] = poker;

        }
        // 牌堆数就是 LIS 长度
        return piles;
    }

    public static void main(String[] args) {
        int[][] envelopes = new int[][]{{2, 100}, {3, 200}, {4, 300}, {5, 500},
                {5, 400}, {5, 250}, {6, 370}, {6, 360}, {7, 380}};
        System.out.println(new Leetcode354().maxEnvelopes(envelopes));
//        System.out.println(envelopes.length);
//        System.out.println(envelopes[0].length);
    }
}
