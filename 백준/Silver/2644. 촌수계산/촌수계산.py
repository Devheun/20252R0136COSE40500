import sys
input=sys.stdin.readline

n = int(input())
a,b = map(int,input().split())
m = int(input())
graph = [[] for _ in range(n+1)] 
visited = [False] * (n+1)
for _ in range(m):
    parent,child = map(int,input().split())
    graph[parent].append(child)
    graph[child].append(parent)

    
def dfs(node, depth):
    
    if node == b:
        print(depth)
        exit()
    
    visited[node] = True
    
    for i in graph[node]:
        if not visited[i]:
            dfs(i, depth + 1)
            
    return

dfs(a, 0)
print(-1)