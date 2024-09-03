package bryanze.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 牛牛开了一家水果店，已知，一个水果恰好可以切成n块(不论大小)，
 * 也只能切成n块，一个顾客，他/她买一盒水果，要求是：这盒水果中的水果块数必须在闭区间[l,r]中。
 * 牛牛只按“个”卖水果，而不是按“块”卖水果，所以，
 * 如果整数个水果并不满足顾客要求，牛牛就不会卖给这位顾客；
 * 而如果存在整数个水果，使得这些水果切成的块数满足顾客要求，
 * 那么，牛牛希望你告诉他，牛牛最少需要切多少个水果，以及最多需要切多少个水果。
 * <p>
 * 输入描述
 * 本题为多组测试数据，第一行输入一个正整数T（1≤T≤1000），代表测试数据的组数。
 * 对于每组测试数据，一行输入三个正整数n,l,r（1≤n≤100;1≤l≤r≤1000）含义如题所述。
 * <p>
 * 输出描述
 * 对于每给测试数据，如果牛牛的水果规则不能满足顾客要求，
 * 则输出-1否则输出两个正整数，依次代表牛牛需要为这位顾客最少切多少个水果，
 * 最多切多少个水果。
 *
 * @author lizelin
 * @date 2024/09/03
 */
public class DW_T1 {
    static List<int[]> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int l = sc.nextInt();
            int r = sc.nextInt();
            list.add(calculate(n, l, r));
        }
        for (int[] ans : list) {
            if (ans[0] == -1) {
                System.out.println(-1);
            } else {
                System.out.println(ans[0] + " " + ans[1]);
            }
        }
    }

    private static int[] calculate(int n, int l, int r) {
        int x_min = (l + n - 1) / n;
        int x_max = r / n;
        if (x_min * n > r) {
            return new int[]{-1, -1};
        } else {
            return new int[]{x_min, x_max};
        }
    }
}
