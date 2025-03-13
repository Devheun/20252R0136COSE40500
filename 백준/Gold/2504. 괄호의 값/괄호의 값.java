import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Deque<Character> stack = new ArrayDeque<>();
    
    public static void main(String[] args) throws IOException {
        String input = br.readLine();
        int val = 1;
        int result = 0;
        boolean flag = false;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '(') {
                val *= 2;
                flag = false;
                stack.push(c);
            }
            else if (c == '[') {
                val *= 3;
                flag = false;
                stack.push(c);
            }
            else if (!stack.isEmpty() && c == ')' && stack.peek() == '(') {
                if (flag == false) {
                    result += val;
                }
                val /= 2;
                flag = true;
                stack.pop();
            }
            else if (!stack.isEmpty() && c == ']' && stack.peek() == '[') {
                if (flag == false) {
                    result += val;
                }
                val /= 3;
                flag = true;
                stack.pop();
            }
            else if (stack.isEmpty() && (c == ']' || c == ')')) {
                System.out.println("0");
                return;
            }
        }
        
        if (!stack.isEmpty()) {
            System.out.println("0");
        } else {
            System.out.println(result);
        }
    }
}