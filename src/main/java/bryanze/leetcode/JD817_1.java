package bryanze.leetcode;

import java.util.Scanner;

/**
 * 村子里有一些桩子，从左到右高度依次为 1,1+2,1+2+3,…，每两颗桩子之间的间隔为 1。
 * 现在下了一场大雪，但是不知道雪下了多厚，现在给你两个数字，
 * 这是雪后某相邻两个桩子在雪面上的高度，请你通过这两个数字计算雪的厚度。
 * <p>
 * 输入描述
 * 第一行输入两个整数a，b(1<=a<b<=5*10^5)
 * <p>
 * 输出描述
 * 一个整数代表答案，保证答案存在
 *
 * @author lizelin
 * @date 2024/08/20
 */
public class JD817_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int h = 0;
        for (int i = 1; i <= b - a; i++) {
            h += i;
        }

        System.out.println(h - b);
    }

    //13组
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int a = scanner.nextInt();
//        int b = scanner.nextInt();
//
//        long i = b - a;
//        long h_i = i * (i + 1) / 2;
//        long snowThickness = h_i - b;
//
//        System.out.println(snowThickness);
//    }
}
