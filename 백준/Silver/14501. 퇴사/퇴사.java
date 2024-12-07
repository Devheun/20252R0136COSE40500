import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[] T;
    static int[] P;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        T = new int[N + 2];
        P = new int[N + 2];
        dp = new int[N + 2];

        for (int i = 1; i <= N; i++) {
            String input = br.readLine();
            T[i] = Integer.parseInt(input.split(" ")[0]);
            P[i] = Integer.parseInt(input.split(" ")[1]);
        }

        for (int i = 1; i <= N; i++) {
            if (i + T[i] <= N + 1) {
                // 전자가 상담 안한 경우, 후자가 상담한 경우
                dp[i + T[i]] = Math.max(dp[i + T[i]], dp[i] + P[i]);
            }

            // 금액이 비는 요일이 없어야됨. 이전 날과 비교해서 더 큰 값으로 설정
            dp[i + 1] = Math.max(dp[i], dp[i + 1]);
        }
        System.out.println(dp[N + 1]);
    }

}

