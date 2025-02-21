import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static LinkedList<Integer> list = new LinkedList<>();
    static List<Integer> result = new ArrayList<>();
    static int N;
    static int K;
    
    public static void main(String[] args) throws IOException {
        input();
        process();
    }
    
    static void input() throws IOException {
        String input = br.readLine();
        N = Integer.parseInt(input.split(" ")[0]);
        K = Integer.parseInt(input.split(" ")[1]);
        
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }
    }
    
    static void process() throws IOException {
        ListIterator<Integer> iter = list.listIterator();
        
        while (!list.isEmpty()) {
            for (int i = 0; i < K - 1; i++) {
                if (!iter.hasNext()) {
                    iter = list.listIterator();
                }
                iter.next();
            }
            
            if (!iter.hasNext()){
                iter = list.listIterator();
            }
            
            int removed = iter.next();
            result.add(removed);
            iter.remove();
        }
        
        StringBuilder output = new StringBuilder();
        output.append("<");
        for (int i = 0; i < result.size() - 1; i++) {
            output.append(result.get(i) + ", ");
        }
        output.append(result.get(result.size()-1) + ">");
        
        bw.write(output.toString());
        bw.flush();
        bw.close();
    }
    
}