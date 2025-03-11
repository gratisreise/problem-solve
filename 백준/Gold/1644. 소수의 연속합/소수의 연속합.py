# 입력 처리
n = int(input())

# 에라토스테네스의 체로 소수 구하기
che = [False] * (n + 1)  # 소수 여부 체크 (False: 소수, True: 비소수)
primes = []              # 소수 리스트
for i in range(2, n + 1):
    if not che[i]:
        primes.append(i)
        for j in range(i * 2, n + 1, i):
            che[j] = True

# 투 포인터로 연속합 경우의 수 계산
lo, hi = 0, 0  # 낮은 인덱스, 높은 인덱스
sum_val = 0    # 현재 합
ret = 0        # 경우의 수

while True:
    if sum_val >= n:          # 합이 n 이상이면 lo 증가
        sum_val -= primes[lo]
        lo += 1
    elif hi == len(primes):   # hi가 끝에 도달하면 종료
        break
    else:                     # 합이 n 미만이면 hi 증가
        sum_val += primes[hi]
        hi += 1
    if sum_val == n:          # 합이 n과 같으면 경우의 수 증가
        ret += 1

# 결과 출력
print(ret)
"""
코드 설명
1. 입력 처리
* 입력:
    * n: 목표 자연수 (1 ≤ N ≤ 4,000,000).
    * 예: n = 41.
2. 에라토스테네스의 체로 소수 구하기
* 역할: 2부터 N까지의 소수를 구함.
* 흐름:
    * che: 소수 여부 배열 (False 초기화).
    * primes: 소수 저장 리스트.
    * 2부터 N까지 순회:
        * che[i] == False: 소수면.
            * primes에 추가.
            * 배수(i*2부터 N까지 i 간격)를 True로 체크 (비소수).
    * 결과: primes에 오름차순 소수 리스트 저장 (예: [2, 3, 5, 7, 11, ...]).
3. 투 포인터로 연속합 계산
* 변수:
    * lo, hi: 투 포인터 (시작, 끝 인덱스).
    * sum_val: 현재 구간 합.
    * ret: 경우의 수.
* 흐름:
    * while True: 종료 조건까지 반복.
        * sum_val >= n: 합이 N 이상 → lo 증가, 합에서 빼기.
        * hi == len(primes): 끝에 도달 → 종료.
        * 그 외: 합이 N 미만 → hi 증가, 합에 더하기.
        * sum_val == n: 합이 N과 같으면 ret 증가.
    * 투 포인터로 모든 연속 구간 탐색.
4. 결과 출력
* 출력: ret (경우의 수).

문제 분석
* 문제: 백준 1644 "소수의 연속합".
* 입력:
    * N: 목표 자연수.
* 조건:
    * N을 소수의 연속합으로 표현하는 경우의 수 계산.
    * 소수는 N 이하의 자연수.
* 출력: 경우의 수.

시간 복잡도
* 소수 구하기: O(N log log N) (에라토스테네스의 체).
* 투 포인터: O(P) (P = N 이하 소수 개수, 약 N / ln(N)).
* 총합: O(N log log N) (N ≤ 4×10^6 → 약 10^7).
* 결과: 2초 내 충분.

결론
* 정확성: 조건 충족, 샘플 통과.
* 효율성: 시간 O(N log log N), 공간 O(N)으로 적절.
* 특징:
    * C++ 코드의 로직을 파이썬으로 정확히 변환.
    * 투 포인터로 효율적 연속합 계산.
* 검증: N 크기에 대해 안정적 동작.
"""