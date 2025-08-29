import sys
from collections import deque
ip, op = sys.stdin, sys.stdout  # 입출력 설정
t = int(ip.readline().rstrip())  # 테스트 케이스 수
ret = []  # 결과 리스트

for _ in range(t):
    s = ip.readline().rstrip()  # 괄호 문자열
    stk = deque()  # 스택
    for c in s:
        if stk and c == ')' and stk[-1] == '(':  # 짝 맞음
            stk.pop()  # '(' 제거
        else:
            stk.append(c)  # '(' 또는 ')' 추가
    ret.append("NO" if stk else "YES")  # 스택 비어 있으면 YES

op.write('\n'.join(ret)+'\n')  # 결과 출력



"""
문제 접근 방법과 아이디어
문제 이해
* 목표: 주어진 괄호 문자열이 올바른 VPS인지 판단.
* 조건:
    * 테스트 케이스: T (1 ≤ T ≤ 50).
    * 문자열: '('와 ')'로 구성, 길이 2 ≤ len ≤ 50.
    * VPS: 모든 '('에 대응하는 ')'가 짝을 이룸.
* 출력: 각 문자열이 VPS면 "YES", 아니면 "NO" (줄 단위).
접근 아이디어
* 스택 사용:
    * '('를 만나면 스택에 push.
    * ')'를 만나면 스택의 '('를 pop.
    * 짝이 맞지 않거나 스택이 비어 있으면 실패.
* 상태 점검:
    * 문자열 끝에서 스택이 비어 있으면 VPS.
    * 스택에 남아 있거나 pop 불가능 시 비-VPS.
* 구현 전략:
    * deque로 스택 구현.
    * 각 테스트 케이스별로 스택 초기화.
    * 결과 리스트에 저장 후 한꺼번에 출력.
1. 입력 처리
* ip, op = sys.stdin, sys.stdout: 빠른 입출력 설정.
* t: 테스트 케이스 수.
* ret: 결과를 저장할 리스트.
2. 괄호 문자열 처리
* for _ in range(t): T번 반복.
    * s: 괄호 문자열 입력 (줄바꿈 제거).
    * stk = deque(): 빈 스택 초기화.
    * for c in s: 문자열 각 문자 순회:
        * stk and c == ')' and stk[-1] == '(':
            * 스택이 비어 있지 않고, 현재 문자가 ')'이고, 스택 맨 위가 '('면 짝 맞음.
            * stk.pop(): '(' 제거.
        * else:
            * 짝이 안 맞거나 '('면 stk.append(c)로 추가.
    * ret.append("NO" if stk else "YES"):
        * 스택이 비어 있으면 VPS → "YES".
        * 남아 있으면 비-VPS → "NO".
3. 출력
* '\n'.join(ret)+'\n': 결과 리스트를 줄 단위로 결합 후 출력.

문제 분석
* 문제: 백준 9012 "괄호".
* 입력: T, T개의 괄호 문자열.
* 출력: 각 문자열의 VPS 여부 ("YES"/"NO").
* 조건: '('와 ')' 짝이 맞아야 함.

시간 복잡도
* 각 문자열 처리: O(|s|) (최대 50).
* T번 반복: O(T * |s|).
* 총합: O(T * |s|) (T ≤ 50, |s| ≤ 50, ≈ 2500), 1초 내 충분.


"""