package bryanze.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author lizelin
 * @date 2024/09/28
 */
public class EquationSolver {

    // 计算表达式的值
    private static long evaluateExpression(String expr) {
        // 将乘号和加号分开处理
        String[] addParts = expr.split("\\+");
        long result = 0;
        for (String addPart : addParts) {
            String[] mulParts = addPart.split("\\*");
            long mulResult = 1;
            for (String mulPart : mulParts) {
                mulResult *= Long.parseLong(mulPart);
            }
            result += mulResult;
        }
        return result;
    }

    // 检查方程是否成立
    private static boolean isEquationValid(String equation) {
        String[] sides = equation.split("=");
        if (sides.length != 2) return false;  // 不合法的方程
        long left = evaluateExpression(sides[0]);
        long right = evaluateExpression(sides[1]);
        return left == right;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();  // 跳过换行符
        List<String> ans = new ArrayList<>();

        for (int t = 0; t < T; t++) {
            String equation = sc.nextLine().replaceAll("\\s", "");

            // 如果方程本身已经成立，直接输出Yes
            if (isEquationValid(equation)) {
                ans.add("Yes");
                continue;
            }

            // 尝试插入一个数位
            boolean valid = false;
            for (int i = 0; i <= equation.length(); i++) {
                for (char digit = '0'; digit <= '9'; digit++) {
                    StringBuilder newEquation = new StringBuilder(equation);
                    newEquation.insert(i, digit);

                    if (isEquationValid(newEquation.toString())) {
                        valid = true;
                        break;
                    }
                }
                if (valid) break;
            }

            if (valid) {
                ans.add("Yes");
            } else {
                ans.add("No");
            }
        }

        sc.close();
        for (String res : ans) {
            System.out.println(res);
        }
    }
}
















