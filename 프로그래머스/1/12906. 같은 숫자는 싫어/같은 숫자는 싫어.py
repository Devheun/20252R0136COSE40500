def solution(arr):
    tmp = [arr[0]]
    for i in range(1, len(arr)):
        if arr[i-1] == arr[i]:
            continue
        else:
            tmp.append(arr[i])
    
    return tmp