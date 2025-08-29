from collections import deque
import sys, itertools, math, heapq

ip, op = sys.stdin, sys.stdout

ret = {"sick fine": 2, "sick sick": 1, "fine sick": 3, "fine fine": 4}
op.write(f"{ret[ip.readline().rstrip()]}\n")

"""
단순 조건문 처리 가능한지 물어봄
입력을 단순 1개만 입력받는 거면 input, print사용하자
1,2
1,3
a sick b fine -> 2
a sick b sick -> 1
a fine b fine -> 3
a fine b fine -> 4
"""