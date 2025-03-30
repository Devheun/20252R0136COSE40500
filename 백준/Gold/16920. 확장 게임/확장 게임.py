from collections import deque
import sys
input=sys.stdin.readline

N,M,P = map(int,input().split())
S = [0] + list(map(int,input().split()))
castle = [deque() for _ in range(P+1)]
ans = [0] * (P+1)

board = [list(input()) for _ in range(N)]

# 처음에 각각의 성들 큐에 넣기, 성 개수 기록하기
for i in range(N):
    for j in range(M):
        if board[i][j] != '.' and board[i][j] != '#':
            ans[int(board[i][j])] += 1
            castle[int(board[i][j])].append((i,j))

dx = (-1, 0, 1, 0)
dy = (0, 1, 0, -1)

while True:
    flag = True
    for player in range(1, P+1):
        q = castle[player]
        for _ in range(S[player]):
            if not q:
                break
            for _ in range(len(q)):
                curX, curY = q.popleft()
                for d in range(4):
                    nx = dx[d] + curX
                    ny = dy[d] + curY
                    if 0<=nx<N and 0<=ny<M and board[nx][ny] == '.':
                        ans[player] += 1
                        q.append((nx,ny))
                        board[nx][ny] = str(player)
                        flag = False
                        
            
    if flag:
        break

print(*ans[1:])
       
