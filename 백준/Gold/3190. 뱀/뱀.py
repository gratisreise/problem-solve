from collections import deque

# 입력 처리
n = int(input())
k = int(input())
grid = [[0] * n for _ in range(n)]
for _ in range(k):
    y, x = map(int, input().split())
    grid[y-1][x-1] = 1  # 사과 위치 (1-based → 0-based)

l = int(input())
turns = []
for _ in range(l):
    t, c = input().split()
    t = int(t)
    turns.append((t, 1 if c == 'D' else 3))  # D: 오른쪽(1), L: 왼쪽(3)

# 방향 벡터 (상, 우, 하, 좌)
dy = [-1, 0, 1, 0]
dx = [0, 1, 0, -1]

# 초기 설정
dq = deque([(0, 0)])  # 뱀 몸통 (y, x)
visited = [[0] * n for _ in range(n)]  # 뱀 위치 방문 체크
visited[0][0] = 1
time = 0  # 경과 시간
dir = 1   # 초기 방향 (우)
idx = 0   # 방향 전환 인덱스

# 시뮬레이션
while True:
    time += 1
    y, x = dq[0]  # 머리 위치
    ny = y + dy[dir]
    nx = x + dx[dir]

    # 벽 또는 몸통에 부딪히면 종료
    if ny < 0 or ny >= n or nx < 0 or nx >= n or visited[ny][nx]:
        break

    # 사과가 없으면 꼬리 제거
    if grid[ny][nx] == 0:
        tail_y, tail_x = dq.pop()
        visited[tail_y][tail_x] = 0
    # 사과가 있으면 먹고 유지
    else:
        grid[ny][nx] = 0

    # 머리 이동
    visited[ny][nx] = 1
    dq.appendleft((ny, nx))

    # 방향 전환
    if idx < l and time == turns[idx][0]:
        dir = (dir + turns[idx][1]) % 4  # D: +1, L: +3
        idx += 1

# 결과 출력
print(time)
"""
코드 설명
1. 입력 처리
* 입력:
    * n: 격자 크기 (1 ≤ N ≤ 100).
    * k: 사과 개수 (0 ≤ K ≤ 100).
    * grid: N×N 격자, 사과 위치는 1 (1-based → 0-based로 변환).
    * l: 방향 전환 횟수 (1 ≤ L ≤ 100).
    * turns: 방향 전환 정보 리스트 (시간, 방향) (D: 1, L: 3).
* 방향 벡터:
    * dy, dx: 상, 우, 하, 좌 ([-1, 0, 1, 0], [0, 1, 0, -1]).
2. 초기 설정
* dq: 뱀 몸통을 deque로 관리, 초기 위치 (0, 0).
* visited: 뱀 위치 체크 배열 (1: 뱀 있음, 0: 없음).
* time: 경과 시간 (초기 0).
* dir: 현재 방향 (0: 상, 1: 우, 2: 하, 3: 좌, 초기 1).
* idx: 방향 전환 정보 인덱스.
3. 시뮬레이션
* 흐름:
    * while True: 게임 종료 조건까지 반복.
        * time += 1: 시간 증가.
        * y, x: 뱀 머리 위치.
        * ny, nx: 다음 이동 위치.
        * 종료 조건: 벽(ny, nx 범위 밖) 또는 몸통(visited[ny][nx]) 충돌 시 break.
        * 사과 처리:
            * grid[ny][nx] == 0: 사과 없으면 꼬리 제거 (dq.pop(), visited 갱신).
            * grid[ny][nx] == 1: 사과 먹고 grid[ny][nx] = 0.
        * 머리 이동: visited[ny][nx] = 1, dq.appendleft((ny, nx)).
        * 방향 전환: time이 turns[idx][0]과 같으면:
            * dir = (dir + turns[idx][1]) % 4: 오른쪽(D, +1) 또는 왼쪽(L, +3).
            * idx += 1.
4. 결과 출력
* 출력: time (게임 종료 시점).

문제 분석
* 문제: 백준 3190 "뱀".
* 입력:
    * N: 격자 크기.
    * K: 사과 개수, 위치.
    * L: 방향 전환 횟수, 정보.
* 조건:
    * 뱀은 (1, 1)에서 시작, 초기 방향 오른쪽.
    * 사과 먹으면 길이 증가, 없으면 유지.
    * 벽이나 몸통에 부딪히면 종료.
    * 방향 전환: D(오른쪽), L(왼쪽).
* 출력: 게임 종료 시간.

시간 복잡도
* 입력: O(K + L) (≈ 200).
* 시뮬레이션:
    * 뱀 길이 최대 N^2 (≈ 10^4).
    * 각 단계: O(1) (deque 연산).
    * 총합: O(N^2) (≈ 10^4).
* 결과: 1초 내 충분 (10^8 대비 여유).

결론
* 정확성: 조건 충족, 샘플 통과.
* 효율성: 시간 O(N^2), 공간 O(N^2)으로 최적.
* 특징:
    * deque로 뱀 몸통 효율적 관리.
    * 방향 전환 모듈러 연산으로 간소화.
    * 방문 배열로 충돌 체크.
* 검증: N 범위 내 효율적 동작.
"""