package bryanze.leetcode;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。
 * 请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
 *
 * @author lizelin
 * @date 2023/11/21/0021
 */
public class Leetcode448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int i = 1;
        while (i <= nums.length) {
            if (!set.contains(i)) {
                list.add(i);
            }
            i++;
        }

        return list;
    }

    public List<Integer> findDisappearedNumbers1(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[Math.abs(nums[i]) - 1] > 0) {
                nums[Math.abs(nums[i]) - 1] *= -1;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                list.add(i + 1);
            }
        }

        return list;
    }

    public List<Integer> findDisappearedNumbers2(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int i = 0;
        while (i < nums.length){
            if(nums[i] == i + 1){ //当前数字本就出现在理应的位置上，跳过，不用换。
                i++;
                continue;
            }

            int id = nums[i] - 1; //当前元素应该出现的位置

            if(nums[i] == nums[id]){ //当前元素 == 它应该出现在的位置上，说明元素有重复
                i++;
                continue;
            }

            int temp = nums[i]; //当前元素未出现在该有的位置上，进行交换
            nums[i] = nums[id];
            nums[id] = temp;

            //交换结束后不要对i加1，因为交换过来的元素也要进行考察

        }

        for (int j = 0; j < nums.length; j++) {
            if(nums[j] != j + 1){
                list.add(j + 1);
            }
        }

        return list;
    }

}
