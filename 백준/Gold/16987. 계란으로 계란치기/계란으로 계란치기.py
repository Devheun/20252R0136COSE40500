def recv(index):
    global max_cnt
    if index == N:
        broken = sum(1 for d, w in egg if d <= 0)
        max_cnt = max(max_cnt, broken)
        return
    
    if egg[index][0] <= 0: # 손에 든 계란이 깨졌을때
        recv(index + 1)
        return

    can_hit = False
    for i in range(0, len(egg)):
        if index == i or egg[i][0] <= 0: continue        
        can_hit = True
        egg[i][0] -= egg[index][1]
        egg[index][0] -= egg[i][1]
        recv(index + 1)
        egg[i][0] += egg[index][1]
        egg[index][0] += egg[i][1]
    
    if not can_hit:
        recv(index +1)
            

N = int(input())
egg = []
max_cnt = 0
for i in range(N):
    d, w = map(int, input().split())
    egg.append([d, w])

# 첫 번째 계란부터 시작
recv(0)
print(max_cnt)        
    