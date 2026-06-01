def ten_to_3(num):
    ret = ''
    while num > 0:
        ret += str(num % 3)
        num //= 3
    return ret[::-1]
    
    

def three_to_10(num):
    ret = 0
    for i,x in enumerate(num):
        ret += (3**i) * (ord(x) - ord('0'))
    return ret


def solution(n):
    ret = ten_to_3(n)
    print(ret)
    ret = three_to_10(ret)
    return ret
    
"""
1.3진법만들기
2.뒤집기
3.10진법변환
"""