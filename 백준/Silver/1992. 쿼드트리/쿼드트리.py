import sys
input = sys.stdin.readline

N = int(input())

grid = [list(map(int,input().rstrip())) for _ in range(N)]

def func(x, y, size):
    if size == 1:
        return str(grid[x][y])
    
    white = 0
    black = 0
    
    for i in range(x, x + size):
        for j in range(y, y + size):
            if grid[i][j] == 0:
                white += 1
            if grid[i][j] == 1:
                black += 1
    
    if white != 0 and black == 0:
        return "0"
    elif white == 0 and black != 0:
        return "1"
    else:
        a = func(x, y, size//2)
        b = func(x, y + size//2, size//2)
        c = func(x + size//2, y, size//2)
        d = func(x + size//2, y + size//2, size//2)
    
    if a == b == c == d == "0":
        return "0"
    elif a == b == c == d == "1":
        return "1"
    else:
        return "(" + str(a) + str(b) + str(c) + str(d) + ")"
    
print(func(0, 0, N))