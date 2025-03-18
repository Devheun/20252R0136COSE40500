import java.util.*;

class Solution {
    static boolean[] visited = new boolean[7];
    static Set<Integer> answer = new HashSet<>();
    static String numbers;
    
    public int solution(String numbers) {
        this.numbers = numbers;
        
        for (int i = 0; i < numbers.length(); i++) {
            back("", 0, i+1);
        }
        
        return answer.size();
    }
    
    public static void back(String str, int depth, int goal) {
        if (depth == goal) {
            int tmp = Integer.parseInt(str);
            if (!answer.contains(tmp) && isPrime(tmp)) {
                answer.add(tmp);
            }
            return;
        }
        
        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                str += numbers.charAt(i);
                visited[i] = true;
                back(str, depth + 1, goal);
                visited[i] = false;
                str = str.substring(0, str.length()-1);
            }
        }
        
    }
    
    public static boolean isPrime(int number) {
        if (number <= 1) return false;
        
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) return false;
        }
        
        return true;
    }
}