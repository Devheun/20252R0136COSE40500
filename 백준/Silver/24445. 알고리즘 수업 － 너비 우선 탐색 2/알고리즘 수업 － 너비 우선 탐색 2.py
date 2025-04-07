from collections import deque
import sys
input = sys.stdin.readline

N,M,R = map(int,input().split())
graph = [[] for _ in range(N+1)]
visited = [0] * (N+1)
ans = 1

for _ in range(M):
    u,v = map(int, input().split())
    graph[u].append(v)
    graph[v].append(u)

for i in range(1, N+1):
    graph[i].sort(reverse = True)

def bfs(node):
    global ans
    ans = 1
    visited[node] = ans
    q = deque()
    q.append(node)
    
    while q:
        a = q.popleft()
        for i in graph[a]:
            if visited[i] == 0:
                ans += 1
                visited[i] = ans
                q.append(i)
                

bfs(R)

for i in range(1, N+1):
    print(visited[i])