import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Main {
    static int N;
    static int M;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Deque<Integer> d = new LinkedList<>();
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        String input = br.readLine();
        N = Integer.parseInt(input.split(" ")[0]);
        M = Integer.parseInt(input.split(" ")[1]);

        for (int i = 1; i <= N; i++) {
            d.addLast(i);
        }

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            int index = ((LinkedList<Integer>) d).indexOf(num);
            if (index == 0) {
                d.pollFirst();
            } else if (index <= (d.size() - 1) / 2) {
                for (int i = 0; i < index; i++) {
                    d.addLast(d.pollFirst());
                    cnt++;
                }
                d.pollFirst();
            } else if (index > (d.size() - 1) / 2) {
                for (int j = 0; j < d.size() - index; j++) {
                    d.addFirst(d.pollLast());
                    cnt++;
                }
                d.pollFirst();
            }
        }
        bw.write(cnt + "\n");
        bw.flush();
        bw.close();

    }
}