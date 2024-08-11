package bryanze.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 给定长度为N的序列a和非负整数X，找出满足ai+aj=X的(i,j)对的数量
 * <p>
 * 输入描述
 * 第一行给出一个序列长度N(1<=N<=10^.
 * 5)和一个非负整数X(1<=X<=10^9),用空格分隔
 * 在第二行中，给出子序列a的N的元素ai(0<=ai<=10^5),用空格分隔
 * <p>
 * 输出描述
 * 输出一个整数表示最多可以找到多少个满足要求的数对
 *
 * @author lizelin
 * @date 2024/08/11
 */
public class JD810_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        long X = sc.nextLong();
        long res = 0;
        List<Long> list = new ArrayList<>();

        long[] count = new long[100001];
        for (int i = 0; i < N; i++) {
            long num = sc.nextLong();
            list.add(num);
            count[(int) num]++;
        }

        for (long num : list) {
            if (list.contains(X - num)) {
                res += count[(int) (X - num)];
            }
        }

        System.out.println(res);
    }
}
