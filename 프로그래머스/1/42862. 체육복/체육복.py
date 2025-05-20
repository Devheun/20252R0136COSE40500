from collections import Counter

def solution(n, lost, reserve):
    answer = 0
    count = Counter({i: 1 for i in range(1, n+1)})
        
    for r in reserve:
        count[r] += 1
    
    for l in lost:
        count[l] -= 1
    
    for i in range(1, n+1):
        if count[i] == 0:
            if count[i-1] > 1:
                count[i-1] -= 1
                count[i] += 1
            elif count[i+1] > 1:
                count[i+1] -= 1
                count[i] += 1
    
    answer = sum(1 for v in count.values() if v >= 1)
        
    return answer
