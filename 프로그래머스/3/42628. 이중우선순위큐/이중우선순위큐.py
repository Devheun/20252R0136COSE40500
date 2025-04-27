import heapq

def solution(operations):
    answer = []
    heap = []
    for oper in operations:
        c, num = oper.split()
        if c == 'I':
            heapq.heappush(heap, int(num))
        elif heap:
            if c == 'D' and int(num) == 1:
                max_val = max(heap)
                heap.remove(max_val)
            elif c == 'D' and int(num) == -1:
                heapq.heappop(heap)
                
    
    if not heap:
        answer = [0,0]
    else:
        answer = [max(heap), heapq.heappop(heap)]
            
    return answer