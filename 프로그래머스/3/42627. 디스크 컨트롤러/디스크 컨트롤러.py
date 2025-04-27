import heapq

def solution(jobs):
    start = -1 # 마지막으로 처리한 작업 시작 시간
    now = 0 # 현재시간
    i = 0 # 처리 개수
    heap = []
    answer = 0
    
    while i < len(jobs):
        for job in jobs:
            if start < job[0] <= now:
                heapq.heappush(heap, (job[1], job[0]))
        
        if heap: # 대기큐에 프로세스가 존재할 때
            cur = heapq.heappop(heap)
            start = now
            now += cur[0]
            answer += now - cur[1]
            i += 1
        else:
            now += 1
    
    return answer // len(jobs)