def convert(arr):
    for i in range(len(arr)):
        if i % 2: arr[i] = arr[i].lower()
        else: arr[i] = arr[i].upper()
    return arr

def solution(s):
    ret = []
    temp = list()
    for c in s:
        if c != ' ':
            temp.append(c)
        else:
            if temp: ret.append(''.join(convert(temp)))
            ret.append(c)
            temp = list()
    if temp:
        ret.append(''.join(convert(temp)))
    return ''.join(ret)
            
"""
하나 이상의 공백문자로 구분
각 단어의 짝수번째 대문자로, 홀수번째 소문자로
문자열 s에 대해 다음을 반복
1. 공백이 아니면 임시문자열에 넣기
2. 공백이고 임시문자열이 있으면
    2-1. 임시문자열의 짝수는 대문자, 홀수는 소문자로 바꾸기
    2-2. 임시문자열 결과문자열에 넣고 초기화
3. 결과문자열 반환

"""