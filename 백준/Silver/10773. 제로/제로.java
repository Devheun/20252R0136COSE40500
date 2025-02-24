import java.io.*;
import java.util.*;

class Main {
    static int K;
    static long result;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Deque<Integer> stack = new ArrayDeque<>();
    
    public static void main(String[] args) throws IOException {
        input();
        process();
    }
    
    static void input() throws IOException {
        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num != 0) {
                stack.push(num);
            }
            else if (num == 0) {
                stack.pop();
            }
        }
    }
    
    static void process() throws IOException {
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }
}