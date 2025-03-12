import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Deque<Character> stack = new ArrayDeque<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                stack.push('(');
            }
            // 레이저
            else if (input.charAt(i) == ')' && i > 0 && input.charAt(i - 1) == '(') {
                stack.pop();
                count += stack.size();
            }
            // 막대기 끝
            else {
                count += 1;
                stack.pop();
            }
        }
        bw.write(count + "\n");
        bw.flush();
        bw.close();
    }
}