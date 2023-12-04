package bryanze.leetcode;


import java.util.HashMap;

public class Leetcode389 {
    public char findTheDifference(String s, String t) {
        if(s.isEmpty()){
            return t.charAt(0);
        }

        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            hashMap.put(s.charAt(i), hashMap.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char tChar = t.charAt(i);
            hashMap.put(tChar, hashMap.getOrDefault(tChar, 0) - 1);
            if(hashMap.get(tChar) < 0){
                return tChar;
            }

        }
        return ' ';
    }

    public static void main(String[] args) {
        String s = "abc";
        String t = "abca";
        System.out.println(new Leetcode389().findTheDifference(s, t));
    }
}
