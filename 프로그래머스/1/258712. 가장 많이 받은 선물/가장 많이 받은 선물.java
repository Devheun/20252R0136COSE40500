import java.io.*;
import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        HashMap<String, Integer> giftScore = new HashMap<>();
        HashMap<String, Integer> giftRecord = new HashMap<>();
        HashMap<String, Integer> resultMap = new HashMap<>();
        // 선물 지수 초기화
        for (int i = 0; i < friends.length; i++) {
            giftScore.put(friends[i], 0);
            resultMap.put(friends[i], 0);
        }
        
        // 서로 주고받은 선물 기록 초기화
        for (int i = 0; i < gifts.length; i++) {
            giftRecord.put(gifts[i], 0);
        }
        
        
        // 선물 지수 입력
        for (int i = 0; i < gifts.length; i++) {
            String giftInfo = gifts[i];
            String gifter = giftInfo.split(" ")[0];
            String giftee = giftInfo.split(" ")[1];
            
            giftScore.put(gifter, giftScore.get(gifter) + 1);
            giftScore.put(giftee, giftScore.get(giftee) - 1);
        }
        
        // 서로 주고받은 선물 기록
        for (int i = 0; i < gifts.length; i++) {    
            giftRecord.put(gifts[i], giftRecord.get(gifts[i]) + 1);
        }
    
        
        // 루프 돌면서 선물 몇 개 받을 지 체크하기
        for (int i = 0; i < friends.length - 1; i++) {
            for (int j = i + 1; j < friends.length; j++) {
                String key1 = friends[i] + " " + friends[j];
                String key2 = friends[j] + " " + friends[i];
                
                if (giftRecord.getOrDefault(key1, 0) < giftRecord.getOrDefault(key2,0)) {
                    resultMap.put(friends[j], resultMap.get(friends[j]) + 1);
                }
                else if (giftRecord.getOrDefault(key1,0) > giftRecord.getOrDefault(key2,0)) {
                    resultMap.put(friends[i], resultMap.get(friends[i]) + 1);
                }
                else {
                    if (giftScore.get(friends[i]) < giftScore.get(friends[j])) {
                        resultMap.put(friends[j], resultMap.get(friends[j]) + 1);
                    }
                     else if (giftScore.get(friends[i]) > giftScore.get(friends[j])) {
                        resultMap.put(friends[i], resultMap.get(friends[i]) + 1);
                    }
                }
            }
        }
        
        List<Integer> values = new ArrayList<>(resultMap.values());
        answer = Collections.max(values);
        
        return answer;
    }
}