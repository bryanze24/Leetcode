package bryanze.leetcode;

import java.util.Scanner;

/**
 * @author lizelin
 * @date 2024/09/07
 */
public class MT97_T3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
//        sc.nextLine();
        long[] cards = new long[n];
        for (int i = 0; i < n; i++) {
            cards[i] = sc.nextLong();
        }
        for (int i = 0; i <= q; i++) {
            System.out.println(min(cards));
            if (i < q) {
                char operation = sc.next().charAt(0);
                sc.nextLine();
                int l = sc.nextInt();
                int r = sc.nextInt();
                int x = sc.nextInt();
                if (operation == '+') {
                    for (int j = l; j <= r; j++) {
                        cards[j] += x;
                    }
                } else if (operation == '-') {
                    for (int j = l; j <= r; j++) {
                        cards[j] -= x;
                    }
                }
            }

        }
    }

    private static int min(long[] cards) {
        long odd = 0;
        long total = 0;
        for (int i = 1; i < cards.length; i++) {
            total += cards[i];
            if (cards[i] % 2 == 1){
                odd++;
            }

            if (odd > 1) {
                return (int) (odd / 2);
            }

        }
        return -1;
    }

}
