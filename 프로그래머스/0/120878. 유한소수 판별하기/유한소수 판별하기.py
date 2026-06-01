def isprime(num):
    if num == 2 or num % 2 == 0: 
        return False
    for i in range(2, num +1):
        if i**2 > num:
            break
        if num % i == 0:
            return False
    return True

def solution(a, b):
    mx = max(a, b)
    for x in range(2, mx+1):
        if x > max(a ,b):
            break
        while a % x == 0 and b % x == 0:
            a //= x
            b //= x
    
    for i in range(2, b+1):
        if b % i == 0 and isprime(i) and (i != 2 and i != 5):
            return 2
    return 1
# 전부 약분 후 분모의 소인수가 2와 5만 존재
# 분모에 소수인 약수가 2와 5만 존재하면된다
# 소수판별 함수로 2와 5 이외의 소수가 있으면 2리턴