from collections import deque
import sys, itertools, math, heapq

ip, op = sys.stdin, sys.stdout
n, m = map(int, ip.readline().split())
graph = [set() for _ in range(n+1)]
ret = 0
for _ in range(m):
    a, b = map(int, ip.readline().split())
    if a == b or b in graph[a]:
        ret += 1
        continue
    graph[a].add(b)
cnt = 0
for a in range(1, n + 1):
    for b in list(graph[a]):
        if a in graph[b]:
            cnt += 1
    
op.write(f'{ret + cnt//2}\n')
    



"""
단순그래프 만들기
1. 자기 참조 없애기
2. 간선은 1개로 만들기

1.자기루프: 정답에 추가
2.다중간선: 중복된 개수에서 하나만 남기고 나머지 게거
O(NlogN)

"""