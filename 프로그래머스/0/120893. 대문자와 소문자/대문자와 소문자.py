def solution(my_string):
    return ''.join(c.lower() if c.isupper() else c.upper() for c in my_string)
        