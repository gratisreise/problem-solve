def solution(s):
    set_list = []
    temp = set()
    stack = []
    for c in s:
        if c == '}' and (temp or stack):
            if stack: 
                temp.add(int(''.join(stack)))
                stack = []
            set_list.append(temp)
            temp = set()
        elif c.isdigit():
            stack.append(c);
        elif c == ',' and stack:
            temp.add(int(''.join(stack)))
            stack = []
    set_list.sort(key=lambda x: len(x))
    ret = []
    for st in set_list:
        ret.extend((st - set(ret)))
    return ret
        
        

"""
1. 원소갯수 n
2. 중복X 
원소 하나 원소 2개 원소 3개 .... 하나씩 
괄호 마다 set을 만들어 주고 그 set의 크기가 작은 것 부터 순서 대로 원소 넣어주기
리스트의 set을 만들어서 크기 순으로 오름차순 정렬하고 
차집합의 숫자를 넣어주기

"""