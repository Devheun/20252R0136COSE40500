import sys
input=sys.stdin.readline

n = int(input())
a = list(map(int, input().split()))
x = int(input())

# n이 10만보다 작거나 같으므로 O(nlogn) 이하로 처리해야함
a.sort()

left = 0
right = len(a) - 1

ans = 0

while left < right:
    left_val = a[left]
    right_val = a[right]
    
    if left_val + right_val == x:
        ans += 1
        left += 1
        right -= 1
    elif left_val + right_val > x:
        right -= 1
    elif left_val + right_val < x:
        left += 1

print(ans)        