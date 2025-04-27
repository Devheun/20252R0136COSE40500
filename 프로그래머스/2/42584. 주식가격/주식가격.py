def solution(prices):
    answer = []
    length = len(prices)
    # 모든 가격 max로 세팅
    answer = [i for i in range(length-1, -1, -1)]
    
    stack = [0]
    for i in range(1, length):
        while stack and prices[stack[-1]] > prices[i]: # 값이 떨어지는 지점이 생기는 경우
            j = stack.pop()
            answer[j] = i - j
        
        stack.append(i)

    return answer