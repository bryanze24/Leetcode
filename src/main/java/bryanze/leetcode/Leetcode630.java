package bryanze.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 这里有 n 门不同的在线课程，按从 1 到 n 编号。给你一个数组 courses ，
 * 其中 courses[i] = [durationi, lastDayi] 表示第 i 门课将会 持续 上 durationi 天课，
 * 并且必须在不晚于 lastDayi 的时候完成。
 * 你的学期从第 1 天开始。且不能同时修读两门及两门以上的课程。
 * 返回你最多可以修读的课程数目。
 *
 * @author lizelin
 * @date 2023/12/24
 */
public class Leetcode630 {
    public int scheduleCourse(int[][] courses) {

        Arrays.sort(courses, Comparator.comparingInt(a -> a[1]));
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b -a);

        int totalDay = 0;
        for (int[] course : courses) {
            int day = course[0];
            int deadline = course[1];
            if(totalDay + day <= deadline) {
                totalDay += day;
                queue.offer(day);
            }else if(!queue.isEmpty() && queue.peek() > day) {
                totalDay = totalDay - queue.poll() + day;
                queue.offer(day);
            }

        }

        return queue.size();
    }

    public static void main(String[] args) {
        int[][] courses = new int[][]{{100, 200}, {200, 1300}, {1000, 1250}, {2000, 3200}};
        System.out.println(new Leetcode630().scheduleCourse(courses));
    }
}
