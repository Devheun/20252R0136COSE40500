import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int result = 0;
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int i = 0;
        while (st.hasMoreTokens()) {
            arr[i] = Integer.parseInt(st.nextToken());
            i++;
        }
        int x = Integer.parseInt(br.readLine());
        
        Arrays.sort(arr);
        
        int left = 0;
        int right = n-1;
        
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == x) {
                result++;
                left++;
                right--;
            }
            else if (sum < x) left++;
            else right--;
        }
        
        bw.write(result + "\n");
        bw.flush();
        bw.close();
        
        
    }
}