import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int t;
   
    static int[][] dist;
    static final int[] dx = {-1,-2,-2,-1,1,2,2,1};
    static final int[] dy = {-2,-1,1,2,2,1,-1,-2};
    static int dest_x;
    static int dest_y;
    static int l;
    
    public static void main(String[] args) throws IOException {
        t = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < t; i++) {
            l = Integer.parseInt(br.readLine());
            
            dist = new int[l][l];
            String input = br.readLine();
            int k_x = Integer.parseInt(input.split(" ")[0]);
            int k_y = Integer.parseInt(input.split(" ")[1]);
            
            String dest = br.readLine();
            dest_x = Integer.parseInt(dest.split(" ")[0]);
            dest_y = Integer.parseInt(dest.split(" ")[1]);
            if (k_x == dest_x && k_y == dest_y) {
                bw.write("0\n");
                continue;
            }
            
            bfs(k_x,k_y);
          
        }
        bw.flush();
        bw.close();
    }
    
    public static void bfs(int x, int y) throws IOException {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});
        
        while (!q.isEmpty()) {
            int curX = q.peek()[0];
            int curY = q.peek()[1];
            q.poll();
            
            for (int i = 0; i < 8; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];
                
                if (nx>=0 && ny>=0 && nx < l && ny <l) {
                    
                    if (nx == dest_x && ny == dest_y) {
                        bw.write((dist[curX][curY] + 1) + "\n");
                        return;
                    }
                    
                    if (dist[nx][ny] == 0) {
                        q.add(new int[]{nx,ny});
                        dist[nx][ny] = dist[curX][curY] + 1;
                    }
                }
            }
        }
    }
}