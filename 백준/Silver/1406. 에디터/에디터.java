import java.io.*;
import java.util.*;

public class Main {
    static String input;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        input = br.readLine();
        M = Integer.parseInt(br.readLine());

        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < input.length(); i++) {
            list.add(input.charAt(i));
        }

        ListIterator<Character> iter = list.listIterator();

        // 처음 커서 맨 뒤로 보내기
        while (iter.hasNext()) {
            iter.next();
        }

        // 연산 수행
        for (int j = 0; j < M; j++) {
            String command = br.readLine();
            if (command.charAt(0) == 'L') {
                if (iter.hasPrevious()) {
                    iter.previous();
                }
            } else if (command.charAt(0) == 'D') {
                if (iter.hasNext()) {
                    iter.next();
                }
            } else if (command.charAt(0) == 'B') {
                if (iter.hasPrevious()) {
                    iter.previous();
                    iter.remove();
                }

            } else { // P $ 입력 시에
                String[] temp = command.split(" ");
                char val = temp[1].charAt(0);
                iter.add(val);
            }
        }
        for (char c : list) {
            bw.write(c);
        }
        
        bw.flush();
        bw.close();
    }
}