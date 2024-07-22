package bryanze.leetcode;

import java.util.*;

/**
 * 现在你总共有 numCourses 门课需要选，记为 0 到 numCourses - 1。
 * 给你一个数组 prerequisites ，其中 prerequisites[i] = [ai, bi] ，
 * 表示在选修课程 ai 前 必须 先选修 bi 。
 * 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示：[0,1] 。
 * 返回你为了学完所有课程所安排的学习顺序。可能会有多个正确的顺序，
 * 你只要返回 任意一种 就可以了。如果不可能完成所有课程，返回 一个空数组 。
 *
 * @author lizelin
 * @date 2024/07/22
 */
public class Leetcode210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        int[] inDegree = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int[] prerequisite : prerequisites) {
            inDegree[prerequisite[0]]++;
            map.putIfAbsent(prerequisite[1], new ArrayList<>());

            map.get(prerequisite[1]).add(prerequisite[0]);
        }

        LinkedList<Integer> queue = new LinkedList<>();
        int[] res = new int[numCourses];
        int index = 0;

        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
                res[index++] = i;
            }
        }

        while (!queue.isEmpty()) {
            Integer course = queue.poll();
            numCourses--;
            for (int nextCourse : map.getOrDefault(course, new ArrayList<>())) {
                inDegree[nextCourse]--;
                if (inDegree[nextCourse] == 0) {
                    queue.offer(nextCourse);
                    res[index++] = nextCourse;
                }
            }
        }

        return numCourses == 0 ? res : new int[0];
    }

    public static void main(String[] args) {
        int[][] prerequisites = {{1, 0}, {0, 1}};
        int[] res = new Leetcode210().findOrder(2, prerequisites);
        System.out.println(Arrays.toString(res));
    }
}
