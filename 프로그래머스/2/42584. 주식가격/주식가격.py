def solution(prices):
    ret = [0 for _ in range(len(prices))]
    stk = []
    for i,p in enumerate(prices):
        while stk and prices[stk[-1]] > p:
            ret[stk[-1]] = (i - stk[-1])
            stk.pop()
        stk.append(i)
    while stk:
        ret[stk[-1]] = len(prices) - 1 - stk[-1]
        stk.pop()
    return ret;