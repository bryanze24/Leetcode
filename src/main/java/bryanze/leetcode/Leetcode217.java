package bryanze.leetcode;


import java.util.HashMap;
import java.util.HashSet;

/**
 * 给你一个整数数组 nums.如果任一值在数组中出现至少两次,返回 true;如果数组中每个元素互不相同,返回 false.
 * @author lizelin
 * @date 2023/11/26
 */

public class Leetcode217 {
    //hashmap  //14ms
    public boolean containsDuplicate(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (map.containsKey(num)) {
                return true;
            }
//            map.put(num, map.getOrDefault(num, 0) + 1);
            map.put(num, 1);
        }

        return false;
    }

    //hashmap优化 8ms
    public boolean containsDuplicate1(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {

//            map.put(num, map.getOrDefault(num, 0) + 1);
            Integer put = map.put(num, 1);
            if(put != null){
                return true;
            }

        }

        return false;
    }



    //hashset  7ms
    public boolean containsDuplicate2(int[] nums){
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
//            if(set.contains(num)){
//                return true;
//            }
//            set.add(num);
            if(!set.add(num)){
                return true;
            }
        }
        return false;
    }
}
