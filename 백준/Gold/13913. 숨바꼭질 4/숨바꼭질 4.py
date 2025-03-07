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
코드 설명
입력 처리:
    N, K: 수빈이와 동생의 위치.
    MAX: 최대 범위 100,001로 설정.
배열 초기화:
    time: 각 위치에 도달하는 최단 시간 (-1은 미방문).
    prev: 각 위치로 오기 전의 위치 저장 (-1은 없음).
BFS:
    초기 위치 N에서 시작, time[N] = 0.
    큐에서 x를 꺼내 다음 이동 계산:
        x-1, x+1, 2*x.
    조건:
        범위 내 (0 ≤ nx < MAX).
        미방문 (time[nx] == -1).
    방문 시: time[nx] 갱신, prev[nx]에 이전 위치 저장.
    x == K면 탐색 종료.
경로 복원:
    K에서 시작해 prev를 따라 N까지 역추적.
    path에 경로 저장 후 뒤집기.
출력:
    time[K]: 최단 시간.
    path: 경로를 공백으로 구분해 출력.

시간 복잡도
    BFS: 각 위치를 최대 한 번 방문, 이동 3가지 → O(MAX) ≈ O(10⁵).
    경로 복원: O(K) (최대 10⁵).
    총: O(10⁵) → 2초 내 충분 (약 10⁷~10⁸ 연산 가능).
공간 복잡도
    time, prev: O(MAX) ≈ 100,001 × 4바이트 × 2 ≈ 800KB.
    queue, path: 최악 O(MAX) ≈ 400KB.
    총: 약 1.2MB (512MB 제한 내 여유).
결론
    이 코드는 BFS로 최단 시간을 계산하고, 경로를 역추적해 정확히 출력해요.
    시간 복잡도 O(10⁵)와 메모리 약 1.2MB로 제한 내 동작.
    스페셜 저지라 경로가 다를 수 있지만, 최단 시간만 맞으면 통과.
"""