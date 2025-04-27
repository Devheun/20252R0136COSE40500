import heapq

def solution(scoville, K):
    arr = []
    for i in scoville:
        heapq.heappush(arr, i)
    cnt = 0
    
    while len(arr) >= 2:
        if arr[0] < K:
            first = heapq.heappop(arr)
            second = heapq.heappop(arr)
            
            new = first + 2*second
            heapq.heappush(arr, new)
            cnt += 1
        elif arr[0] >= K:
            break
    
    if len(arr) == 1 and arr[0] < K:
        return -1

    return cnt
            