def solution(n,a,b):
    ret = 1
    while True :
        a = a//2 if a % 2 == 0 else a//2 +1
        b = b//2 if b % 2 == 0 else b//2 +1
        if a == b:
            break
        ret += 1
    return ret

"""
1~n, n명참가,
12, 34, 56 ... 이렇게 바로 양옆에서 대결
A가 B와 몇번째 라운드에서 만나는지 반환
12, 34, 56,


12 34 56 78

1, 2, 3, 4
ㅂ1, 2

"""