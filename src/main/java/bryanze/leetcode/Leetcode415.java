package bryanze.leetcode;

/**
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
 * 你不能使用任何內建的用于处理大整数的库（比如 BigInteger），
 * 也不能直接将输入的字符串转换为整数形式。
 *
 * @author lizelin
 * @date 2024/07/31
 */
public class Leetcode415 {
    public String addStrings(String num1, String num2) {
        if ("0".equals(num1)) {
            return num2;
        } else if ("0".equals(num2)) {
            return num1;
        }

        int carry = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carry != 0; j--, i--) {
            int x = i < 0 ? 0 : num1.charAt(i) - '0';
            int y = j < 0 ? 0 : num2.charAt(j) - '0';
            int add = x + y + carry;
            sb.append(add % 10);
            carry = add / 10;
        }

        return sb.reverse().toString();
    }
}
