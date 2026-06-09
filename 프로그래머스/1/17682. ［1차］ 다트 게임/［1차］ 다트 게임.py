def spplit(s):
    limit = len(s)
    temp = ''
    ret = []
    i = 0
    while i < limit:
        temp += s[i]
        if s[i] == 'S' or s[i] == 'D' or s[i] == 'T':
            if i+1 < limit:
                if s[i+1] == '*' or s[i+1] == '#':
                    temp += s[i+1]
                    i += 1
            ret.append(temp)
            temp = ''
        i += 1
    return ret
    
def count(cmd, ret):
    ans = 0
    if 'S' in cmd:
        pos = cmd.index('S')
        ans = int(cmd[:pos])
    if 'D' in cmd:
        pos = cmd.index('D')
        ans = int(cmd[:pos]) ** 2
    if 'T' in cmd:
        pos = cmd.index('T')
        ans = int(cmd[:pos]) ** 3
    if '*' in cmd:
        if not ret:
            ret.append(ans*2)
        else:
            ret[-1]= ret[-1]*2
            ret.append(ans*2)
    elif '#' in cmd:
        ret.append(-ans)
    else:
        ret.append(ans)
        

def solution(dartResult):
    cmds = spplit(dartResult)
    ret = []
    for cmd in cmds:
        count(cmd, ret)
    
    return sum(ret)
"""
1. 3번 던짐(점수SDT옵션)
2. 0~10
3. 점수 + (S, D, T), 1승,2승, 3승
4. 옵션: *: 이전*2, 현재*2    #: -현재
5. 처음*: 현재만*2
6. *중첩가능 중첩시 4배
7. *과# 중첩가능 #는 -2배됨
8. SDT점수마다 하나씩 반드시 존재
9. *,#은 점수마다 둘중 하나만 존재 

1. 각각의 기회를 나눈다
    이전이 sdt나 *,#일때 멈춤
     
2. 계산하다
3. 출력한다


"""