from itertools import combinations
n, m = map(int, input().split())  # 격자 크기, 치킨집 수

a, chi, home = [], [], []  # 격자, 치킨집 좌표, 집 좌표
for i in range(n):
    a.append(list(map(int, input().split())))
    for j in range(n):
        if a[i][j] == 1:
            home.append((i, j))  # 집 좌표
        elif a[i][j] == 2:
            chi.append((i, j))  # 치킨집 좌표

combi = list(combinations(chi, m))  # M개 치킨집 조합
ret = int(1e9)  # 최소 도시 치킨 거리

for arr in combi:  # 각 조합
    sum_dis = 0  # 도시 치킨 거리
    for h in home:  # 각 집
        mn = int(1e9)  # 최소 치킨 거리
        for pos in arr:  # 선택된 치킨집
            dis = abs(h[0] - pos[0]) + abs(h[1] - pos[1])  # 맨해튼 거리
            mn = min(dis, mn)  # 최소 거리 갱신
        sum_dis += mn  # 도시 치킨 거리 합산
    ret = min(sum_dis, ret)  # 최소값 갱신

print(ret)  # 결과 출력
"""



문제 접근 방법과 아이디어
문제 이해
* 목표: 도시에서 M개의 치킨집을 선택하여 모든 집의 치킨 거리 합을 최소화.
* 조건:
    * 격자: N×N (2 ≤ N ≤ 50).
    * 치킨집 수: M (1 ≤ M ≤ 13).
    * 격자 값: 0(빈 칸), 1(집), 2(치킨집).
    * 치킨 거리: 집과 가장 가까운 치킨집 사이의 맨해튼 거리 (|x1-x2| + |y1-y2|).
    * 도시 치킨 거리: 모든 집의 치킨 거리 합.
* 출력: 최소 도시 치킨 거리.
접근 아이디어
* 브루트 포스:
    * 치킨집 중 M개를 선택 (조합 사용).
    * 각 조합에 대해 모든 집의 치킨 거리 합 계산.
    * 최소 합 선택.
* 상태 관리:
    * home: 집 좌표 리스트.
    * chi: 치킨집 좌표 리스트.
    * combi: M개 치킨집 조합.
* 구현 전략:
    * 집과 치킨집 좌표 수집.
    * itertools.combinations로 치킨집 조합 생성.
    * 각 조합에 대해 치킨 거리 합 계산, 최소값 갱신.
1. 입력 처리
* n, m: 격자 크기(N), 선택할 치킨집 수(M).
* a: N×N 격자 입력.
* chi, home: 치킨집과 집 좌표 리스트.
* 격자 순회:
    * a[i][j] == 1: home.append((i, j)).
    * a[i][j] == 2: chi.append((i, j)).
2. 치킨집 조합 생성
* combi = list(combinations(chi, m)):
    * itertools.combinations로 치킨집 중 M개 선택.
    * 예: 치킨집 5개, M=3 → C(5,3) 조합 생성.
3. 치킨 거리 계산
* ret = int(1e9): 최소 도시 치킨 거리 초기값.
* for arr in combi: 각 치킨집 조합:
    * sum_dis = 0: 도시 치킨 거리.
    * for h in home: 각 집:
        * mn = int(1e9): 집의 최소 치킨 거리.
        * for pos in arr: 선택된 치킨집:
            * dis = abs(h[0] - pos[0]) + abs(h[1] - pos[1]): 맨해튼 거리.
            * mn = min(dis, mn): 최소 거리 갱신.
        * sum_dis += mn: 도시 치킨 거리 합산.
    * ret = min(sum_dis, ret): 최소 도시 치킨 거리 갱신.
4. 출력
* print(ret): 최소 도시 치킨 거리 출력.

문제 분석
* 문제: 백준 15686 "치킨 배달".
* 입력: N, M, N×N 격자.
* 출력: 최소 도시 치킨 거리.
* 조건: M개 치킨집 선택, 집마다 최소 치킨 거리 합산.

시간 복잡도
* 입력: O(N^2).
* 조합 생성: O(C(|chi|, M)) (최악 C(13,13)).
* 각 조합 처리:
    * 집: O(|home|) ≤ N^2 ≤ 2500.
    * 치킨집: O(M) ≤ 13.
    * 총: O(C(|chi|, M) * |home| * M).
* 최악: C(13,6) ≈ 1716, |home| ≈ 2500, M = 13 → 1716 * 2500 * 13 ≈ 5.6×10^7, 1초 내 충분.

"""