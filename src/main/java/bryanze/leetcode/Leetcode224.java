package bryanze.leetcode;

import java.util.LinkedList;

/**
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 * 注意:不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。
 *
 * @author lizelin
 * @date 2024/09/22
 */
public class Leetcode224 {
    public int calculate(String s) {
        int len = s.length();
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(1);
        int res = 0;
        int sign = 1;
        int i = 0;
        while (i < len) {
            if (s.charAt(i) == ' ') {
                i++;
            } else if (s.charAt(i) == '+') {
                sign = stack.peek();
                i++;
            } else if (s.charAt(i) == '-') {
                sign = -stack.peek();
                i++;
            } else if (s.charAt(i) == '(') {
                stack.push(sign);
                i++;
            } else if (s.charAt(i) == ')') {
                stack.pop();
                i++;
            } else {
                long sum = 0L;
                while (i < len && Character.isDigit(s.charAt(i))) {
                    sum = sum * 10 + (s.charAt(i) - '0');
                    i++;
                }
                res += (sign * sum);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String str = "1+1";
        System.out.println(new Leetcode224().calculate(str));
    }
}
