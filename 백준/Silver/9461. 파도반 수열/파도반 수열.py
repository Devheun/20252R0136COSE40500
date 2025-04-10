import sys
input = sys.stdin.readline

d = [0] * 101

def func(N):
    if N == 1 or N == 2:
        return 1
    
    d[0] = 1
    d[1] = 1
    d[2] = 1
    
    for i in range(3, N):
        d[i] = d[i-2] + d[i-3]
    
    return d[N-1]

T = int(input())
for _ in range(T):
    N = int(input())
    print(func(N))