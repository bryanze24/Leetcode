package bryanze.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
 * 注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s 。
 * 返回一个表示每个字符串片段的长度的列表。
 *
 * @author lizelin
 * @date 2024/06/19
 */
public class Leetcode763 {
    public List<Integer> partitionLabels(String s) {
        int[] pos = new int[26];
        Arrays.fill(pos, -1);
        for (int i = 0; i < s.length(); i++) {
            pos[s.charAt(i) - 'a'] = i;
        }

        int start = 0;
        int maxPos = 0;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            int currentPos = pos[s.charAt(i) - 'a'];
            maxPos = Math.max(maxPos, currentPos);
            if (maxPos == i) {
                ans.add(i - start + 1);
                start = i + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "ababcbacadefegdehijkhlij";
        System.out.println(new Leetcode763().partitionLabels(s));
    }

}
