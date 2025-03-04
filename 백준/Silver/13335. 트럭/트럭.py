from collections import deque
import sys
input = sys.stdin.readline

n, w, l = map(int, input().rstrip().split())
buses = deque(map(int, input().rstrip().split()))
q = deque()
time = 0
while True:
    time += 1
    if q and  time - q[0][1] == w:
        q.popleft()
    if len(q) < w and buses and sum(x[0] for x in q) + buses[0] <= l:
        q.append((buses.popleft(), time))
    if not q and not buses:
        break
print(time)