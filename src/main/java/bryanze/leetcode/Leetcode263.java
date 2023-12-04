package bryanze.leetcode;

/**
 * 丑数 就是只包含质因数 2、3 和 5 的正整数。
 * 给你一个整数 n ，请你判断 n 是否为 丑数 。如果是，返回 true ；否则，返回 false 。
 */

public class Leetcode263 {
    public boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }

        int[] array = {2, 3, 5};
        for (int num : array) {
            while (n % num == 0) {
                n /= num;
            }
        }

        return n == 1;
    }
}
