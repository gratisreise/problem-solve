def is_allow(c):
    if ord('a') <= ord(c) <= ord('z'):
        return True
    if ord('0') <= ord(c) <= ord('9'):
        return True
    if c == '-' or c == '_' or c == '.':
        return True
    return False
    
def solution(new_id):
    new_id = new_id.lower() #1
    new_id = ''.join(c for c in new_id if is_allow(c))
    ret = ''
    prev = ''
    for c in new_id:
        if prev =='.' and c == '.':
            continue
        ret += c
        prev = c
    if ret and ret[0] == '.': ret = ret[1:]
    if ret and ret[-1] == '.': ret = ret[:-1]
    if not ret:
        ret += 'a'
    if len(ret) >= 16:
        ret = ret[:15]
    if ret and ret[0] == '.': ret = ret[1:]
    if ret and ret[-1] == '.': ret = ret[:-1]
    print(ret)
    while len(ret) < 3:
        ret += ret[-1]
    return ret
    
    
    
"""
아이디: 3~15, 소문자, 숫자, -,_,.
.는 처음끝 사용x, 연속 사용x



"""