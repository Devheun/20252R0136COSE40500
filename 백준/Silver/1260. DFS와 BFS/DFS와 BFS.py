import sys
from collections import deque

input = sys.stdin.readline

N, M, V = map(int, input().split())
visited = [False] * (N+1)
graph = [[] for _ in range(N+1)]
result = []

for _ in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

for i in range(1, N+1):
    graph[i].sort()

def dfs(node):
    visited[node] = True
    result.append(node)
    
    for i in graph[node]:
        if not visited[i]:
            dfs(i)

def bfs(node):
    q = deque()
    visited[node] = True
    result.append(node)
    q.append(node)
    
    while q:
        cur = q.popleft()
        for i in graph[cur]:
            if not visited[i]:
                visited[i] = True
                result.append(i)
                q.append(i)

# DFS
dfs(V)
print(*result, end = " ")
print()

# result 초기화, visited 초기화
visited = [False] * (N+1)
result = []

# BFS
bfs(V)
print(*result, end = " ")