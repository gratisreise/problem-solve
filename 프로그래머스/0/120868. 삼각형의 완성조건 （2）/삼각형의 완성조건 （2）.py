def solution(sides):
    big = max(sides)
    small = min(sides)
    
    return sum(1 for i in range(1, big) if (i + small) > big) + sum(1 for i in range(big, small + big) if i < (small +big))
# 두변중 큰놈이 가장 큰놈이여서 가장 큰놈 보다 작은 수중 되는 놈들 숫자 구하기
# 두변의 합보다 작은 놈중 지금 맥스보다 큰놈중 구하기