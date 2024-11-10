from collections import deque
def third(n):
    ans = deque()
    while n > 0:
        ans.appendleft(str(n%3))
        n //= 3
    return ''.join(ans)

def solution(n):
    ret = 0
    third_str = third(n)
    for i in range(len(third_str)):
        ret += int(third_str[i]) * (3 ** i)
    return ret
    