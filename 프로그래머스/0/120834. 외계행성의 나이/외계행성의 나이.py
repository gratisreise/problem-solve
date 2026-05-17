def solution(age):
    dic = {str(i): chr(ord('a') + i) for i in range(10)}
    return ''.join(dic[c] for c in str(age))
    