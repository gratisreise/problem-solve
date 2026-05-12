def solution(my_string, m, c):
    
    return ''.join(x for i,x in enumerate(my_string) if (i % m)+1 == c)