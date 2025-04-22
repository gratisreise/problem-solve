def calc(c, a, b):
    if c == '+': return a + b
    elif c == '-': return a - b
    elif c == '*': return a * b

def go(idx, sum):
    if idx == len(oper):
        global ret
        ret = max(ret, sum)
        return
    go(idx+1, calc(oper[idx], sum, nums[idx+1]))  # 괄호 없이 진행
    if idx + 2 <= len(oper):  # 다음 연산 괄호 가능
        temp = calc(oper[idx+1], nums[idx+1], nums[idx+2])  # 괄호 계산
        go(idx+2, calc(oper[idx], sum, temp))  # 괄호 결과로 진행

n = int(input())  # 수식 길이
s = input()  # 수식 문자열
oper, nums, ret = [], [], -int(1e9)  # 연산자, 숫자, 최대값

for c in s:
    if c.isdigit():
        nums.append(int(c))  # 숫자
    else:
        oper.append(c)  # 연산자

go(0, nums[0])  # DFS 시작
print(ret)  # 결과 출력




""""
문제 접근 방법과 아이디어
문제 이해
* 목표: 주어진 수식에 괄호를 추가하여 얻을 수 있는 최대 결과값 구하기.
* 조건:
    * 수식 길이: N (1 ≤ N ≤ 19, 홀수).
    * 수식: 숫자와 연산자(+, -, *)가 번갈아 등장.
    * 괄호 규칙:
        * 괄호 안에는 연산자 하나와 숫자 두 개만 가능.
        * 괄호는 중첩 불가, 겹침 불가.
    * 연산: 주어진 순서대로 수행 (괄호 우선).
* 출력: 최대 결과값.
접근 아이디어
* DFS:
    * 각 연산자 인덱스에서 두 가지 선택:
        1. 괄호 없이 현재 연산 수행.
        2. 다음 연산을 괄호로 묶고 현재 연산 수행.
    * 재귀적으로 모든 경우 탐색, 최대값 갱신.
* 상태 관리:
    * nums: 숫자 리스트.
    * oper: 연산자 리스트.
    * ret: 최대 결과값.
    * idx: 현재 연산자 인덱스.
    * sum: 현재까지의 계산 결과.
* 구현 전략:
    * 수식 파싱: 숫자와 연산자 분리.
    * DFS로 괄호 추가 경우 탐색.
    * 각 경로의 결과값 중 최대값 선택.
1. 입력 처리
* n: 수식 길이 (홀수).
* s: 수식 문자열 (예: "1+2*3").
* oper: 연산자 리스트.
* nums: 숫자 리스트.
* ret = -int(1e9): 최대 결과값 초기값.
* for c in s:
    * c.isdigit(): 숫자 → nums.append(int(c)).
    * 그 외: 연산자 → oper.append(c).
2. 계산 함수
* calc(c, a, b):
    * c: 연산자 (+, -, *).
    * a, b: 피연산자.
    * 연산 수행 후 결과 반환:
        * +: a + b.
        * -: a - b.
        * *: a * b.
3. DFS 함수
* go(idx, sum):
    * idx: 현재 연산자 인덱스.
    * sum: 현재까지의 계산 결과.
    * 종료 조건:
        * idx == len(oper): 모든 연산자 처리 완료.
        * ret = max(ret, sum): 최대값 갱신.
    * 선택 1: 괄호 없이 진행:
        * calc(oper[idx], sum, nums[idx+1]): 현재 연산 수행.
        * go(idx+1, ...): 다음 연산자로 진행.
    * 선택 2: 다음 연산 괄호 묶기:
        * if idx + 2 <= len(oper): 다음 연산자 존재 확인.
        * temp = calc(oper[idx+1], nums[idx+1], nums[idx+2]): 괄호 내 연산 (nums[idx+1]과 nums[idx+2]).
        * go(idx+2, calc(oper[idx], sum, temp)): 현재 연산에 괄호 결과 적용, 두 연산자 건너뜀.
4. 실행 및 출력
* go(0, nums[0]): 초기 상태 (첫 숫자, 연산자 인덱스 0)로 DFS 시작.
* print(ret): 최대 결과값 출력.

문제 분석
* 문제: 백준 16637 "괄호 추가하기".
* 입력: N, 수식 문자열.
* 출력: 최대 결과값.
* 조건: 괄호 추가로 연산 우선순위 변경, 중첩/겹침 불가.

시간 복잡도
* 연산자 수: (N-1)/2.
* 각 연산자에서 선택: 2가지 (괄호 O/X).
* 최대 경우의 수: O(2^((N-1)/2)).
* N ≤ 19 → (N-1)/2 ≤ 9 → 2^9 = 512.
* 각 경로 계산: O(1) (calc 호출).
* 총합: O(2^((N-1)/2)) ≈ 512, 1초 내 충분.
"""