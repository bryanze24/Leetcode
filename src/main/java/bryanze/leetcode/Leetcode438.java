package bryanze.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，
 * 返回这些子串的起始索引。不考虑答案输出的顺序。
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 *
 * @author lizelin
 * @date 2024/04/08
 */
public class Leetcode438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();

        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        for (int i = 0; i < p.length(); i++) {
            char ch = p.charAt(i);
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }

        int valid = 0, left = 0, right = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            right++;

            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }

            }

            while (right - left >= p.length()) {
                if (valid == p.length()) {
                    list.add(left);
                }

                char d = s.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (need.get(d).equals(window.get(d))) {
                        valid--;
                    }

                    window.put(d, window.get(d) - 1);
                }

            }

        }

        return list;
    }

//    public List<Integer> findAnagrams1(String s, String p) {
//        Map<Character, Integer> need = new HashMap<>(p.length());
//        Map<Character, Integer> windows = new HashMap<>(p.length());
//        List<Integer> res = new ArrayList<>();
//
//        //初始化need
//        for(int i = 0; i < p.length(); i++){
//            char c = p.charAt(i);
//            need.put(c, need.getOrDefault(c, 0) + 1);
//        }
//
//        //滑动窗口的左右边界;开区间：[left, right)
//        int left = 0, right = 0;
//        int valid = 0;//windows 中满足need 的字符的个数。
//
//        while(right < s.length()){
//            char c =  s.charAt(right);//将要加入到windows中的字符
//            right++;
//
//            if(need.containsKey(c)){
//                windows.put(c, windows.getOrDefault(c, 0) + 1);
//                if(need.get(c).equals(windows.get(c))){
//                    valid++;
//                }
//            }
//
//            //缩小滑动窗口
//            while(right - left >= p.length()){
//                if(valid == need.size()) res.add(left);
//
//                char d = s.charAt(left);//要移除的字符
//                left++;
//
//                if(need.containsKey(d)){
//                    if(need.get(d).equals(windows.get(d))){
//                        valid--;
//                    }
//                    windows.put(d, windows.get(d) - 1);
//                }
//            }
//        }
//
//        return res;
//
//    }

    public static void main(String[] args) {
        String s = "abab";
        String p = "ab";
        System.out.println(new Leetcode438().findAnagrams(s, p));
    }
}
