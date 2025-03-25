import java.util.*;

class Solution {
    static boolean[] visited;
    static String[] result;
    static String[][] tickets;
    static boolean found = false;  // valid 경로를 찾았음을 표시하는 변수
    
    public String[] solution(String[][] tickets) {
        this.tickets = tickets;
        
        // DFS 호출 전에 티켓 배열을 사전순으로 정렬합니다.
        Arrays.sort(tickets, new TicketComparator());
        
        result = new String[tickets.length + 1];
        visited = new boolean[tickets.length];
        List<String> tmp = new ArrayList<>();
        tmp.add("ICN");
        
        dfs(0, "ICN", tmp);
        
        return result;
    }
    
    static void dfs(int depth, String now, List<String> tmp) {
        if (found) return;  // 이미 valid 경로를 찾은 경우 더 이상 탐색하지 않음
        
        // 모든 티켓을 사용했으면 valid 경로를 찾은 것으로 간주하고 결과 저장 후 종료
        if (depth == tickets.length) {
            for (int i = 0; i < tmp.size(); i++) {
                result[i] = tmp.get(i);
            }
            found = true;
            return;
        }
        
        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && now.equals(tickets[i][0])) {
                visited[i] = true;
                tmp.add(tickets[i][1]);
                
                dfs(depth + 1, tickets[i][1], tmp);
                
                if (found) return;  // valid 경로가 이미 발견되었으면 더 이상 백트래킹하지 않음
                
                visited[i] = false;
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}

class TicketComparator implements Comparator<String[]> {
    @Override
    public int compare(String[] s1, String[] s2) {
        if (s1[0].equals(s2[0])) {
            return s1[1].compareTo(s2[1]);
        }
        return s1[0].compareTo(s2[0]);
    }
}