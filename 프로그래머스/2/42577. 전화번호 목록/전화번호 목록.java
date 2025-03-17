import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Set<String> phones = new HashSet<>(Arrays.asList(phone_book));
        for (int i = 0; i < phone_book.length; i++) {
            for (int j = 1; j < phone_book[i].length(); j++) {
                if (phones.contains(phone_book[i].substring(0,j))) {
                    answer = false;
                    return false;
                }
            }
        }
                                           
        return answer;
    }
}