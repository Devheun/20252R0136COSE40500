import math

N = input()

numbers = [0] * 10

for i in range(len(N)):
    if int(N[i]) == 9: # 9일때 6으로 몰빵
        numbers[6] += 1
    else:
        numbers[int(N[i])] += 1

max_val = 0
numbers[6] = math.ceil(numbers[6] / 2)

for num in numbers:
    max_val = max(num, max_val)
print(max_val)