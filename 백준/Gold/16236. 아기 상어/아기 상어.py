from collections import deque
import sys

input = sys.stdin.readline

# 이동 방향: 상, 좌, 하, 우
dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]

# BFS로 먹을 물고기 찾기
def bfs(grid, x, y, size):
    n = len(grid)
    visited = [[-1] * n for _ in range(n)]  # 거리 저장 (-1: 미방문)
    q = deque([(x, y)])
    visited[x][y] = 0
    fish = []  # (거리, x, y) 저장
    
    while q:
        cx, cy = q.popleft()
        for i in range(4):
            nx, ny = cx + dx[i], cy + dy[i]
            if 0 <= nx < n and 0 <= ny < n and visited[nx][ny] == -1:
                # 이동 가능: 빈칸(0) 또는 자신보다 작은 물고기
                if grid[nx][ny] <= size:
                    visited[nx][ny] = visited[cx][cy] + 1
                    q.append((nx, ny))
                    # 먹을 수 있는 물고기면 리스트에 추가
                    if 0 < grid[nx][ny] < size:
                        fish.append((visited[nx][ny], nx, ny))
    
    # 먹을 물고기 없으면 빈 리스트 반환
    if not fish:
        return None
    # 가장 가까운 물고기 중 우선순위(위, 왼쪽)로 정렬
    fish.sort()  # (거리, x, y) 순으로 정렬
    return fish[0]  # (dist, nx, ny)

# 입력 처리
N = int(input())
grid = [list(map(int, input().split())) for _ in range(N)]

# 아기 상어 초기 위치 찾기
shark_x, shark_y = 0, 0
for i in range(N):
    for j in range(N):
        if grid[i][j] == 9:
            shark_x, shark_y = i, j
            grid[i][j] = 0  # 상어 위치를 빈칸으로

# 메인 로직
shark_size = 2  # 초기 크기
eaten = 0       # 먹은 물고기 수
total_time = 0  # 총 이동 시간

while True:
    result = bfs(grid, shark_x, shark_y, shark_size)
    if result is None:  # 먹을 물고기 없음
        break
    
    dist, nx, ny = result
    total_time += dist
    shark_x, shark_y = nx, ny  # 상어 이동
    grid[nx][ny] = 0  # 물고기 먹음
    eaten += 1
    
    # 크기만큼 먹으면 성장
    if eaten == shark_size:
        shark_size += 1
        eaten = 0

# 결과 출력
print(total_time)


"""
문제 분석
입력:
NxN 격자 (2 ≤ N ≤ 20).
격자 값: 0(빈칸), 1~6(물고기 크기), 9(아기 상어 위치).
조건:
아기 상어 초기 크기: 2.
이동: 상, 좌, 하, 우 (상하 우선, 좌우 우선).
먹을 수 있는 물고기: 자신보다 작은 크기.
크기만큼 물고기 먹으면 크기 +1.
먹을 물고기 없으면 종료.
출력: 아기 상어가 이동한 총 시간.
접근법
BFS로 아기 상어에서 먹을 수 있는 모든 물고기까지의 거리 계산.
가장 가까운 물고기 중 우선순위(위, 왼쪽)로 선택.
물고기 먹고 크기 갱신, 반복.
더 이상 먹을 물고기 없으면 종료.

"""