def solution(polynomial):
    arr = polynomial.split(' ')
    a = 0
    b = 0
    for s in arr:
        if s == '+': continue
        elif s[-1] == 'x':
            if len(s) == 1: a += 1
            else: a += int(s[:-1])
        else: b += int(s)
    print(a, b)
    if a == 1 and b != 0: return f"x + {b}"
    if a == 1 and b == 0: return "x"
    if a == 0: return f"{b}"
    elif b == 0: return f"{a}x"
    else: return f"{a}x + {b}"
    
    # print(f"{a}x + {b}")
# ax + b