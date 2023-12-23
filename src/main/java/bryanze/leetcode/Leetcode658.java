package bryanze.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 给定一个 排序好 的数组 arr ，两个整数 k 和 x ，从数组中找到最靠近 x（两数之差最小）的 k 个数。
 * 返回的结果必须要是按升序排好的。
 * 整数 a 比整数 b 更接近 x 需要满足：
 * |a - x| < |b - x| 或者
 * |a - x| == |b - x| 且 a < b
 *
 * @author lizelin
 * @date 2023/12/23
 */
public class Leetcode658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[1] != b[1] ? b[1] - a[1] : b[0] - a[0];
            }
        });

        for (int num : arr) {

            if (queue.size() < k) {
                queue.offer(new int[]{num, Math.abs(num - x)});
            } else if (Math.abs(num - x) < queue.peek()[1] ||
                    (Math.abs(num - x) == queue.peek()[1] && num < queue.peek()[0])) {
                queue.poll();
                queue.offer(new int[]{num, Math.abs(num - x)});
            }

        }

        List<Integer> list = new ArrayList<>();

        while (!queue.isEmpty()) {
//            System.out.println(Arrays.toString(queue.poll()));
            list.add(queue.poll()[0]);
        }

        list.sort(Comparator.comparingInt(a -> a));

        return list;
    }

    public List<Integer> findClosestElements1(int[] arr, int k, int x) {
        int left = 0, right = arr.length - 1;

        int deleteNumber = arr.length - k;

        while (deleteNumber-- > 0) {
            if (Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
                right--;
            } else {
                left++;
            }

        }

        List<Integer> list = new ArrayList<>();

        for (int i = left; i < left + k; i++) {
            list.add(arr[i]);
        }

        return list;

    }

    public List<Integer> findClosestElements2(int[] arr, int k, int x) {
        /*
        将数组 arr 分成两部分，前一部分所有元素 [0,left]都小于 x，
        后一部分所有元素 [right,n−1]都大于等于 x
         */
        int right = binarySearch(arr, x);
        int left = right - 1;

        while (k > 0) {

            if (left < 0) {
                right++;

            } else if (right > arr.length - 1) {
                left--;

            } else if (x - arr[left] <= arr[right] - x) {
                left--;

            } else {
                right++;
            }

            k--;
        }

        List<Integer> list = new ArrayList<>();
        for (int i = left + 1; i < right; i++) {
            list.add(arr[i]);
        }

        return list;
    }

    private int binarySearch(int[] arr, int x) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int mid = left + ((right - left) >> 1);

            if (arr[mid] >= x) {
                right = mid;
            } else {
                left = mid + 1;
            }

        }

        return right;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        System.out.println(new Leetcode658().findClosestElements(arr, 2, 2));
    }

}
