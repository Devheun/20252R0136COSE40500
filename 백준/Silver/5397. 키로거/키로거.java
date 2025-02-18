import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int T;
    static LinkedList<Character> list = new LinkedList<>();


    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            list.clear();
            String L = br.readLine();
            ListIterator<Character> iter = list.listIterator();
            for (int j = 0; j < L.length(); j++) {
                char c = L.charAt(j);
                if (c == '<') {
                    if (iter.hasPrevious()) {
                        iter.previous();
                    }
                } else if (c == '>') {
                    if (iter.hasNext()) {
                        iter.next();
                    }
                } else if (c == '-') {
                    if (iter.hasPrevious()) {
                        iter.previous();
                        iter.remove();
                    }
                } else {
                    iter.add(c);
                }
            }

            for (char c : list) {
                bw.write(c);
            }
            bw.write("\n");
            bw.flush();
        }
        bw.close();
    }
}