import sys
from collections import Counter

input = sys.stdin.readline

r, c, k = map(int, input().split())
A = [list(map(int, input().split())) for _ in range(3)]

def operate(A):
    new_A = []
    max_len = 0
    for row in A:
        count = Counter(x for x in row if x != 0)
        sorted_count = sorted(count.items(), key=lambda x: (x[1], x[0]))
        new_row = []
        for num, freq in sorted_count:
            new_row.extend([num, freq])
        max_len = max(max_len, len(new_row))
        new_A.append(new_row)

    for row in new_A:
        row.extend([0] * (max_len - len(row)))
        if len(row) > 100:
            row[:] = row[:100]

    return new_A

time = 0
while time <= 100:
    if 0 <= r - 1 < len(A) and 0 <= c - 1 < len(A[0]) and A[r - 1][c - 1] == k:
        print(time)
        break

    if len(A) >= len(A[0]):
        A = operate(A)
    else:
        A = list(map(list, zip(*operate(list(zip(*A))))))

    time += 1
else:
    print(-1)
"""
코드 설명:

입력:

r, c, k를 입력받습니다.
초기 배열 A를 입력받습니다.
operate(A) 함수:

배열 A의 각 행(또는 열)에 대해 연산을 수행합니다.
각 행(또는 열)의 수를 카운트하고, 등장 횟수와 수의 크기 순으로 정렬합니다.
정렬된 결과를 새로운 행(또는 열)으로 구성합니다.
모든 행(또는 열)의 길이가 같도록 0을 추가합니다.
행(또는 열)의 길이가 100을 초과하면 100까지만 남깁니다.
새로운 배열을 반환합니다.
메인 로직:

time 변수를 0으로 초기화합니다.
while 루프를 사용하여 100번까지 연산을 수행합니다.
A[r-1][c-1]의 값이 k와 같으면 time을 출력하고 종료합니다.
A의 행의 개수가 열의 개수보다 크거나 같으면 R 연산을 수행하고, 그렇지 않으면 C 연산을 수행합니다.
R 연산: operate(A) 함수를 호출하여 A를 갱신합니다.
C 연산: A를 전치하고 operate() 함수를 호출한 다음 다시 전치하여 A를 갱신합니다.
time을 1 증가시킵니다.
100번의 연산 후에도 A[r-1][c-1]의 값이 k와 같지 않으면 -1을 출력합니다.
핵심 로직:

R 연산과 C 연산을 구현합니다.
각 연산에서 수의 등장 횟수와 크기를 기준으로 정렬합니다.
배열의 크기를 조절합니다.
100번의 연산 동안 목표 값을 찾습니다.
코드 최적화:

Counter를 사용하여 수의 등장 횟수를 효율적으로 계산합니다.
sorted 함수를 사용하여 정렬을 수행합니다.
배열의 크기를 조절하여 메모리 사용량을 줄입니다.

"""