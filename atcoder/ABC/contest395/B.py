from collections import deque
import sys, itertools, math, heapq

ip, op = sys.stdin, sys.stdout
n = int(input())
ret = [[0]*(n+2) for _ in range(n+2)]

for i in range(1, n+1):
    j = n + 1 - i
    if i <= j:
        for y in range(i, j+1):
            for x in range(i, j+1):
                if i % 2 == 0:
                    ret[y][x] = '.'
                else: ret[y][x] = '#'  

for i in range(1, n+1):
    print(''.join(ret[i][1:-1]))




"""
1 ~ N 까지
j = n+1 -i

i <= j -> (i, i) -> (j, j)색칠
i홀수 -> #, 짝수:.


"""