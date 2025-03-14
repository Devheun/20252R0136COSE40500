import java.io.*;
import java.util.*;

class Main {
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Deque<int[]> queue = new ArrayDeque<>();
    static int cnt1 = 0; // 색약 X
    static int cnt2 = 0; // 색약 O
    static char[][] arr; // 맵 기록
    static boolean[][] visited; // 방문 기록
    static int N;
    
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N][N];
        arr = new char[N][N];
        
        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], false);
        }
        
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < input.length(); j++) {
                arr[i][j] = input.charAt(j);
            }
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    cnt1++;
                    bfs1(i,j);
                }
            }
        }
        
        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], false);
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    cnt2++;
                    bfs2(i,j);
                }
            }
        }
        
        System.out.print(cnt1 + " " + cnt2);
    }
    
    static void bfs1(int x, int y) {
        visited[x][y] = true;
        queue.addLast(new int[]{x,y});
        
        while (!queue.isEmpty()) {
            int[] peek = queue.pollFirst();
            int curX = peek[0];
            int curY = peek[1];
            
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + curX;
                int ny = dy[i] + curY;
                
                if (nx >=0 && nx < N && ny >= 0 && ny < N) {
                    if (!visited[nx][ny] && arr[nx][ny] == arr[curX][curY]) {
                        queue.addLast(new int[]{nx,ny});
                        visited[nx][ny] = true;
                    }
                }
            }
            
        }
    }
    
    static void bfs2(int x, int y) {
        visited[x][y] = true;
        queue.addLast(new int[]{x,y});
        
        while (!queue.isEmpty()) {
            int[] peek = queue.pollFirst();
            int curX = peek[0];
            int curY = peek[1];
            
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + curX;
                int ny = dy[i] + curY;
                
                if (nx >=0 && nx < N && ny >= 0 && ny < N) {
                    if (!visited[nx][ny]) {
                        if (arr[nx][ny] == 'B' && arr[nx][ny] == arr[curX][curY]) {
                            queue.addLast(new int[]{nx,ny});
                            visited[nx][ny] = true;   
                        }
                        else if (arr[nx][ny] != 'B' && arr[curX][curY] != 'B') {
                            queue.addLast(new int[]{nx,ny});
                            visited[nx][ny] = true;   
                        }
                    }
                }
            }
            
        }        
    }
}