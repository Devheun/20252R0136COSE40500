def solution(progresses, speeds):
    days = []
    # 각 작업이 며칠 소요되는지 확인
    for i in range(len(progresses)):
        remain = 100 - progresses[i]
        if remain % speeds[i] > 0:
            days.append((remain//speeds[i]) + 1)
        elif remain % speeds[i] == 0:
            days.append((remain//speeds[i]))
    
    # 소요되는 일수 확인 후, stack의 top과 비교해서 소요되는 일수가 top보다 작으면 +1
    # 7, 3, 9 (days)
    answer = []
    cnt = 0
    top = 0
    for i in range(len(days)):
        if i == 0:
            cnt += 1
            top = days[i]
        elif top >= days[i]:
            cnt += 1
        elif top < days[i]:
            answer.append(cnt)
            cnt = 1
            top = days[i]
    
    answer.append(cnt)
        
    return answer