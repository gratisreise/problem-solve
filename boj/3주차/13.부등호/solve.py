def check(c, a, b):
    if c == '<': return a < b
    if c == '>': return a > b

def go(idx, nums):
    if idx == n:
        global ret_max, ret_min
        ret_max = max(ret_max, ''.join(map(str, nums)))
        ret_min = min(ret_min, ''.join(map(str, nums)))
        return
    for i in range(10):
        if cnt[i]: continue
        if check(s[idx], nums[-1], i):
            cnt[i] = 1
            nums.append(i)
            go(idx+1, nums)
            cnt[i] = 0
            nums.pop()

n, s = int(input()), (input().split())  # 부등호 수, 부등호 리스트
ret_max, ret_min = '0'*(n+1), '9'*(n+1)  # 최대/최소 초기값
cnt = [0]*10  # 숫자 사용 여부
temp = []
for i in range(10):
    cnt[i] = 1
    temp.append(i)
    go(0, temp)
    cnt[i] = 0
    temp = []
print(ret_max, ret_min, sep='\n')
"""
문제 이해
* 목표: 부등호 조건을 만족하는 (k+1)자리 수 중 최대값과 최소값 구하기.
* 조건:
    * 부등호 수: k (1 ≤ k ≤ 9).
    * 부등호: '<' 또는 '>'.
    * 숫자: 0~9, 중복 불가.
    * 수: k+1개의 숫자로 구성, 부등호 조건 충족.
* 출력:
    * 최대값 (문자열).
    * 최소값 (문자열).
접근 아이디어
* 백트래킹:
    * 숫자 0~9 중 하나를 선택하며 부등호 조건 확인.
    * 조건 만족 시 다음 자리로 진행, 불만족 시 다른 숫자 시도.
    * 모든 자리 완성 시 최대/최소값 갱신.
* 상태 관리:
    * s: 부등호 리스트.
    * nums: 현재 선택된 숫자 리스트.
    * cnt: 숫자 사용 여부 (0~9).
    * ret_max, ret_min: 최대/최소 결과 문자열.
* 구현 전략:
    * 첫 숫자를 0~9 중 선택, 백트래킹 시작.
    * 각 단계에서 부등호 조건 확인 후 유효 숫자 추가.
    * k+1자리 완성 시 결과 갱신.
1. 입력 처리
* n: 부등호 수 (k).
* s: 부등호 리스트 (k개, '<' 또는 '>').
* ret_max = '0'*(n+1): 최대값 초기화 (최소 문자열로).
* ret_min = '9'*(n+1): 최소값 초기화 (최대 문자열로).
* cnt = [0]*10: 숫자 0~9 사용 여부 (0: 미사용, 1: 사용).
* temp = []: 임시 숫자 리스트.
2. 부등호 확인 함수
* check(c, a, b):
    * c: 부등호 ('<' 또는 '>').
    * a, b: 비교할 두 숫자.
    * 반환:
        * c == '<': a < b.
        * c == '>': a > b.
3. 백트래킹 함수
* go(idx, nums):
    * idx: 현재 부등호 인덱스.
    * nums: 선택된 숫자 리스트.
    * 종료 조건:
        * idx == n: k+1자리 완성.
        * ret_max = max(...): 숫자 리스트를 문자열로 변환, 최대값 갱신.
        * ret_min = min(...): 최소값 갱신.
    * 탐색:
        * for i in range(10): 0~9 숫자 시도.
        * if cnt[i]: 사용된 숫자 → 스킵.
        * if check(s[idx], nums[-1], i): 부등호 조건 확인 (마지막 숫자와 i).
        * 조건 만족 시:
            * cnt[i] = 1: 숫자 사용 표시.
            * nums.append(i): 숫자 추가.
            * go(idx+1, nums): 다음 자리로 진행.
            * cnt[i] = 0: 백트래킹 (사용 해제).
            * nums.pop(): 숫자 제거.
4. 실행
* for i in range(10):
    * 첫 숫자 0~9 시도.
    * cnt[i] = 1: 숫자 사용.
    * temp.append(i): 첫 숫자 추가.
    * go(0, temp): 백트래킹 시작 (부등호 인덱스 0).
    * cnt[i] = 0: 초기화.
    * temp = []: 리스트 초기화.
5. 출력
* print(ret_max, ret_min, sep='\n'): 최대값과 최소값 출력.

문제 분석
* 문제: 백준 2529 "부등호".
* 입력: k, k개의 부등호.
* 출력: 부등호 조건을 만족하는 최대/최소 (k+1)자리 수.
* 조건: 0~9 숫자, 중복 불가, 부등호 충족.

시간 복잡도
* 숫자 선택: 10 * 9 * ... * (10-k) = 10! / (10-k-1)!.
* k ≤ 9 → 최악: 10! = 3,628,800.
* 각 단계 확인: O(1).
* 총합: O(10! / (10-k-1)!) ≈ 3.6×10^6 (k=9), 1초 내 충분.

"""