class Solution {
    static int depth;
    static String temp;
    static String word;
    static int result;
    static int answer;
    
    public int solution(String word) {
        this.word = word;
        back(0, "");
        return result;
    }
    
    public static void back(int depth, String temp) {
        // Base Condition
        if (temp.equals(word)) {
            result = answer;
            return;
        }
        
        // Base Condition 
        if (depth == 5) return;
        
        for (int i = 0; i < 5; i++) {
            if (i == 0) { answer++; back(depth + 1, temp + "A");}
            else if (i == 1){ answer++; back(depth + 1, temp + "E"); }
            else if (i == 2) { answer++; back(depth + 1, temp + "I"); }
            else if (i == 3) { answer++; back(depth + 1, temp + "O"); }
            else if (i == 4) { answer++; back(depth + 1, temp + "U"); }
        }
    }
}