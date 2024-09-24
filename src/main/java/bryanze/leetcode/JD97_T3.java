package bryanze.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author lizelin
 * @date 2024/09/07
 */
public class JD97_T3 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int sum = sc.nextInt();
            int res = minOperation(n, k, sum);
            list.add(res);
        }

        for (Integer num : list) {
            System.out.println(num);
        }
    }

        private static int minOperation(int n, int k, int targetSum) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = i + 1;
        }
        int totalOperation = 0;
        for (int i = 0; i <= n - k; i++) {
            int currentSum = 0;
            for (int j = i; j < i + k; j++) {
                currentSum += a[j];
            }
            while (currentSum > targetSum) {
                int maxIndex = i;
                for (int j = i + 1; j < i + k; j++) {
                    if (a[j] > a[maxIndex]) {
                        maxIndex = j;
                    }
                }

                a[maxIndex]--;
                currentSum--;
                totalOperation++;

            }

        }
        return totalOperation;
    }
//    private static int minOperation(int n, int k, int targetSum) {
//        int[] a = new int[n];
//        for (int i = 0; i < n; i++) {
//            a[i] = i + 1;
//        }
//        int totalOperation = 0;
//
//        PriorityQueue<Node> maxHeap = new PriorityQueue<>(new Comparator<Node>() {
//            @Override
//            public int compare(Node o1, Node o2) {
//                return o2.value - o1.value;
//            }
//        });
//        int currentSum = 0;
//        for (int i = 0; i < k; i++) {
//            currentSum += a[i];
//            maxHeap.offer(new Node(a[i], i));
//        }
//        for (int i = 0; i <= n - k; i++) {
//            while (currentSum > targetSum) {
//                Node maxNode = maxHeap.peek();
//                while (maxNode.index < i) {
//                    maxHeap.poll();
//                    maxNode = maxHeap.peek();
//                }
//                a[maxNode.index]--;
//                currentSum--;
//                totalOperation++;
//                maxHeap.poll();
//                maxHeap.offer(new Node(a[maxNode.index], maxNode.index));
//            }
//            if (i + k < n) {
//                currentSum = currentSum - a[i] + a[i + k];
//                maxHeap.offer(new Node(a[i + k], i + k));
//            }
//
//        }
//        return totalOperation;
//    }
//
//    static class Node {
//        int value;
//        int index;
//
//        public Node(int value, int index) {
//            this.value = value;
//            this.index = index;
//        }
//    }
}
