import java.io.*;
import java.util.*;

class Info {
    int value;
    int idx;
    
    Info(int value, int idx) {
        this.value = value;
        this.idx = idx;
    }
}


class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Deque<Info> stack = new ArrayDeque<>();
    static int N;
    
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder result = new StringBuilder();
        int[] arr = new int[N+1];
        
        while (st.hasMoreTokens()) {
            for (int i = 1; i <= N; i++) {
                int newValue = Integer.parseInt(st.nextToken());
                if (stack.isEmpty()) {
                    stack.push(new Info(newValue, i));
                }
                else {
                    while (true) {
                        if (stack.isEmpty()) {
                            stack.push(new Info(newValue,i));
                            break;
                        }
                        
                        if (stack.peek().value < newValue) {
                            arr[stack.peek().idx] = newValue;
                            stack.pop();
                        }
                        else {
                            stack.push(new Info(newValue, i));
                            break;
                        }
                    }
                }
            }
        }
        
        for (int j = 1; j <= N; j++) {
            if (arr[j] == 0) {
                result.append("-1 ");
            }
            else result.append(arr[j] + " ");
        }
        
        bw.write(result.toString() + "\n");
        bw.flush();
        bw.close();
    }
}