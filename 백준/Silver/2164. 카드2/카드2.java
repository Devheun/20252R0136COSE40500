import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static Deque<Integer> q = new ArrayDeque<>();
    
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            q.addLast(i);
        }
        
        while (q.size() >= 2) {
            q.pollFirst();
            q.addLast(q.pollFirst());
        }
        
        bw.write(q.peek() + "\n");
        bw.flush();
        bw.close();
    }
}