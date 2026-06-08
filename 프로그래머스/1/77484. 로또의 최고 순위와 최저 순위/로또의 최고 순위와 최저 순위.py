from collections import Counter

def solution(lottos, win_nums):
    rank = {6:1, 5:2, 4:3, 3:4, 2:5, 1:6, 0:6}
    cnt = Counter(lottos)
    mmn = len(set(lottos) & set(win_nums))
    mmx = mmn + cnt[0]
    return [rank[mmx], rank[mmn]]
    
        
    
            
    
"""
일부번호 인식불가,
최고, 최저순위 파악
다맞을 때와 다틀릴때
[최고, 최저] 반환
1. 같은 숫자 갯수 구하기
2. 0인 갯수 구하기
3. 처음 같은 숫자 갯수는 최저, 0인 갯수 더한게 최고

"""