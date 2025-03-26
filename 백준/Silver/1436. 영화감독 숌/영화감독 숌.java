import java.io.*;
import java.util.*;

public class Main { 
    static int N;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        int cnt = 1;
        int[] result = new int[10001];
        for (int i = 666; i <= 10000000; i++) {
            if (String.valueOf(i).contains("666") && cnt < 10001) {
                result[cnt] = i;
                cnt++;
            }
        }
        
        bw.write(result[N] + "\n");
        bw.flush();
        bw.close();
    }
}