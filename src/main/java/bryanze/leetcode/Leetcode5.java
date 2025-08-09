package bryanze.leetcode;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串
 *
 * @author lizelin
 * @date 2024/09/24
 */
public class Leetcode5 {
    public String longestPalindrome(String s) {
        int length = s.length();
        boolean[][] dp = new boolean[length][length];

        int max = 1;
        int start = 0;
        for (int i = length - 1; i >= 0; i--) {
            dp[i][i] = true;
            for (int j = i + 1; j < length; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 1) {
                        dp[i][j] = true;
                    } else {
                        if (dp[i + 1][j - 1]) {
                            dp[i][j] = true;
                        }
                    }
                }
                if (dp[i][j] && (j - i + 1 > max)) {
                    start = i;
                    max = j - i + 1;
                }
            }
        }
        return s.substring(start, start + max);
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode5().longestPalindrome("babad"));
        String str1 = "abc";
        String str2 = new String("abc");
        String str3 = "a";
        String str4 = "bc";
        String str6 = "a" + "bc";
        String str5 = str3 + str4;
        System.out.println(str1 == str2);
        System.out.println(str1 == str5);
        System.out.println(str2 == str5);
        System.out.println(str1 == str6);
        System.out.println(test());

    }

    private static int test() {

        try{
            int a = 1 / 0;
            return 1;
        } catch (Exception e){
            System.exit(1);
            return 2;

        } finally {
            return 3;
        }

    }
}
