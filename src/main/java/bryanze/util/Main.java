package bryanze.util;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 快读:FastReader 类
 * 快写:PrintWriter 类,其定义后使用和System.out 用法一样，
 * 但是你不需要从System这个类中输出.
 *
 * @author lizelin
 * @date 2024/03/17
 */
public class Main {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        int a = sc.nextInt();
        int b = sc.nextInt();
        out.println(a + b);
        // 最后记得flush，不然会没有输出
        out.flush();
    }
}

// 下面是快读模板。需要使用时直接贴在下面就好了
class FastReader {
    StringTokenizer st;
    BufferedReader br;

    public FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

}
