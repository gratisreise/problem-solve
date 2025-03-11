n = int(input())
coins = [input().strip() for _ in range(n)]

# 각 행을 비트마스크로 표현
rows = [0] * n
for i in range(n):
    for j in range(n):
        if coins[i][j] == 'T':
            rows[i] |= (1 << j)

# 최소 뒷면 개수 초기화
min_tails = float('inf')

# 모든 열 뒤집기 조합 시도
for mask in range(0, 1 << n):
    total_tails = 0
    for row in rows:
        # 현재 행에서 뒷면 개수 계산
        tails = bin(row ^ mask).count('1')
        # 뒷면이 적은 쪽 선택
        total_tails += min(tails, n - tails)
    # 최소값 갱신
    if total_tails < min_tails:
        min_tails = total_tails

print(min_tails)

"""
문제 분석
    문제: 백준 1285번 "동전 뒤집기".
    입력:
        N: 격자 크기 (1 ≤ N ≤ 20).
        N개의 길이 N 문자열 (H/T로 구성).
    조건:
        연산: 각 행 또는 열을 뒤집어 모든 동전을 반대면으로 변경 가능.
        목표: 뒷면('T') 개수 최소화.
    출력: 최소 뒷면 개수.

접근 방법
    아이디어:
        열 뒤집기를 비트마스크로 완전 탐색 (2^N 가지).
        열 상태가 고정되면, 각 행은 뒤집거나 안 뒤집는 두 선택지 중 최소 뒷면 개수를 선택 (탐욕적).
        모든 조합 중 최소값 계산.
    구현:
        행을 비트마스크로 변환.
        열 뒤집기 후 행별 최적 선택.

코드 설명
1. 입력 처리
    입력:
        n: 격자 크기(N×N, 1 ≤ N ≤ 20).
        coins: N개의 문자열 리스트로, 각 문자열은 N개의 문자('H' 또는 'T')로 구성.
            'H': 앞면 (0으로 간주).
            'T': 뒷면 (1로 간주).
        입력 예: coins = ['HTT', 'THH', 'HHT'].
    비트마스크 변환:
        rows: 각 행을 비트마스크로 변환한 리스트.
        각 행의 'T'를 1로, 'H'를 0으로 하여 비트를 설정.
        예: 'HTT'는 0b011 (2진수로 3), 'THH'는 0b100 (4).
        rows[i] |= (1 << j): j번째 열이 'T'면 해당 비트를 1로 설정.
2. 최소 뒷면 개수 계산
    초기화:
        min_tails: 최소 뒷면 개수를 무한대(float('inf'))로 설정.
    열 뒤집기 조합 탐색:
        mask: 열 뒤집기 상태를 나타내는 비트마스크 (0 ~ 2^N-1).
            예: mask = 0b001은 첫 번째 열 뒤집기, 0b010은 두 번째 열 뒤집기.
        range(0, 1 << n): 0부터 2^N-1까지 모든 조합 시도 (N ≤ 20 → 최대 2^20 ≈ 10^6).
    행별 뒷면 개수 계산:
        각 row에 대해:
            row ^ mask: 현재 행과 열 뒤집기 상태를 XOR 연산.
        XOR 결과는 뒤집힌 상태를 반영 (0→1, 1→0).
        tails = bin(row ^ mask).count('1'): 뒤집힌 상태에서 1('T')의 개수.
        min(tails, n - tails): 행을 뒤집거나(뒷면 개수 = tails) 안 뒤집거나(뒷면 개수 = n - tails) 중 최소값 선택.
        total_tails: 모든 행의 최소 뒷면 개수 합.
    최소값 갱신:
        if total_tails < min_tails: 현재 조합의 뒷면 개수가 더 작으면 갱신.
3. 결과 출력
    출력:
        min_tails: 최종 최소 뒷면 개수 출력.

시간 복잡도
    입력 처리: O(n^2) (격자 변환).
    열 조합 탐색: O(2^N) (N ≤ 20 → 약 10^6).
    행별 계산: O(n) per 조합 (bin.count 사용).
    총합: O(n^2 + 2^N * n) (≈ 2×10^7).
    결과: 2초 내 충분 (10^8 대비 여유).
"""