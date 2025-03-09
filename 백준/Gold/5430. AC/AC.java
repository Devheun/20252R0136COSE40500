import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Main {
    static int T;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Deque<String> d = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        input();
    }

    static void input() throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String input = br.readLine();
            String subInput = input.substring(1, input.length() - 1);
            StringTokenizer st = new StringTokenizer(subInput, ",");

            while (st.hasMoreTokens()) {
                d.addLast(st.nextToken());
            }

            process(p, d);
            d.clear();
        }
    }

    static void process(String p, Deque<String> d) throws IOException {
        boolean isReverse = false; // 0번 인덱스가 맨 앞
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == 'R') {
                isReverse = !isReverse;
            } else if (p.charAt(i) == 'D') {
                if (d.isEmpty()) {
                    bw.write("error\n");
                    bw.flush();
                    return;
                } else {
                    if (isReverse) {
                        d.pollLast();
                    } else {
                        d.pollFirst();
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int size = d.size();
        if (isReverse) {
            for (int i = 0; i < size; i++) {
                sb.append(d.pollLast() + ",");
            }
        } else {
            for (int i = 0; i < size; i++) {
                sb.append(d.pollFirst() + ",");
            }
        }
        if (sb.length() > 1) {
            sb.deleteCharAt(sb.length() - 1);            
        }
        sb.append("]");
        bw.write(sb.toString() + "\n");
        bw.flush();
    }
}