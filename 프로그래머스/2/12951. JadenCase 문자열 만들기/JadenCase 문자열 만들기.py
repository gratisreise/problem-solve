def convert(s):
    return ''.join(c.upper() if i == 0 else c for i,c in enumerate(s.lower()))

def solution(s):
    word = ''
    ret = ''
    c = ''
    for c in s:
        if c == ' ':
            if word:
                ret += convert(word)
                word = ''
            ret += c
        else:
            word += c
    
    if word:
        ret += convert(word)
        
    return ret
                
        
    
"""
1. 순회하면서 문자열 쌓기
2. 공백만나면 지금까지 만든 문자열 처리해서 넣기

"""