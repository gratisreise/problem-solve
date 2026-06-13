def solution(survey, choices):
    listing = ['RT', 'CF', 'JM', 'AN']
    dic = {x:[0,0] for x in listing}
    
    for sv, ch in zip(survey, choices):
        if ch ==  4:
            continue
        idx = ch // 4
        key = ''.join(sorted(list(sv)))
        idx = key.index(sv[idx])
        score = ch % 4 if ch > 4 else (4-ch)
        dic[key][idx] += score
        
    ret = ''
    for alp in listing:
        c = ''
        if dic[alp][0] < dic[alp][1]:
            c = alp[1]
        else:
            c = alp[0]
        ret += c
    return ret
    
        

"""
동의 비동의는 계속 바뀜 방향바뀜
지표별 점수 높은 놈 => 사전순
각 알파벳 마다 점수 
점수는 4를 기준으로 큰놈은 오른쪽 작은 놈은 왼쪽에 점순 넣기
'AN': [0, 0]
배열에 순서대로 넣고 비교하면서 순회하면 되겠다
1. 조사를 돌면서 점수를 계산
2. 계산된 점수에 따라 정렬 
3. 성향 출력
"""