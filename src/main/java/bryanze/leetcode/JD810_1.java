package bryanze.leetcode;

import java.util.Scanner;

/**
 * 薯条哥昨晚喝醉了，走路开始疯狂摇摆，方向也分不清了。
 * 假设他所在的地方是一个二维平面，一开始它位于坐标为(0,0)的地方，并且面朝北方即y轴正方向。
 * W表示薯条哥向前走，A表示薯条哥把当前方向向左转90度，
 * D表示薯条哥把方向向右转90度，S表示薯条哥呆在原地。
 * 给出一个字符串表示薯条哥的酒后行为方式，你能告诉他走完后它位于哪个坐标点吗?
 * <p>
 * 输入描述
 * 输入仅有一行，一个字符串S(1<=S<=10^5)，并且仅有四种字符 W A S D 表示薯条哥的行为方式。
 * <p>
 * 输出描述
 * 输出仅有一行，坐标位置x和y用空格分开，表示薯条哥的最终位置。
 *
 * @author lizelin
 * @date 2024/08/11
 */
public class JD810_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int east = 0, west = 2, south = 3, north = 1;
        int current = north;

        int x = 0, y = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'S') {
                continue;
            }

            if (s.charAt(i) == 'W') {
                if (current == north) {
                    y++;
                } else if (current == south) {
                    y--;
                } else if (current == east) {
                    x++;
                } else {
                    x--;
                }
            } else if (s.charAt(i) == 'A') {
                current = (current + 1) % 4;
            } else if (s.charAt(i) == 'D') {
                current = (current - 1 + 4) % 4;
            }
        }

        System.out.println(x + " " + y);
//        System.out.println(-1 % 4);
    }
}
