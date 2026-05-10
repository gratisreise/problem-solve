def solution(myString, pat):
    myString = ''.join('A' if c == 'B' else 'B' for c in myString)
    return 1 if pat in myString else 0