package bryanze.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author lizelin
 * @date 2024/10/09
 */
public class exe1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String str1 = str.substring(1, str.length() - 1);
        String[] split = str1.split(",\\s*");
        int[] height = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            height[i] = Integer.parseInt(split[i]);
        }
        if (height.length < 2) {
            System.out.println("无");
        } else {
            System.out.println(dfs(height));
        }
    }
    public static int dfs(int[] height) {
        HashSet<Integer> set = new HashSet<>();
        for (int h : height) {
            set.add(h);
        }
        Integer[] array = set.toArray(new Integer[0]);
        Arrays.sort(array);
        return array.length < 2? array[array.length - 1] : array[array.length - 2];
    }
}
