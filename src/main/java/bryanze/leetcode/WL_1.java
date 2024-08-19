package bryanze.leetcode;

import java.util.*;

/**
 * @author lizelin
 * @date 2024/08/19
 */
public class WL_1 {
    static class Fraction implements Comparable<Fraction> {
        int A;
        int B;
        public Fraction(int A, int B) {
            this.A = A;
            this.B = B;
        }

        @Override
        public int compareTo(Fraction o) {
            return this.A * o.B - o.A * this.B;
        }

        @Override
        public String toString() {
            return A + " " + B;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Fraction> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            list.add(new Fraction(A, B));
        }

        list.sort(Collections.reverseOrder());
        for (Fraction fraction : list) {
            System.out.println(fraction);
        }

    }
}
