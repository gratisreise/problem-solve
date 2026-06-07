def solution(s):
    ret = []
    temp = ''
    gi = s[0]
    cnt1 = cnt2 = 0
    for i,c in enumerate(s):
        temp += c
        if gi == c:
            cnt1 += 1
        else:
            cnt2 += 1
        if cnt1 == cnt2:
            ret.append(temp)
            temp, gi = '', s[min(i+1, len(s)-1)]
    if temp:
        ret.append(temp)
    return len(ret)
        
        
    
"""
1. 첫글자 x
2. 왼 -> 오른, 
    2-1.x와 x아닌 놈들 횟수세기
    2-2.두 횟수가 같아지는 순간 멈춤
    2-3.문자열 분리
3. 분리후 남은 문자열에 대해 반복
4. 더이상 읽을 놈 없으면 분리하고 종료
s
"""