import heapq
import sys
input = sys.stdin.readline

INF = int(1e9)
N, E = map(int, input().split())
graph = [[] for _ in range(N+1)]

for i in range(E):
    a,b,c = map(int,input().split())
    graph[a].append((b,c))
    graph[b].append((a,c))
 
v1,v2 = map(int, input().split())
        
def dijkstra(start):
    q = []
    distance = [INF] * (N+1)
    distance[start] = 0
    heapq.heappush(q, (0, start))
    
    while q:
        dist, now= heapq.heappop(q)
        if distance[now] < dist:
            continue

        for i in graph[now]:
            cost = i[1] + dist
            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(q, (cost, i[0]))
    
    return distance

dist_from_1 = dijkstra(1)
dist_from_v1 = dijkstra(v1)
dist_from_v2 = dijkstra(v2)

# 1 -> v1 -> v2 -> N
path1 = dist_from_1[v1] + dist_from_v1[v2] + dist_from_v2[N]

# 1 -> v2 -> v1 -> N
path2 = dist_from_1[v2] + dist_from_v2[v1] + dist_from_v1[N]

if path1 >= INF and path2 >= INF:
    print(-1)
else:
    print(min(path1, path2))
