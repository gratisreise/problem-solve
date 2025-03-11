n = int(input())
like = [list(map(int, input().split())) for _ in range(n*n)]
grid = [[0] * n for _ in range(n)]

# 방향 벡터 (상, 하, 좌, 우)
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

# 학생 배치
for student in like:
    num = student[0]
    favorites = student[1:]
    candidates = []

    # 모든 칸 탐색
    for i in range(n):
        for j in range(n):
            if grid[i][j] == 0:
                like_count = 0
                empty_count = 0
                for d in range(4):
                    nx = i + dx[d]
                    ny = j + dy[d]
                    if 0 <= nx < n and 0 <= ny < n:
                        if grid[nx][ny] in favorites:
                            like_count += 1
                        if grid[nx][ny] == 0:
                            empty_count += 1
                candidates.append((like_count, empty_count, i, j))

    # 조건에 따라 정렬
    candidates.sort(key=lambda x: (-x[0], -x[1], x[2], x[3]))
    x, y = candidates[0][2], candidates[0][3]
    grid[x][y] = num

# 만족도 계산
satisfaction = 0
for i in range(n):
    for j in range(n):
        num = grid[i][j]
        favorites = [x[1:] for x in like if x[0] == num][0]
        like_count = 0
        for d in range(4):
            nx = i + dx[d]
            ny = j + dy[d]
            if 0 <= nx < n and 0 <= ny < n:
                if grid[nx][ny] in favorites:
                    like_count += 1
        if like_count > 0:
            satisfaction += 10 ** (like_count - 1)

# 결과 출력
print(satisfaction)
"""
1. 입력 처리
* 입력:
    * n: 격자 크기(N×N, 1 ≤ N ≤ 20).
    * like: N^2명의 학생 정보 리스트.
        * 각 리스트: [학생 번호, 좋아하는 학생 번호 4개].
        * 예: like = [[4, 2, 5, 1, 7], [2, 1, 4, 3, 5], ...].
    * grid: N×N 격자, 초기값 0 (빈 칸).
* 방향 벡터:
    * dx, dy: 상, 하, 좌, 우 탐색용 ([-1, 1, 0, 0], [0, 0, -1, 1]).
2. 학생 배치
* 역할: 각 학생을 규칙에 따라 격자에 배치.
* 흐름:
    * for student in like: N^2명 순차 처리.
        * num: 학생 번호.
        * favorites: 좋아하는 학생 번호 리스트.
    * 빈 칸 탐색:
        * candidates: 가능한 자리 리스트 [(좋아하는 학생 수, 빈 칸 수, 행, 열)].
        * 모든 칸 (i, j) 순회:
            * grid[i][j] == 0 (빈 칸)일 때:
                * like_count: 인접한 좋아하는 학생 수.
                * empty_count: 인접한 빈 칸 수.
                * 4방향 탐색으로 계산.
    * 정렬:
        * sort(key=lambda x: (-x[0], -x[1], x[2], x[3])):
            * 1순위: like_count 내림차순 (최대).
            * 2순위: empty_count 내림차순 (최대).
            * 3순위: 행 번호 오름차순 (최소).
            * 4순위: 열 번호 오름차순 (최소).
        * 최적 자리: candidates[0]의 (x, y).
    * 배치:
        * grid[x][y] = num: 학생 배치.
3. 만족도 계산
* 역할: 배치 후 각 학생의 만족도 합산.
* 흐름:
    * satisfaction: 총 만족도 점수.
    * 격자 순회:
        * num: 현재 학생 번호.
        * favorites: 해당 학생의 좋아하는 학생 리스트 (like에서 검색).
        * like_count: 인접한 좋아하는 학생 수 (4방향 탐색).
        * 점수 계산:
            * 0명: 0.
            * 1명: 1 (10^0).
            * 2명: 10 (10^1).
            * 3명: 100 (10^2).
            * 4명: 1000 (10^3).
        * satisfaction += 10 ** (like_count - 1) (0명 제외).
4. 결과 출력
* 출력: satisfaction.


문제 분석
* 문제: 백준 21608 "상어 초등학교".
* 입력:
    * N: 격자 크기.
    * N^2개의 학생 정보 (번호, 좋아하는 학생 4명).
* 조건:
    * 배치 규칙:
        1. 인접한 좋아하는 학생 수 최대.
        2. 인접한 빈 칸 수 최대.
        3. 행 번호 최소.
        4. 열 번호 최소.
    * 만족도: 인접한 좋아하는 학생 수에 따라 0, 1, 10, 100, 1000.
* 출력: 총 만족도.

시간 복잡도
* 입력: O(N^2) (≈ 400).
* 학생 배치:
    * 각 학생: O(N^2 * 4) (격자 탐색).
    * 정렬: O(N^2 log N^2) (최악 400 log 400).
    * 총합: O(N^2 * N^2) (≈ 10^5).
* 만족도 계산: O(N^2 * 4) (≈ 10^3).
* 총합: O(N^4) (N ≤ 20 → 약 10^5).
* 결과: 2초 내 충분.


결론
* 정확성: 조건 충족, 샘플 통과.
* 효율성: 시간 O(N^4), 공간 O(N^2)으로 적절.
* 특징:
    * 정렬로 우선순위 명확히 구현.
    * 만족도 계산 간단히 처리.
* 검증: N 작아 완전 탐색으로 충분.
"""