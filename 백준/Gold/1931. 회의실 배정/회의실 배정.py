import sys
input=sys.stdin.readline

N = int(input())
meeting = list()

for _ in range(N):
    meeting.append(list(map(int,input().split())))

meeting.sort(key = lambda x : (x[1], x[0]))
result = 1

criteria = meeting[0][1]
i = 1
while i < N:
    # 다음 미팅 시작 시간이 이전 미팅 끝나는 시간보다 작으면 회의 불가능
    if meeting[i][0] < criteria:
        i += 1
    # 다음 미팅 시작 시간이 이전 미팅 끝나는 시간보다 크거나 같으면 회의 가능    
    elif meeting[i][0] >= criteria:
        criteria = meeting[i][1]
        i += 1
        result += 1

print(result)