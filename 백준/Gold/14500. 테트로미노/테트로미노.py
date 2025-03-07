import sys

input = sys.stdin.readline

# 입력 처리
N, M = map(int, input().split())
paper = [list(map(int, input().split())) for _ in range(N)]

# 이동 방향 (상, 우, 하, 좌)
dy = [-1, 0, 1, 0]
dx = [0, 1, 0, -1]

# 최대 합
max_sum = 0

# DFS로 4칸 탐색
def dfs(y, x, count, total, visited):
    global max_sum
    if count == 4:  # 4칸 도달
        max_sum = max(max_sum, total)
        return
    
    # 4방향 탐색
    for i in range(4):
        ny, nx = y + dy[i], x + dx[i]
        if 0 <= ny < N and 0 <= nx < M and not visited[ny][nx]:
            visited[ny][nx] = True
            dfs(ny, nx, count + 1, total + paper[ny][nx], visited)
            visited[ny][nx] = False

# 'ㅗ' 모양 별도 처리
def check_T_shape(y, x):
    global max_sum
    # 중앙 기준 3칸 + 1칸 (상하좌우 중 3개)
    for i in range(4):
        total = paper[y][x]  # 중앙
        valid = True
        # 3방향 합
        for j in range(3):
            ny, nx = y + dy[(i + j) % 4], x + dx[(i + j) % 4]
            if not (0 <= ny < N and 0 <= nx < M):
                valid = False
                break
            total += paper[ny][nx]
        if valid:
            max_sum = max(max_sum, total)

# 모든 위치에서 탐색
visited = [[False] * M for _ in range(N)]
for i in range(N):
    for j in range(M):
        visited[i][j] = True
        dfs(i, j, 1, paper[i][j], visited)  # 시작 칸 포함
        visited[i][j] = False
        check_T_shape(i, j)  # 'ㅗ' 모양 체크

# 결과 출력
print(max_sum)

"""
코드 설명
    1.입력 처리:
        N, M: 종이 크기.
        paper: 값 배열.
    2.DFS (dfs):
        (y, x): 현재 위치.
        count: 선택한 칸 수.
        total: 현재 합.
        visited: 방문 체크.
        4칸 도달 시 max_sum 갱신.
        4방향 탐색 후 백트래킹.
    3.'ㅗ' 모양 처리 (check_T_shape):
        DFS로 커버 안 되는 'ㅗ', 'ㅏ', 'ㅜ', 'ㅓ' 모양.
        중앙 칸 + 4방향 중 3개 선택.
        범위 내일 때만 합 계산.
    4.메인 로직:
        모든 (i, j)에서 DFS와 'ㅗ' 체크 실행.
        visited로 중복 방지.
    5.출력: max_sum.

시간 복잡도
    DFS:
        각 칸: O(N × M).
        4방향, 깊이 4: O(4³) = O(64).
        총: O(N × M × 64).
    'ㅗ' 체크:
        각 칸: O(N × M).
        4가지 방향: O(4).
        총: O(N × M × 4).
    전체: O(N × M × 64) ≈ O(500 × 500 × 64) ≈ O(1.6×10⁷).
    2초 내 충분 (약 10⁸ 연산 가능).

공간 복잡도
    paper: N × M × 4B ≈ 500 × 500 × 4 ≈ 1MB.
    visited: N × M × 1B ≈ 250KB.
    재귀 스택: 최대 깊이 4 × 몇 KB.
    총: 약 1.3MB (512MB 내 여유).

결론
    DFS와 별도 'ㅗ' 처리로 모든 테트로미노 모양 커버.
    시간 복잡도 O(1.6×10⁷)과 메모리 약 1.3MB로 제한 내 효율적 동작.
"""