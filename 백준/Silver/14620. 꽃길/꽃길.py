import sys

input = sys.stdin.readline

# 입력 처리
N = int(input())
garden = [list(map(int, input().split())) for _ in range(N)]

# 이동 방향 (중앙 포함)
dy = [-1, 0, 1, 0, 0]  # 상, 좌, 하, 우, 중앙
dx = [0, -1, 0, 1, 0]

# 꽃 심기 가능 여부 체크
def can_plant(y, x, visited):
    for i in range(5):
        ny, nx = y + dy[i], x + dx[i]
        # 범위 밖이거나 이미 방문했으면 불가
        if not (0 <= ny < N and 0 <= nx < N) or visited[ny][nx]:
            return False
    return True

# 꽃 비용 계산
def get_cost(y, x):
    cost = 0
    for i in range(5):
        ny, nx = y + dy[i], x + dx[i]
        cost += garden[ny][nx]
    return cost

# DFS로 꽃 3개 심기
def dfs(count, total_cost, visited):
    global min_cost
    if count == 3:  # 꽃 3개 심음
        min_cost = min(min_cost, total_cost)
        return
    if total_cost >= min_cost:  # 이미 최소 비용 초과
        return
    
    # 가능한 모든 위치 탐색
    for y in range(1, N-1):  # 경계 제외
        for x in range(1, N-1):
            if can_plant(y, x, visited):
                # 꽃 심기
                for i in range(5):
                    ny, nx = y + dy[i], x + dx[i]
                    visited[ny][nx] = True
                dfs(count + 1, total_cost + get_cost(y, x), visited)
                # 백트래킹
                for i in range(5):
                    ny, nx = y + dy[i], x + dx[i]
                    visited[ny][nx] = False

# 방문 배열
visited = [[False] * N for _ in range(N)]
min_cost = float('inf')

# DFS 실행
dfs(0, 0, visited)

# 결과 출력
print(min_cost)

"""
문제 분석
    입력:
        N: 화단 크기 (6 ≤ N ≤ 10).
        N × N: 각 지점의 비용 (0 ≤ G ≤ 200).
    조건:
        꽃 3개 심기.
        각 꽃: 중앙 + 상하좌우 5칸 (십자 모양).
        제약:
            꽃잎이 겹치면 안 됨.
            화단 밖으로 나가면 안 됨.
        비용: 각 꽃의 5칸 비용 합.
    출력: 최소 비용.

접근법
    DFS: 가능한 꽃 위치 조합을 탐색하며 최소 비용 갱신.
    겹침 체크: 방문 배열로 꽃잎 위치 관리.
    최적화: 최소 비용 갱신으로 가지치기.

    
코드 설명
    1.입력 처리:
        N: 화단 크기.
        garden: 비용 배열.
    2.함수 정의:
        can_plant: 꽃 심기 가능 여부 (범위 내, 겹침 없음).
        get_cost: 꽃 5칸의 비용 합 계산.
        dfs: 꽃 개수(count), 총 비용(total_cost), 방문 상태(visited) 관리.
    3.DFS 로직:
        종료 조건: count == 3, 최소 비용 갱신.
        가지치기: total_cost >= min_cost면 중단.
        탐색: (1,1)부터 (N-2,N-2)까지 (경계 제외).
        꽃 심기: visited 표시 후 재귀, 백트래킹으로 복원.
    4.초기화 및 실행:
        visited: 방문 여부.
        min_cost: 최소 비용 (초기값 무한대).

시간 복잡도
    위치 수: 경계 제외 (N-2) × (N-2) ≈ 최대 64 (N=10).
    DFS: 3개 선택 → C(64, 3) ≈ 41,664.
    각 경우:
        can_plant: O(5).
        get_cost: O(5).
    총: O(41,664 × 10) ≈ O(4×10⁵) → 2초 내 충분.

공간 복잡도
    garden: N × N ≈ 100 × 4바이트 ≈ 400B.
    visited: N × N ≈ 100B.
    재귀 스택: 최대 깊이 3 → 약 1KB.
    총: 약 2KB (256MB 내 여유).

결론
    DFS로 꽃 3개의 최소 비용 조합을 효율적으로 탐색.
    시간 복잡도 O(4×10⁵)와 메모리 약 2KB로 제한 내 동작.
"""