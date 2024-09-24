package bryanze.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author lizelin
 * @date 2024/09/22
 */
public class PDD_T1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();
        String[] words = new String[N];
        for (int i = 0 ; i < N; i++) {
            words[i] = sc.nextLine();
        }
        words = dfs(words, M);
        for (int i = 0; i < M; i++) {
            System.out.println(words[i]);
        }

    }

    private static String[] dfs(String[] str, int m) {
        Comparator<String> cmp = new Comparator<String>(){
            @Override
            public int compare(String word1, String word2) {
                if (word1.contains("PDD") && word2.contains("PDD")) {
                    return word1.compareTo(word2);
                }
                if (word1.contains("PDD")) {
                    return -1;
                }
                if (word2.contains("PDD")) {
                    return 1;
                }

                return word1.compareTo(word2);
            }

        };
        Arrays.sort(str, cmp);
        return str;
    }
}
