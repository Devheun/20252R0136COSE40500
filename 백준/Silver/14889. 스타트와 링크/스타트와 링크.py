import sys
input = sys.stdin.readline

N = int(input())
power = [list(map(int,input().split())) for _ in range(N)]

members = [i for i in range(1, N+1)]
minDiff = 100000
visited = []

def func(idx, cnt):
    global members
    global minDiff
    global visited
    
    if idx > N:
        return
     
    if cnt == N / 2: # 팀이 반으로 딱 나눠졌을때
        start_sum = 0
        link_sum = 0
        for i in range(N):
            for j in range(N):
                if visited[i] and visited[j]: # 스타트팀
                    start_sum += power[i][j]
                
                elif not visited[i] and not visited[j]: #링크팀
                    link_sum += power[i][j]
        
        minDiff = min(minDiff, abs(start_sum - link_sum))
    
    else:
        visited[idx] = True
        func(idx + 1, cnt + 1)
        visited[idx] = False
        func(idx + 1, cnt)

visited = [False] * (N + 1)
func(1, 0)

print(minDiff)