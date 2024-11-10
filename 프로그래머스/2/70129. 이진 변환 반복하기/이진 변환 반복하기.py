
def solution(s):
    ret = [0, 0]
    cnt = 0
    while s != '1':
        l = sum(1 for c in s if c == '1')
        ret[1] += (len(s)-l)
        s = bin(l)[2:]
        ret[0] += 1
    return ret
"""
1. '1'의 갯수 카운팅
2. 카운팅한 수를 이진수로 바꾸기
3. '1'의 갯수가 1이될 때까지 반복

"""