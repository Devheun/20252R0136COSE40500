import math

def solution(progresses, speeds):
    days = []
    # 각 작업이 며칠 소요되는지 확인
    for p,s in zip(progresses, speeds):
        remain = 100 - p
        days.append(math.ceil(remain / s))
    
    # 소요되는 일수 확인 후, stack의 top과 비교해서 소요되는 일수가 top보다 작으면 +1
    answer = []
    cnt = 1
    current = days[0]
    for d in days[1:]:
        if d <= current:
            cnt += 1
        else:
            answer.append(cnt)
            cnt = 1
            current = d
    
    answer.append(cnt)
    return answer