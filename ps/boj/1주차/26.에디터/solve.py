from collections import deque
import sys

input = sys.stdin.readline
print = sys.stdout.write

# 초기 문자열 입력
init = input().rstrip()
left = deque(init)  # 커서 왼쪽
right = deque()     # 커서 오른쪽

# 명령어 수 입력
q = int(input().rstrip())

# 명령어 처리
for _ in range(q):
    line = input().rstrip()
    if not line:  # 빈 줄 무시
        continue
    command = line.split()
    op = command[0]
    
    if op == 'P':  # 커서 위치에 문자 추가
        add = command[1]
        left.append(add)
    elif op == 'L':  # 커서 왼쪽 이동
        if left:
            right.appendleft(left.pop())  # 왼쪽 끝에서 오른쪽 앞에 추가
    elif op == 'D':  # 커서 오른쪽 이동
        if right:
            left.append(right.popleft())  # 오른쪽 앞에서 왼쪽 끝에 추가
    elif op == 'B':  # 커서 앞 문자 삭제
        if left:
            left.pop()

# 결과 출력
print(''.join(left) + ''.join(right))
"""
최적화된 양쪽 deque 방식
left와 right를 각각 deque로 관리하고, 커서를 기준으로 끝에서만 연산하면 O(1) 연산을 유지할 수 있어.

동작 원리
left: 커서 왼쪽 문자열 (deque).
right: 커서 오른쪽 문자열 (deque).
연산:
P: left.append(add) → O(1).
L: right.appendleft(left.pop()) → O(1) (양쪽 끝 연산).
D: left.append(right.popleft()) → O(1).
B: left.pop() → O(1).
시간 복잡도
각 명령어: O(1).
총: O(q) ≈ O(500,000) ≈ 5 * 10^5.
출력: O(n) ≈ O(100,000).
총합: O(q + n) ≈ O(6 * 10^5) ≈ 600,000 연산. 0.3초 내 충분히 가능 (파이썬에서 약 10^7~10^8 연산 가능).
공간 복잡도
left, right: O(n).


1. 단일 리스트/덱 방식
문제점:
list.insert, list.pop: 중간 연산은 O(n).
deque.insert, deque 중간 삭제: O(n).
총: O(q * n) ≈ 5 * 10^10 → 시간 초과 (0.3초 ≈ 10^7~10^8 연산).
결론: 부적합.
2. 양쪽 리스트 (기본 리스트)
구현: left와 right로 커서 기준 분리.
문제점: right.insert(0, ...)와 right.pop(0)가 O(n) → O(q * n).
결론: 시간 초과.
3. 양쪽 deque 방식 (최적)
구현: left와 right를 deque로 관리, 끝에서만 연산.
시간 복잡도:
각 연산: O(1) (append, pop, appendleft, popleft).
총: O(q) + 출력 O(n) ≈ 6 * 10^5.
공간 복잡도: O(n).
특징: 파이썬에서 C++의 O(1) 연산을 최대한 모방, 시간 제한 내 처리 가능.

"""