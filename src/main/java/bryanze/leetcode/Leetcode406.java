package bryanze.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性（不一定按顺序）。
 * 每个 people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，前面 正好 有 ki 个身高大于或等于 hi 的人。
 * 请你重新构造并返回输入数组 people 所表示的队列。返回的队列应该格式化为数组 queue ，
 * 其中 queue[j] = [hj, kj] 是队列中第 j 个人的属性（queue[0] 是排在队列前面的人）。
 * @author lizelin
 * @date 2023/12/07
 */
public class Leetcode406 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (x, y) -> x[0] == y[0] ? x[1] - y[1] : y[0] - x[0]);
        List<int[]> ans = new ArrayList<>();

        for (int[] p : people) {
            ans.add(p[1], p);
        }

        return ans.toArray(new int[0][0]);
    }

    public static void main(String[] args) {
        int[][] people = new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        int[][] queue = new Leetcode406().reconstructQueue(people);

        for (int[] person : queue) {
            System.out.println(Arrays.toString(person));
        }

    }
}
