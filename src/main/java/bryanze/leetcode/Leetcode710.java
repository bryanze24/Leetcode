package bryanze.leetcode;

import java.util.*;

/**
 * 给定一个整数 n 和一个 无重复 黑名单整数数组 blacklist 。
 * 设计一种算法，从 [0, n - 1] 范围内的任意整数中选取一个 未加入 黑名单 blacklist 的整数。
 * 任何在上述范围内且不在黑名单 blacklist 中的整数都应该有 同等的可能性 被返回。
 * 优化你的算法，使它最小化调用语言 内置 随机函数的次数。
 * <p>
 * 实现 Solution 类:
 * Solution(int n, int[] blacklist) 初始化整数 n 和被加入黑名单 blacklist 的整数
 * int pick() 返回一个范围为 [0, n - 1] 且不在黑名单 blacklist 中的随机整数
 *
 * @author lizelin
 * @date 2023/12/24
 */
public class Leetcode710 {
    int n, m, idx;
    Random random = new Random();
    Set<Integer> s1 = new HashSet<>(), s2 = new HashSet<>();
    Map<Integer, Integer> map = new HashMap<>();

    public Leetcode710(int n, int[] blacklist) {
        this.n = n; m = blacklist.length;
        int max = n - m;

        for (int x : blacklist) {
            if (x < max) s1.add(x);
            else s2.add(x);
        }

        idx = n - m;
    }

    public int pick() {

        int val = random.nextInt(n - m);
        if (!s1.contains(val)) {
            return val;
        }

        if (!map.containsKey(val)) {
            while (s2.contains(idx)) {
                idx++;
            }

            map.put(val, idx++);
        }

        return map.get(val);
    }
}
