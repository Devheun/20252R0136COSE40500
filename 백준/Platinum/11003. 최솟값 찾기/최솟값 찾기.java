import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int L;
    static Deque<int[]> deque = new LinkedList<>();
    // 0이 index, 1이 value
    
    public static void main(String[] args) throws IOException {
        process();    
    }
    
    static void process() throws IOException {
        String firstLine = br.readLine();
        N = Integer.parseInt(firstLine.split(" ")[0]);
        L = Integer.parseInt(firstLine.split(" ")[1]);
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st.nextToken());
            
            while (!deque.isEmpty() && deque.peekLast()[1] > temp) {
                deque.pollLast();
            }
            deque.addLast(new int[]{i, temp});
            
            // window 크기 다 찼을 때 빼주기
            if (deque.peekFirst()[0] <= i - L) {
                deque.pollFirst();
            }
            bw.write(deque.peekFirst()[1] + "\n");
        }
        bw.flush();
        bw.close();
    }
}