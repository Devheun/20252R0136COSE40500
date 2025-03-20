import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int L, C;
    static char[] letters = new char[16];
    static char[] P = new char[16];

    public static void main(String[] args) throws IOException {
        String firstLine = br.readLine();
        L = Integer.parseInt(firstLine.split(" ")[0]);
        C = Integer.parseInt(firstLine.split(" ")[1]);

        StringTokenizer st = new StringTokenizer(br.readLine());

        int i = 0;
        while (st.hasMoreTokens()) {
            letters[i] = st.nextToken().charAt(0);
            i++;
        }

        Arrays.sort(letters, 0, C);
        dfs(0, -1, 0, 0);
        bw.flush();
        bw.close();
    }

    public static void dfs(int depth, int prev, int consonant, int vowel) throws IOException {
        if (depth == L) {
            if (consonant >= 2 && vowel >= 1) {
                bw.write(new String(P, 0, L) + "\n");
            }
            return;
        }

        for (int i = prev + 1; i < C; i++) {
            P[depth] = letters[i];
            if (letters[i] == 'a' || letters[i] == 'e' || letters[i] == 'i' || letters[i] == 'o' || letters[i] == 'u') {
                dfs(depth + 1, i, consonant, vowel + 1);
            } else {
                dfs(depth + 1, i, consonant + 1, vowel);
            }
        }
    }
}