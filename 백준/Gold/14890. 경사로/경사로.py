import sys

input = sys.stdin.readline

# 입력: 격자 크기 N, 경사로 길이 L
N, L = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(N)]
grid_t = list(map(list, zip(*grid)))  # 열을 행으로 변환 (전치 행렬)

# 지나갈 수 있는 길 확인 함수
def solve(board):
    count = 0
    for i in range(N):
        cnt = 1  # 연속된 동일 높이 카운트
        j = 0
        while j < N - 1:
            if board[i][j] == board[i][j + 1]:
                cnt += 1
            elif board[i][j] + 1 == board[i][j + 1]:  # 오르막
                if cnt >= L:
                    cnt = 1
                else:
                    break
            elif board[i][j] - 1 == board[i][j + 1]:  # 내리막
                if cnt >= 0:
                    cnt = -L + 1
                else:
                    break
            else:
                break
            j += 1
        if j == N - 1 and cnt >= 0:  # 끝까지 도달하고 경사로 조건 만족
            count += 1
    return count

# 행과 열에 대해 각각 확인
ret = solve(grid) + solve(grid_t)

# 결과 출력
print(ret)

"""
코드 설명
1.입력 처리:
N, L: 격자 크기와 경사로 길이.
grid: NxN 격자 입력.
grid_t: 전치 행렬로 열을 행으로 변환 (C++의 b[j][i] = a[i][j] 대체).

2.확인 함수 (solve):
각 행(또는 열)마다:
cnt: 연속된 동일 높이 칸 수 추적.
오르막(+1): 이전 L칸이 필요 → cnt >= L 확인.
내리막(-1): 이후 L칸 확보 → cnt >= 0 후 -L+1로 갱신.
높이 차이 1 초과: 불가능 → 종료.
끝까지 도달(j == N-1)하고 cnt >= 0이면 길 가능.

3.메인 로직:
행(grid)과 열(grid_t)에 대해 solve 호출.
결과 합산.
출력:
가능한 길의 총 개수 출력.

시간 복잡도
각 행/열 확인: O(N) (최대 N칸 탐색).
행 N개, 열 N개: O(N * N).
총: O(N^2) ≈ O(10^4) → 1초 내 충분.

공간 복잡도
O(N^2): 격자와 전치 격자 저장.
"""