package bryanze.algorithm.recursion;

/**
 * 华为面试题
 * @author lizelin
 * @date 2024/05/16
 */
public class Main {
    public String method(String str) {
        if (str == null) {
            return null;
        }

        char[] cs = str.toCharArray();
        int length = cs.length;
        if (length <= 1) {
            return str;
        }

        boolean[][] dp = new boolean[length][length];
        int maxLength = 1;
        int begin = 0;
        for (int i = length - 1; i >= 0 ; i--) {
            for (int j = i; j < length; j++) {
                int curr = j - i + 1;
                if (curr <= 2) {
                    dp[i][j] = cs[i] == cs[j];
                } else {
                    dp[i][j] = dp[i + 1][j-1] && (cs[i] == cs[j]);
                }

                if (dp[i][j] && curr > maxLength) {
                    maxLength = curr;
                    begin = i;
                }
            }
        }
        return new String(cs, begin, maxLength);
    }

    public static void main(String[] args) {
//        String str = "aba";
//        String str = "baac";
//        String str = "bsdf";
//        String str = "abaclaa";
//        String str = "a";
        String str = "abacdc";
        System.out.println(new Main().method(str));
    }

}
