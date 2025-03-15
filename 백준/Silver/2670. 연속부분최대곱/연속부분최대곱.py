# 연속 부분 최대곱 계산 함수
def go(nums):
    n = len(nums)
    mx = float('-inf')  # 최대값 초기화 (-무한대)
    for start in range(n):
        curr = 1.0  # 현재 곱 초기화
        for end in range(start, n):
            curr *= nums[end]  # 연속 곱 갱신
            mx = max(mx, curr)  # 최대값 갱신
    return mx

# 입력 처리
n = int(input())
nums = [float(input()) for _ in range(n)]

# 결과 계산 및 출력
ret = go(nums)
print(f'{ret:.3f}')  # 소수점 아래 3자리 출력

"""
코드 설명
1. 함수 go(nums)
* 역할: 연속된 부분 수열의 곱 중 최대값 계산.
* 입력: nums (실수 리스트).
* 흐름:
    * n: 수열 길이.
    * mx: 최대 곱을 저장, 초기값 -inf (C++의 -1e9 대체).
    * 이중 반복문:
        * start: 부분 수열 시작 인덱스 (0 ~ n-1).
        * end: 부분 수열 끝 인덱스 (start ~ n-1).
        * curr: 현재 연속 곱, 1.0으로 초기화 (실수 연산 보장).
        * curr *= nums[end]: 연속 곱 갱신.
        * mx = max(mx, curr): 최대값 갱신.
    * 반환: mx.
2. 입력 처리
* n: 수열 길이 (1 ≤ N ≤ 10,000).
* nums: N개의 실수 리스트 (0 < nums[i] ≤ 10).
    * float(input()): 실수 입력 처리 (C++의 cin >> nums[i] 대체).
3. 결과 출력
* ret = go(nums): 최대 곱 계산.
* print(f'{ret:.3f}'): 소수점 아래 3자리까지 출력.
    * C++의 cout << fixed << setprecision(3) << ret와 동일.

문제 분석
* 문제: 백준 2670 "연속부분최대곱".
* 입력:
    * N: 수열 길이.
    * N개의 실수 (0 초과 10 이하).
* 출력:
    * 연속된 부분 수열의 곱 중 최대값.
    * 소수점 아래 3자리까지.
* 조건: 모든 숫자는 양수.
시간 복잡도
* 이중 반복문:
    * 외부: O(n) (start).
    * 내부: 평균 O(n) (end).
    * 총합: O(n^2) (≈ 10^8).
* 결과: N ≤ 10,000이므로 2초 내 충분 (10^8 연산 가능).

결론
* 정확성: C++ 코드와 동일한 로직, 샘플 통과.
* 효율성: 시간 O(n^2), 공간 O(n)으로 문제 제한 내 동작.
* 특징:
    * 완전 탐색으로 모든 연속 부분 수열의 곱 계산.
    * 실수 연산 및 소수점 출력 처리.
* 검증: 문제 요구사항 충족.
"""