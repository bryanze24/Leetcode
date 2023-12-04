package bryanze.leetcode;

/**
 * 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，
 * 短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
 * 字母和数字都属于字母数字字符。
 * 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
 */

public class Leetcode125 {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^0-9a-zA-Z]", "");
        String str = s.toLowerCase();
        char[] array = str.toCharArray();
        int slow = 0;
        int fast = array.length - 1;

        while (slow < fast) {
            if (array[slow] != array[fast]) {
                return false;
            }
            slow++;
            fast--;

        }
        return true;

    }

    public static void main(String[] args) {
        String s = "";
        System.out.println(new Leetcode125().isPalindrome(s));
    }
}
