import java.io.*;
import java.util.*;

class Main {
    static int T;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static char[][] arr;
    static int w;
    static int h;
    static int[][] dist1; // 불 경로
    static int[][] dist2; // 상근이 경로
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    
    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String input = br.readLine();
            w = Integer.parseInt(input.split(" ")[0]);
            h = Integer.parseInt(input.split(" ")[1]);
            
            arr = new char[h][w];
            dist1 = new int[h][w];
            dist2 = new int[h][w];
            
            for (int j = 0; j < h; j++) {
                Arrays.fill(dist1[j], -1);
                Arrays.fill(dist2[j], -1);
            }
            
            for (int j = 0; j < h; j++) {
                String arrInput = br.readLine();
                for (int k = 0; k < arrInput.length(); k++) {
                    arr[j][k] = arrInput.charAt(k);
                }
            }
            
            Queue<int[]> fireQueue = new ArrayDeque<>();
            Queue<int[]> personQueue = new ArrayDeque<>();
            
            for (int j = 0; j < h; j++) {
                for (int k = 0; k < w; k++) {
                    if (arr[j][k] == '*') {
                        fireQueue.add(new int[]{j, k});
                        dist1[j][k] = 0;
                    }
                    if (arr[j][k] == '@') {
                        personQueue.add(new int[]{j, k});
                        dist2[j][k] = 0;
                    }
                }
            }

            
            while (!fireQueue.isEmpty()) {
                int[] cur = fireQueue.poll();
                int x = cur[0], y = cur[1];
                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    if (nx >= 0 && nx < h && ny >= 0 && ny < w) {
                        if (arr[nx][ny] == '#' || dist1[nx][ny] != -1) continue;
                        dist1[nx][ny] = dist1[x][y] + 1;
                        fireQueue.add(new int[]{nx, ny});
                    }
                }
            }
            
            // 상근이 BFS 돌리기
            int answer = -1;
            while (!personQueue.isEmpty()) {
                int[] cur = personQueue.poll();
                int x = cur[0], y = cur[1];
              
                if (x == 0 || x == h - 1 || y == 0 || y == w - 1) {
                        answer = dist2[x][y] + 1;
                        break;   
                }
                
                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    
                    if (nx >= 0 && nx < h && ny >= 0 && ny < w) {
                        if (arr[nx][ny] == '.' && dist2[nx][ny] == -1 && (dist1[nx][ny] == -1 || dist1[nx][ny] > dist2[x][y] + 1)) {
                            dist2[nx][ny] = dist2[x][y] + 1;
                            personQueue.add(new int[]{nx, ny});
                        }
                    }
                }
            }
            
            if (answer == -1) {
                bw.write("IMPOSSIBLE\n");
            } else {
                bw.write(answer + "\n");
            }

        }
        bw.flush();
        bw.close();
    }
}