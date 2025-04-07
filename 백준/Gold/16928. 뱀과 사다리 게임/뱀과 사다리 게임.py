from collections import deque
import sys
input = sys.stdin.readline

N,M = map(int,input().split())
ladder = dict()
snake = dict()
dist = [0] * 101

# N개 사다리 입력
for _ in range(N):
    x, y = map(int,input().split())
    ladder[x] = y
    
# M개 뱀 입력
for _ in range(M):
    u,v = map(int,input().split())
    snake[u] = v

    
def bfs(start):
    q = deque()
    q.append(start)
    
    while q:
        cur = q.popleft()

        for i in range(1, 7):
            next = cur + i
            
            if next > 100:
                continue
            
            if next in ladder:
                next = ladder[next]
                
            if next in snake:
                next = snake[next]
                
            if dist[next] == 0:
                dist[next] = dist[cur] + 1
                q.append(next)
                
bfs(1)

print(dist[100])