from collections import deque

N, K = map(int, input().split())

arr = [i+1 for i in range(N)]

queue = deque(arr)
result = list()

while len(queue) > 0:
    for i in range(K-1):
        a = queue.popleft()
        queue.append(a)
    
    val = queue.popleft()
    result.append(val)

answer = "<"

for i in range(len(result) - 1):
    answer += str(result[i]) + ", "

answer += str(result[len(result)-1]) + ">"

print(answer)
