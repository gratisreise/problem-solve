def push(c, n):
    if c.isupper():
        c = chr(ord('A') + (ord(c) - ord('A') + n) % 26)
    elif c.islower():
        c = chr(ord('a') + (ord(c) - ord('a') + n) % 26)
    return c

def solution(s, n):
    return ''.join(push(c, n) for c in s)
        