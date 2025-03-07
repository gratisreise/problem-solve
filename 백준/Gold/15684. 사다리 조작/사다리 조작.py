import sys

input = sys.stdin.readline

# 사다리 결과 확인
def check_ladder(ladder):
    for i in range(N):  # i번 세로선
        pos = i
        for h in range(H):
            if pos < N-1 and ladder[h][pos]:  # 오른쪽 이동 (pos가 N-1 미만)
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
            # 가로선 추가 가능 여부 (연속/접촉 체크)
            if not ladder[h][b] and (b == 0 or not ladder[h][b-1]) and (b == N-2 or not ladder[h][b+1]):
                ladder[h][b] = 1
                dfs(ladder, count + 1, limit, h, b + 1)
                ladder[h][b] = 0

# 입력 처리
N, M, H = map(int, input().split())
ladder = [[0] * (N-1) for _ in range(H)]  # 가로선 상태 (b번 세로선과 b+1 연결)

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
문제 분석
    입력:
        N: 세로선 수 (2 ≤ N ≤ 10).
        M: 기존 가로선 수 (0 ≤ M ≤ (N-1)×H).
        H: 가로선 위치 수 (1 ≤ H ≤ 30).
        M줄: 가로선 정보 (a, b) (a: 행, b: 시작 세로선).
    조건:
        사다리 게임: 각 세로선에서 시작, 가로선을 만나면 좌/우 이동.
        목표: i번 세로선이 i번으로 끝나도록.
        제약:
            가로선은 인접 세로선 연결.
            연속/접촉 불가.
        추가 가로선 최대 3개, 불가능 시 -1.
    출력: 최소 추가 가로선 수 또는 -1.

접근법
    사다리 시뮬레이션: 각 세로선의 결과 계산.
    DFS: 가능한 가로선 조합을 탐색하며 최소 개수 찾기.
    최적화: 추가 개수가 3 초과 시 종료.

코드 설명
    1.입력 처리:
        N, M, H: 사다리 크기와 가로선 수.
        ladder: H × (N-1) 배열 (가로선 존재 여부).
    2.사다리 결과 확인 (check_ladder):
        각 세로선 i에서 시작, H 행을 내려가며 이동.
        가로선 있으면 pos 변경, 최종 pos == i 확인.
    3.DFS (dfs):
        ladder: 현재 사다리 상태.
        count: 추가한 가로선 수.
        limit: 추가 개수 상한 (0~3).
        start_h, start_b: 탐색 시작점 (중복 방지).
        조건:
            count >= min_count: 이미 더 작은 결과 있음.
            check_ladder: 성공 시 min_count 갱신.
            count >= limit: 상한 초과.
        가로선 추가: 연속/접촉 체크 후 재귀.
    4.메인 로직:
        0~3개 추가 시도, 성공 시 종료.
    5.출력:
        min_count ≤ 3: 결과 출력.
        아니면 -1.
시간 복잡도
    사다리 확인: O(N × H) ≈ O(10 × 30) = O(300).
    DFS: 가능한 가로선 위치 (N-1) × H ≈ 300개.
        최대 3개 선택: C(300, 3) ≈ 4.5×10⁶.
        각 경우마다 확인: O(300) → 총 O(10⁹).
    실제: 가지치기로 훨씬 줄어, 2초 내 가능.

공간 복잡도
    ladder: H × (N-1) ≈ 300 바이트.
    재귀 스택: 최대 깊이 3 → 약 1KB.
    총: 약 2KB (512MB 내 여유).

결론
    DFS로 최소 가로선 수를 탐색하며, 시간과 메모리 제한 내 해결.
    가지치기로 효율성 개선.

"""