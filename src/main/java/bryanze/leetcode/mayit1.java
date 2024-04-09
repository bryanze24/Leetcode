package bryanze.leetcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author lizelin
 * @date 2024/04/06
 */
public class mayit1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        scanner.close();

        // 将字符串转换为字符数组，然后对数组进行排序
        char[] chars = s.toCharArray();
        Arrays.sort(chars);

        // 将排序后的字符数组转换回字符串
        String result = new String(chars);

        // 输出结果
        System.out.println(result);
    }
}
