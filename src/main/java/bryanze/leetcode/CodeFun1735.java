package bryanze.leetcode;

import java.util.*;

/**
 * @author lizelin
 * @date 2024/04/02
 */
public class CodeFun1735 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            int d = sc.nextInt();
            List<Long> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(sc.nextLong());
            }

            Collections.sort(list);
            Collections.reverse(list);
            for (int i = 1; i < list.size(); i++) {
                list.set(i, list.get(i - 1) + list.get(i));
            }

            long ans;
            if (m == 0) {
                ans = list.get(list.size() - 1);
            } else {
                ans = list.get(list.size() - 1) * (-k);
                for (int i = 0; i <= d; i++) {
                    //要删掉的元素和
                    long pre = i > 0 ? list.get(i - 1) : 0;
                    //需要 m 个乘 (-k) 的元素索引位置，有可能 从第i个位置开始取
                    // m 个后的索引 > list.size(),所以取小
                    int j = Math.min(i + m - 1, list.size());
                    ans = Math.max(ans, (-k) * (list.get(j) - pre)
                            + list.get(list.size() - 1) - list.get(j));
                }
            }

            System.out.println(ans);
        }
    }
}
