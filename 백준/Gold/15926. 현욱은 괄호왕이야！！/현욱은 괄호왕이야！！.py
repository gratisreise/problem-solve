import sys
from collections import deque  # 스택 대신 deque 사용 가능

input = sys.stdin.readline

# 입력 처리
n = int(input())
s = input().strip()

# 유효 괄호 위치 배열
d = [0] * n
stk = deque()

# 괄호 쌍 매칭
for i in range(n):
    if s[i] == '(':
        stk.append(i)  # 여는 괄호 위치 스택에 추가
    elif stk:  # 닫는 괄호이고 스택에 여는 괄호 있음
        d[i] = 1  # 현재 닫는 괄호 유효
        d[stk.pop()] = 1  # 매칭된 여는 괄호 유효

# 최대 연속 길이 계산
ret = 0  # 최대 길이
cnt = 0  # 현재 연속 길이
for i in range(n):
    if d[i]:
        cnt += 1
        ret = max(ret, cnt)
    else:
        cnt = 0

# 결과 출력
print(ret)

"""
코드 설명
입력 처리:
n: 문자열 길이.
s: 괄호 문자열 (개행 제거).
변수 초기화:
d: 유효한 괄호 위치 표시 배열 (0: 유효 아님, 1: 유효).
stk: 여는 괄호 위치를 저장하는 스택 (deque 사용).
괄호 쌍 매칭:
s[i] == '(': 여는 괄호면 스택에 위치 저장.
s[i] == ')' && stk: 닫는 괄호이고 스택에 매칭될 여는 괄호 있으면:
d[i] = 1: 닫는 괄호 유효.
d[stk.pop()] = 1: 매칭된 여는 괄호 유효.
최대 연속 길이 계산:
cnt: 현재 연속된 유효 길이.
ret: 최대 연속 길이.
d[i] == 1: 유효하면 cnt 증가, ret 갱신.
d[i] == 0: 연속 끊기면 cnt 초기화.
출력:
최대 길이 ret 출력.


시간 복잡도
괄호 쌍 매칭: O(n) (각 문자 1번 처리).
최대 길이 계산: O(n).
총: O(n) ≈ O(2 * 10^5) → 1초 내 충분.
공간 복잡도
O(n): d 배열과 스택.

"""