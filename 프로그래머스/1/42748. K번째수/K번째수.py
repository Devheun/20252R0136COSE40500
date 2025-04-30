def solution(array, commands):
    answer = []
    for command in commands:
        i = command[0]
        j = command[1]
        k = command[2]
        
        tmp = array[i-1:j]
        tmp.sort()
        answer.append(tmp[k-1])
    return answer