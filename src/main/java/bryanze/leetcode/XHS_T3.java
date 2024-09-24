package bryanze.leetcode;

import java.util.*;

/**
 * @author lizelin
 * @date 2024/09/08
 */
public class XHS_T3 {
    // 计算f(x)，即x的二进制表示中1的个数
    public static int f(int x) {
        return Integer.bitCount(x);
    }

    // 计算g(x)，即比x大的最小的具有相同二进制1个数的数
    public static int g(int x) {
        int countOnes = f(x);
        int y = x + 1;
        while (f(y) != countOnes) {
            y++;
        }
        return y;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 输入点赞数量
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        // 用来存储每个点赞数及其g(x)
        Map<Integer, Integer> gMap = new HashMap<>();

        // 存储f(x)值相同的点赞数量
        Map<Integer, List<Integer>> sameOnesMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int fVal = f(a[i]);
            sameOnesMap.computeIfAbsent(fVal, k -> new ArrayList<>()).add(a[i]);
        }

        // 计算最长精选队列长度
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            int length = 1;
            int current = a[i];
            while (true) {
                int next = g(current);
                if (!sameOnesMap.containsKey(f(next)) || !sameOnesMap.get(f(next)).contains(next)) {
                    break;
                }
                current = next;
                length++;
            }
            maxLength = Math.max(maxLength, length);
        }

        // 输出最长精选队列的长度
        System.out.println(maxLength);
    }
}
