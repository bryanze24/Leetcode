package bryanze.leetcode;

import org.checkerframework.checker.formatter.qual.ConversionCategory;
import org.checkerframework.checker.units.qual.A;

import java.util.*;

/**
 * @author lizelin
 * @date 2024/08/28
 */
public class SQB_T2 {
    static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Interval interval = (Interval) o;
            return start == interval.start && end == interval.end;
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end);
        }
    }

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(0);
        for (int i = 1; i <= 100000; i++) {
            list.add(i);
        }

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Interval> intervals = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            intervals.add(new Interval(start, end));
        }

//        intervals.sort(Comparator.comparingInt(interval -> interval.end));
//        intervals.sort((a, b) -> a.end - b.end != 0 ? a.end - b.end : a.start - b.start);
        int count = 0;
        int lastEnd = -1;
        for (Interval interval : intervals) {
            if (isContains(list, interval.start, interval.end)) {
                count++;
                for (int i = interval.start; i < interval.end; i++) {
                    list.set(i, 0);
                }

            }
        }

        System.out.println(count);
    }

    private static boolean isContains(List<Integer> list, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (list.get(i) == 0) {
                return false;
            }

        }
        return true;
    }
}
