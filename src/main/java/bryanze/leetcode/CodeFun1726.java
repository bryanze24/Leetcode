package bryanze.leetcode;

import java.util.Scanner;

/**
 * @author lizelin
 * @date 2024/03/23
 */
public class CodeFun1726 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] array = new int[n][m];
        for (int i = 0; i < n; i++) {
            String str = sc.next();

            for (int j = 0; j < m; j++) {
                array[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
            }
        }

//        for (int i = 0; i < array.length; i++) {
//            for (int j = 0; j < array[0].length; j++) {
//                System.out.print(array[i][j]);
//            }
//            System.out.println();
//        }

        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m - 1; j++) {
                boolean flag = dfs(array, i, j);
                if (flag) {
                    count++;
                }
            }
        }


        System.out.println(count);

    }

    public static boolean dfs(int[][] array, int iIndex, int jIndex) {
        int oneCount = 0;
        for (int i = iIndex; i < iIndex + 2; i++) {
            for (int j = jIndex; j < jIndex + 2; j++) {
                if (array[i][j] == 1) {
                    oneCount++;
                }
            }
        }

        return oneCount == 2;
    }
}
