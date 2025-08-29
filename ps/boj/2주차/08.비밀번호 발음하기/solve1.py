def isMo(c):  # 모음 판별 함수
    return c == 'a' or c == 'e' or c == 'o' or c == 'i' or c == 'u'

while True:
    s = input()  # 비밀번호 입력
    if s == 'end':  # 종료 조건
        break
    
    cnt_j, cnt_m, prev, cnt = 0, 0, '', 0  # 자음 연속, 모음 연속, 이전 문자, 모음 총수
    flag = 0  # 조건 위반 플래그
    
    for c in s:  # 문자열 순회
        if isMo(c):  # 모음이면
            cnt_m += 1  # 모음 연속 증가
            cnt += 1  # 모음 총수 증가
            cnt_j = 0  # 자음 연속 초기화
        else:  # 자음이면
            cnt_j += 1  # 자음 연속 증가
            cnt_m = 0  # 모음 연속 초기화
        
        # 규칙 2: 모음/자음 3개 연속 체크
        if cnt_j >= 3 or cnt_m >= 3:
            flag = 1
            break
        
        # 규칙 3: 같은 글자 연속 체크 (ee, oo 제외)
        if prev != '' and c != 'e' and c != 'o' and prev == c:
            flag = 1
            break
        
        prev = c  # 이전 문자 갱신
    
    # 결과 판단
    if flag:  # 규칙 2, 3 위반
        print(f"<{s}> is not acceptable.")
    else:
        if cnt == 0:  # 규칙 1 위반 (모음 없음)
            print(f"<{s}> is not acceptable.")
        else:
            print(f'<{s}> is acceptable.')
