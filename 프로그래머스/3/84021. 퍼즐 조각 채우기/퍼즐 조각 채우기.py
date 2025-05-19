from collections import deque

state_list = (1,0)

def bfs(x, y, board, visited, state):
    direction = [(-1, 0), (0,1), (1,0), (0, -1)]
    q = deque()
    q.append((x, y))
    
    puzzle = [(x,y)]
    
    while q:
        curX, curY = q.popleft()
        visited[curX][curY] = 1
        
        for dx, dy in direction:
            nx, ny = curX + dx, curY + dy
            if 0 <= nx < N and 0 <= ny < N and visited[nx][ny] ==0:
                if board[nx][ny] == state:
                    visited[nx][ny] = 1
                    q.append((nx, ny))
                    puzzle.append((nx, ny))
    
    return puzzle

def search_puzzle(board, blocks, state):
    visited = [[0] * N for _ in range(N)]
    
    for i in range(N):
        for j in range(N):
            # game_board는 1일때 skip, table은 0일때 skip
            if board[i][j] == state_list[state] or visited[i][j]:
                continue
            blocks.append(bfs(i, j, board, visited, state))

def cover_puzzle(puzzle):
    x = [i[0] for i in puzzle]
    y = [i[1] for i in puzzle]
    
    r = max(y) - min(y) + 1
    c = max(x) - min(x) + 1
    temp = [[0] * r for _ in range(c)]
    
    for i, j in puzzle:
        temp[i-min(x)][j-min(y)] = 1
    
    return temp

def rotate(puzzle):
    cnt = 0
    r, c = len(puzzle), len(puzzle[0])
    temp = [[0] * r for _ in range(c)]
    for i in range(r):
        for j in range(c):
            if puzzle[i][j] == 1:
                cnt += 1
            temp[j][r-1-i] = puzzle[i][j]
    return temp, cnt
    

def solution(game_board, table):
    global N
    N = len(game_board)
    game_blocks, table_blocks = [], []
    
    search_puzzle(game_board, game_blocks, 0)
    search_puzzle(table, table_blocks, 1)
    
    answer = 0
    for gb in game_blocks:
        flag = False
        # 절대 위치 변경
        game_puzzle = cover_puzzle(gb)
        
        for tb in table_blocks:
            # 이미 빈칸을 채웠음
            if flag == True:
                break
            # 조각의 개수가 적은 경우 볼 필요 X (어차피 못 채우므로)
            if len(game_puzzle) > len(tb):
                continue
            
            table_puzzle = cover_puzzle(tb)
            
            for _ in range(4):
                table_puzzle, cnt = rotate(table_puzzle)
                
                if table_puzzle == game_puzzle:
                    answer += cnt
                    table_blocks.remove(tb)
                    flag = True
                    break
    return answer