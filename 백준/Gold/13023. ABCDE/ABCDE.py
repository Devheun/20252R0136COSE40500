import sys
input=sys.stdin.readline

N, M = map(int, input().split())

friends = [[] for _ in range(N)]
visited = [False] * N

def dfs(person, cnt):
    global visited
    if cnt == 4:
        print(1)
        exit()
    
    visited[person] = True
    for i in friends[person]:
        if not visited[i]:
            visited[i] = True
            dfs(i, cnt + 1)
            visited[i] = False
    return

for _ in range(M):
    a,b = map(int,input().split())
    friends[a].append(b)
    friends[b].append(a)

for i in range(N):
    visited = [False] * N
    dfs(i,0)

print(0)