import java.util.*;

class Solution {
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    
    public int solution(int n, int[][] wires) {
        list = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) list[i] = new ArrayList<>();
        
        // 값 넣어주기
        for (int i = 0; i < wires.length; i++) {
            int a = wires[i][0];
            int b = wires[i][1];
            
            list[a].add(b);
            list[b].add(a);
        }
        
        // 모든 간선에 대해 한번씩 끊어보기
        for (int i = 0; i < wires.length; i++) {
            int a = wires[i][0];
            int b = wires[i][1];
            
            list[a].remove(Integer.valueOf(b));
            list[b].remove(Integer.valueOf(a));
            
            visited = new boolean[n+1];
            
            int cnt = dfs(1);
            
            int diff = Math.abs(cnt - (n - cnt));
            min = Math.min(min,diff);
            
            list[a].add(b);
            list[b].add(a);
        }
        
        return min;
    }
    
    public static int dfs(int v) {
        visited[v] = true;
        int cnt = 1;
        
        for (int next : list[v]) {
            if (!visited[next]) {
                cnt += dfs(next);
            }
        }
        
        return cnt;
    }
}