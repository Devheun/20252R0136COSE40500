import sys
input = sys.stdin.readline

ans = 0

def parametric_search(arr, c):
    global ans
    start = 1 # 최소 공유기 거리는 1 (모든 집이 다른 좌표에 있으므로)
    end = arr[-1] - arr[0] # 최대 공유기 거리는 맨 끝 집 - 맨 첫 집
    
    while start <= end:
        total = 1 # 1번 집에는 무조건 공유기 설치
        cur = arr[0] # 가장 최근에 설치한 공유기 위치
        mid = (start + end) // 2 
        for i in arr:
            if i - cur >= mid:
                total += 1
                cur = i
        
        if total >= c:
            if ans < mid:
                ans = mid
            start = mid + 1
        else:
            end = mid - 1
            
        
N, C = map(int, input().split())
home = []
for _ in range(N):
    home.append(int(input()))

home.sort()
parametric_search(home, C)

print(ans)