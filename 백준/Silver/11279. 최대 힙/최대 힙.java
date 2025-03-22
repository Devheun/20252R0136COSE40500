import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static long x;
    static PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            x = Long.parseLong(br.readLine());
            
            if (x == 0) {
                if (!pq.isEmpty()) {
                    long val = pq.poll();
                    bw.write(val+"\n");
                }
                else bw.write("0\n");
            }
            else pq.add(x);
        }
        
        bw.flush();
        bw.close();
    }
}