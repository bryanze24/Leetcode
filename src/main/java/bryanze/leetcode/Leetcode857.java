package bryanze.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 有 n 名工人。 给定两个数组 quality 和 wage ，其中，quality[i] 表示第 i 名工人的工作质量，
 * 其最低期望工资为 wage[i] 。
 * 现在我们想雇佣 k 名工人组成一个工资组。在雇佣 一组 k 名工人时，我们必须按照下述规则向他们支付工资：
 * 对工资组中的每名工人，应当按其工作质量与同组其他工人的工作质量的比例来支付工资。
 * 工资组中的每名工人至少应当得到他们的最低期望工资。
 * 给定整数 k ，返回 组成满足上述条件的付费群体所需的最小金额 。在实际答案的 10-5 以内的答案将被接受。
 *
 * @author lizelin
 * @date 2023/12/25
 */
public class Leetcode857 {
    public double minCostToHireWorkers(int[] quality, int[] wage, int k) {
        int length = quality.length;
        Integer[] h = new Integer[length];

        for (int i = 0; i < length; i++) {
            h[i] = i;
        }

        Arrays.sort(h, (a, b) -> quality[b] * wage[a] - quality[a] * wage[b]);

        double res = Double.MAX_VALUE;
        double totalq = 0.0;

        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);

        for (int i = 0; i < k - 1; i++) {
            totalq += quality[h[i]];
            queue.offer(quality[h[i]]);
        }

        for (int i = k - 1; i < length; i++) {
            int id = h[i];
            totalq += quality[id];
            queue.offer(quality[id]);
            double totalc = (double) wage[id] / quality[id] * totalq;
            res = Math.min(res, totalc);
            totalq -= queue.poll();

        }

        return res;
    }

    public static class Employee {
        public int quality;
        public double rubbishDegree;

        public Employee(int quality, int wage) {
            this.quality = quality;
            this.rubbishDegree = (double) wage / (double) quality;
        }
    }

    public double minCostToHireWorkers1(int[] quality, int[] wage, int k) {
        Employee[] employees = new Employee[quality.length];

        for (int i = 0; i < quality.length; i++) {
            Employee employee = new Employee(quality[i], wage[i]);
            employees[i] = employee;
        }

        Arrays.sort(employees, (a, b) -> a.rubbishDegree <= b.rubbishDegree ? -1 : 1);

        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);

        double result = Double.MAX_VALUE;
        int qualitySum = 0;

        for (int i = 0; i < quality.length; i++) {
            int curQuality = employees[i].quality;

            if (queue.size() < k) {
                qualitySum += curQuality;
                queue.offer(curQuality);

                if (queue.size() == k) {
                    result = Math.min(result, qualitySum * employees[i].rubbishDegree);
                }

            } else {

                if (queue.peek() > curQuality) {
                    qualitySum -= queue.poll();
                    qualitySum += curQuality;
                    queue.offer(curQuality);
                    result = Math.min(result, qualitySum * employees[i].rubbishDegree);
                }

            }

        }

        return result;
    }

    public static void main(String[] args) {
        int[] quality = {3,1,10,10,1};
        int[] wage = {4,8,2,2,7};
        System.out.println(new Leetcode857().minCostToHireWorkers1(quality, wage, 3));
    }
}
