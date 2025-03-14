from collections import defaultdict

# 입력 처리
want = int(input())
n, m = map(int, input().split())
a = [0] * (n + 1)  # 1-based 배열
b = [0] * (m + 1)
psum_a = [0] * (2 * n + 1)  # 누적합 배열
psum_b = [0] * (2 * m + 1)
a_cnt = defaultdict(int)  # A 피자의 합 빈도
b_cnt = defaultdict(int)  # B 피자의 합 빈도

# A 피자 조각 입력 및 누적합 계산
for i in range(1, n + 1):
    a[i] = int(input())
    psum_a[i] = psum_a[i - 1] + a[i]
for i in range(n + 1, 2 * n + 1):
    psum_a[i] = psum_a[i - 1] + a[i - n]

# B 피자 조각 입력 및 누적합 계산
for i in range(1, m + 1):
    b[i] = int(input())
    psum_b[i] = psum_b[i - 1] + b[i]
for i in range(m + 1, 2 * m + 1):
    psum_b[i] = psum_b[i - 1] + b[i - m]

# 가능한 모든 합 계산 함수
def make(size, psum, cnt_map):
    for interval in range(1, size + 1):  # 구간 길이
        for start in range(interval, size + interval):  # 시작 위치
            sum_val = psum[start] - psum[start - interval]
            cnt_map[sum_val] += 1
            if interval == size:  # 전체 합은 한 번만
                break

# A, B 피자의 합 계산
make(n, psum_a, a_cnt)
make(m, psum_b, b_cnt)

# 결과 계산
ret = a_cnt[want] + b_cnt[want]  # A 또는 B 단독으로 want를 만드는 경우
for i in range(1, want):  # A와 B 조합으로 want를 만드는 경우
    ret += a_cnt[i] * b_cnt[want - i]

# 결과 출력
print(ret)
"""
코드 설명
1. 입력 처리
* 입력:
    * want: 목표 크기 (1 ≤ want ≤ 200,000).
    * n, m: A 피자 조각 수, B 피자 조각 수 (3 ≤ n, m ≤ 1,000).
    * a, b: A, B 피자의 조각 크기 (1-based 배열로 저장).
* 누적합 배열:
    * psum_a, psum_b: 원형 배열 처리 위해 2배 크기로 생성.
    * 첫 번째 구간: 입력값 누적.
    * 두 번째 구간: 원형 연결 위해 처음부터 반복.
2. 초기 설정
* a_cnt, b_cnt: defaultdict(int)로 각 피자의 가능한 합 빈도 저장 (C++의 map 대체).
* 배열 인덱스: C++처럼 1-based로 맞춤.
3. 가능한 합 계산 (make 함수)
* 역할: 각 피자의 연속 구간 합을 계산해 빈도 맵에 저장.
* 흐름:
    * interval: 구간 길이 (1 ~ n 또는 m).
    * start: 시작 위치 (interval ~ n+interval-1).
    * sum_val = psum[start] - psum[start - interval]: 구간 합 계산.
    * cnt_map[sum_val] += 1: 빈도 증가.
    * if interval == n: 전체 합은 한 번만 계산 (중복 방지).
4. 결과 계산
* ret = a_cnt[want] + b_cnt[want]: A 또는 B 단독으로 want를 만드는 경우.
* for i in range(1, want): A와 B의 조합으로 want를 만드는 경우.
    * a_cnt[i] * b_cnt[want - i]: A에서 i, B에서 want-i를 선택하는 경우의 수.
5. 결과 출력
* ret: 총 경우의 수 출력.

문제 분석
* 문제: 백준 2632 "피자판매".
* 입력:
    * want, n, m: 목표 크기, A 조각 수, B 조각 수.
    * A, B 피자 조각 크기.
* 조건:
    * 연속된 조각만 선택 가능.
    * A, B에서 선택한 조각 합이 want가 되는 경우의 수.
* 출력: 경우의 수.

시간 복잡도
* 입력 및 누적합: O(n + m) (≈ 2,000).
* make 함수:
    * A: O(n^2) (n ≤ 1,000 → 약 10^6).
    * B: O(m^2) (m ≤ 1,000 → 약 10^6).
* 결과 계산: O(want) (≈ 2×10^5).
* 총합: O(n^2 + m^2 + want) (≈ 2×10^6).
* 결과: 1초 내 충분.

공간 복잡도
* a, b: O(n + m) ≈ 8KB.
* psum_a, psum_b: O(2n + 2m) ≈ 16KB.
* a_cnt, b_cnt: 최악 O(n^2 + m^2) 키 개수 (≈ 40KB).
* 총합: 약 64KB (128MB 내 여유).

결론
* 정확성: C++ 코드와 동일한 로직, 샘플 통과.
* 효율성: 시간 O(n^2 + m^2 + want), 공간 O(n + m)으로 적절.
* 특징:
    * 누적합으로 구간 합 효율적 계산.
    * defaultdict로 빈도 관리 간소화.
* 검증: n, m, want 범위 내 효율적 동작.
"""