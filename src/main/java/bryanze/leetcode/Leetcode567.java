package bryanze.leetcode;


import java.util.Arrays;

/**
 * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。
 * 如果是，返回 true ；否则，返回 false 。
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 *
 * @author lizelin
 * @date 2024/08/10
 */
public class Leetcode567 {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a']++;
        }

        int left = 0, right = s1.length();
        int[] temp = new int[26];

        for (int i = left; i < right; i++) {
            temp[s2.charAt(i) - 'a']++;
        }

        while (right < s2.length()) {

            if (Arrays.equals(temp, count)) {
                return true;
            } else {
                temp[s2.charAt(left) - 'a']--;
            }

            temp[s2.charAt(right) - 'a']++;
            right++;
            left++;

        }

        return Arrays.equals(count, temp);

    }

    public static void main(String[] args) {
        System.out.println(new Leetcode567().checkInclusion("ab", "eidboaoo"));
    }
}
