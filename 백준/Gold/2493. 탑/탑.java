import java.io.*;
import java.util.*;

class Info {
    int idx;
    int height;
    
    Info(int idx, int height) {
        this.idx = idx;
        this.height = height;
    }
}

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Deque<Info> stack = new ArrayDeque<>();
        StringBuilder result = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        for (int i = 1; i <= N; i++) {
            int height = Integer.parseInt(st.nextToken());
            
            if (stack.isEmpty()) {
                stack.push(new Info(i, height));
                result.append("0 ");
            }
            else {
                while (true) {
                    if (stack.isEmpty()){
                        result.append("0 ");
                        stack.push(new Info(i, height));
                        break;
                    }
                    if (stack.peek().height < height) {
                        stack.pop();
                    }
                    else {
                        result.append(stack.peek().idx + " ");
                        stack.push(new Info(i, height));
                        break;
                    }
                }
            }
        }
        
        bw.write(result.toString() + "\n");
        bw.flush();
        bw.close();
    }
}