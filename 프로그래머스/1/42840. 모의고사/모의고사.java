import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        
        int[] reply1 = new int[answers.length];
        int[] reply2 = new int[answers.length];
        int[] reply3 = new int[answers.length];
        
        // 1번 수포자
        for (int i = 0; i < answers.length; i++) {
            if (i % 5 == 0) reply1[i] = 1;
            else if (i % 5 == 1) reply1[i] = 2;
            else if (i % 5 == 2) reply1[i] = 3;
            else if (i % 5 == 3) reply1[i] = 4;
            else if (i % 5 == 4) reply1[i] = 5;
        }
        
        // 2번 수포자
        for (int i = 0; i < answers.length; i++) {
            if (i % 2 == 0) reply2[i] = 2;
            else if (i % 8 == 1) reply2[i] = 1;
            else if (i % 8 == 3) reply2[i] = 3;
            else if (i % 8 == 5) reply2[i] = 4;
            else if (i % 8 == 7) reply2[i] = 5;
        }
        
        // 3번 수포자
        for (int i = 0; i < answers.length; i++) {
            if (i % 10 == 0 || i % 10 == 1) reply3[i] = 3;
            else if (i % 10 == 2 || i % 10 == 3) reply3[i] = 1;
            else if (i % 10 == 4 || i % 10 == 5) reply3[i] = 2;
            else if (i % 10 == 6 || i % 10 == 7) reply3[i] = 4;
            else if (i % 10 == 8 || i % 10 == 9) reply3[i] = 5;
        }
        
        // 답 체크
        int cnt1 = 0;
        int cnt2 = 0;
        int cnt3 = 0;
        
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == reply1[i]) cnt1++;
            if (answers[i] == reply2[i]) cnt2++;
            if (answers[i] == reply3[i]) cnt3++;
        }
        
        int max_v = Math.max(cnt1, cnt2);
        max_v = Math.max(max_v,cnt3);
        
        List<Integer> rank = new ArrayList<>();
        if (max_v == cnt1) rank.add(1);
        if (max_v == cnt2) rank.add(2);
        if (max_v == cnt3) rank.add(3);
        
        answer = rank.stream().mapToInt(Integer::intValue).toArray();
        
        return answer;
    }
}