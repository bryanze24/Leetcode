package bryanze.leetcode;

import java.util.Arrays;

/**
 * 冬季已经来临。 你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。
 * 在加热器的加热半径范围内的每个房屋都可以获得供暖。
 * 现在，给出位于一条水平线上的房屋 houses 和供暖器 heaters 的位置，
 * 请你找出并返回可以覆盖所有房屋的最小加热半径。
 * 注意：所有供暖器 heaters 都遵循你的半径标准，加热的半径也一样。
 *
 * @author lizelin
 * @date 2023/12/14
 */
public class Leetcode475 {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);

        int result = 0;

        for (int i = 0, j = 0; i < houses.length; i++) {

            //将距离初始化为 houses[i]−heaters[j]
            int distance = Math.abs(houses[i] - heaters[j]);

            /*
            对于每个房屋houses[i]，只要heaters[j]和当前房屋的距离大于等于heaters[j+1]和当前房屋的距离，
            则j = j + 1直到 j 到达有右边界或者条件不成立，此时heaters[j]为距离houses[i]最近的供暖器
             */

            while (j < heaters.length - 1 &&
                    Math.abs(houses[i] - heaters[j]) >= Math.abs(houses[i] - heaters[j + 1])) {

                j++;
                distance = Math.min(distance, Math.abs(houses[i] - heaters[j]));
            }

            result = Math.max(result, distance);

        }

        return result;
    }

    public static void main(String[] args) {
        int[] houses = new int[]{1, 2, 3, 4};
        int[] heaters = new int[]{1, 4};
        System.out.println(new Leetcode475().findRadius(houses, heaters));
    }

}
