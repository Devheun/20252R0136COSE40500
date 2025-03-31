import sys
input=sys.stdin.readline

N = int(input())

dist = list(map(int, input().split()))
oil = list(map(int,input().split()))

min_price = oil[0]
result = 0;

for i in range(N-1):
    if min_price > oil[i]:
        min_price = oil[i]
    
    result += (min_price * dist[i])

print(result)    
        