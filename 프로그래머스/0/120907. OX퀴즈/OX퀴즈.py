def solution(quiz):
    ret = []
    for q in quiz:
        print(q.split(" "))
        x, oper, y, eq, z = q.split(" ")
        x, y, z = int(x), int(y), int(z)
        if oper == '+' and x+y == z:
            ret.append("O")
        elif oper == '-' and x - y == z:
            ret.append("O")
        else:
            ret.append("X")
    return ret
    
"""
수식의 올바름 여부

"""