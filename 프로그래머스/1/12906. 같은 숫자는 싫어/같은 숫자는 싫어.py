def solution(arr):
    tmp = [arr[0]]
    for i in arr:
        if tmp[-1] == i:
            continue
        else:
            tmp.append(i)
    
    return tmp