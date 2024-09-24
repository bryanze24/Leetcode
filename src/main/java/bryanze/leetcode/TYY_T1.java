package bryanze.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author lizelin
 * @date 2024/09/12
 */
public class TYY_T1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // 读取测试数据组数
        List<int[]> ans = new ArrayList<>();
        while (T-- > 0) {
            int n = scanner.nextInt(); // 读取每组测试数据的n值
            int[] maxWeightAndRatio = findMaxWeightAndRatio(n);
            ans.add(maxWeightAndRatio);
        }
        scanner.close();
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i)[0] + " " + ans.get(i)[1]);
            if (i != ans.size() - 1){
                System.out.println();
            }
        }
    }

    private static int[] findMaxWeightAndRatio(int n) {
        int maxWeight = 0;
        int ratio = 2; // 公比至少为2

        // 从公比为2开始，逐渐增加公比，直到找到最大的项数
        while (true) {
            int sum = 0;
            int weight = 0;
            int current = 1;
            while (sum + current <= n) {
                sum += current;
                current *= ratio;
                weight++;
            }
            if (sum == n) { // 如果和正好等于n，则找到了一个可能的解
                maxWeight = weight;
                break;
            } else if (sum > n) { // 如果和超过了n，则需要减小公比
                break;
            }
            ratio++;
        }

//        System.out.println(maxWeight + " " + ratio); // 输出最大重量和对应的公比
        return new int[]{maxWeight, ratio};
    }
}













