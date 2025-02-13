import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String N = br.readLine();
        int[] arr = new int[10];

        // 6이랑 9일때만 특수케이스로
        for (int i = 0; i < N.length(); i++) {
            int num = N.charAt(i) - '0';
            if (num == 9 || num == 6) {
                int small = (arr[9] >= arr[6]) ? 6 : 9;
                arr[small]++;
            } else {
                arr[num]++;
            }
        }

        int max = -1;
        for (int i = 0; i <= 9; i++) {
            max = Math.max(max, arr[i]);
        }
        bw.write(max + "\n");
        bw.flush();
        bw.close();
    }
}