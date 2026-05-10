def solution(my_string, alp):
    return ''.join(c.upper() if c == alp else c for c in my_string)