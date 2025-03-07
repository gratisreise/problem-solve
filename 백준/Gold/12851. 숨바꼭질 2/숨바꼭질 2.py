from collections import deque
import sys

input = sys.stdin.readline

# 입력 처리
N, K = map(int, input().split())
MAX = 100001  # 최대 위치 범위

# 방문 시간과 경로 수 배열
time = [-1] * MAX  # -1: 미방문
ways = [0] * MAX   # 경로 수

# BFS
queue = deque([N])
time[N] = 0
ways[N] = 1

while queue:
    x = queue.popleft()
    
    # 현재 시간이 동생 위치의 최단 시간보다 크면 탐색 중지
    if time[x] > time[K] and time[K] != -1:
        continue
    
    # 이동: X-1, X+1, 2*X
    for nx in (x-1, x+1, 2*x):
        if 0 <= nx < MAX:
            # 처음 방문
            if time[nx] == -1:
                time[nx] = time[x] + 1
                ways[nx] = ways[x]
                queue.append(nx)
            # 동일 시간에 도달 (최단 시간 경로 추가)
            elif time[nx] == time[x] + 1:
                ways[nx] += ways[x]

# 결과 출력
print(time[K])
print(ways[K])