def is_prime(n):
    """소수 판별 함수. n이 소수면 True, 아니면 False 반환"""
    if n <= 1:  # 1 이하는 소수가 아님
        return False
    if n <= 3:  # 2와 3은 소수
        return True
    if n % 2 == 0 or n % 3 == 0:  # 2와 3으로 나누어 떨어지면 소수가 아님
        return False
    i = 5
    while i * i <= n:  # √n 까지만 확인
        if n % i == 0 or n % (i + 2) == 0:  # i 또는 i+2로 나누어 떨어지면 소수가 아님
            return False
        i += 6
    return True


n = input()
ret = 0
for c in map(int, input().split()):
    if is_prime(c): ret += 1
print(ret)