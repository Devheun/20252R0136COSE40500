import sys
from collections import deque
input=sys.stdin.readline

N = int(input())

visited = [False] * (N+1)
graph = [[] for _ in range(N+1)]

for _ in range(N-1):
    a,b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

order = deque(map(int,input().split()))

def dfs(order):
    tmp = order.popleft()
    
    if not order:
        print(1)
        exit()
        
    visited[tmp] = True
    
    for i in range(len(graph[tmp])):
        if order[0] in graph[tmp] and not visited[order[0]]:
            dfs(order)

if order[0] != 1:
    print(0)
else:
    dfs(order)
    print(0)
    