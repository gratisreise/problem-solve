from collections import deque

# 입력 처리
n, m = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(n)]

# 방향 벡터 (상, 하, 좌, 우)
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

# 가장 큰 블록 그룹 찾기
def find_largest_group():
    visited = [[False] * n for _ in range(n)]
    max_group = []
    max_rainbow = -1
    max_size = 0

    for i in range(n):
        for j in range(n):
            if grid[i][j] > 0 and not visited[i][j]:  # 일반 블록인 경우
                color = grid[i][j]
                queue = deque([(i, j)])
                visited[i][j] = True
                group = [(i, j)]
                rainbow = 0

                while queue:
                    x, y = queue.popleft()
                    for d in range(4):
                        nx, ny = x + dx[d], y + dy[d]
                        if 0 <= nx < n and 0 <= ny < n:
                            if (grid[nx][ny] == color or grid[nx][ny] == 0) and not visited[nx][ny]:
                                visited[nx][ny] = True
                                queue.append((nx, ny))
                                group.append((nx, ny))
                                if grid[nx][ny] == 0:
                                    rainbow += 1

                # 무지개 블록 방문 초기화
                for x, y in group:
                    if grid[x][y] == 0:
                        visited[x][y] = False

                # 그룹 크기 비교
                if len(group) > max_size or (len(group) == max_size and (rainbow > max_rainbow or (rainbow == max_rainbow and (i > max_group[0][0] or (i == max_group[0][0] and j > max_group[0][1]))))):
                    max_size = len(group)
                    max_rainbow = rainbow
                    max_group = group

    return max_group

# 블록 그룹 제거
def remove_group(group):
    for x, y in group:
        grid[x][y] = -2  # 빈 칸으로 표시

# 중력 적용
def apply_gravity():
    for j in range(n):
        for i in range(n - 1, -1, -1):
            if grid[i][j] >= 0:  # 검은색 블록이 아닌 경우
                x = i
                while x + 1 < n and grid[x + 1][j] == -2:
                    grid[x + 1][j] = grid[x][j]
                    grid[x][j] = -2
                    x += 1

# 격자 90도 반시계 방향 회전
def rotate():
    global grid
    grid = [list(row) for row in zip(*grid)][::-1]

# 메인 로직
score = 0
while True:
    # 1. 가장 큰 블록 그룹 찾기
    group = find_largest_group()
    if len(group) < 2:
        break

    # 2. 블록 그룹 제거 및 점수 추가
    score += len(group) ** 2
    remove_group(group)

    # 3. 중력 적용
    apply_gravity()

    # 4. 격자 90도 반시계 방향 회전
    rotate()

    # 5. 중력 적용
    apply_gravity()

# 결과 출력
print(score)