package bryanze.leetcode;


import java.util.Scanner;

/**
 * 薯条哥有一个长度为n且值都为0的数组a。对于这个数组薯条哥每次操作可以选择一个区间[l,r]，
 * 对于[l,r]上的每一个数薯条哥必须让其加一或者乘二
 * (元素之间操作独立，可以选择一些元素乘二，一些元素加一，但是区间内每个元素都要操作)。
 * 薯条哥还有一个目标数组b，薯条哥想知道对于初始数组a来说，其最少操作多少次可以将其变为b呢。
 * <p>
 * 输入描述
 * 第一行为t，表示有t(1≤t≤10)组数据
 * 接下来有2×t行，每数据的组第一行为一个n(1≤n≤10的5次方)
 * 第二行为n整数，表示目标数组的元素bi(1≤bi≤10的9次方)
 * 保证所有的测试样例的n之和不超过10的5次方
 * <p>
 * 输出描述
 * 输出为t行，每行为一组答案表示薯条哥的最小操作次数。
 *
 * @author lizelin
 * @date 2024/08/11
 */
public class JD810_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[] b = new int[n];
            int[] operation = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = sc.nextInt();
                operation[i] = dfs(b[i]);
            }
            int res = operation[0];
            for (int i = 1; i < n; i++) {
                res += Math.max(0, operation[i] - operation[i - 1]);
            }

            System.out.println(res);
        }
    }

    private static int dfs(int num) {
        int count = 0;
        while (num > 0) {
            if ((num & 1) == 1) {
                num /= 2;
            } else {
                num--;
            }
            count++;
        }
        return count;
    }
}
