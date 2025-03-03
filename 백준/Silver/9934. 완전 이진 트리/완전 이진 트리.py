from collections import deque
import sys
ip, op = sys.stdin.readline, sys.stdout.write

n = int(ip().rstrip())
nums = list(map(int, ip().rstrip().split()))
q = deque()
q.append((0, len(nums)-1))

while q:
    tempq = deque()
    while q:
        l, r = q.popleft()
        mid = (l+r)//2
        op(f"{nums[mid]} ")
        if l == r: continue
        tempq.append((l, mid-1))
        tempq.append((mid+1, r))
    op('\n')
    q = deque(tempq)