import math
from collections import deque
def n_to_k(n, k):
    ret = deque()
    while n > 0:
        ret.appendleft(str(n % k))
        n //= k
    return ''.join(ret)

def is_prime(n):
    # 2는 소수이므로 바로 True 반환
    if n == 2: return True
    
    # 짝수는 소수가 아니므로 False 반환
    if n % 2 == 0: return False
    
    # 3부터 √n 까지 홀수로 나누어 소수 여부 확인
    for i in range(3, int(math.sqrt(n)) + 1, 2):
        if n % i == 0: return False
    return True

def solution(n, k):
    answer = -1
    temp = n_to_k(n, k)
    arr = temp.split('0')
    ret = 0
    for num in arr:
        if num and int(num) >= 2 and is_prime(int(num)):
            ret += 1
    return ret
# 0P0, P0, 0P, P 형태
# 자릿수에 0을 포함하지 않는 소수
