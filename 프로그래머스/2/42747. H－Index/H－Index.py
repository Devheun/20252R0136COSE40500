def search(arr):
    h_index = 0
    for i in range(max(arr)):
        h_temp = i
        cnt_high = 0
        cnt_low = 0
        for j in range(len(arr)):
            if arr[j] >= h_temp:
                cnt_high += 1
            elif arr[j] < h_temp:
                cnt_low += 1
        
        if cnt_high >= h_temp and cnt_low <= h_temp:
            h_index = h_temp
        else:
            break
    
    return h_index
                
        
    
def solution(citations):
    answer = 0
    citations.sort()
    answer = search(citations)
    return answer