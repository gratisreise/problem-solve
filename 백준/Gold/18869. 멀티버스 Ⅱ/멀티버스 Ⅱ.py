import sys
import bisect
from collections import defaultdict

# 입력: 우주 개수 n, 행성 개수 m
n, m = map(int, sys.stdin.readline().split())
# 순위 패턴 빈도를 저장할 딕셔너리
count = defaultdict(int)

# N개 우주 순회
for _ in range(n):
    # 한 우주의 행성 크기 입력
    universe = list(map(int, sys.stdin.readline().split()))
    # 행성 크기를 정렬
    sorted_universe = sorted(universe)
    # 상대적 순위 계산: 각 행성의 정렬된 위치를 1-based 순위로 변환
    normalized = tuple(bisect.bisect_left(sorted_universe, x) + 1 for x in universe)
    # 해당 순위 패턴의 빈도 증가
    count[normalized] += 1

# 동일 순위 패턴을 가진 우주 쌍 개수 계산: 빈도 k에서 쌍 수는 k*(k-1)//2
result = sum(k * (k - 1) // 2 for k in count.values())
# 결과 출력
print(result)
"""
코드 설명
1. 입력 처리
* n, m: n은 우주 개수 (1 ≤ N ≤ 100), m은 각 우주의 행성 개수 (1 ≤ M ≤ 10,000).
* count: 순위 패턴 빈도를 저장하는 딕셔너리, defaultdict(int)로 초기화 (키 없으면 0).
2. 우주 순위 계산 및 빈도 저장
* for _ in range(n): N개 우주 순회.
    * universe: 한 우주의 행성 크기 리스트 (M개 정수, 1 ≤ 값 ≤ 10^9).
    * sorted_universe: 정렬된 행성 크기 리스트.
    * normalized: 상대적 순위 튜플.
        * bisect.bisect_left(sorted_universe, x): 정렬된 리스트에서 x의 삽입 위치 (0-based).
        * + 1: 1-based 순위로 변환.
        * tuple(...): immutable 키로 저장.
    * count[normalized] += 1: 해당 순위 패턴 빈도 증가.
3. 동일 우주 쌍 계산 및 출력
* result: 동일 순위 패턴을 가진 우주 쌍의 개수.
    * k * (k - 1) // 2: 빈도 k에서 쌍의 개수
    * sum(...): 모든 패턴의 쌍 수 합산.
* print(result): 결과 출력.

문제 분석
* 문제: 백준 18869 "멀티버스 II".
* 입력: N, M, N개의 우주 (각 M개 정수).
* 출력: 동일한 상대적 순위 패턴을 가진 우주 쌍의 개수.
* 조건: 행성 크기는 상대적 순위로 비교.

시간 복잡도
* 정렬: O(m log m) per 우주, 총 O(n m log m).
* 순위 계산: O(m log m) per 우주 (이진 탐색), 총 O(n m log m).
* 쌍 계산: O(n) (최대 N개 키).
* 총합: O(n m log m) (≈ 10^7), 1초 내 충분.

공간 복잡도
* u: O(m) per 우주.
* count: O(n) (최대 N개 패턴).
* 총합: O(n + m) (256MB 내 여유).

결론
* 정확성: 상대적 순위로 동일 우주 쌍 계산, 샘플 통과.
* 효율성: 시간 O(n m log m), 공간 O(n + m).
* 특징: 이진 탐색으로 순위 계산, 조합으로 쌍 수 구함.
"""