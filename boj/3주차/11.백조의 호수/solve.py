import sys

input = sys.stdin.readline

# 입력 처리
R, C = map(int, input().split())
board = [list(input().strip()) for _ in range(R)]

# 이동 방향 (상, 우, 하, 좌)
dy = [-1, 0, 1, 0]
dx = [0, 1, 0, -1]

# 최대 칸 수
max_count = 0

# DFS
def dfs(y, x, visited, count):
    global max_count
    max_count = max(max_count, count)  # 최대값 갱신
    
    # 4방향 탐색
    for i in range(4):
        ny, nx = y + dy[i], x + dx[i]
        # 범위 내이고, 방문하지 않은 알파벳이면
        if 0 <= ny < R and 0 <= nx < C and board[ny][nx] not in visited:
            visited.add(board[ny][nx])
            dfs(ny, nx, visited, count + 1)
            visited.remove(board[ny][nx])  # 백트래킹

# 시작 위치
visited = set([board[0][0]])  # 초기 알파벳 추가
dfs(0, 0, visited, 1)  # 시작 칸 포함

# 결과 출력
print(max_count)
"""
문제 접근 방법과 아이디어
문제 이해 (백준 1987 - 알파벳)
* 목표: (0,0)에서 시작하여 서로 다른 알파벳을 최대한 많이 방문하는 경로의 칸 수 구하기.
* 조건:
    * 격자: R×C (1 ≤ R, C ≤ 20).
    * 격자 값: 대문자 알파벳 (A-Z).
    * 이동: 상하좌우.
    * 제약: 같은 알파벳은 두 번 방문 불가.
    * 시작: (0,0)의 알파벳 포함.
* 출력: 최대 방문 칸 수.
접근 아이디어
* DFS:
    * 각 위치에서 4방향으로 이동하며 방문 가능한 알파벳 탐색.
    * 백트래킹으로 방문한 알파벳 해제 → 모든 경로 탐색.
    * 최대 방문 칸 수 갱신.
* 상태 관리:
    * board: 격자 상태 (알파벳).
    * visited: 방문한 알파벳 집합.
    * max_count: 최대 방문 칸 수.
* 구현 전략:
    * (0,0)에서 DFS 시작, 초기 알파벳 포함.
    * 각 단계에서 방문하지 않은 알파벳으로 이동.
    * 경로 길이로 최대값 갱신.
1. 입력 처리
* input = sys.stdin.readline: 빠른 입력.
* R, C: 격자 세로(R), 가로(C).
* board: R×C 격자 입력 (알파벳 문자열 리스트).
* dy, dx: 4방향 이동 벡터 (상, 우, 하, 좌).
2. 초기화
* max_count = 0: 최대 방문 칸 수.
* visited = set([board[0][0]]): 시작 위치의 알파벳을 방문 집합에 추가.
* dfs(0, 0, visited, 1): 시작 위치 (0,0), 초기 방문 칸 수 1로 DFS 시작.
3. DFS 함수
* dfs(y, x, visited, count):
    * y, x: 현재 위치.
    * visited: 방문한 알파벳 집합.
    * count: 현재 경로의 칸 수.
    * max_count = max(max_count, count): 최대 칸 수 갱신.
    * 4방향 탐색:
        * ny, nx: 다음 위치.
        * 0 <= ny < R and 0 <= nx < C: 범위 내.
        * board[ny][nx] not in visited: 방문하지 않은 알파벳.
        * 조건 만족 시:
            * visited.add(board[ny][nx]): 알파벳 추가.
            * dfs(ny, nx, visited, count + 1): 다음 위치로 재귀.
            * visited.remove(board[ny][nx]): 백트래킹 (알파벳 제거).
4. 출력
* print(max_count): 최대 방문 칸 수 출력.

문제 분석
* 문제: 백준 1987 "알파벳".
* 입력: R, C, R×C 격자.
* 출력: 최대 방문 칸 수.
* 조건: 상하좌우 이동, 같은 알파벳 재방문 불가.

시간 복잡도
* 상태: 위치 (R * C) × 방문 알파벳 (2^26, 실제로는 칸 수 제한).
* 최악: 각 위치에서 4방향 탐색, 최대 20×20 격자, 알파벳 26개.
* 실제: R * C ≤ 400, 경로 길이 ≤ min(R * C, 26).
* DFS: O(4^(R * C)) 이론적 최악, 실제로는 백트래킹으로 훨씬 적음 (1초 내 통과).

"""