package bryanze.leetcode;

import java.util.*;

/**
 * 小美准备登录美团，需要输入密码，小美忘记了密码，只记得密码可能是 n个字符串中的一个。
 * 小美会按照密码的长度从小到大依次尝试每个字符串，对于相同长度的字符串，
 * 小美随机尝试，并且相同的密码只会尝试一次。小美想知道，
 * 她最少需要尝试多少次才能登录成功，最多需要尝试多少次才能登录成功。
 * 小美不会重新尝试已经尝试过的字符串。成功登录后会立即停止尝试。
 * <p>
 * 输入描述
 * 第一行输入一个整数 n(1<=n<=1000)代表密码字符串的个数。
 * 第二行输入一个只由小写字母组成的字符串 s(1<=|s|<=1000)代表正确的密码。
 * 接下来 n 行，每行输入一个长度不超过 1000的字符串，代表小美记得的密码。
 * <p>
 * 输出描述
 * 在一行上输出两个整数，表示最少和最多尝试次数。
 *
 * @author lizelin
 * @date 2024/08/10
 */
public class MT810_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String ans = sc.next();
        HashMap<Integer, List<String>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String str = sc.next();
            if (!map.containsKey(str.length())) {
                map.put(str.length(), new ArrayList<>());
            }

            if (!map.get(str.length()).contains(str)) {
                map.get(str.length()).add(str);
            }
        }

        int min = 0;
        int max = 0;
        int step = 0;
        List<Map.Entry<Integer, List<String>>> list = new ArrayList<>(map.entrySet());
        list.sort(Comparator.comparingInt(Map.Entry::getKey));
        for (Map.Entry<Integer, List<String>> entry : list) {
            if (entry.getValue().contains(ans)) {
                min = step + 1;
                max = step + entry.getValue().size();
            } else {
                step += entry.getValue().size();
            }
        }

        System.out.println(min + " " + max);
    }
}
