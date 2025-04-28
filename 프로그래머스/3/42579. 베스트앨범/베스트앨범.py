def solution(genres, plays):
    # 장르별 총 재생횟수 구하기
    genres_cnt = dict()
    for g, p in zip(genres,plays):
        if g not in genres_cnt:
            genres_cnt[g] = 0
        genres_cnt[g] += p
    
    ordered_dict = sorted(genres_cnt.items(), key = lambda x : -x[1])
    
    result = []
    for key, value in ordered_dict:
        tmp = []
        for i,(g,p) in enumerate(zip(genres, plays)):
            if g == key:
                tmp.append((p, i))
        
        tmp.sort(key = lambda x : (-x[0], x[1]))
        if len(tmp) >= 2:
            result.append(tmp[0][1])
            result.append(tmp[1][1])
        else:
            result.append(tmp[0][1])
    
    return result
        
        
    