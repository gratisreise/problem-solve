def solution(chicken):
    ret = 0
    while chicken >= 10:
        div = chicken // 10
        mod = chicken % 10
        ret += div
        chicken = div + mod
    return ret 
        
"""
쿠폰10장 -> 서비스 1 + 1장 
최대 서비스 치킨의 수
x마리
10 나머지 + 10으로 나눈결과
"""