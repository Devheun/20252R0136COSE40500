import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static String baseInput;
    static int M;
    static LinkedList<Character> list = new LinkedList<>();
    
    static void input() throws IOException {
        baseInput = br.readLine();
        for (int i = 0; i < baseInput.length(); i++) {
            list.add(baseInput.charAt(i));
        }
        M = Integer.parseInt(br.readLine());
    }
    
    static void process() throws IOException {
        ListIterator<Character> iter = list.listIterator();
        while (iter.hasNext()) { // 커서 맨 뒤로
            iter.next();
        }
        
        for (int i = 0; i < M; i++) {
            String command = br.readLine();
            if (command.equals("L")) {
                if (iter.hasPrevious()) {
                    iter.previous();
                }
            }
            else if (command.equals("D")) {
                if (iter.hasNext()) {
                    iter.next();
                }
            }
            else if (command.equals("B")) {
                if (iter.hasPrevious()) {
                    iter.previous();
                    iter.remove();
                }
            }
            else {
                char cha = command.split(" ")[1].charAt(0);
                iter.add(cha);
            }
        }
    }
    
    static void print() throws IOException {
        for (char c : list) {
            bw.write(c);
        }
        bw.flush();
        bw.close();
    }
    
    public static void main(String[] args) throws IOException {
        input();
        process();
        print();
    }
}