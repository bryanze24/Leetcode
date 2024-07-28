package bryanze.leetcode;

/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，
 * 返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。
 *
 * @author lizelin
 * @date 2024/07/28
 */
public class Leetcode43 {
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }

        String res = "0";
        for (int i = num2.length() - 1; i >= 0; i--) {
            //表示相乘向前进位的数字
            int carry = 0;

            //保存num2的第i位与num1相乘的结果，但是是逆序，使用时需要反转
            StringBuilder sb = new StringBuilder();

            //需要在后补0的个数
            for (int j = 0; j < num2.length() - 1 - i; j++) {
                sb.append(0);
            }

            int n2 = num2.charAt(i) - '0';  // num2的第i位
            //相乘
            for (int j = num1.length() - 1; j >= 0 || carry != 0; j--) {
                int n1 = j < 0 ? 0 : num1.charAt(j) - '0';
                int mul = n1 * n2 + carry;
                int temp = mul % 10;
                sb.append(temp);
                carry = mul / 10;
            }

            //将当前计算结果与前一步计算结果相加
            res = add(res, sb.reverse().toString());
        }

        return res;
    }

    /**
     * 当前计算结果与前一步计算结果相加
     *
     * @param str1 前一步计算结果
     * @param str2 当前步计算结果
     * @return 相加结果，但是返回值需要进行一步反转
     */
    private String add(String str1, String str2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = str1.length() - 1, j = str2.length() - 1;
             i >= 0 || j >= 0 || carry != 0; i--, j--) {
            int x = i < 0 ? 0 : str1.charAt(i) - '0';
            int y = j < 0 ? 0 : str2.charAt(j) - '0';
            int mul = x + y + carry;
            sb.append(mul % 10);
            carry = mul / 10;
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode43().multiply("123", "456"));
    }
}
