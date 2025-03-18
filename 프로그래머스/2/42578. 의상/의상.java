import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < clothes.length; i++) {
            String kind = clothes[i][1];
            
            map.put(kind, map.getOrDefault(kind, 0) + 1);
        }
        
        List<Integer> values = new ArrayList<>(map.values());
        
        int cnt = 1;
        for (int i = 0; i < values.size(); i++) {
            cnt *= values.get(i) + 1;
        }
        
        answer = cnt - 1;
        
        return answer;
    }
}