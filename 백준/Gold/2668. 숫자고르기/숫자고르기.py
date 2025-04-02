import sys
input = sys.stdin.readline

N = int(input())

graph = [0] + [int(input()) for _ in range(N)]

ans = set()

def dfs(node, start):
    global ans
    global visited
    
    if visited[node]:
        if node == start:
            ans.add(node)
        return
    
    visited[node] = True
    dfs(graph[node], start)


for i in range(1, N+1):
    visited = [False] * (N + 1)
    dfs(i,i)

result = list(ans)
result.sort()
print(len(result))

for i in result:
    print(i)