def solution(x):
    return True if x%(sum(int(c) for c in str(x))) == 0 else False