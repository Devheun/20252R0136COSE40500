import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    static int N;
    static int x;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        PriorityQueue<Info> pq = new PriorityQueue<>(new PQComparator());

        for (int i = 0; i < N; i++) {
            x = Integer.parseInt(br.readLine());

            if (x != 0) { // 값 추가
                pq.add(new Info(Math.abs(x), x));
            } else { // 절댓값 가장 작은 값 출력 및 값 배열에서 제거
                if (pq.isEmpty()) {
                    bw.write("0\n");
                } else {
                    Info cur = pq.poll();
                    bw.write(cur.realVal + "\n");
                }
            }
        }

        bw.flush();
        bw.close();
    }
}

class Info {
    int absVal;
    int realVal;

    Info(int absVal, int realVal) {
        this.absVal = absVal;
        this.realVal = realVal;
    }
}

class PQComparator implements Comparator<Info> {
    @Override
    public int compare(Info o1, Info o2) {
        if (o1.absVal == o2.absVal) {
            return o1.realVal - o2.realVal;
        }
        return o1.absVal - o2.absVal;
    }
}