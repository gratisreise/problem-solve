from itertools import permutations

def isprime(n):
    if n < 2: 
        return 0
    for i in range(2, int(n ** 0.5)+1):
        if n % i == 0:
            return 0
    return 1
        
def solution(numbers):
    numbers = list(numbers);
    num = []
    for i in range(1, len(numbers)+1):
        num.append(permutations(numbers, i))
    num = set([int(''.join(y)) for x in num for y in x])
    return len([n for n in num if isprime(n)])
    # ret = set(n for num in n if isprime(n))
    # return len(ret)
    
"""
1. 뽑는 갯수마다 순열 구해서 숫자를 저장
2. 숫자가 소수인지 확인해서 갯수반환

"""