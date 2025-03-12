from collections import deque

k = int(input())
w, h = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(h)]

# 상하좌우 이동 방향
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

# 나이트 이동 방향 (8방향)
knight_dx = [-2, -1, 1, 2, 2, 1, -1, -2]
knight_dy = [1, 2, 2, 1, -1, -2, -2, -1]

# 3차원 방문 배열: [k][x][y]
visited = [[[False] * w for _ in range(h)] for _ in range(k + 1)]

q = deque()
q.append((0, 0, k, 0))
visited[k][0][0] = True  # 시작 지점 방문 처리

answer = -1

while q:
    x, y, remain_k, moves = q.popleft()
    
    # 목표 지점 도달 시 종료
    if x == h - 1 and y == w - 1:
        answer = moves
        break
    
    # 일반 이동 (상하좌우)
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < h and 0 <= ny < w:
            if grid[nx][ny] == 0 and not visited[remain_k][nx][ny]:
                visited[remain_k][nx][ny] = True
                q.append((nx, ny, remain_k, moves + 1))
    
    # 나이트 이동 (남은 기회가 있을 때만)
    if remain_k > 0:
        for i in range(8):
            nx = x + knight_dx[i]
            ny = y + knight_dy[i]
            if 0 <= nx < h and 0 <= ny < w:
                if grid[nx][ny] == 0 and not visited[remain_k - 1][nx][ny]:
                    visited[remain_k - 1][nx][ny] = True
                    q.append((nx, ny, remain_k - 1, moves + 1))

print(answer)
"""
백준 1600번 "말이 되고픈 원숭이" 문제를 해결하는 코드를 기반으로 설명을 작성할게. 이 문제는 W×H 격자에서 원숭이가 (0, 0)에서 (H-1, W-1)까지 최소 이동 횟수로 도달하는 BFS 문제야. 원숭이는 상하좌우로 이동하거나, 나이트처럼 8방향으로 K번까지 이동할 수 있어. 장애물(1)을 피해야 하고, 도달 불가능하면 -1을 출력해야 해. 아래에서 단계별로 설명할게.

코드 설명
1. 입력 처리
* 입력:
    * k: 나이트 이동 가능 횟수 (0 ≤ K ≤ 30).
    * w, h: 격자 크기 (열 W, 행 H).
        * 1 ≤ W, H ≤ 200.
    * grid: H×W 격자.
        * 0: 이동 가능.
        * 1: 장애물.
* 방향 벡터:
    * dx, dy: 상하좌우 이동 ([-1, 1, 0, 0], [0, 0, -1, 1]).
    * knight_dx, knight_dy: 나이트 이동 8방향 ([-2, -1, 1, 2, 2, 1, -1, -2], [1, 2, 2, 1, -1, -2, -2, -1]).
2. 초기 설정
* 방문 배열:
    * visited: 3차원 배열 [k+1][h][w].
        * visited[remain_k][x][y]: 남은 나이트 이동 횟수가 remain_k일 때 (x, y) 방문 여부.
* 큐 초기화:
    * q: BFS용 deque.
    * (0, 0, k, 0): 시작점 (x, y, 남은 나이트 횟수, 이동 횟수).
    * visited[k][0][0] = True: 시작 지점 방문 처리.
3. BFS 탐색
* 변수:
    * answer: 최소 이동 횟수 (초기값 -1).
* 흐름:
    * while q: 큐가 빌 때까지.
        * x, y, remain_k, moves: 현재 위치, 남은 나이트 횟수, 이동 횟수.
        * 목표 도달: (x, y) == (h-1, w-1)이면:
            * answer = moves 기록 후 종료.
        * 상하좌우 이동:
            * 4방향 탐색:
                * nx, ny: 새 위치.
                * 조건: 격자 내, 장애물 없음(grid[nx][ny] == 0), 미방문(not visited[remain_k][nx][ny]).
                * 방문 처리 후 큐에 추가 (나이트 횟수 유지).
        * 나이트 이동:
            * if remain_k > 0: 남은 나이트 횟수가 있으면.
            * 8방향 탐색:
                * 조건: 격자 내, 장애물 없음, 미방문(not visited[remain_k-1][nx][ny]).
                * 방문 처리 후 큐에 추가 (나이트 횟수 -1).
4. 결과 출력
* 출력: answer.
    * 도달했으면 최소 이동 횟수, 아니면 -1.

문제 분석
* 문제: 백준 1600 "말이 되고픈 원숭이".
* 입력:
    * K: 나이트 이동 횟수.
    * W, H: 격자 크기 (열, 행).
    * H×W 격자.
* 조건:
    * (0, 0)에서 (H-1, W-1)까지 최소 이동 횟수.
    * 이동: 상하좌우(1칸) + 나이트(8방향, K번까지).
    * 장애물(1) 피하기.
    * 도달 불가능하면 -1.
* 출력: 최소 횟수 또는 -1.

시간 복잡도
* 입력: O(H * W) (≈ 4×10^4).
* BFS:
    * 상태: (x, y, remain_k) → 최대 H * W * (K+1) (≈ 10^6).
    * 각 상태당 이동: 상하좌우 4 + 나이트 8 = 12.
    * 총합: O(H * W * K * 12) (≈ 10^7).
* 결과: 1초 내 충분 (10^8 대비 여유).

공간 복잡도
* grid: O(H * W) ≈ 0.16MB.
* visited: O(K * H * W) ≈ 5MB (K ≤ 30).
* queue: O(H * W * K) 최악 경우 (≈ 5MB).
* 총합: 약 10MB (128MB 내 여유).

결론
* 정확성: 조건 충족, 샘플 통과.
* 효율성: 시간 O(H * W * K), 공간 O(H * W * K)으로 최적.
* 특징:
    * 3차원 방문 배열로 나이트 횟수 관리.
    * BFS로 최소 이동 횟수 보장.
    * 목표 도달 시 즉시 종료로 최적화.
* 검증: H, W, K 범위 내 효율적 동작.
"""