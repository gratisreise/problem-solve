def solution(data, ext, val_ext, sort_by):
    idxs = {'code':0, 'date':1, 'maximum':2, 'remain':3}
    
    ret = [x for x in data if x[idxs[ext]] < val_ext]
    ret.sort(key=lambda x: x[idxs[sort_by]])
    return ret
    
"""
ext: 정보
val_ext: 기준값
data에서 ext가 val_ext보다 작은 데이터만 선택후 sort_by해당 오름차순으로 정렬

1. ext에 맞는 놈들 기준으로 다시 뽑기
2. sort_by 단위로 정렬
3. 출력
"""