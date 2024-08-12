package bryanze.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 小美有一个长度为 n 的数组 a1,a2,....,an ，他可以对数组进行如下操作：
 * ● 删除第一个元素 a1，同时数组的长度减一，花费为 x。
 * ● 删除整个数组，花费为 k*MEX(a) （其中 MEX(a) 表示 a 中未出现过的最小非负整数。
 * 例如 [0,1,2,4] 的 MEX 为 3 ）。
 * 小美想知道将 a 数组全部清空的最小代价是多少，请你帮帮他吧。
 * <p>
 * 输入描述
 * 每个测试文件均包含多组测试数据。第一行输入一个整数 T(1<=T<=1000) 代表数据组数，每组测试数据描述如下：
 * 第一行输入三个正整数 n,k,x(1<=n<=2*10^5, 1<=k,x<=10^9)
 * 代表数组中的元素数量、删除整个数组的花费系数、删除单个元素的花费。
 * 第二行输入 n 个整数 a1,a2,....,an(0<=ai<=n)，表示数组元素。
 * 除此之外，保证所有的 n 之和不超过 2*10^5。
 * <p>
 * 输出描述
 * 对于每一组测试数据，在一行上输出一个整数表示将数组中所有元素全部删除的最小花费。
 *
 * @author lizelin
 * @date 2024/08/10
 */
public class MT810_2 {
    static final int N = 200000 + 10;
    static int T, n, k, x;
    static int[] a = new int[N];
    static Scanner scanner = new Scanner(System.in);

    public static void solve() {
        n = scanner.nextInt();
        k = scanner.nextInt();
        x = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
        }
        long res = Long.MAX_VALUE;  // 初始化最小花费为一个极大值
        int mex = 0;  // 表示数组a中未出现过的最小非负整数
        Set<Integer> numsSet = new HashSet<>();  // 存储a数组的所有元素
        for (int i = n; i >= 0; i--) {
            while (numsSet.contains(mex)) {  // 当前while循环最多只会执行n次
                mex++;
            }
            res = Math.min(res, (long) i * x + (long) mex * k);
            numsSet.add(a[i]);
        }
        System.out.print(res + " ");
    }

    public static void main(String[] args) {

        T = scanner.nextInt();
        while (T-- > 0) {
            solve();
        }
    }
}
