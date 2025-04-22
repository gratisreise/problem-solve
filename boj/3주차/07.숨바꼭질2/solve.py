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

"""
문제 접근 방법과 아이디어
문제 이해
* 목표: 수빈이(위치 N)가 동생(위치 K)에 도달하는 최단 시간과 그 경로의 수 구하기.
* 조건:
    * 위치: 0 ≤ N, K ≤ 100,000.
    * 이동:
        * X-1 또는 X+1: 1초 소요.
        * 2*X: 1초 소요.
    * 최단 시간 경로만 고려.
* 출력:
    * 최단 시간.
    * 최단 시간 경로의 수.
접근 아이디어
* BFS:
    * 최단 시간 경로 탐색 → BFS 적합.
    * 상태: 위치 X.
    * 각 위치의 최단 도착 시간과 경로 수 관리.
* 상태 관리:
    * time: 각 위치의 최단 도착 시간.
    * ways: 각 위치로의 최단 경로 수.
    * queue: BFS 큐, 탐색 위치 저장.
* 구현 전략:
    * BFS로 수빈이 위치(N)에서 시작.
    * 각 이동(X-1, X+1, 2*X)에 대해:
        * 처음 방문: 시간과 경로 수 기록.
        * 동일 시간 재방문: 경로 수 추가.
    * 동생 위치(K) 도달 시 결과 출력.
1. 입력 처리
* input = sys.stdin.readline: 빠른 입력.
* N, K: 수빈이 위치(N), 동생 위치(K).
* MAX = 100001: 위치 범위 (0~100,000).
* time = [-1] * MAX: 각 위치의 도착 시간, -1은 미방문.
* ways = [0] * MAX: 각 위치로의 최단 경로 수.
2. BFS 초기화
* queue = deque([N]): BFS 큐, 시작 위치 N.
* time[N] = 0: 시작 위치 시간 0.
* ways[N] = 1: 시작 위치 경로 수 1.
3. BFS
* while queue:
    * x = queue.popleft(): 현재 위치.
    * if time[x] > time[K] and time[K] != -1: 현재 시간이 동생의 최단 시간보다 크면 스킵 (최적화).
    * 이동: for nx in (x-1, x+1, 2*x):
        * 0 <= nx < MAX: 범위 체크.
        * 처음 방문 (time[nx] == -1):
            * time[nx] = time[x] + 1: 도착 시간 기록.
            * ways[nx] = ways[x]: 경로 수 상속.
            * queue.append(nx): 다음 위치 추가.
        * 동일 시간 재방문 (time[nx] == time[x] + 1):
            * ways[nx] += ways[x]: 경로 수 추가 (최단 경로 유지).
4. 출력
* print(time[K]): 동생 위치의 최단 시간.
* print(ways[K]): 동생 위치로의 최단 경로 수.

문제 분석
* 문제: 백준 12851 "숨바꼭질 2".
* 입력: N, K.
* 출력: 최단 시간, 최단 경로 수.
* 조건: X-1, X+1, 2*X 이동, 최단 경로만 고려.

시간 복잡도
* 상태: 위치 (0~100,000).
* 각 위치에서 이동: 3가지 (X-1, X+1, 2*X).
* BFS: O(MAX * 3) ≈ O(300,000), 1초 내 충분.
"""