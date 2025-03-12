# 입력 처리
n = int(input())
s = [list(map(int, input().split())) for _ in range(n)]

# 팀 능력치 차이 계산 함수
def go(start, link):
    start_sum = 0
    link_sum = 0
    # 스타트 팀 능력치 합
    for i in range(n // 2):
        for j in range(n // 2):
            if i != j:
                start_sum += s[start[i]][start[j]]
    # 링크 팀 능력치 합
    for i in range(n // 2):
        for j in range(n // 2):
            if i != j:
                link_sum += s[link[i]][link[j]]
    # 능력치 차이 반환
    return abs(start_sum - link_sum)

# 메인 로직
INF = int(1e9)
ret = INF

# 비트마스크로 모든 조합 탐색
for i in range(1 << n):  # 0부터 2^n-1까지
    if bin(i).count('1') != n // 2:  # 1의 개수가 n/2가 아니면 스킵
        continue
    start = []
    link = []
    # 팀 나누기
    for j in range(n):
        if i & (1 << j):  # j번째 비트가 1이면 스타트 팀
            start.append(j)
        else:            # 아니면 링크 팀
            link.append(j)
    ret = min(ret, go(start, link))  # 최소 차이 갱신

# 결과 출력
print(ret)
"""
코드 설명
1. 입력 처리
* 입력:
    * n: 사람 수 (2 ≤ N ≤ 20, 짝수).
    * s: N×N 능력치 행렬 (s[i][j]는 i와 j가 같은 팀일 때의 능력치 합).
        * 1 ≤ s[i][j] ≤ 100.
2. 팀 능력치 차이 계산 함수 (go 함수)
* 역할: 스타트 팀과 링크 팀의 능력치 차이를 계산.
* 흐름:
    * start_sum: 스타트 팀 능력치 합.
        * start[i]와 start[j] (i ≠ j)의 s[start[i]][start[j]] 합산.
    * link_sum: 링크 팀 능력치 합.
        * link[i]와 link[j] (i ≠ j)의 s[link[i]][link[j]] 합산.
    * 반환: abs(start_sum - link_sum) (차이의 절댓값).
3. 메인 로직
* 변수:
    * INF: 초기 최대값 (987654321).
    * ret: 최소 능력치 차이.
* 비트마스크 탐색:
    * for i in range(1 << n): 0부터 2^N-1까지 모든 조합.
    * bin(i).count('1'): 비트에서 1의 개수 (팀 인원 체크).
        * n // 2와 다르면 스킵 (팀 인원이 N/2여야 함).
    * 팀 나누기:
        * i & (1 << j): j번째 비트가 1이면 start에 추가.
        * 아니면 link에 추가.
    * ret = min(ret, go(start, link)): 최소 차이 갱신.
4. 결과 출력
* 출력: ret (최소 능력치 차이).

문제 분석
* 문제: 백준 14889 "스타트와 링크".
* 입력:
    * N: 사람 수 (짝수).
    * N×N 능력치 행렬.
* 조건:
    * N명을 N/2씩 두 팀으로 나눔.
    * 팀 능력치: 같은 팀 내 모든 쌍의 능력치 합.
    * 목표: 두 팀 능력치 차이 최소화.
* 출력: 최소 차이.

시간 복잡도
* 입력: O(N^2) (≈ 400).
* 비트마스크:
    * 조합 수: 2^N (N ≤ 20 → 약 10^6).
    * 유효 조합: N C N/2 (최대 약 10^5).
    * go 함수: O((N/2)^2) ≈ O(N^2) per 조합.
    * 총합: O(2^N * N^2) (≈ 10^8).
* 결과: 2초 내 충분 (최적화 없이도 가능).

공간 복잡도
* s: O(N^2) ≈ 1.6KB.
* start, link: O(N) ≈ 0.1KB.
* 총합: 약 2KB (1024MB 내 여유).

결론
* 정확성: 조건 충족, 샘플 통과.
* 효율성: 시간 O(2^N * N^2), 공간 O(N^2)으로 적절.
* 특징:
    * 비트마스크로 조합 효율적 탐색.
    * C++ 로직을 파이썬으로 정확히 변환.
* 검증: N 작아 완전 탐색으로 충분.
"""