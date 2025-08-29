import sys
from collections import deque
dy, dx = [-1, 0, 1, 0], [0, 1, 0, -1]  # 상, 우, 하, 좌
ip, op = sys.stdin.readline, sys.stdout.write  # 빠른 입출력
n, m = map(int, ip().split())  # 격자 크기
sy, sx, ey, ex = map(int, ip().split())  # 시작, 목표 위치
sy, sx, ey, ex = sy - 1, sx - 1, ey - 1, ex - 1  # 0-based로 변환
a, vis, q = [], [[0]*m for _ in range(n)], deque()  # 격자, 방문 배열, 큐
vis[sy][sx] = 1  # 시작 위치 방문
q.append((sy, sx))  # 시작 위치 큐에 추가
for _ in range(n):
    a.append(list(ip()))  # 격자 입력
cnt = 0  # 시간 (벽 부수기 횟수)
while True:
    tempq = deque()  # 다음 시간 큐
    while q:  # 현재 시간 처리
        y, x = q.popleft()
        for d in range(4):
            ny, nx = y + dy[d], x + dx[d]
            if ny < 0 or nx < 0 or ny >= n or nx >= m:
                continue
            if vis[ny][nx]:
                continue
            if a[ny][nx] == '1':  # 벽
                tempq.append((ny, nx))
                vis[ny][nx] = vis[y][x] + 1
            else:  # 빈 칸 또는 목표
                q.append((ny, nx))
                vis[ny][nx] = vis[y][x] + 1
    cnt += 1  # 시간 증가
    if not tempq or vis[ey][ex]:  # 다음 큐 없거나 목표 도달
        break
    q = deque(tempq)  # 다음 시간으로 이동
print(cnt)
"""
문제 접근 방법과 아이디어
문제 이해
* 목표: 주난이(시작 위치: sy, sx)가 친구(목표 위치: ey, ex)에게 도달하는 최소 시간 구하기.
* 조건:
    * 격자: N×M (1 ≤ N, M ≤ 300).
    * 격자 값:
        * '0': 빈 칸 (이동 가능).
        * '1': 벽 (1초 소요하여 부숨).
        * '#': 친구 위치.
        * '*': 주난 위치.
    * 이동: 상하좌우.
    * 시간:
        * 빈 칸 이동: 0초 (동일 시간 내 처리).
        * 벽 부수기: 1초 (다음 시간에 처리).
    * 시작/목표 좌표는 1-based 입력 (1 ≤ sy, sx, ey, ex ≤ N/M).
* 출력: 최소 시간 (벽을 부수는 횟수).
접근 아이디어
* BFS:
    * 최단 시간 경로 탐색 → BFS 적합.
    * 벽 부수기가 1초 소요 → 시간 단위로 BFS 진행.
    * 각 시간 단계에서:
        * 빈 칸('0') 이동: 동일 시간 내 큐에 추가.
        * 벽('1') 이동: 다음 시간 큐에 추가.
* 상태 관리:
    * a: 격자 상태.
    * vis: 방문 배열, 이동 시간 저장.
    * q: 현재 시간 큐.
    * tempq: 다음 시간 큐 (벽 부수기 위치).
    * cnt: 시간(벽 부수기 횟수).
* 구현 전략:
    * 시작 위치에서 BFS 시작.
    * 각 시간 단계에서 빈 칸 이동 우선 처리, 벽은 다음 단계로 지연.
    * 목표 위치(ey, ex) 도달 시 시간 출력.
1. 입력 처리
* ip, op = sys.stdin.readline, sys.stdout.write: 빠른 입출력.
* n, m: 격자 세로(N), 가로(M).
* sy, sx, ey, ex: 시작과 목표 위치 (1-based).
* sy, sx, ey, ex = sy - 1, sx - 1, ey - 1, ex - 1: 0-based로 변환.
* a: N×M 격자 입력 (문자 리스트: '0', '1', '*', '#').
* vis = [[0]*m for _ in range(n)]: 방문 배열, 방문 시간 저장.
* q = deque(): BFS 큐.
* vis[sy][sx] = 1: 시작 위치 방문.
* q.append((sy, sx)): 시작 위치 큐에 추가.
2. BFS
* cnt = 0: 시간 (벽 부수기 횟수).
* while True:
    * tempq = deque(): 다음 시간 큐 (벽 부수기 위치).
    * 현재 시간 처리:
        * while q:
            * y, x = q.popleft(): 현재 위치.
            * 4방향 탐색:
                * ny, nx: 다음 위치.
                * 범위 벗어남 또는 방문済: 스킵.
                * 벽(a[ny][nx] == '1'):
                    * tempq.append((ny, nx)): 다음 시간 큐에 추가.
                    * vis[ny][nx] = vis[y][x] + 1: 방문 시간 기록.
                * 빈 칸 또는 목표(a[ny][nx] != '1'):
                    * q.append((ny, nx)): 현재 시간 큐에 추가.
                    * vis[ny][nx] = vis[y][x] + 1: 방문 시간 기록.
    * cnt += 1: 시간 증가.
    * 종료 조건:
        * not tempq: 다음에 부술 벽 없음 → 종료.
        * vis[ey][ex]: 목표 위치 도달 → 종료.
    * q = deque(tempq): 다음 시간 큐로 전환.
3. 출력
* print(cnt): 최소 시간 (벽 부수기 횟수).

문제 분석
* 문제: 백준 14497 "주난의 난".
* 입력: N, M, 시작/목표 위치, N×M 격자.
* 출력: 최소 시간 (벽 부수기 횟수).
* 조건: 빈 칸은 즉시 이동, 벽은 1초 소요.

시간 복잡도
* BFS: O(N * M) (각 칸 최대 1번 방문).
* 최대 시간 단계: O(N * M) (최악 모든 칸이 벽).
* 총합: O(N * M * N * M) (N, M ≤ 300, ≈ 300^4 ≈ 8.1×10^9 이론적 최악, 실제로는 훨씬 적음).
* 실제: 벽 수가 제한적이므로 1초 내 충분.

공간 복잡도
* a: O(N * M) ≈ 360KB.
* vis: O(N * M) ≈ 360KB.
* q, tempq: O(N * M) ≈ 720KB.
* 총합: O(N * M) (128MB 내 여유).

"""