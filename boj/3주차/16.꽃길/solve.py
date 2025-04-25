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
문제 접근 방법과 아이디어
문제 이해
* 목표: N×N 정원에서 꽃 3개를 심어 최소 비용을 구하기.
* 조건:
    * 정원 크기: N (6 ≤ N ≤ 10).
    * 각 칸의 비용: 0 ≤ 비용 ≤ 200.
    * 꽃 심기:
        * 중앙 칸 + 상하좌우 4칸 (총 5칸).
        * 꽃의 영역은 서로 겹치면 안 됨.
        * 정원 경계(첫/마지막 행/열)에는 심을 수 없음.
    * 비용: 꽃이 심어진 5칸의 비용 합.
* 출력: 꽃 3개를 심는 최소 비용.
접근 아이디어
* 백트래킹:
    * 가능한 모든 중앙 위치에 꽃을 심으며 3개 완성.
    * 각 단계에서 겹침 여부 확인.
    * 최소 비용 갱신.
* 상태 관리:
    * garden: 정원 비용 배열.
    * visited: 방문 여부 배열 (겹침 방지).
    * min_cost: 최소 비용.
* 구현 전략:
    * 경계를 제외한 위치(1~N-2)에서 꽃 심기 시도.
    * 겹침 확인 후 유효하면 방문 표시, 비용 추가, 재귀.
    * 백트래킹으로 방문 해제, 다른 위치 시도.
    * 3개 꽃 완성 시 비용 갱신.

1. 입력 처리
* input = sys.stdin.readline: 빠른 입력.
* N: 정원 크기.
* garden: N×N 정원 비용 배열.
2. 초기화
* dy, dx: 이동 방향 (상, 좌, 하, 우, 중앙).
* visited = [[False] * N for _ in range(N)]: 방문 여부 배열.
* min_cost = float('inf'): 최소 비용 초기화.
3. 꽃 심기 가능 여부 체크
* can_plant(y, x, visited):
    * (y, x)를 중앙으로 하는 5칸 확인.
    * for i in range(5):
        * ny, nx: 중앙 및 주변 위치.
        * 범위 밖(not (0 <= ny < N and 0 <= nx < N)) 또는 방문済(visited[ny][nx]) → False.
    * 모두 유효하면 True.
4. 꽃 비용 계산
* get_cost(y, x):
    * (y, x)를 중앙으로 하는 5칸 비용 합 계산.
    * for i in range(5):
        * cost += garden[ny][nx].
    * 비용 반환.
5. DFS 함수
* dfs(count, total_cost, visited):
    * count: 현재 심은 꽃 수.
    * total_cost: 현재까지 비용.
    * visited: 방문 상태.
    * 종료 조건:
        * count == 3: 꽃 3개 완성 → min_cost 갱신.
        * total_cost >= min_cost: 비용 초과 → 종료.
    * 탐색:
        * for y in range(1, N-1): 경계 제외.
        * for x in range(1, N-1):
            * can_plant(y, x, visited): 심기 가능 확인.
            * 가능 시:
                * 5칸 방문 표시 (visited[ny][nx] = True).
                * dfs(count + 1, total_cost + get_cost(y, x), visited): 재귀.
                * 백트래킹 (visited[ny][nx] = False).
6. 실행 및 출력
* dfs(0, 0, visited): 초기 상태로 DFS 시작.
* print(min_cost): 최소 비용 출력.

문제 분석
* 문제: 백준 14620 "꽃길".
* 입력: N, N×N 정원 비용.
* 출력: 꽃 3개를 심는 최소 비용.
* 조건: 꽃 영역(5칸) 겹침 불가, 경계 불가.

시간 복잡도
* 중앙 위치: (N-2) * (N-2) ≈ 64 (N=10).
* 꽃 3개 선택: C(64, 3) ≈ 41,664.
* 각 선택:
    * can_plant: O(5).
    * get_cost: O(5).
* 총합: O(C((N-2)^2, 3) * 10) ≈ 416,640, 1초 내 충분.

"""