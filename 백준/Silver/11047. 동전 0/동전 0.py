import sys
input=sys.stdin.readline

N, K = map(int, input().split())
coin = list()
ans = 0

for _ in range(N):
    coin.append(int(input()))

coin.sort(reverse = True)

for val in coin:
    if K // val == 0:
        continue
    else:
        ans += K // val
        K %= val
print(ans)
    
    
    
