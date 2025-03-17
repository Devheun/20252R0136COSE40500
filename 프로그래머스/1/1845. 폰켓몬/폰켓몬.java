import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int length = nums.length / 2;
        int answer = 0;
        Set<Integer> pocketmons = new HashSet<>();
        
        for (int i = 0; i < nums.length; i++) {
            pocketmons.add(nums[i]);
        }
        
        if (pocketmons.size() > length) answer = length;
        else answer = pocketmons.size();
        
        return answer;
    }
}