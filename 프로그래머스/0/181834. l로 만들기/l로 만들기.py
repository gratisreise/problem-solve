def solution(myString):
    return ''.join('l' if ord(c) < ord('l') else c for c in myString)