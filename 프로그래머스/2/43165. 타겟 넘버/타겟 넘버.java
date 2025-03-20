class Solution {
    static int cnt;
    static int[] numbers;
    static int target;
    
    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
        dfs(0, 0);
        return cnt;
    }
    
    public void dfs(int cur, int depth) {
        if (depth == numbers.length && cur == target) {
            cnt++;
            return;
        }
        else if (depth == numbers.length) return;
        
        dfs(cur + numbers[depth], depth + 1);
        dfs(cur - numbers[depth], depth + 1);
    }
}