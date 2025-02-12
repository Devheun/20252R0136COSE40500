import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        long sum = 1;
        int arr[] = new int[10];
        for (int i = 0; i < 3; i++) {
            long num = Long.parseLong(br.readLine());
            sum *= num;
        }
        String strNum = String.valueOf(sum);
        
        for (int j = 0; j < strNum.length(); j++) {
            int number = strNum.charAt(j) - '0';
            arr[number]++;
        }
        
        for (int k = 0; k < 10; k++) {
            bw.write(arr[k]+"\n");
        }
        
        bw.flush();
        bw.close();
    }
}