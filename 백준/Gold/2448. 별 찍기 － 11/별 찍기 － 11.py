N = int(input())

stars = [[' '] * 2 * N for _ in range(N)]

def recursion(x, y, size):
    if size == 3:
        stars[x][y] = '*'
        stars[x+1][y-1] = stars[x+1][y+1] = '*'
        for i in range(-2, 3):
            stars[x+2][y+i] = '*'
        return
    
    recursion(x, y, size//2)
    recursion(x + size//2, y - size//2, size//2)
    recursion(x + size//2, y + size//2, size//2)

recursion(0, N-1, N)

for star in stars:
    print(''.join(star))