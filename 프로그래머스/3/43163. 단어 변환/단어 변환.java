import java.util.*;

class Solution {
    static int cnt;
    static String begin, target;
    static String[] words;
    static boolean[] visited;
    
    public int solution(String begin, String target, String[] words) {
        this.begin = begin;
        this.target = target;
        this.words = words;
        visited = new boolean[words.length + 1];
        int result = bfs(begin);
        
        return result;
    }
    
    public static int bfs(String tmp) {
        Queue<WordStep> queue = new ArrayDeque<>();
        
        // 처음에 begin에서 바뀔 수 있는 것들 큐에 다 넣어놓기
        for (int i = 0; i < words.length; i++) {
            int check = 0;
            for (int j = 0; j < words[i].length(); j++) {
                if (tmp.charAt(j) != words[i].charAt(j)) check++;
                if (check >= 2) break;
            }
            if (check == 1) {
                if (words[i].equals(target)) {
                    return 1;
                }
                visited[i] = true;
                queue.add(new WordStep(words[i], 1));
            }
        }
                
        
        while (!queue.isEmpty()) {
            WordStep wordstep = queue.poll();
            String cur = wordstep.word;
            int step = wordstep.step;
            // 여기서 최소 몇번째인지 체크하면 될 듯. 큐에 나올때마다 cnt 체크가 아닌 한 level에서 체크를 해야함.
            for (int i = 0; i < words.length; i++) {
                if (visited[i]) continue;
                int check = 0;
                for (int j = 0; j < words[i].length(); j++) {
                    if (cur.charAt(j) != words[i].charAt(j)) check++;
                    if (check >= 2) break;
                }
                if (check == 1) {
                    if (words[i].equals(target) && !visited[i]) {
                        return step + 1;
                    }
                    visited[i] = true;
                    queue.add(new WordStep(words[i], step + 1));
                }
            }
        
        }
        return 0;
    }
}

    class WordStep {
        String word;
        int step;
        
        WordStep(String word, int step) {
            this.word = word;
            this.step = step;
        }
    }