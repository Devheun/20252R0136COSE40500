import heapq
from collections import Counter

def solution(operations):
    min_h, max_h = [], []
    cnt = Counter()

    for oper in operations:
        op, num = oper.split()
        n = int(num)

        if op == 'I':
            cnt[n] += 1
            heapq.heappush(min_h, n)
            heapq.heappush(max_h, -n)

        else:  # 'D'
            if n == 1:
                # 최대값 삭제
                while max_h and cnt[-max_h[0]] == 0:
                    heapq.heappop(max_h)
                if max_h:
                    v = -heapq.heappop(max_h)
                    cnt[v] -= 1
            else:
                # 최솟값 삭제
                while min_h and cnt[min_h[0]] == 0:
                    heapq.heappop(min_h)
                if min_h:
                    v = heapq.heappop(min_h)
                    cnt[v] -= 1

    # 남아 있는 stale 원소 정리
    while min_h and cnt[min_h[0]] == 0:
        heapq.heappop(min_h)
    while max_h and cnt[-max_h[0]] == 0:
        heapq.heappop(max_h)

    # 결과 반환
    if not min_h:
        return [0, 0]
    return [-max_h[0], min_h[0]]