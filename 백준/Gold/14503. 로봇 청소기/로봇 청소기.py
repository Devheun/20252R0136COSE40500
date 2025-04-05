import sys
input=sys.stdin.readline

N,M = map(int,input().split())
r,c,d = map(int,input().split())
graph = []
dx = (-1, 0, 1, 0) # 북, 동, 남, 서
dy = (0, 1, 0, -1) # 북, 동, 남, 서
flag = False

for _ in range(N):
    s = list(map(int,input().split()))
    graph.append(s)

visited = [[False] * M for _ in range(N)]

def turn_left():
    global d
    d -= 1
    if d == -1:
        d = 3
    
def robot(x,y):
    global d
    global flag
    
    if flag:
        return
    
    if not visited[x][y] and graph[x][y] == 0:
        visited[x][y] = True
    
    # 현재 칸 주변 4칸 중에 청소되지 않은 칸이 있는지 체크
    turn_count = 0
    while True:
        turn_left()
        nx = x + dx[d]
        ny = y + dy[d]
        
        if not visited[nx][ny] and graph[nx][ny] == 0:
            turn_count = 0
            robot(nx,ny)
            return
        else:
            turn_count += 1
        
        
        # 현재칸 주변 4칸 중 청소되지 않은 빈칸이 없는 경우
        if turn_count == 4:
            back_d = (d+2) % 4
            
            # 후진 했는데 뒤쪽 벽이라면 작동 멈춤
            bx = x + dx[back_d]
            by = y + dy[back_d]
            if graph[bx][by] == 1:
                flag = True
                return
            else:
                turn_count = 0
                robot(bx,by)
                return
    
robot(r,c)
result = sum(1 for i in range(N) for j in range(M) if visited[i][j])
print(result)            