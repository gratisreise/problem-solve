import math
def isprime(num):
    if num == 1: return 0
    if num == 2: return 1 
    if num % 2 == 0: return 0
    for i in range(num +1, int(math.sqrt(num))+1):
        if num % i == 0: return 0
    return 1

def count(numbers, number_set, number):
    if len(number) == len(numbers):
        return number_set.add(int(''.join(numbers[i] for i in number)))
    if number: number_set.add(int(''.join(numbers[i] for i in number)))
    for i in range(len(numbers)):
        if i in number: continue
        number.append(i)
        count(numbers, number_set, number)
        number.pop()
def solution(numbers):
    answer = 0
    numbers = list(numbers)
    number_set = set()
    count(numbers, number_set, [])
    return sum(1 for i in number_set if isprime(i))
"""
문자열의 숫자에 대해 순열

"""