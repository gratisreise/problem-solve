import sys

input = sys.stdin.readline

# 사다리 결과 확인
def check_ladder(ladder):
    for i in range(N):  # i번 세로선
        pos = i
        for h in range(H):
            if pos < N-1 and ladder[h][pos]:  # 오른쪽 이동
                pos += 1
            elif pos > 0 and ladder[h][pos-1]:  # 왼쪽 이동
                pos -= 1
        if pos != i:  # i번이 i로 안 끝남
            return False
    return True

# DFS로 가로선 추가
def dfs(ladder, count, limit, start_h, start_b):
    global min_count
    if count >= min_count:  # 이미 더 작은 결과 있음
        return
    if check_ladder(ladder):  # 목표 달성
        min_count = min(min_count, count)
        return
    if count >= limit:  # 추가 개수 초과
        return
    
    # 가로선 추가 시도
    for h in range(start_h, H):
        b_start = start_b if h == start_h else 0
        for b in range(b_start, N-1):
            # 가로선 추가 가능 여부
            if not ladder[h][b] and (b == 0 or not ladder[h][b-1]) and (b == N-2 or not ladder[h][b+1]):
                ladder[h][b] = 1
                dfs(ladder, count + 1, limit, h, b + 1)
                ladder[h][b] = 0

# 입력 처리
N, M, H = map(int, input().split())
ladder = [[0] * (N-1) for _ in range(H)]  # 가로선 상태

# 기존 가로선 설정
for _ in range(M):
    a, b = map(int, input().split())
    ladder[a-1][b-1] = 1  # 1-based → 0-based

# 최소 추가 개수
min_count = float('inf')

# 0~3개 추가 시도
for i in range(4):
    dfs(ladder, 0, i, 0, 0)
    if min_count != float('inf'):  # 성공
        break

# 결과 출력
print(min_count if min_count <= 3 else -1)
"""
문제 접근 방법과 아이디어
문제 이해
* 목표: 사다리에 가로선을 최소한으로 추가하여 각 세로선 i가 i로 끝나도록 만들기.
* 조건:
    * 세로선 수: N (2 ≤ N ≤ 10).
    * 가로선 위치 수: H (1 ≤ H ≤ 30).
    * 기존 가로선 수: M (0 ≤ M ≤ (N-1)×H).
    * 가로선: (a, b) → 높이 a에서 b번과 b+1번 세로선 연결 (1-based).
    * 제약:
        * 같은 높이에서 가로선은 연속/접촉 불가.
        * 추가 가로선은 최대 3개.
    * 결과:
        * i번 세로선이 i번으로 끝나야 함.
* 출력:
    * 최소 추가 가로선 수 (0~3).
    * 불가능 시 -1.
접근 아이디어
* 백트래킹:
    * 0~3개의 가로선을 추가하며 모든 경우 탐색.
    * 각 추가 후 사다리 결과 확인.
    * 최소 추가 개수 갱신.
* 사다리 결과 확인:
    * 각 세로선 i를 따라 이동:
        * 오른쪽 (b와 b+1 연결) 또는 왼쪽 (b-1과 b 연결) 이동.
        * 최종 위치가 i와 같아야 함.
* 상태 관리:
    * ladder: 가로선 상태 (h, b) → b번과 b+1번 연결.
    * min_count: 최소 추가 가로선 수.
* 구현 전략:
    * 초기 사다리 설정.
    * DFS로 가로선 추가 시도 (최대 0~3개).
    * 각 상태에서 사다리 결과 확인, 최소값 갱신.
    * 결과가 3 초과면 -1.
1. 입력 처리
* input = sys.stdin.readline: 빠른 입력.
* N, M, H: 세로선 수, 기존 가로선 수, 가로선 위치 수.
* ladder = [[0] * (N-1) for _ in range(H)]: 가로선 상태 배열 (h, b) → b번과 b+1번 연결.
* 기존 가로선:
    * a, b: 높이 a, b번 세로선과 b+1 연결.
    * ladder[a-1][b-1] = 1: 1-based → 0-based.
2. 사다리 결과 확인
* check_ladder(ladder):
    * for i in range(N): 각 세로선 i.
        * pos = i: 현재 위치.
        * for h in range(H):
            * pos < N-1 and ladder[h][pos]: 오른쪽 이동 (pos → pos+1).
            * pos > 0 and ladder[h][pos-1]: 왼쪽 이동 (pos → pos-1).
        * if pos != i: i번이 i로 끝나지 않음 → False.
    * 모두 i로 끝나면 True.
3. DFS 함수
* dfs(ladder, count, limit, start_h, start_b):
    * count: 추가한 가로선 수.
    * limit: 추가 허용 최대 개수 (0~3).
    * start_h, start_b: 탐색 시작 위치 (중복 방지).
    * 종료 조건:
        * count >= min_count: 더 작은 결과 존재 → 종료.
        * check_ladder(ladder): 목표 달성 → min_count 갱신.
        * count >= limit: 추가 초과 → 종료.
    * 가로선 추가:
        * for h in range(start_h, H):
            * b_start = start_b if h == start_h else 0: 동일 높이에서는 다음 b부터.
            * for b in range(b_start, N-1):
                * 조건: not ladder[h][b] (미설치), b == 0 or not ladder[h][b-1] (왼쪽 연속 방지), b == N-2 or not ladder[h][b+1] (오른쪽 연속 방지).
                * ladder[h][b] = 1: 가로선 추가.
                * dfs(..., count + 1, limit, h, b + 1): 재귀 호출.
                * ladder[h][b] = 0: 백트래킹.
4. 실행
* min_count = float('inf'): 최소 추가 개수 초기화.
* for i in range(4): 0~3개 추가 시도.
    * dfs(ladder, 0, i, 0, 0): DFS 실행.
    * if min_count != float('inf'): 성공 → 종료.
* 출력:
    * min_count <= 3: min_count 출력.
    * 그 외: -1.

문제 분석
* 문제: 백준 15684 "사다리 조작".
* 입력: N, M, H, M개의 가로선 (a, b).
* 출력: 최소 추가 가로선 수 (0~3) 또는 -1.
* 조건: i번 세로선이 i로 끝나야, 가로선 연속/접촉 불가.

시간 복잡도
* 가로선 추가 위치: H * (N-1) ≈ 300.
* 최대 3개 추가: C(300, 3) ≈ 4.5×10^6.
* 사다리 확인: O(N * H) ≈ 300.
* 최악: O(C(H*(N-1), 3) * N * H) ≈ 4.5×10^6 * 300 ≈ 1.35×10^9 (이론적).
* 실제: 백트래킹과 최적화로 1초 내 통과.
"""