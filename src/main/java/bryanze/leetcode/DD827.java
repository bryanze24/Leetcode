package bryanze.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DD827 {
    static class HeapNode {
        int value;
        int row;
        int col;

        HeapNode(int value, int row, int col) {
            this.value = value;
            this.row = row;
            this.col = col;
        }

    }

    public static int[] dfs(int[][] nums) {
        if (nums == null) {
            return new int[0];
        }

        PriorityQueue<HeapNode> queue = new PriorityQueue<>(
                Comparator.comparing(node -> node.value));

        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            int[] row = nums[i];
            total += row.length;
            if (row != null && row.length > 0) {
                queue.offer(new HeapNode(row[0], i, 0));
            }
        }

        int[] res = new int[total];
        int index = 0;
        while (!queue.isEmpty()) {
            HeapNode node = queue.poll();
            res[index] = node.value;
            index++;
            int val = node.col + 1;
            int[] curRow = nums[node.row];
            if (val < curRow.length) {
                queue.offer(new HeapNode(curRow[val], node.row, val));
            }
        }
        return res;

    }

    public static void main(String[] args) {
        int[][] nums = {
                {1, 5},
                {2, 3, 6, 7},
                {4, 6, 8},
        };

        System.out.println(Arrays.toString(dfs(nums)));

    }

}
