# 입력 처리
n = int(input())
lines = []
for _ in range(n):
    from_, to = map(int, input().split())
    lines.append((from_, to))

# 선분 정렬
lines.sort()

# 초기 설정
l, r = lines[0][0], lines[0][1]
total_length = 0

# 선분 처리
for i in range(1, n):
    if r < lines[i][0]:  # 이전 선분과 겹치지 않음
        total_length += r - l
        l = lines[i][0]
        r = lines[i][1]
    elif lines[i][0] <= r and lines[i][1] > r:  # 일부 겹치고 더 길어짐
        r = lines[i][1]

# 마지막 선분 길이 추가
total_length += r - l

# 결과 출력
print(total_length)

"""
코드 설명
1. 입력 처리
* 입력:
    * n: 선분 개수 (1 ≤ n ≤ 1,000,000).
    * lines: 선분 리스트, 각 선분은 (from, to) 튜플로 저장 (from: 시작점, to: 끝점).
        * -10^9 ≤ from ≤ to ≤ 10^9.
2. 선분 정렬
* lines.sort(): 선분을 시작점 기준으로 오름차순 정렬.
    * C++의 sort(L, L + n)과 동일.
    * Python의 기본 정렬은 튜플 첫 번째 요소(from)를 기준으로, 필요 시 두 번째 요소(to)도 고려.
3. 초기 설정
* l, r: 첫 번째 선분의 시작점과 끝점 (lines[0][0], lines[0][1]).
* total_length: 총 길이, 초기값 0.
4. 선분 처리
* 역할: 선분을 순회하며 겹치지 않는 길이 합산.
* 흐름:
    * for i in range(1, n): 두 번째 선분부터 처리.
        * 조건 1: r < lines[i][0] (이전 선분과 겹치지 않음):
            * 이전 선분 길이(r - l)를 total_length에 추가.
            * 새로운 선분으로 갱신 (l, r = lines[i][0], lines[i][1]).
        * 조건 2: lines[i][0] <= r and lines[i][1] > r (일부 겹치고 더 길어짐):
            * 끝점만 확장 (r = lines[i][1]).
        * 그 외 (완전 포함 등): 무시 (길이 변화 없음).
5. 마지막 선분 길이 추가
* total_length += r - l: 마지막 선분의 길이를 더함 (루프 밖에서 처리).
6. 결과 출력
* total_length: 총 길이 출력.

문제 분석
* 문제: 백준 2170 "선 긋기".
* 입력:
    * N: 선분 개수.
    * N개의 (from, to) 쌍.
* 조건:
    * 선분은 1차원 직선 상에 있음.
    * 겹치는 부분은 한 번만 계산.
    * 총 길이 = 모든 선분의 합 - 겹치는 부분.
* 출력: 선분이 덮는 총 길이.

시간 복잡도
* 입력: O(N) (≈ 10^6).
* 정렬: O(N log N) (Python의 Timsort, ≈ 10^6 log 10^6 ≈ 2×10^7).
* 선분 처리: O(N) (≈ 10^6).
* 총합: O(N log N) (≈ 2×10^7).
* 결과: 1초 내 충분 (10^8 대비 여유).

공간 복잡도
* lines: O(N) ≈ 8MB (N ≤ 10^6, 각 튜플 8바이트 가정).
* 총합: 약 8MB (256MB 내 여유).

결론
* 정확성: C++ 코드와 동일한 로직, 샘플 통과.
* 효율성: 시간 O(N log N), 공간 O(N)으로 적절.
* 특징:
    * 정렬 후 선분 스위핑으로 간단히 해결.
    * 겹침 처리 로직 명확.
* 검증: N 범위 내 효율적 동작.
"""