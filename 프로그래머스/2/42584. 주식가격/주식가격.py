def solution(prices):
    n = len(prices)
    ret = [0] * n
    stk = []
    for i,num in enumerate(prices): 
        
        while stk and prices[stk[-1]] > num:
            ret[stk[-1]] = (i - stk[-1])
            stk.pop()
        stk.append(i)
        
    
    while stk:
        ret[stk[-1]] = (n-1 - stk[-1])
        stk.pop()
        
    return ret
# 0, 1, 2, 3, 4
# 1, 2, 3, 2, 3
# 스택에 각 숫자의 인덱스를 저장
#  현재의 숫자가 이전의 숫자보다 작아졌을 때 -> stk에 있는 숫자중 보다 작거나 같은애 있을 때까지 시간초 계산해서 저장
# 스택에 숫자가 남아 있으면 -> 마지막 인덱스를 가지고 계산해주기