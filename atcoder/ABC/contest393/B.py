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



"""