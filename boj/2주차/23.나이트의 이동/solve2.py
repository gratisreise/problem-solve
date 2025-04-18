import sys
ip, op = sys.stdin, sys.stdout  # 입출력 설정
from collections import deque

dy, dx = [1, 2, 2, 1, -1, -2, -2, -1], [-2, -1, 1, 2, 2, 1, -1, -2]  # 나이트 이동 방향

t = int(ip.readline().rstrip())  # 테스트 케이스 수
for _ in range(t):
    l = int(ip.readline().rstrip())  # 체스판 크기
    sy, sx = map(int, ip.readline().rstrip().split())  # 시작 위치
    ey, ex = map(int, ip.readline().rstrip().split())  # 목표 위치
    if sy == ey and sx == ex:  # 시작과 목표 같음
        op.write("0\n")
        continue
    vis = [[0] * l for _ in range(l)]  # 방문 배열
    vis[sy][sx] = 1  # 시작점 방문 (1부터 시작)
    q = deque()
    q.append((sy, sx))  # 시작점 큐에 추가
    while q:
        y, x = q.popleft()  # 현재 위치
        if vis[ey][ex]:  # 목표 도달
            break
        for d in range(8):  # 8방향 탐색
            ny, nx = y + dy[d], x + dx[d]
            if ny < 0 or nx < 0 or ny >= l or nx >= l:  # 범위 체크
                continue
            if vis[ny][nx]:  # 방문済
                continue
            q.append((ny, nx))  # 다음 위치 추가
            vis[ny][nx] = vis[y][x] + 1  # 이동 횟수 기록
    op.write(f"{vis[ey][ex]-1}\n")  # 결과 출력

"""
질문

문제 접근 방법과 아이디어
문제 이해
* 목표: 체스판에서 나이트가 시작 위치에서 목표 위치까지 이동하는 최소 이동 횟수 구하기.
* 조건:
    * 테스트 케이스: T (1 ≤ T ≤ 300).
    * 체스판 크기: L×L (4 ≤ L ≤ 300).
    * 시작 위치: (sy, sx).
    * 목표 위치: (ey, ex).
    * 나이트 이동: 8방향 (L자 이동).
* 출력: 각 테스트 케이스별 최소 이동 횟수 (줄 단위).
접근 아이디어
* BFS:
    * 나이트의 이동은 최단 경로 문제로, BFS가 적합.
    * 시작 위치에서 8방향으로 이동하며 최단 거리 계산.
* 상태 관리:
    * vis: 방문 배열, 각 칸까지의 이동 횟수 저장.
    * q: BFS 큐, 탐색할 위치 저장.
* 구현 전략:
    * 각 테스트 케이스마다 BFS 수행.
    * 시작과 목표가 같으면 0 출력.
    * BFS로 목표 위치 도달 시 이동 횟수 출력.
1. 입력 처리
* ip, op = sys.stdin, sys.stdout: 빠른 입출력.
* dy, dx: 나이트의 8방향 이동 벡터.
* t: 테스트 케이스 수.
* for _ in range(t):
    * l: 체스판 크기(L).
    * sy, sx: 시작 위치.
    * ey, ex: 목표 위치.
2. 특수 경우 처리
* if sy == ey and sx == ex:
    * 시작과 목표 위치가 같으면 이동 불필요 → "0" 출력 후 다음 케이스.
3. BFS
* vis = [[0] * l for _ in range(l)]: 방문 배열, 0은 미방문.
* vis[sy][sx] = 1: 시작점 방문, 이동 횟수 1로 시작.
* q = deque(): BFS 큐.
* q.append((sy, sx)): 시작점 추가.
* while q:
    * y, x = q.popleft(): 현재 위치.
    * if vis[ey][ex]: 목표 도달 시 종료.
    * 8방향 탐색:
        * ny, nx: 다음 위치.
        * 범위 벗어남: 스킵.
        * 방문済: 스킵.
        * q.append((ny, nx)): 다음 위치 추가.
        * vis[ny][nx] = vis[y][x] + 1: 이동 횟수 기록.
4. 출력
* vis[ey][ex]-1: 목표 위치의 이동 횟수(1 시작이므로 -1).
* op.write(f"{vis[ey][ex]-1}\n"): 결과 출력.

문제 분석
* 문제: 백준 7562 "나이트의 이동".
* 입력: T, 각 케이스에 L, 시작/목표 위치.
* 출력: 최소 이동 횟수.
* 조건: 나이트의 L자 이동, 체스판 범위 내.

시간 복잡도
* BFS: O(L^2) (최악 모든 칸 방문).
* 테스트 케이스: O(T).
* 총합: O(T * L^2) (T ≤ 300, L ≤ 300, ≈ 300 * 9×10^4 ≈ 2.7×10^7), 1초 내 충분.


"""