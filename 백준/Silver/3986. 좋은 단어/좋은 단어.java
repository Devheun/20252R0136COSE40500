import java.io.*;
import java.util.*;

class Main {
    static int N;
    static Deque<Character> stack = new ArrayDeque<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int cnt = 0;
   
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            for (int j = 0; j < word.length(); j++) {
                char character = word.charAt(j);
                if (!stack.isEmpty() && stack.peek() == character) {
                    stack.pop();
                }
                else stack.push(character);
            }
            
            if (stack.isEmpty()) cnt++;
            stack.clear();
        }
        bw.write(cnt+"\n");
        bw.flush();
        bw.close();
    }
}