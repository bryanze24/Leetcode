package bryanze.leetcode;

import java.util.Arrays;

/**
 * 给你一个整数数组 citations ，其中 citations[i] 表示研究者的第 i 篇论文被引用的次数。
 * 计算并返回该研究者的 h 指数。
 * 根据维基百科上 h 指数的定义：h 代表“高引用次数” ，一名科研人员的 h 指数 是指他（她）至少发表了 h 篇论文，
 * 并且每篇论文 至少 被引用 h 次。如果 h 有多种可能的值，h 指数 是其中最大的那个。
 *
 * @author lizelin
 * @date 2023/12/03
 */
public class Leetcode274 {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int h = 0;
        int length = citations.length - 1;
        while (length >= 0 && citations[length] > h) {
            h++;
            length--;
        }
        return h;
    }

    public int hIndex1(int[] citations) {

        int length = citations.length;

        int[] count = new int[length + 1];

        for (int citation : citations) {
            if (citation >= length) {
                count[length]++;
            } else {
                count[citation]++;
            }
        }

        int total = 0;
        for (int i = length; i >= 0; i--) {
            total += count[i];
            if (total >= i) {
                return i;
            }

        }

        return 0;
    }

    public static void main(String[] args) {
        int[] citations = {100};
        System.out.println(new Leetcode274().hIndex1(citations));
    }
}
