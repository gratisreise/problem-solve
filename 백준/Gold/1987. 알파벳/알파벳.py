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
문제 분석
    입력:
        R, C: 보드의 행과 열 (1 ≤ R, C ≤ 20).
        R줄: C개의 대문자 알파벳으로 된 보드.
    조건:
        시작: 좌측 상단 (0, 0).
        이동: 상하좌우 (4방향).
        제약: 같은 알파벳을 두 번 방문 불가.
        목표: 최대 이동 칸 수 (시작 칸 포함).
    출력: 최대 칸 수.

접근법
    DFS: 모든 경로를 탐색하며 최대 깊이(칸 수)를 구함.
    알파벳 중복 체크: 집합(set)으로 방문한 알파벳 관리.
    최적화: 최대 칸 수를 전역 변수로 갱신.

코드 설명
    1.입력 처리:
        R, C: 보드 크기.
        board: 알파벳 보드 (2D 리스트).
    2.변수 초기화:
        dy, dx: 상하좌우 이동 방향.
        max_count: 최대 이동 칸 수 (전역 변수).
        visited: 방문한 알파벳 집합.
    3.DFS 함수:
        (y, x): 현재 위치.
        visited: 현재까지 방문한 알파벳 집합.
        count: 현재 경로의 칸 수.
        동작:
            현재 칸 수로 max_count 갱신.
            4방향 탐색:
                범위 내이고, 새 알파벳이면 visited에 추가 후 재귀.
                탐색 후 visited에서 제거 (백트래킹).
    4.실행:
        (0, 0)에서 시작, 초기 칸 포함 (count=1).
    5.출력:
        max_count: 최대 칸 수.

시간 복잡도
    최악의 경우: 모든 칸을 방문하며, 각 칸에서 4방향 탐색.
    보드 크기: R × C ≤ 20 × 20 = 400.
    최대 깊이: 알파벳 26개 (A~Z).
    DFS 호출 수: O(4^26) 이론적이지만, 실제로는 보드 크기와 알파벳 제약으로 훨씬 작음.
    실질적: O(R × C × 26) 정도로 제한됨 → 약 O(10⁴) 수준, 2초 내 충분.
공간 복잡도
    board: R × C ≈ 400 바이트.
    visited: 최대 26개 알파벳 ≈ 1KB.
    재귀 스택: 최대 깊이 26 ≈ 몇 KB.
    총: 약 10KB (256MB 제한 내 여유).

결론
    DFS와 백트래킹으로 모든 경로를 탐색하며 최대 칸 수를 효율적으로 구함.
    시간 복잡도 O(R × C × 26)과 메모리 약 10KB로 제한 내 동작.
"""