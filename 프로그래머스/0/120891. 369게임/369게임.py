def solution(order):
    cnt = ['3', '6', '9']
    return sum(1 for c in str(order) if c in cnt)
        