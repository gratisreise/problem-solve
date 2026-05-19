def solution(emergency):
    order = sorted([i for i in emergency], reverse=True)
    return [order.index(x)+1 for x in emergency]