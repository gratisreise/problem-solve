import sys
from collections import deque
from itertools import combinations

# 입력 처리
n, m = map(int, sys.stdin.readline().split())
grid = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

# 섬 번호 매기기
def bfs_island_labeling(grid):
    label = 2  # 섬 번호는 2부터 시작
    for i in range(n):
        for j in range(m):
            if grid[i][j] == 1:
                queue = deque([(i, j)])
                grid[i][j] = label
                while queue:
                    x, y = queue.popleft()
                    for dx, dy in [(-1, 0), (1, 0), (0, -1), (0, 1)]:
                        nx, ny = x + dx, y + dy
                        if 0 <= nx < n and 0 <= ny < m and grid[nx][ny] == 1:
                            grid[nx][ny] = label
                            queue.append((nx, ny))
                label += 1
    return label - 2  # 섬의 총 개수

# 섬 간의 다리 길이 계산
def find_bridges(grid, num_islands):
    bridges = []
    for i in range(n):
        for j in range(m):
            if grid[i][j] > 1:
                for dx, dy in [(-1, 0), (1, 0), (0, -1), (0, 1)]:
                    x, y = i, j
                    length = 0
                    while True:
                        x += dx
                        y += dy
                        if not (0 <= x < n and 0 <= y < m):
                            break
                        if grid[x][y] == grid[i][j]:
                            break
                        if grid[x][y] > 1:
                            if length >= 2:
                                bridges.append((length, grid[i][j] - 2, grid[x][y] - 2))
                            break
                        length += 1
    return bridges

# 크루스칼 알고리즘을 위한 Union-Find
parent = []
def find(u):
    if parent[u] != u:
        parent[u] = find(parent[u])
    return parent[u]

def union(u, v):
    u_root = find(u)
    v_root = find(v)
    if u_root != v_root:
        parent[v_root] = u_root

# 크루스칼 알고리즘
def kruskal(bridges, num_islands):
    global parent
    parent = [i for i in range(num_islands)]
    bridges.sort()
    total_cost = 0
    for cost, u, v in bridges:
        if find(u) != find(v):
            union(u, v)
            total_cost += cost
    # 모든 섬이 연결되었는지 확인
    root = find(0)
    for i in range(1, num_islands):
        if find(i) != root:
            return -1
    return total_cost

# 메인 로직
num_islands = bfs_island_labeling(grid)
bridges = find_bridges(grid, num_islands)
result = kruskal(bridges, num_islands)

# 결과 출력
print(result)

"""
코드 설명
1. 입력 처리
    입력:
        n, m: 격자 크기 (1 ≤ N, M ≤ 10).
        grid: N×M 격자, 0(바다) 또는 1(섬)으로 구성.
            예: grid = [[1, 1, 0], [0, 1, 0], [0, 0, 1]].
        sys.stdin.readline: 빠른 입력 처리.
2. 섬 번호 매기기 (bfs_island_labeling 함수)
    역할: 각 섬에 고유 번호를 부여.
    흐름:
        label: 섬 번호 (2부터 시작, 0과 1 구분용).
        격자 순회하며 섬(1) 발견 시:
            BFS로 연결된 모든 1을 label로 변경.
            4방향(상, 하, 좌, 우) 탐색: (-1, 0), (1, 0), (0, -1), (0, 1).
             label 증가.
        반환: 섬 개수 (label - 2).
3. 섬 간 다리 길이 계산 (find_bridges 함수)
    역할: 가능한 모든 다리(간선) 정보 수집.
    흐름:
        bridges: 다리 정보 리스트 [(길이, 섬1, 섬2)].
        격자 순회하며 섬(grid[i][j] > 1) 발견 시:
            4방향으로 직선 탐색:
                같은 섬 만나면 중단.
                다른 섬 만나면:
                    length >= 2면 다리 추가 (최소 길이 2 조건).
                    섬 번호는 0-based로 변환 (grid[i][j] - 2, grid[x][y] - 2).
                바다(0)면 length 증가.
        반환: 다리 리스트.
4. Union-Find 구현
    구조: 크루스칼 알고리즘을 위한 부모 배열 기반.
    변수:
        parent: 각 섬의 부모를 저장 (초기화 시 자기 자신).
    find 함수:
        루트 노드 찾기 (경로 압축 적용).
    union 함수:
        두 섬 연결 (루트가 다르면 합침).
5. 크루스칼 알고리즘 (kruskal 함수)
    역할: 최소 스패닝 트리(MST)로 최소 다리 비용 계산.
    흐름:
        bridges.sort(): 다리 길이 기준 오름차순 정렬.
        total_cost: 총 다리 길이.
        각 다리 (cost, u, v)에 대해:
            find(u) != find(v)면:
                union(u, v)로 연결.
                total_cost += cost.
        연결 확인:
            모든 섬이 같은 루트로 연결되지 않았으면 -1 반환.
        반환: total_cost.
6. 메인 로직
    흐름:
        num_islands = bfs_island_labeling(grid): 섬 개수와 번호 부여.
        bridges = find_bridges(grid, num_islands): 다리 정보 수집.
        result = kruskal(bridges, num_islands): MST 계산.
        print(result): 결과 출력.

문제 분석
    문제: 백준 17472 "다리 만들기 2".
    입력:
        N, M: 격자 크기.
        N×M 격자 (0 또는 1).
    조건:
        섬: 연결된 1들의 집합.
        다리: 가로/세로로 길이 2 이상, 섬 연결.
        목표: 모든 섬을 연결하는 최소 다리 길이 합 (불가능 시 -1).
    출력: 최소 길이 합 또는 -1.

접근 방법
    아이디어:
        BFS로 섬에 번호 부여.
        각 섬에서 가능한 다리(간선) 정보 수집.
        크루스칼 알고리즘으로 MST 계산.
    구현:
        섬 식별 → 다리 탐색 → MST.

시간 복잡도
    BFS: O(N * M) (격자 크기, 최대 100).
    다리 계산: O(N * M * (N + M)) (최악 10^4).
    크루스칼:
        정렬: O(E log E) (E ≈ N * M).
        Union-Find: O(E * α(V)) (V = 섬 수, α ≈ 상수).
        총합: O(E log E) (E 작음).
    총합: O(N * M * (N + M) + E log E) (≈ 10^4).
    결과: 2초 내 충분.

결론
    정확성: 조건 충족, 샘플 통과.
    효율성: 시간 O(N * M * (N + M) + E log E), 공간 O(N * M)으로 적절.
    특징:
        BFS로 섬 분리 간단히 처리.
        크루스칼로 최소 비용 보장.
    검증: N, M 작아 완전 탐색 기반 최적화 가능.
"""