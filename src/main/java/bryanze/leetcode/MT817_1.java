package bryanze.leetcode;

import java.util.Scanner;

/**
 * 小美对gcd(最大公约数)很感兴趣，她会询问你t次，每次询问给出一个大于1的正整数n，
 * 你是否找到一个数字m(2<=m<=n),使得gcd(n,m)为素数
 * <p>
 * 输入描述
 * 每个测试文件将包含多组测试数据，每组测试数据的第一行包含一个整数k(2<=k<=10^5).
 * 表示有k个待测数字，接下来k行，每行包含一个整数n(2<=n<=10^9)，表示待测的数字
 * <p>
 * 输出描述
 * 对于每一组测试数据，在一行上输出一个整数，代表数字m。如果有多种合法答案，您可以输出任意一种
 *
 * @author lizelin
 * @date 2024/08/19
 */
public class MT817_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            boolean flag = true;
            for (int i = 2; i * i <= n; i++) {
                if (n % i == 0) {
                    System.out.println(i);
                    flag = false;
                    break;
                }
            }

            if (flag) {
                System.out.println(n);
            }
        }
    }
}
