import sys
input = sys.stdin.readline

ans = 0

def parametric_search(arr, target):
    global ans
    start = 1
    end = max(arr)
    
    while start <= end:
        mid = (start + end) // 2
        total = 0
        
        for i in arr:
            total += i // mid
        
        if total >= target:
            ans = mid
            start = mid + 1
        else:
            end = mid - 1

K, N = map(int, input().split())
lan = []

for _ in range(K):
    lan.append(int(input()))

lan.sort()

parametric_search(lan, N)

print(ans)