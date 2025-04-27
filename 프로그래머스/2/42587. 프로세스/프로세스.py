from collections import deque

def solution(priorities, location):
    q = deque([(i,p) for i,p in enumerate(priorities)])
    answer = 0
    while True:
        cur = q.popleft()
        if any(cur[1] < a[1] for a in q):
            q.append(cur)
        else:
            answer += 1
            if location == cur[0]:
                return answer
            
            
            