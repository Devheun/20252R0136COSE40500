import sys
input = sys.stdin.readline

def parametric_search(arr, target):
    global ans
    start = 0
    end = max(arr)
    
    while start <= end:
        total = 0
        mid = (start + end) // 2
        
        for i in arr:
            if i > mid :
                total += i - mid
        
        if total >= target:
            ans = mid
            start = mid + 1
        else:
            end = mid - 1
        
        

ans = 0

N, M = map(int,input().split())

tree = list(map(int,input().split()))

tree.sort()

parametric_search(tree, M)

print(ans)