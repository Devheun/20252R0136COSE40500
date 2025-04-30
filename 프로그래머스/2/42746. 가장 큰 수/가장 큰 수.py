from functools import cmp_to_key

def sort_key(a,b):
    return int(str(b) + str(a)) - int(str(a) + str(b))

def solution(numbers):
    numbers.sort(key = cmp_to_key(sort_key))
    answer = str(int(''.join(map(str, numbers))))
    return answer