import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new long[n + 1];

        if (n == 1) {
            System.out.println("1");
            return;
        }
        if (n == 2) {
            System.out.println("3");
            return;
        } 
        
        dp[1] = 1;
        dp[2] = 3;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + 2 * dp[i - 2]) % 10007;
        }

        System.out.println(dp[n] % 10007);
    }
}