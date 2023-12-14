package bryanze.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * 给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，
 * 找出列表中任意两个时间的最小时间差并以分钟数表示。
 * @author lizelin
 * @date 2023/12/14
 */
public class Leetcode539 {
    public int findMinDifference(List<String> timePoints) {

        timePoints.sort(String::compareTo);

//        for (String timePoint : timePoints) {
//            System.out.println(timePoint);
//        }

        int result = Integer.MAX_VALUE;
        int prev = getMinutes(timePoints.get(0));
        int t0 = prev;

        for (int i = 1; i < timePoints.size(); i++) {
            int minutes = getMinutes(timePoints.get(i));
            result = Math.min(result, Math.abs(minutes - prev)); //相邻时间差
            prev = minutes;
        }

        result = Math.min(result, t0 + 1440 - prev); //首尾时间差

        return result;

    }

    private int getMinutes(String t){
        return ((t.charAt(0) - '0') * 10 + (t.charAt(1) - '0')) * 60 + (t.charAt(3) - '0') * 10 + (t.charAt(4) - '0');
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("01:00","02:00");
        System.out.println(new Leetcode539().findMinDifference(list));
    }
}
