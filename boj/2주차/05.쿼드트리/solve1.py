n = int(input())
a = []
def go(y, x, size):
    if size == 1: return a[y][x]
    b = a[y][x]
    ret = []
    for i in range(y, y + size):
        for j in range(x, x + size):
            if a[i][j] != b:
                ret.append('(')
                ret.append(go(y,x, size//2))
                ret.append(go(y,x + size//2, size//2))
                ret.append(go(y + size//2, x, size//2))
                ret.append(go(y + size//2, x + size//2, size//2))
                ret.append(')')
                return(''.join(ret))
    return a[y][x]

for _ in range(n):
    a.append(list(input()))

print(go(0, 0, n))


"""
문제 접근 방법과 아이디어
문제 이해
* 목표: N×N 격자를 쿼드트리 형태로 압축한 문자열 출력.
* 조건:
    * 격자: N×N (N은 2의 제곱수, 1 ≤ N ≤ 64).
    * 각 칸: 0 또는 1.
    * 압축 규칙:
        * 모두 0 → "0".
        * 모두 1 → "1".
        * 섞여 있으면 → 4등분 후 각 부분 재귀적으로 압축, 괄호로 묶음 "(상좌, 상우, 하좌, 하우)".
* 출력: 압축된 문자열.
접근 아이디어
* 분할 정복:
    * 전체 격자가 단일 값(0 또는 1)인지 확인.
    * 단일 값이면 해당 값 반환.
    * 섞여 있으면 4등분 후 재귀적으로 처리.
* 재귀 함수:
    * go(y, x, size): (y,x)에서 시작하는 size×size 영역 압축.
* 구현 전략:
    * 재귀적으로 영역 분할.
    * 각 영역이 단일 값인지 확인 후 문자열 조합.
코드설명
1. 입력 처리
* n: 격자 크기(N).
* a: N×N 격자, 각 행을 문자열 리스트로 입력 (예: "01" → ['0', '1']).
2. 재귀 함수 (go)
* y, x: 현재 영역의 좌상단 좌표.
* size: 현재 영역의 크기.
* 기저 조건:
    * size == 1: 1×1 영역 → 해당 값 반환.
* 동작:
    * b = a[y][x]: 기준 값 (첫 칸).
    * ret: 결과 문자열 리스트.
    * 영역 순회:
        * for i in range(y, y + size): y축.
        * for j in range(x, x + size): x축.
        * a[i][j] != b: 다른 값 발견 시:
            * '(' 추가.
            * 4등분 재귀 호출:
                * 상좌: go(y, x, size//2).
                * 상우: go(y, x + size//2, size//2).
                * 하좌: go(y + size//2, x, size//2).
                * 하우: go(y + size//2, x + size//2, size//2).
            * ')' 추가.
            * return ''.join(ret): 문자열로 반환.
    * 모두 같으면: b 반환.
3. 출력
* go(0, 0, n): 전체 격자(0,0)에서 시작, 크기 N.
* 결과 출력.

문제 분석
* 문제: 백준 1992 "쿼드트리".
* 입력: N, N×N 격자 (0/1).
* 출력: 쿼드트리 압축 문자열.
* 조건: 4등분 분할, 단일 값 압축.

시간 복잡도
* 각 재귀: size×size 순회 → O(size^2).
* 분할: log N 단계 (N → N/2 → N/4 → ...).
* 총합: O(N^2 * log N) (N ≤ 64, ≈ 10^4), 1초 내 충분.
* 실제: 최악 O(N^2) 근사 (단일 값 체크로 조기 종료 가능).

결론
* 정확성: 재귀로 쿼드트리 규칙 정확히 구현.
* 효율성: 시간 O(N^2 * log N), 공간 O(N^2).
* 아이디어: 분할 정복으로 영역 압축, 단일 값 체크로 최적화.

"""