def solution(k, m, score):
    temp = []
    score.sort(reverse=True)
    ret = 0
    for s in score:
        temp.append(s)
        if len(temp) == m:
            ret += temp[-1] *m
            temp = []
    return ret
    
"""
k점 최상, 한상자에m개씩
상자단위로 판매 남는거 버림
내림차순으로 정렬하고 비싼거 끼리 몰아서 넣고 그다음 보내기

"""