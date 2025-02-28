from collections import deque
n, m = map(int, input().split())
q = deque([i+1 for i in range(n)])
ret = 0
data = list(map(int, input().split()))
for num in data:
    temp_r, temp_l = deque(q), deque(q)
    cnt = 0
    while temp_r[0] != num and temp_l[0] != num:
        temp_r.rotate(1)
        temp_l.rotate(-1)
        cnt += 1
    if temp_r[0] == num:
        temp_r.popleft()
        q = deque(temp_r)
    elif temp_l[0] == num:
        temp_l.popleft()
        q = deque(temp_l)
    ret += cnt
print(ret)