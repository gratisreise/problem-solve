from collections import deque

# 입력 처리
n, m, k = map(int, input().split())
grid = [list(map(int, input().strip())) for _ in range(n)]

# 방향 벡터 (상, 하, 좌, 우)
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

# 3차원 방문 배열: [x][y][벽 부순 횟수]
visited = [[[False] * (k + 1) for _ in range(m)] for _ in range(n)]

def bfs():
    q = deque()
    q.append((0, 0, 0))  # 시작점 (x, y, 벽 부순 횟수)
    visited[0][0][0] = True  # 방문 처리
    distance = 1  # 시작점 포함

    while q:
        for _ in range(len(q)):
            x, y, breaks = q.popleft()
            
            # 목표 지점 도달 시 종료
            if x == n - 1 and y == m - 1:
                return distance
            
            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]
                
                if 0 <= nx < n and 0 <= ny < m:
                    # 다음 칸이 빈 공간인 경우
                    if grid[nx][ny] == 0 and not visited[nx][ny][breaks]:
                        visited[nx][ny][breaks] = True
                        q.append((nx, ny, breaks))
                    # 다음 칸이 벽이고, 부술 수 있는 경우
                    elif grid[nx][ny] == 1 and breaks < k and not visited[nx][ny][breaks + 1]:
                        visited[nx][ny][breaks + 1] = True
                        q.append((nx, ny, breaks + 1))
        distance += 1
    return -1

print(bfs())
"""
코드 설명
1. 입력 처리
* 입력:
    * n, m, k: 격자 크기 (행 N, 열 M), 벽 부술 수 있는 횟수 K.
        * 1 ≤ N, M ≤ 1,000, 0 ≤ K ≤ 10.
    * grid: N×M 격자 (문자열로 입력 후 정수 변환).
        * 0: 이동 가능 (빈 공간).
        * 1: 벽.
* 방향 벡터:
    * dx, dy: 상, 하, 좌, 우 이동 ([-1, 1, 0, 0], [0, 0, -1, 1]).
2. 초기 설정
* 방문 배열:
    * visited: 3차원 배열 [n][m][k+1].
        * visited[x][y][breaks]: (x, y) 위치에 벽을 breaks번 부순 상태로 방문 여부.
        * k+1 크기로 0부터 k까지 관리.
* 큐 초기화:
    * q: BFS용 deque.
    * (0, 0, 0): 시작점 (x, y, 벽 부순 횟수).
    * visited[0][0][0] = True: 시작 지점 방문 처리.
    * distance = 1: 이동 거리 (시작점 포함).
3. BFS 탐색 (bfs 함수)
* 역할: (0, 0)에서 (N-1, M-1)까지 최소 이동 횟수 계산.
* 흐름:
    * while q: 큐가 빌 때까지.
        * for _ in range(len(q)): 현재 거리의 모든 노드 처리 (층별 BFS).
            * x, y, breaks: 현재 위치와 벽 부순 횟수.
            * 목표 도달: (x, y) == (n-1, m-1)이면 distance 반환.
            * 4방향 탐색:
                * nx, ny: 새 위치.
                * 조건: 격자 내 (0 <= nx < n and 0 <= ny < m).
                * 빈 공간 이동:
                    * grid[nx][ny] == 0이고 미방문(not visited[nx][ny][breaks])이면:
                        * 방문 처리 후 큐에 추가 (breaks 유지).
                * 벽 부수기:
                    * grid[nx][ny] == 1, breaks < k, 미방문(not visited[nx][ny][breaks+1])이면:
                        * 방문 처리 후 큐에 추가 (breaks + 1).
        * distance += 1: 다음 층으로 이동.
    * 도달 불가능 시 -1 반환.
4. 결과 출력
* 출력: bfs() 결과.
    * 목표에 도달했으면 최소 이동 횟수, 아니면 -1.

문제 분석
* 문제: 백준 14442 "벽 부수고 이동하기 2".
* 입력:
    * N, M, K: 격자 크기 (행, 열), 벽 부술 횟수.
    * N×M 격자.
* 조건:
    * (0, 0)에서 (N-1, M-1)까지 최소 이동 횟수.
    * 벽(1)을 최대 K번 부술 수 있음.
    * 도달 불가능하면 -1.
* 출력: 최소 횟수 또는 -1.

시간 복잡도
* 입력: O(N * M) (≈ 10^6).
* BFS:
    * 상태: (x, y, breaks) → 최대 N * M * (K+1) (≈ 10^7).
    * 각 상태당 이동: 4방향.
    * 총합: O(N * M * K) (K ≤ 10 → 약 10^7).
* 결과: 1초 내 충분 (10^8 대비 여유).

공간 복잡도
* grid: O(N * M) ≈ 4MB.
* visited: O(N * M * (K+1)) ≈ 40MB (K ≤ 10).
* queue: O(N * M * K) 최악 경우 (≈ 40MB).
* 총합: 약 80MB (128MB 내 여유).

결론
* 정확성: 조건 충족 (K번 벽 부수기), 샘플 통과.
* 효율성: 시간 O(N * M * K), 공간 O(N * M * K)으로 최적.
* 특징:
    * 3차원 방문 배열로 벽 부순 횟수 관리.
    * 층별 BFS로 최소 거리 보장.
    * 간단한 구현으로 문제 해결.
* 검증: N, M, K 범위 내 효율적 동작.
"""