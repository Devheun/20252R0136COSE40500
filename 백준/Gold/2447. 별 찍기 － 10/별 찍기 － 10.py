N = int(input())

# N * N 크기의 2차원 배열 생성
arr =[['' for _ in range(N)] for _ in range(N)]

def print_blank(x, y, size):
    for i in range(x, x + size):
        for j in range(y, y + size):
            arr[i][j] = ' '

def func(x,y,size):
    if size == 3:
        for i in range(x, x + 3):
            for j in range(y, y+3):
                if i == x+1 and j == y+1:
                    arr[i][j] = ' '
                else:
                    arr[i][j] = '*'
        return
    
    
    func(x, y, size//3)
    func(x, y + size//3, size//3)
    func(x, y + 2 * size//3, size//3)
    func(x + size//3, y, size//3)
    print_blank(x + size//3, y + size//3, size//3) # 이게 가운데
    func(x + size//3, y + 2 * size//3, size//3)
    func(x + 2 * size//3, y, size//3)
    func(x + 2 * size//3, y + size//3, size//3)
    func(x + 2 * size//3, y + 2 * size//3, size//3)

func(0,0,N)

for row in arr:
    print(''.join(row))