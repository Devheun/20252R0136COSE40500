import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static int[] result;
    static HashSet<String> hs = new LinkedHashSet<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String input = br.readLine();
        N = Integer.parseInt(input.split(" ")[0]);
        M = Integer.parseInt(input.split(" ")[1]);

        arr = new int[N];
        result = new int[M];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int i = 0;
        while (st.hasMoreTokens()) {
            arr[i] = Integer.parseInt(st.nextToken());
            i++;
        }

        Arrays.sort(arr);

        func(0);
        hs.forEach(System.out::println);
    }

    public static void func(int depth) {
        // Base Condition
        if (depth == M) {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < M; i++) {
                sb.append(result[i] + " ");
            }
            hs.add(sb.toString());
            return;
        }

        for (int i = 0; i < N; i++) {
            result[depth] = arr[i];
            func(depth + 1);
        }
    }
}