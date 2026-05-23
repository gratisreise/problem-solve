def solution(str_list):
    for i,c in enumerate(str_list):
        if c == 'l':
            if i == 0: return []
            else: return str_list[:i]
        elif c == 'r':
            if i == len(str_list) - 1:
                return []
            else: return str_list[i+1:]
    return []
    
# l먼저 왼쪽 리스트
# r먼저 오른쪽 문자열