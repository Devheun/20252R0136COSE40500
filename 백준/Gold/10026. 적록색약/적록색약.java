import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static char[][] arr;
    static boolean[][] visited;
    static int normal_cnt_red;
    static int normal_cnt_blue;
    static int normal_cnt_green;

    // 적록색약 카운트
    static int cnt_red;
    static int cnt_blue;

    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < input.length(); j++) {
                arr[i][j] = input.charAt(j);
            }
        }

        // 적록색약 아닌 사람 카운트
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && arr[i][j] == 'R') {
                    bfs(i, j, 'R');
                    normal_cnt_red++;
                } else if (!visited[i][j] && arr[i][j] == 'G') {
                    bfs(i, j, 'G');
                    normal_cnt_green++;
                } else if (!visited[i][j] && arr[i][j] == 'B') {
                    bfs(i, j, 'B');
                    normal_cnt_blue++;
                }
            }
        }
        int normal_cnt = normal_cnt_red + normal_cnt_green + normal_cnt_blue;

        for (int j = 0; j < N; j++) {
            Arrays.fill(visited[j], false);
        }

        // 적록색약용 배열로 변경
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 'G') {
                    arr[i][j] = 'R';
                }
            }
        }

        // 적록색약 카운트
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && arr[i][j] == 'R') {
                    bfs(i, j, 'R');
                    cnt_red++;
                } else if (!visited[i][j] && arr[i][j] == 'B') {
                    bfs(i, j, 'B');
                    cnt_blue++;
                }
            }
        }

        int cnt = cnt_red + cnt_blue;
        System.out.print(normal_cnt + " " + cnt);
    }

    public static void bfs(int x, int y, char color) {
        visited[x][y] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});

        while (!q.isEmpty()) {
            int curX = q.peek()[0];
            int curY = q.peek()[1];
            q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];
                if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                    if (!visited[nx][ny] && arr[nx][ny] == color) {
                        visited[nx][ny] = true;
                        bfs(nx, ny, color);
                    }
                }
            }
        }
    }
}