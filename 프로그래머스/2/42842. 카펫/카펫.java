class Solution {
    static int[] answer = new int[2];
    static boolean processed = false;
    public int[] solution(int brown, int yellow) {
        for (int i = 1; i <= yellow; i++) {
            if (yellow % i == 0) {
                processed = process(brown, i, yellow / i);
                if (processed) {
                    break;
                }
            }
        }
        return answer;
    }
    
    public static boolean process(int brown, int row, int val) {
        // brown 갯수 비교 연산
        int sum = val * 2 + row * 2 + 4;
        
        if (brown == sum) {
            answer[0] = val + 2;
            answer[1] = row + 2;
            return true;
        }
        
        return false;
    }
}