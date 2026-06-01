def solution(s):
    dic = {x:-1 for x in set(s)}
    ret = []
    for i,c in enumerate(s):
        if dic[c] == -1:
            ret.append(-1)
        else:
            ret.append(i-dic[c])
        dic[c] = i
    return ret

"""
자기앞, 가장 가까운 같은 글자
각 알파벳마다 지금까지 나온 인덱스 저장하고 차이로 구하면되지
1.알파벳 소문자 : -1 저장
2.문자열 순회하면서 구하기
3.

"""