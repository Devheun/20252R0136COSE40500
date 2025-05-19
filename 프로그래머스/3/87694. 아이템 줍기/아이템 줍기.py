from collections import deque

def solution(rectangle, characterX, characterY, itemX, itemY):
    answer = 0
    q = deque()
    dist = [[0 for _ in range(102)] for _ in range(102)]
    graph = [[-1 for _ in range(102)] for _ in range(102)]
    direction = [(-1,0), (0,1), (1,0), (0,-1)]
    
    for r in rectangle:
        x1, y1, x2, y2 = map(lambda x : x*2, r)
        
        for i in range(x1, x2+1):
            for j in range(y1, y2+1):
                if x1 < i < x2 and y1 < j < y2:
                    # 도형 내부면 0으로 채우기
                    graph[i][j] = 0
                elif graph[i][j] != 0:
                    # 테두리면 1로 채우기
                    graph[i][j] = 1
        
    cx, cy, ix, iy = 2 * characterX, 2 * characterY, 2 * itemX, 2 * itemY
        
    q.append((cx, cy))
    dist[cx][cy] += 1
        
    while q:
        curX, curY = q.popleft()
            
        if curX == ix and curY == iy:
            answer = dist[curX][curY] // 2
            break
            
        for dx, dy in direction:
            nx, ny = curX + dx, curY + dy
            if 1 <= nx <= 100 and 1 <= ny <= 100:
                if dist[nx][ny] == 0 and graph[nx][ny] == 1:
                    q.append((nx,ny))
                    dist[nx][ny] = dist[curX][curY] + 1
        
    return answer
    