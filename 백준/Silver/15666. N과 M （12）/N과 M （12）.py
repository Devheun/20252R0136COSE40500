N, M = map(int, input().split())
numbers = list(map(int,input().split()))

numbers.sort()

answer = []

def back_tracking(tmp, index):
    if len(tmp) == M:
        if ' '.join(tmp) not in answer:
            answer.append(' '.join(tmp))
        return
    
    for i in range(index, N):
        tmp.append(str(numbers[i]))
        back_tracking(tmp, i)
        tmp.pop()
        
        

back_tracking([], 0)

for i in answer:
	print(i)
