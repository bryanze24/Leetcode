package bryanze.leetcode;

/**
 * 你总共有 n 枚硬币，并计划将它们按阶梯状排列。对于一个由 k 行组成的阶梯，其第 i 行必须正好有 i 枚硬币。
 * 阶梯的最后一行 可能 是不完整的。
 * 给你一个数字 n ，计算并返回可形成 完整阶梯行 的总行数。
 *
 * @author lizelin
 * @date 2024/03/25
 */
public class Leetcode441 {
    public int arrangeCoins(int n) {

        long l = 1, r = n;
        while (l < r) {
            long mid = (r + l + 1) >> 1;
            long need = (mid * (mid + 1)) >> 1;
            if (need > n) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }

        return (int)l;

    }

    public static void main(String[] args) {
        System.out.println(new Leetcode441().arrangeCoins(8));
    }

}
