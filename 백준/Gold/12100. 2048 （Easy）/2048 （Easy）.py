from copy import deepcopy

# 입력 처리
n = int(input())
board = [list(map(int, input().split())) for _ in range(n)]

# 최대값 저장
max_value = 0

# 격자 90도 회전
def rotate(board):
    temp = [[0] * n for _ in range(n)]
    for i in range(n):
        for j in range(n):
            temp[i][j] = board[n - 1 - j][i]
    return temp

# 슬라이드 (왼쪽으로 밀기)
def slide(board):
    temp = [[0] * n for _ in range(n)]
    for i in range(n):
        cnt = 0  # 다음 채울 위치
        for j in range(n):
            if board[i][j] == 0:
                continue
            if temp[i][cnt] == 0:  # 빈 칸이면 추가
                temp[i][cnt] = board[i][j]
            elif temp[i][cnt] == board[i][j]:  # 같은 값이면 합치기
                temp[i][cnt] *= 2
                cnt += 1
            else:  # 다른 값이면 다음 위치에 추가
                cnt += 1
                temp[i][cnt] = board[i][j]
    return temp

# 최대값 계산
def counting(board):
    global max_value
    for i in range(n):
        for j in range(n):
            max_value = max(max_value, board[i][j])

# 재귀적 탐색
def go(here, board):
    if here == 5:  # 5번 이동 완료
        counting(board)
        return
    for _ in range(4):  # 상, 하, 좌, 우 (4방향)
        new_board = deepcopy(board)  # 원본 보존
        new_board = slide(new_board)  # 슬라이드
        go(here + 1, new_board)      # 다음 이동
        board = rotate(board)        # 회전

# 실행
go(0, board)
print(max_value)

"""
코드 설명
1. 입력 처리
* 입력:
    * n: 격자 크기 (1 ≤ N ≤ 20).
    * board: N×N 격자 (초기 블록 값: 0 또는 2의 제곱수).
2. 초기 설정
* max_value: 최대 블록 값 저장 (전역 변수).
3. 격자 90도 회전 (rotate 함수)
* 역할: 격자를 시계 방향으로 90도 회전.
* 흐름:
    * temp: 새 격자 생성.
    * temp[i][j] = board[n-1-j][i]: 회전 공식 (행 → 열, 열 → n-1-행).
    * 반환: 회전된 격자.
4. 슬라이드 (slide 함수)
* 역할: 왼쪽으로 블록을 밀고 합침 (2048 게임 규칙).
* 흐름:
    * temp: 결과 격자 초기화.
    * 각 행마다:
        * cnt: 다음 채울 위치.
        * board[i][j] 순회:
            * 0이면 건너뜀.
            * temp[i][cnt] == 0: 빈 칸이면 값 추가.
            * temp[i][cnt] == board[i][j]: 같은 값이면 합치고 cnt 증가.
            * 그 외: 다음 위치에 추가 후 cnt 증가.
    * 반환: 슬라이드된 격자.
5. 최대값 계산 (counting 함수)
* 역할: 현재 격자의 최대 블록 값을 갱신.
* 흐름:
    * 격자 순회하며 max_value와 비교.
6. 재귀적 탐색 (go 함수)
* 역할: 최대 5번 이동하며 모든 경우 탐색.
* 흐름:
    * if here == 5: 5번 이동 완료 시 counting 호출 후 종료.
    * 4방향(상, 하, 좌, 우) 시도:
        * new_board = deepcopy(board): 원본 보존.
        * slide(new_board): 왼쪽으로 슬라이드.
        * go(here + 1, new_board): 다음 이동.
        * board = rotate(board): 다음 방향 위해 회전 (상 → 좌 → 하 → 우 순).
7. 결과 출력
* 출력: max_value (최대 블록 값).

문제 분석
* 문제: 백준 12100 "2048 (Easy)".
* 입력:
    * N: 격자 크기.
    * N×N 격자.
* 조건:
    * 최대 5번 이동 (상, 하, 좌, 우).
    * 이동 시 블록 밀고, 같은 값은 합쳐짐 (한 번만 합침).
    * 목표: 최대 블록 값.
* 출력: 최대 블록 값.

시간 복잡도
* 입력: O(N^2) (≈ 400).
* 탐색:
    * 이동 경우의 수: 4^5 (≈ 1024).
    * 슬라이드: O(N^2) per 이동.
    * 총합: O(4^5 * N^2) (N ≤ 20 → 약 4×10^5).
* 결과: 2초 내 충분 (10^8 대비 여유).

공간 복잡도
* board: O(N^2) ≈ 1.6KB.
* temp: O(N^2) per 함수 호출.
* 재귀 스택: O(5 * N^2) (≈ 8KB).
* 총합: 약 10KB (128MB 내 여유).

결론
* 정확성: 조건 충족, 샘플 통과.
* 효율성: 시간 O(4^5 * N^2), 공간 O(N^2)으로 적절.
* 특징:
    * 회전으로 4방향 처리 간소화.
    * 재귀적 완전 탐색으로 모든 경우 확인.
    * deepcopy로 격자 상태 유지.
* 검증: N 범위 내 효율적 동작.
"""