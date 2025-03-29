n, c = map(int, input().split())
ret, dic = {}, {}
for i,num in enumerate(map(int, input().split())):
    if num not in ret:
        ret[num] = 0
    ret[num] += 1
    if num in dic: continue
    dic[num] = i
ans = []
for num in sorted(ret.keys(), key = lambda x: (-ret[x], dic[x])):
    for _ in range(ret[num]):
        ans.append(str(num))
print(' '.join(ans))

"""

문제 접근 방법과 아이디어
문제 이해
* 목표: 수열을 빈도 내림차순, 동일 빈도 시 등장 순서 오름차순으로 정렬.
* 조건:
    * N: 수열 길이 (1 ≤ N ≤ 1000).
    * C: 수 범위 (1 ≤ C ≤ 10^9).
    * 수열: N개의 정수.
* 출력: 정렬된 수열 (공백 구분).
접근 아이디어
* 빈도와 순서 관리:
    * 각 수의 빈도 수를 카운트.
    * 각 수의 첫 등장 순서를 기록.
* 정렬 기준:
    * 1순위: 빈도 내림차순 (많이 등장한 수 우선).
    * 2순위: 등장 순서 오름차순 (먼저 나온 수 우선).
* 구현 전략:
    * 딕셔너리로 빈도와 순서 저장.
    * 정렬 후 빈도만큼 수 반복 출력.
코드설명
1. 입력 처리
* n, c: 수열 길이(N), 수 범위(C) (C는 사용 안 함).
* ret: 수별 빈도를 저장하는 딕셔너리.
* dic: 수별 첫 등장 순서를 저장하는 딕셔너리.
2. 수열 입력 및 처리
* enumerate: 인덱스(i)와 값(num) 함께 처리.
    * if num not in ret: 처음 등장 시 빈도 0 초기화.
    * ret[num] += 1: 빈도 증가.
    * if num in dic: 이미 순서 기록 시 스킵.
    * dic[num] = i: 첫 등장 인덱스 기록.
3. 정렬 및 출력 준비
* sorted(ret.keys(), key=lambda x: (-ret[x], dic[x])):
    * ret.keys(): 등장한 수 목록.
    * key=lambda x: (-ret[x], dic[x]): 정렬 기준.
        * -ret[x]: 빈도 내림차순 (음수로 변환).
        * dic[x]: 순서 오름차순.
    * 결과: 빈도 높은 순, 동일 빈도 시 먼저 나온 순.
* ans: 결과 리스트.
    * for num in ...: 정렬된 수 순회.
    * for _ in range(ret[num]): 빈도만큼 num 추가.
4. 출력
* ' '.join(ans): 리스트를 공백 구분 문자열로 변환 후 출력.

문제 분석
* 문제: 백준 2910 "빈도 정렬".
* 입력: N, C, N개의 수.
* 출력: 빈도 내림차순, 순서 오름차순 정렬된 수열.
* 조건: 동일 수 연속 출력.

시간 복잡도
* 입력 처리: O(N).
* 정렬: O(K log K), K는 고유 수 개수 (K ≤ N).
* 출력 리스트 생성: O(N).
* 총합: O(N + K log K) (N ≤ 1000, ≈ 10^4), 1초 내 충분.

결론
* 정확성: 빈도와 순서 기준으로 정확히 정렬.
* 효율성: 시간 O(N + K log K), 공간 O(N).
* 아이디어: 딕셔너리로 빈도와 순서 관리, 커스텀 정렬로 해결.

"""