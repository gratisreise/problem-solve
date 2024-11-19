from itertools import permutations

def isprime(n):
    if n < 2: return 0
    for i in range(2, int(n ** 0.5)+1):
        if n % i == 0: return 0
    return 1

def solution(numbers):
    answer = []
    numbers = list(numbers)
    num = []
    
    for i in range(1, len(numbers)+1):
        num.append(list(permutations(numbers, i)))  
    num = [int(''.join(y)) for x in num for y in x]    
    
    for i in num:
        if isprime(i):
            answer.append(i)
    
    return len(set(answer))