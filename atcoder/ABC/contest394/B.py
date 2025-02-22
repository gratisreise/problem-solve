from collections import deque
import sys, itertools, math, heapq

ip, op = sys.stdin, sys.stdout

S = ip.readline().rstrip()
n, ret = len(S), 0
for i in range(1, n//2+1):
    for j in range(n - (3 + (i-1)*2) +1):
        if S[j] == 'A' and S[j + i] == 'B' and S[j + 2*i] == 'C':
            ret += 1
        
op.write(f'{ret}\n')


"""
길이의 // 3한것의 인터벌 만큼 반복
3중 for문으로 완전탐색을 해도 시간안에 충분히 가능

하나의 입력과 하나의 출력 -> 단순입출력 사용하자

보너스:
C level: O(S^2)
F level: O(SlogS)
"""