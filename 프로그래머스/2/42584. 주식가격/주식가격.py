def solution(prices):
    answer = []
    
    for i in range(len(prices) - 1):
        cur = prices[i]
        flag = False
        for j in range(i+1, len(prices)):
            if cur > prices[j]:
                answer.append(j - i)
                flag = True
                break
        if flag:
            continue
        else:
            answer.append(len(prices) - i - 1)
    
    answer += [0]
        
    return answer