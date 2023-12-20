package bryanze.leetcode;

import org.omg.IOP.TAG_ORB_TYPE;

import java.util.Arrays;
import java.util.function.Consumer;

/**
 * 给你一个用字符数组 tasks 表示的 CPU 需要执行的任务列表。其中每个字母表示一种不同种类的任务。
 * 任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。
 * 在任何一个单位时间，CPU 可以完成一个任务，或者处于待命状态。
 * 然而，两个 相同种类 的任务之间必须有长度为整数 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU
 * 在执行不同的任务，或者在待命状态。
 * 你需要计算完成所有任务所需要的 最短时间 。
 *
 * @author lizelin
 * @date 2023/12/20
 */
public class Leetcode621 {
    public int leastInterval(char[] tasks, int n) {

        if(tasks.length <= 1 || n < 1){
            return tasks.length;
        }

        int[] count = new int[26];
        for (char task : tasks) {
            count[task - 'A']++;
        }

        Arrays.sort(count);
        int minMinute = (n + 1) * (count[25] - 1) + 1;

        for (int i = 24; i > 0 ; i--) {
            if(count[i] == count[25]){
                minMinute++;
            }

            if(count[i] == 0){
                break;
            }
        }

        return Math.max(minMinute, tasks.length);
    }

    public int leastInterval1(char[] tasks, int n){

        if(tasks.length <= 1 || n < 1){
            return tasks.length;
        }

        int[] count = new int[26];

        int maxCount = 0;

        for (char task : tasks) {
            count[task - 'A']++;

            // 调用 Math.max() 任务总数次，可能要比26次大很多
//            maxCount = Math.max(maxCount, count[task - 'A']);

        }

        // 获取最大的任务数
        for (int i = 0; i < 26; i++) {
            // 调用 Math.max() 26次
            maxCount = Math.max(maxCount, count[i]);
        }

        int total = 0;
        for (int i = 0; i < 26; i++) {
            total += count[i] == maxCount ? 1 : 0;
        }

        return Math.max(tasks.length, (n + 1) * (maxCount - 1) + total);

    }

    public static void main(String[] args) {
        char[] tasks = {'A','A','A','A','A','A','B','C','D','E','F','G'};
        System.out.println(new Leetcode621().leastInterval1(tasks, 2));
    }

}
