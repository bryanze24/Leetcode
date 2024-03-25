package bryanze.leetcode;


/**
 * @author lizelin
 * @date 2024/03/25
 */
public class Leetcode303 {

    private int[] nums;
    private int[] prifix;

    public Leetcode303(int[] nums) {
        this.nums = nums;
        prifix = new int[nums.length + 1];
        prifix = sum();

    }

    public int sumRange(int left, int right) {
//        System.out.println(Arrays.toString(prifix));
        return prifix[right + 1] - prifix[left];
    }

    private int[] sum() {

        for (int i = 0; i < nums.length; i++) {
            prifix[i + 1] = prifix[i] + nums[i];
        }

        return prifix;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        Leetcode303 leetcode303 = new Leetcode303(nums);
        System.out.println(leetcode303.sumRange(0, 2));
    }

}


