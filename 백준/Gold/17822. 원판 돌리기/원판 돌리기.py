import sys
from collections import deque
sys.setrecursionlimit(10000)
# 입력 처리
input = sys.stdin.readline
n, m, t = map(int, input().split())
a = [list(map(int, input().split())) for _ in range(n)]

# 방향 배열 (상, 우, 하, 좌)
dy = [-1, 0, 1, 0]
dx = [0, 1, 0, -1]

# 원판 회전 함수
def rotate(y, dir, k):
    # deque로 변환하여 회전
    v = deque(a[y])
    if dir == 1:  # 반시계 방향
        v.rotate(-k)  # 왼쪽으로 k번 이동
    else:  # 시계 방향
        v.rotate(k)   # 오른쪽으로 k번 이동
    a[y] = list(v)

# DFS로 인접한 같은 숫자 찾기
def dfs(y, x, visited):
    global flag
    for i in range(4):
        ny = y + dy[i]
        nx = (x + dx[i] + m) % m  # 원형 구조 반영
        if ny < 0 or ny >= n:  # 범위 벗어남
            continue
        if visited[ny][nx]:  # 이미 방문
            continue
        if a[y][x] == a[ny][nx]:  # 같은 숫자 발견
            visited[y][x] = visited[ny][nx] = True
            flag = False  # 인접 숫자 존재
            dfs(ny, nx, visited)

# 인접 숫자 찾고 제거
def find_adj():
    global flag
    flag = True  # 인접 숫자 없는 경우 True 유지
    visited = [[False] * m for _ in range(n)]
    for i in range(n):
        for j in range(m):
            if a[i][j] == 0 or visited[i][j]:  # 0이거나 방문한 경우 스킵
                continue
            dfs(i, j, visited)
    # 제거: 방문한 곳 0으로
    for i in range(n):
        for j in range(m):
            if visited[i][j]:
                a[i][j] = 0
    return flag

# 평균으로 숫자 조정
def set_average():
    sum_val = 0
    cnt = 0
    # 합과 개수 계산
    for i in range(n):
        for j in range(m):
            if a[i][j] != 0:
                sum_val += a[i][j]
                cnt += 1
    if cnt == 0:  # 숫자 없으면 종료
        return
    av = sum_val / cnt  # 평균
    # 평균보다 크면 -1, 작으면 +1
    for i in range(n):
        for j in range(m):
            if a[i][j] != 0:
                if a[i][j] > av:
                    a[i][j] -= 1
                elif a[i][j] < av:
                    a[i][j] += 1

# 메인 로직
for _ in range(t):
    x, d, k = map(int, input().split())
    # x의 배수 원판 회전
    for j in range(x - 1, n, x):
        rotate(j, d, k)
    # 인접 숫자 제거 후 없으면 평균 조정
    if find_adj():
        set_average()

# 최종 합 계산
ret = 0
for i in range(n):
    for j in range(m):
        ret += a[i][j]
print(ret)
"""
코드 설명
1. 입력 처리
* n, m, t: 원판 개수 (N), 원판 크기 (M), 회전 횟수 (T).
* a: N×M 2D 리스트로 원판 정보 입력.
2. 원판 회전 함수 (rotate)
* y: 회전할 원판 번호.
* dir: 방향 (0: 시계, 1: 반시계).
* k: 회전 칸 수.
* deque 사용: 리스트를 deque로 변환 후 rotate로 회전 (시계: k, 반시계: -k), 다시 리스트로 저장.
3. DFS로 인접 숫자 탐색 (dfs)
* y, x: 현재 위치.
* visited: 방문 여부 체크.
* 4방향 탐색: 상하 (ny), 좌우 (nx, 원형 구조로 % m 처리).
* 같은 숫자 발견 시: 방문 표시, flag=False, 재귀 호출.
4. 인접 숫자 찾고 제거 (find_adj)
* flag: 인접 숫자 없으면 True 유지.
* visited 초기화: N×M False 배열.
* 모든 칸 순회: 0이거나 방문한 경우 스킵, DFS로 탐색.
* 제거: 방문한 칸 0으로 변경.
* 반환: flag (조정 여부 결정).
5. 평균 조정 (set_average)
* sum_val, cnt: 0 아닌 숫자의 합과 개수 계산.
* av: 평균 (sum_val / cnt).
* 조정: 평균보다 크면 -1, 작으면 +1.
6. 메인 로직
* t번 반복: x, d, k 입력받아 x 배수 원판 회전.
* find_adj(): 인접 숫자 제거, True면 set_average() 호출.
* 최종 합: 모든 칸의 합 계산 후 출력.

문제 분석
* 문제: 백준 17822 "원판 돌리기".
* 입력: N, M, T, 원판 정보, T개 회전 정보 (x, d, k).
* 출력: 최종 원판 숫자 합.
* 조건: 인접 숫자 제거 후 없으면 평균 조정.

시간 복잡도
* 회전: O(m) per 원판, 총 O(t * n * m).
* 인접 탐색: O(n * m) per DFS, 총 O(t * n * m).
* 평균 조정: O(n * m) per 호출.
* 총합: O(t * n * m) (T ≤ 50, N ≤ 50, M ≤ 50), 1초 내 충분.

공간 복잡도
* a: O(n * m) ≈ 10KB.
* visited: O(n * m) ≈ 2.5KB.
* 총합: O(n * m) (128MB 내 여유).

결론
* 정확성: C++ 로직 유지, 문제 조건 충족.
* 효율성: 시간 O(t * n * m), 공간 O(n * m).
* 특징: deque로 회전, DFS로 인접 탐색, 평균 조정.
"""