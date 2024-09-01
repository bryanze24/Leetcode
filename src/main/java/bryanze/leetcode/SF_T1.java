package bryanze.leetcode;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 通过82%
 * @author lizelin
 * @date 2024/08/29
 */
public class SF_T1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String functionName = sc.next();
            ans.add(convert(functionName));
        }

        for (String string : ans) {
            System.out.println(string);
        }
    }

    private static String convert(String functionName) {
        if (isCamelCase(functionName)) {
            return convertCamelToSnake(functionName);
        } else if (isSnakeCase(functionName)) {
            return functionName;
        } else {
            return "indistinct";
        }
    }

    private static boolean isSnakeCase(String functionName) {
        return functionName.equals(functionName.toLowerCase()) && functionName.contains("_")
                && functionName.charAt(functionName.length() - 1) != '_'
                && functionName.charAt(0) != '_'
                && isContainsBreakTwoLine(functionName);
    }

    private static boolean isContainsBreakTwoLine(String functionName) {
        for (int i = 0; i < functionName.length() - 1; i++) {
            if (functionName.charAt(i) == '_' && functionName.charAt(i + 1) == '_') {
                return false;
            }

            if (('a' <= functionName.charAt(i)
                    && 'z' >= functionName.charAt(i))
                    || ('A' <= functionName.charAt(i) && 'Z' >= functionName.charAt(i))
                    || functionName.charAt(i) == '_') {

            } else {
                return false;
            }
        }
        return true;
    }

    private static boolean isCamelCase(String functionName) {
        return Character.isLowerCase(functionName.charAt(0)) && !functionName.contains("_")
                && containsUpperCase(functionName);
    }

    private static boolean containsUpperCase(String functionName) {
        for (char c : functionName.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }

        return false;
    }


    private static String convertCamelToSnake(String functionName) {
        StringBuilder sb = new StringBuilder();
        for (char c : functionName.toCharArray()) {
            if (Character.isUpperCase(c)) {
                sb.append("_").append(Character.toLowerCase(c));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
