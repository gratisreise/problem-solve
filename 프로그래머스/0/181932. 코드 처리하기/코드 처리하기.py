def solution(code):
    ret, mode  = '', 0
    for i,x in enumerate(code):
        if mode == 0:
            if x != '1':
                if i % 2  == 0:
                    ret += x
            else:
                mode = 1
        else:
            if x != '1':
                if i % 2 == 1:
                    ret += x
            else:
                mode = 0
    return ret if ret else "EMPTY"
                
            
            
    
"""
mode:0 => 1아니면 idx 짝수일 때 ret에 code[idx] 추가, 1이며 mode=0
mode:1 => 1아니면, idx 홀 ret에 code[idx] 추가, 1이면 mode= 1

"""