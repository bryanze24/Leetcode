package bryanze.leetcode;

import java.util.*;

/**
 * @author lizelin
 * @date 2024/03/23
 */
public class CodeFun1721 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int x = sc.nextInt();
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < x; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            list.add(new int[]{a, b});
        }

        Comparator<int[]> comparator = (o1, o2) -> o1[0] - o2[0] != 0 ? o1[0] - o2[0] : o1[1] - o2[1];

        Collections.sort(list, comparator);

        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1] != 0 ? o1[1] - o2[1] : o1[0] - o2[0]);

        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            int[] arr = list.get(i);
            if (queue.size() < m) {
                queue.offer(arr);
                sum += (arr[1] - arr[0]);
            } else {
                if (queue.peek()[1] <= list.get(i)[0]) {
                    queue.poll();
                    queue.offer(arr);
                    sum += (arr[1] - arr[0]);
                }
            }
        }

        System.out.println(sum);
    }
}
