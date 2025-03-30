from collections import deque
import sys
input = sys.stdin.readline

N,M,P = map(int, input().split())
S = [0] + list(map(int, input().split()))
board = [list(input()) for _ in range(N)]

answer = [0] * (P+1)

castle = [deque() for _ in range(P+1)]

# 초기 성들 큐에 넣으면서 갯수 더해주기
for i in range(N):
    for j in range(M):
        if board[i][j] != '.' and board[i][j] != '#': 
            castle[int(board[i][j])].append((i,j))
            answer[int(board[i][j])] += 1

dx = (-1, 0, 1, 0)
dy = (0, 1, 0, -1)

while True:
    flag = True
    for player in range(1, P+1):
        q = castle[player]
        for _ in range(S[player]):
            if len(q) == 0:
                break
            for _ in range(len(q)):
                curX, curY = q.popleft()
                for d in range(4):
                    nx = curX + dx[d]
                    ny = curY + dy[d]
                    
                    if 0<=nx<N and 0<=ny<M and board[nx][ny]=='.':
                        board[nx][ny] = str(player)
                        answer[player] += 1
                        q.append((nx,ny))
                        flag = False
    if flag:
        break

print(*answer[1:])
