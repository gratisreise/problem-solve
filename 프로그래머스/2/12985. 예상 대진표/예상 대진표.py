def solution(n,a,b):
    ret = 1
    while max(a,b)- min(a,b) != 1 or max(a,b) % 2 != 0:
        print(a, b)
        if a % 2 == 0: a //= 2
        else: a = a//2 + 1
        if b % 2 == 0: b //= 2
        else: b = b//2 + 1
        ret += 1
    return ret
"""
1. 1~N번 배정
2. 게임 이후 번호 다시 배정
3. 임의의 A와 B 번호 몇번째 라운드에서 만나지?

"""