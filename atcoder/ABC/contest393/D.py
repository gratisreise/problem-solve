from collections import deque
import sys, itertools, math, heapq

ip, op = sys.stdin, sys.stdout
n = int(ip.readline())
s = ip.readline().rstrip()

if n == 1 or n == 2:
    op.write('0\n')



"""

S는 최소 하나의 1은 가지고 있다
모든 1이 연속되도록 만드는 최소의 swap
swap = (i, i+1)

1. 가장 길게 연속되는 수

"""