"""
문제 접근 방법과 아이디어
문제 이해
* 목표: 입력된 비밀번호가 규칙을 만족하는지 판단.
* 조건:
    * 규칙 1: 모음(a, e, i, o, u) 하나 이상 포함.
    * 규칙 2: 모음 또는 자음이 3개 연속 불가.
    * 규칙 3: 같은 글자 연속 두 번 불가 (ee, oo 제외).
    * 입력 종료: "end".
* 출력: "<문자열> is (not) acceptable."
접근 아이디어
* 문자열 검사:
    * 각 문자를 순회하며 조건 확인.
* 상태 관리:
    * 모음 개수(cnt)로 규칙 1 체크.
    * 연속 모음(cnt_m)과 자음(cnt_j)으로 규칙 2 체크.
    * 이전 문자(prev)와 비교로 규칙 3 체크.
* 구현 전략:
    * 모음 판별 함수(isMo) 정의.
    * 조건 위반 시 플래그 설정.
    * 모든 조건 통과 시 결과 출력.
코드 설명

백준 4659번 "비밀번호 발음하기" 문제를 해결하는 제공된 파이썬 코드를 기반으로, 문제 접근 방법과 코드 설명을 작성하겠습니다. 이 문제는 문자열이 특정 규칙을 만족하는지 확인하는 구현 문제입니다.

문제 접근 방법과 아이디어
문제 이해
* 목표: 입력된 비밀번호가 규칙을 만족하는지 판단.
* 조건:
    * 규칙 1: 모음(a, e, i, o, u) 하나 이상 포함.
    * 규칙 2: 모음 또는 자음이 3개 연속 불가.
    * 규칙 3: 같은 글자 연속 두 번 불가 (ee, oo 제외).
    * 입력 종료: "end".
* 출력: "<문자열> is (not) acceptable."
접근 아이디어
* 문자열 검사:
    * 각 문자를 순회하며 조건 확인.
* 상태 관리:
    * 모음 개수(cnt)로 규칙 1 체크.
    * 연속 모음(cnt_m)과 자음(cnt_j)으로 규칙 2 체크.
    * 이전 문자(prev)와 비교로 규칙 3 체크.
* 구현 전략:
    * 모음 판별 함수(isMo) 정의.
    * 조건 위반 시 플래그 설정.
    * 모든 조건 통과 시 결과 출력.

코드 설명
코드
python
CollapseWrapCopy
def isMo(c):  # 모음 판별 함수
    return c == 'a' or c == 'e' or c == 'o' or c == 'i' or c == 'u'

while True:
    s = input()  # 비밀번호 입력
    if s == 'end':  # 종료 조건
        break
    
    cnt_j, cnt_m, prev, cnt = 0, 0, '', 0  # 자음 연속, 모음 연속, 이전 문자, 모음 총수
    flag = 0  # 조건 위반 플래그
    
    for c in s:  # 문자열 순회
        if isMo(c):  # 모음이면
            cnt_m += 1  # 모음 연속 증가
            cnt += 1  # 모음 총수 증가
            cnt_j = 0  # 자음 연속 초기화
        else:  # 자음이면
            cnt_j += 1  # 자음 연속 증가
            cnt_m = 0  # 모음 연속 초기화
        
        # 규칙 2: 모음/자음 3개 연속 체크
        if cnt_j >= 3 or cnt_m >= 3:
            flag = 1
            break
        
        # 규칙 3: 같은 글자 연속 체크 (ee, oo 제외)
        if prev != '' and c != 'e' and c != 'o' and prev == c:
            flag = 1
            break
        
        prev = c  # 이전 문자 갱신
    
    # 결과 판단
    if flag:  # 규칙 2, 3 위반
        print(f"<{s}> is not acceptable.")
    else:
        if cnt == 0:  # 규칙 1 위반 (모음 없음)
            print(f"<{s}> is not acceptable.")
        else:
            print(f'<{s}> is acceptable.')
1. 모음 판별 함수
* isMo(c):
    * c가 'a', 'e', 'i', 'o', 'u' 중 하나면 True 반환.
2. 입력 처리
* while True: 무한 루프.
* s: 비밀번호 입력.
* if s == 'end': 종료 조건.
* 변수 초기화:
    * cnt_j: 연속 자음 수.
    * cnt_m: 연속 모음 수.
    * prev: 이전 문자 (초기값 빈 문자열).
    * cnt: 모음 총수.
    * flag: 규칙 위반 플래그.
3. 문자열 검사
* for c in s: 각 문자 순회.
    * 모음 여부:
        * isMo(c):
            * cnt_m += 1: 모음 연속 증가.
            * cnt += 1: 모음 총수 증가.
            * cnt_j = 0: 자음 연속 초기화.
        * 아니면:
            * cnt_j += 1: 자음 연속 증가.
            * cnt_m = 0: 모음 연속 초기화.
    * 규칙 2:
        * cnt_j >= 3 or cnt_m >= 3: 모음/자음 3개 연속 → flag = 1, 종료.
    * 규칙 3:
        * prev != '': 첫 문자 아닌 경우.
        * c != 'e' and c != 'o': 예외 제외.
        * prev == c: 연속 동일 문자 → flag = 1, 종료.
    * prev = c: 이전 문자 갱신.
4. 결과 판단
* if flag: 규칙 2 또는 3 위반 → "not acceptable".
* else:
    * cnt == 0: 모음 없음 (규칙 1 위반) → "not acceptable".
    * 아니면: 모든 규칙 통과 → "acceptable".

문제 분석
* 문제: 백준 4659 "비밀번호 발음하기".
* 입력: 여러 비밀번호, "end"로 종료.
* 출력: 각 비밀번호의 수용 여부.
* 조건: 모음 1개 이상, 연속 3개 불가, 연속 동일 불가 (ee, oo 제외).

시간 복잡도
* 문자열 길이: 최대 20 (문제 예시 기반).
* 각 문자열 처리: O(|s|).
* 총합: O(T * |s|) (T는 입력 수, ≈ 10^3), 1초 내 충분.

결론
* 정확성: 세 규칙 정확히 검사.
* 효율성: 시간 O(T * |s|), 공간 O(1).
* 아이디어: 상태 변수로 조건 체크, 간단한 순회로 해결.
"""