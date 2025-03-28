import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int[] dp = new int[5001];
    
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        
        dp[3] = 1;
        dp[5] = 1;
 
        for (int i = 6; i <= N; i++) {
            if (dp[i-5] != 0) dp[i] = dp[i-5] + 1;
            else if (dp[i-3] != 0) dp[i] = dp[i-3] + 1;
        }
        
        if (dp[N] == 0) bw.write("-1\n");
        else bw.write(dp[N] + "\n");
        
        bw.flush();
        bw.close();
    }
}