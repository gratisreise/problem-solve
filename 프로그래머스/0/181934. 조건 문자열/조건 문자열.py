def solution(ineq, eq, n, m):
    ret = 0
    if ineq == '>':
        if eq == '=':
            ret = 1 if n >= m else 0
        else:
            ret = 1 if n > m else 0
    else:
        if eq == '=':
            ret = 1 if n <= m else 0
        else:
            ret = 1 if n < m else 0
    return ret