package bryanze.leetcode;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢?
 *
 * @author lizelin
 * @date 2024/06/19
 */
public class Leetcode70 {
    public int climbStairs(int n) {
        int a = 0; //f(n - 2)
        int b = 1; //f(n - 1)
        int sum = 1; //f(n)
        for (int i = 1; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode70().climbStairs(4));
    }
}
