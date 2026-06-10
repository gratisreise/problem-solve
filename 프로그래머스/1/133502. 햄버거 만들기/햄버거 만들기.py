def solution(ingredient):
    ret = 0
    stk = []
    for c in ingredient:
        stk.append(str(c))
        if len(stk) >= 4 and stk[-1] == '1':
            temp = ''
            for _ in range(4):
                temp = stk.pop() + temp
            if temp == '1231':
                ret += 1     
                continue
            for c in temp:
                stk.append(c)
    return ret
    
                
                
                
            

"""
1: 빵
2: 야채
3: 고기
1231

"""