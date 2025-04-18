# 입력 처리
n = int(input())
a = list(map(int, input().split()))

# 변수 초기화
s, e = 0, 0  # 시작 포인터, 끝 포인터
cnt = [0] * 100001  # 각 숫자의 등장 횟수
ret = 0  # 결과 (중복 없는 연속 구간 개수)

# 투 포인터로 중복 없는 구간 계산
while e < n:
    if cnt[a[e]] == 0:  # 새로운 숫자면 추가
        cnt[a[e]] += 1
        e += 1
    else:  # 중복 발생 시
        ret += (e - s)  # 현재 구간 길이만큼 경우의 수 추가
        cnt[a[s]] -= 1  # 시작 포인터의 숫자 제거
        s += 1

# 남은 구간 경우의 수 계산 (삼각수)
ret += (e - s) * (e - s + 1) // 2

# 결과 출력
print(ret)
"""
코드 설명
1. 입력 처리
* 입력:
    * n: 수열의 길이 (1 ≤ N ≤ 100,000).
    * a: N개의 정수 리스트 (1 ≤ a[i] ≤ 100,000).
    * 예: n = 5, a = [1, 2, 3, 2, 1].
2. 변수 초기화
* s, e: 투 포인터 (시작, 끝 인덱스).
* cnt: 각 숫자의 등장 횟수 배열 (크기 100,001, 0-based로 충분).
* ret: 중복 없는 연속 구간 개수 (long long 대응 위해 정수형 사용).
3. 투 포인터로 중복 없는 구간 계산
* 흐름:
    * while e < n: 끝 포인터가 수열 끝에 도달할 때까지.
        * cnt[a[e]] == 0: 새로운 숫자면:
            * cnt[a[e]] += 1: 등장 횟수 증가.
            * e += 1: 끝 포인터 이동.
        * else: 중복 발생 시:
            * ret += (e - s): 현재 구간 길이만큼 경우의 수 추가 (s~e-1까지).
            * cnt[a[s]] -= 1: 시작 포인터의 숫자 제거.
            * s += 1: 시작 포인터 이동.
    * 중복 없는 구간을 유지하며 계산.
4. 남은 구간 경우의 수 계산
* 역할: 마지막 중복 없는 구간(s~e-1)의 경우의 수 추가.
* 계산:
    * 길이 len = e - s.
    * 경우의 수: len + (len-1) + ... + 1 = len * (len + 1) // 2 (삼각수).
    * ret += (e - s) * (e - s + 1) // 2.
5. 결과 출력
* 출력: ret (경우의 수).

문제 분석
* 문제: 백준 13144 "List of Unique Numbers".
* 입력:
    * N: 수열 길이.
    * N개의 정수.
* 조건:
    * 연속 구간 중 중복 없는 경우의 수 계산.
    * 수는 1 이상 100,000 이하.
* 출력: 경우의 수 (long long 범위).

시간 복잡도
* 입력: O(N) (≈ 10^5).
* 투 포인터:
    * s와 e는 각각 최대 N번 이동.
    * 총합: O(N) (≈ 10^5).
* 총합: O(N) (10^8 대비 여유).
* 결과: 2초 내 충분.

결론
* 정확성: 조건 충족, 샘플 통과.
* 효율성: 시간 O(N), 공간 O(N)으로 최적.
* 특징:
    * C++ 코드의 로직을 파이썬으로 정확히 변환.
    * 투 포인터로 효율적 구간 계산.
    * 삼각수 공식으로 마지막 구간 처리.
* 검증: N 크기에 대해 안정적 동작.
"""