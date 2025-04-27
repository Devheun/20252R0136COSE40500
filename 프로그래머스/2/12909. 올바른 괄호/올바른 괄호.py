def solution(s):
    arr = []
    result = False
    flag = True
    for cur in s:
        if cur == '(':
            arr.append(cur)
        elif cur == ')' and len(arr) > 0 and arr[-1] == '(':
            arr.pop()
        else:
            flag = False
            break
    
    if len(arr) == 0 and flag == True:
        result = True
    
    return result