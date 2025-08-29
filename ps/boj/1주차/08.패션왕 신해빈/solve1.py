import sys
from collections import Counter
from functools import reduce
from operator import mul

input = sys.stdin.readline

t = int(input())
for _ in range(t):
    n = int(input())
    clothes = Counter()
    for _ in range(n):
        _, kind = input().split()
        clothes[kind] += 1
    
    # math.prod 대신 reduce와 mul 사용
    result = reduce(mul, (count + 1 for count in clothes.values()), 1) - 1
    print(result)