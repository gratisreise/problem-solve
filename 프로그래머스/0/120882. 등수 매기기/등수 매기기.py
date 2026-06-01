from collections import Counter
def solution(score):
    avgs = [(x[0] + x[1])/2 for x in score]
    cnt = Counter(avgs)
    orders = sorted(cnt.keys(), reverse=True)
    ranks = {}
    rank = 1
    for x in orders:
        ranks[x] = rank
        rank += cnt[x]
    return [ranks[x] for x in avgs]

"""
1. 인덱스 - 평균점수
2. 등수정하기
3. 인덱스 - 등수반환
"""