from functools import cmp_to_key

def solution(numbers):
    numbers = list(map(str, numbers))
    numbers.sort(key=cmp_to_key(lambda x,y: int(x+y)-int(y+x)), reverse=True)
    return str(int(''.join(numbers)))


# from functools import cmp_to_key

# def solution(numbers):
#     numbers = list(map(str, numbers))
#     numbers.sort(key=cmp_to_key(lambda x,y: int(x+y)-int(y+x)), reverse=True)
#     return str(int(''.join(numbers)))
"""
가장 큰 수가 되게 만드는 경우??
1. 앞자리가 커야한다
2. 나보다

문자열의 중간에 현재 기준보다 작은 문자가 있으면 어떻게 확인하고 비교해서 정렬하지?
-> 자릿수가 4자리수이고 한자리수의 각 요소가 1000이하이니 각 문자열을 3번 반복함으로 해결가능


"""