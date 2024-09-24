package bryanze.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


/**
 * @author lizelin
 * @date 2024/09/14
 */
public class MT914_T1 {

    static class Pair {
        int key;
        int value;

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int posR = -1;
        int posG = -1;
        int posB = -1;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == 'R') {
                posR = i;
            } else if (c == 'B') {
                posB = i;
            } else if (c == 'G') {
                posG = i;
            }
        }

        int timeR = bfs(posR, str);
        int timeG = bfs(posG, str);
        int timeB = bfs(posB, str);
        System.out.println(timeR + " " + timeB + " " + timeG);

    }

    private static int bfs(int posSeeker, String s) {

        Queue<Pair> queue = new LinkedList<>();
        boolean[] visited = new boolean[s.length()];
        queue.offer(new Pair(posSeeker, 0));
        visited[posSeeker] = true;
        HashSet<Character> hiders = new HashSet<>();
        hiders.add('R');
        hiders.add('G');
        hiders.add('B');
        hiders.remove(s.charAt(posSeeker));
        while (!queue.isEmpty()) {
            Pair cur = queue.poll();
            int pos = cur.getKey();
            int dis = cur.getValue();
            if (hiders.contains(s.charAt(pos))) {
                return dis;
            }

            if (pos > 0 && s.charAt(pos - 1) != '#' && !visited[pos - 1]) {
                queue.offer(new Pair(pos - 1, dis + 1));
                visited[pos - 1] = true;
            }

            if (pos< s.length() - 1 && s.charAt(pos + 1) != '#' && !visited[pos + 1]) {
                queue.offer(new Pair(pos + 1, dis + 1));
                visited[pos + 1] = true;
            }
        }

        return -1;
    }
}
