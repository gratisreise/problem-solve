from collections import Counter
def solution(X, Y):
    cnt = {str(x):0 for x in range(10)}
    alp1 = Counter(X)
    alp2 = Counter(Y)
    for i in range(10):
        key = str(i)
        if key in alp1.keys() and key in alp2.keys():
            cnt[key] = min(alp1[key], alp2[key])
    
    ret = '';
    for i in range(9,-1, -1):
        num = cnt[str(i)]
        if num > 0:
            ret += str(i) * num
    while len(ret) > 1 and ret[0] == '0':
        ret = ret[1:]
    
    return ret if ret else '-1'
        
        
        
    
"""
짝꿍 = X와 Y에서 공통으로 나타나는 숫자로 만들 수 있는 가장 큰 수
1. X Y 짝꿍없으면 짝꿍: -1
2. X Y 짝꿍 0으로 구성 짝꿍:0
"""