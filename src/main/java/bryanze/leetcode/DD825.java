package bryanze.leetcode;

import java.util.Random;

public class DD825 {
    private final static Random RANDOM = new Random(System.currentTimeMillis());

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private int dfs(int[] nums, int left, int right) {
        int random = left + RANDOM.nextInt(right - left + 1);
        swap(nums, left, random);
        int p = nums[left];
        int le = left + 1;
        int ge = right;
        while (true) {
            while (le <= ge && nums[le] < p) {
                le++;
            }

            while (le <= ge && nums[ge] > p) {
                ge--;
            }

            if (le >= ge) {
                break;
            }
            swap(nums, le, ge);
            le++;
            ge--;

        }
        return ge;
    }

    public int findK(int[] nums, int k) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        int target = len - k;
        while (true) {
            int j = dfs(nums, left, right);
            if (j == target) {
                return nums[j];
            } else if (j < target) {
                left = j + 1;
            } else {
                right = j - 1;
            }
        }

    }

}
