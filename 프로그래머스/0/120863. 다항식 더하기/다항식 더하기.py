def solution(polynomial):
    polys = polynomial.split(" + ")
    a, b  = 0, 0
    for s in polys:
        if 'x' in s:
            if s == 'x':
                a += 1
            else:
                a += int(s[:s.index("x")])
        else:
            b += int(s)
    if a != 0 and b != 0:
        if a == 1:
            return f"x + {b}"
        return f"{a}x + {b}"
    elif a == 0 and b != 0:
        return f"{b}"
    elif a != 0 and b == 0:
        if a == 1:
            return f"x"
        return f"{a}x"
    else:
        return 0
    
# +기준으로 분할해서 x있는놈과 아닌놈 분리해서 x있는 놈들은 a에 넣기 아닌놈들은 b에 넣기