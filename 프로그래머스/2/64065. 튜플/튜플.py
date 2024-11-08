def convert(s):
    arr = s.split(',')
    return set([int(num) for num in arr])
def solution(s):
    sets, ret, temp, mid = list(), list(), list(), set()
    flag = 0
    for c in s:
        if c == '{': flag = 1
        elif c.isdigit():
            temp.append(c)
        elif c == ',' and flag:
            temp.append(c)
        elif c == '}': 
            flag = 0
            if temp: sets.append(convert(''.join(temp)))
            temp = list()
    sets.sort(key=lambda x: len(x))
    for st in sets:
        ret.extend(list(st - mid))
        mid = st
    return ret
"""
크기가 작은 집합부터 차례대로 정렬하고 
해당집합 - 결과집합을 결과집합에 저장
1. 모든 문자열의 문자에 대해 다음을 반복
 1-1. '{'인 경우 flag = true
 1-2. 숫자인 경우 temp에 넣기
 1-3. '}'인 경우 flag = false, 집합리스트에 temp넣기, temp초기화
 1-4. ','는 flag = true일 때만 넣기
2. 집합의 리스트를 크기 오름차순정렬
3. 결과집합에 현재집합 차집합 결과집합으로 넣어주기


"""