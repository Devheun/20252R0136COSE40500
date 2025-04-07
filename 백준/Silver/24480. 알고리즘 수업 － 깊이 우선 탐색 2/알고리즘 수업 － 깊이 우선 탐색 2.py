import sys
sys.setrecursionlimit(10**5)
input = sys.stdin.readline


N,M,R = map(int,input().split())
graph = [[] for _ in range(N+1)]
visited = [0] * (N+1)
ans = 1

for _ in range(M):
    u,v = map(int,input().split())
    graph[u].append(v)
    graph[v].append(u)

for i in range(1, N+1):
    graph[i].sort(reverse = True)

def dfs(node):
    global ans
    visited[node] = ans
    ans += 1
    
    for i in graph[node]:
        if visited[i] == 0:
            dfs(i)
    
                
dfs(R)

for i in range(1, N+1):
    print(visited[i])
