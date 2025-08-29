from collections import deque
import sys

input = sys.stdin.readline

# 입력 처리
N, K = map(int, input().split())
MAX = 100001  # 최대 위치 범위

# 방문 시간과 이전 위치 배열
time = [-1] * MAX  # -1: 미방문
prev = [-1] * MAX  # 이전 위치 저장

# BFS
queue = deque([N])
time[N] = 0

while queue:
    x = queue.popleft()
    if x == K:  # 동생 위치 도달
        break
    
    # 이동: X-1, X+1, 2*X
    for nx in (x-1, x+1, 2*x):
        if 0 <= nx < MAX and time[nx] == -1:  # 범위 내이고 미방문
            time[nx] = time[x] + 1
            prev[nx] = x
            queue.append(nx)

# 경로 복원
path = []
curr = K
while curr != -1:
    path.append(curr)
    curr = prev[curr]
path.reverse()

# 결과 출력
print(time[K])
print(' '.join(map(str, path)))

"""
문제 접근 방법과 아이디어
문제 이해
* 목표: 수빈이(위치 N)가 동생(위치 K)에 도달하는 최단 시간과 그 경로 구하기.
* 조건:
    * 위치: 0 ≤ N, K ≤ 100,000.
    * 이동:
        * X-1 또는 X+1: 1초 소요.
        * 2*X: 1초 소요.
    * 최단 시간 경로만 고려.
* 출력:
    * 최단 시간.
    * 최단 경로 (위치 순서, 공백으로 구분).
접근 아이디어
* BFS:
    * 최단 시간 경로 탐색 → BFS 적합.
    * 상태: 위치 X.
    * 각 위치의 최단 도착 시간과 이전 위치 저장.
* 상태 관리:
    * time: 각 위치의 최단 도착 시간.
    * prev: 각 위치의 이전 위치 (경로 복원용).
    * queue: BFS 큐, 탐색 위치 저장.
* 구현 전략:
    * BFS로 수빈이 위치(N)에서 시작.
    * 동생 위치(K) 도달 시 탐색 종료.
    * prev 배열로 경로 복원.
    * 시간과 경로 출력.
1. 입력 처리
* input = sys.stdin.readline: 빠른 입력.
* N, K: 수빈이 위치(N), 동생 위치(K).
* MAX = 100001: 위치 범위 (0~100,000).
* time = [-1] * MAX: 각 위치의 도착 시간, -1은 미방문.
* prev = [-1] * MAX: 각 위치의 이전 위치.
2. BFS 초기화
* queue = deque([N]): BFS 큐, 시작 위치 N.
* time[N] = 0: 시작 위치 시간 0.
3. BFS
* while queue:
    * x = queue.popleft(): 현재 위치.
    * if x == K: 동생 위치 도달 → 탐색 종료.
    * 이동: for nx in (x-1, x+1, 2*x):
        * 0 <= nx < MAX and time[nx] == -1: 범위 내, 미방문:
            * time[nx] = time[x] + 1: 도착 시간 기록.
            * prev[nx] = x: 이전 위치 기록.
            * queue.append(nx): 다음 위치 추가.
4. 경로 복원
* path = []: 경로 저장 리스트.
* curr = K: 동생 위치에서 시작.
* while curr != -1:
    * path.append(curr): 현재 위치 추가.
    * curr = prev[curr]: 이전 위치로 이동.
* path.reverse(): 경로를 시작(N)부터 K까지 순서로 뒤집기.
5. 출력
* print(time[K]): 최단 시간.
* print(' '.join(map(str, path))): 경로 공백 구분 출력.

문제 분석
* 문제: 백준 13913 "숨바꼭질 4".
* 입력: N, K.
* 출력: 최단 시간, 최단 경로.
* 조건: X-1, X+1, 2*X 이동, 최단 경로 출력.

시간 복잡도
* 상태: 위치 (0~100,000).
* 각 위치에서 이동: 3가지 (X-1, X+1, 2*X).
* BFS: O(MAX * 3) ≈ O(300,000).
* 경로 복원: O(MAX) (최악 경로 길이).
* 총합: O(MAX), 1초 내 충분.
"""