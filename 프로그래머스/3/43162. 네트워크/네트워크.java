class Solution {
    static int n;
    static int[][] computers;
    static boolean[][] visited;
    static int cnt;
    
    public int solution(int n, int[][] computers) {
        this.n = n;
        this.computers = computers;
        
        visited = new boolean[n+1][n+1];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (computers[i][j] == 1 && !visited[i][j]) {
                    dfs(i,j);
                    cnt++;
                }
                
            }
        }
        
        return cnt;
    }
    
    public static void dfs(int from, int to) {
        visited[from][to] = true; // from 컴퓨터와 to 컴퓨터는 연결되어있음
        visited[to][from] = true;
        
        for (int i = 0; i < n; i++) {
            if (!visited[to][i] && computers[to][i] == 1) {
                dfs(to,i);
            }
        }
        
        return;
    }
}