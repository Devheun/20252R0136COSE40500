import java.io.*;
import java.util.*;

public class Main {
    static long[] dp;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        dp = new long[n + 2];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n + 1; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }

        System.out.println(dp[n]);

    }
}