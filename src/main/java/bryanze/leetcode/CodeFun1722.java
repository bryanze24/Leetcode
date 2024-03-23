package bryanze.leetcode;

import java.util.*;

/**
 * @author lizelin
 * @date 2024/03/23
 */
public class CodeFun1722 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strArray = str.split(" ");
        int length = strArray.length;
        long[] array = new long[length];
        for (int i = 0; i < length; i++) {
            array[i] = Long.parseLong(strArray[i]);
        }

        for (int i = 0; i < length; i++) {
            long sum = 0;
            int j = i - 1;
            while (j >= 0 && sum < array[i]) {
                sum += array[j];
                j--;
            }

            if (sum == array[i]) {
                array[i] *= 2;
                for (int k = i - 1; k >= j + 1; k--) {
                    array[k] = 0;
                }
                i--; //检查一轮之后，有可能更改数据之后还有符合条件的，需要重新检查一遍
            }

        }

        long[] res = new long[length];
        int index = 0;
        for (int i = length - 1; i >= 0; i--) {
            if (array[i] != 0) {
                res[index] = array[i];
                index++;
            }
        }

        for (int i = 0; i < res.length; i++) {
            if (res[i] != 0) {
                System.out.print(res[i]);
            }else {
                break;
            }
            if (res[i + 1] != 0) {
                System.out.print(" ");
            }
        }

    }
}
