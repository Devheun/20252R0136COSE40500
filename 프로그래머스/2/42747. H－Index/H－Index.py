def solution(citations):
    citations.sort(reverse=True)
    h_index = 0
    answer = 0
    for i, c in enumerate(citations):
        if c >= i+1:
            h_index = i + 1
            answer = h_index
    return answer