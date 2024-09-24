package bryanze.leetcode;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author lizelin
 * @date 2024/09/13
 */
public class DD_T2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        List<String> list = new ArrayList<>();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[][] singScore = new int[n][2];

            int oneCount = 0;
            int fOneCount = 0;
            for (int i = 0; i < n; i++) {
                int op = sc.nextInt();
                int x = sc.nextInt();
                singScore[i][0] = op;
                singScore[i][1] = x;
                if (op == 1) {
                    oneCount++;
                } else if (op == -1) {
                    fOneCount++;
                }
            }

            if (oneCount != fOneCount) {
                list.add("NO");
                continue;
            }
//
//            if (singScore[n - 1][0] == 1) {
//                list.add("NO");
//                continue;
//            }
//
//            if (singScore[0][0] == -1) {
//                list.add("NO");
//                continue;
//            }

            int lower;
            int upper;
            for (lower = 0, upper = 0; lower < n && upper < n; ) {
                while (lower < n && singScore[lower][0] != -1) {
                    lower++;
                }
                while (upper < n && singScore[upper][0] != 1) {
                    upper++;
                }

                if (upper < lower) {
                    oneCount--;
                    fOneCount--;
                }
                lower++;
                upper++;

            }

//            if (oneCount != 0) {
//                int index = upper + 1;
//                while (upper < n && oneCount != 0) {
//                    for (; index < n; index++) {
//                        if (singScore[index][0] != 0) {
//                            oneCount--;
//                            index++;
//                            break;
//                        }
//                    }
//
//                }
//            } else if (fOneCount != 0) {
//                int index = lower - 1;
//                while (lower >= 0 && fOneCount != 0){
//                    for (; index >= 0; index--) {
//                        if (singScore[index][0] != 0) {
//                            fOneCount--;
//                            index--;
//                            break;
//                        }
//                    }
//                }
//            }


            if(oneCount == 0 && fOneCount == 0) {
                list.add("YES");
            } else {
                list.add("NO");
            }
        }
        for (String string : list) {
            System.out.println(string);
        }
    }
}
