package bryanze.leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 给你一个 n x n 矩阵 matrix ，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 请注意，它是 排序后 的第 k 小元素，而不是第 k 个 不同 的元素。
 * 你必须找到一个内存复杂度优于 O(n2) 的解决方案。
 *
 * @author lizelin
 * @date 2023/12/04
 */
public class Leetcode378 {

    public int kthSmallest(int[][] matrix, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                map.put(matrix[i][j], map.getOrDefault(matrix[i][j], 0) + 1);
            }
        }

        System.out.println(map);

        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();

            while (count > 0) {
                if (queue.size() == k) {
                    if (queue.peek() > num) {
                        queue.poll();
                        queue.offer(num);
                    }

                } else {
                    queue.offer(num);
                }
                count--;

            }

        }

        System.out.println(queue);

//        Integer polled = queue.peek();
//        while (!queue.isEmpty()) {
//            polled = queue.poll();
//        }
        return queue.peek();
    }

    public int kthSmallest1(int[][] matrix, int k) {
        int length = matrix.length;
        int left = matrix[0][0];
        int right = matrix[length - 1][length - 1];

        while (left < right) {

            int mid = left + ((right - left) >> 1);

            if (check(matrix, mid, k, length)) {
                right = mid;

            } else {
                left = mid + 1;
            }

        }
        return left;

    }

    private boolean check(int[][] matrix, int mid, int k, int length) {
        int i = length - 1;
        int j = 0;
        int sum = 0;
        while (i >= 0 && j < length) {

            if(matrix[i][j] <= mid){
                j++;
                sum += i + 1;

            } else {
                i--;
            }
        }

        return sum >= k;
    }

    public static void main(String[] args) {
        /*
        int[][] matrix = new int[][]{{1,5,9},{10,11,13},{12,13,15}};
        int[][] matrix = new int[][]{{-5}};
         */

        int[][] matrix = new int[][]{{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        System.out.println(new Leetcode378().kthSmallest1(matrix, 8));
    }
}
