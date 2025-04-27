from collections import deque

def solution(priorities, location):
    q = deque()
    pq = deque(priorities)
    answer = []
    for i in range(len(priorities)):
        q.append(i)
    
    while pq:
        flag = False
        curP = pq.popleft()
        curI = q.popleft()
        for i in pq:
            if i > curP:
                pq.append(curP)
                q.append(curI)
                flag = True
                break
        
        if not flag:
            answer.append(curI)
    
    for i in range(len(answer)):
        if answer[i] == location:
            return i+1
    
            
            