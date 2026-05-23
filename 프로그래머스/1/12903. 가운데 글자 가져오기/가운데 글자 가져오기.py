def solution(s):
    slen = len(s)
    mid = slen//2
    return s[mid] if slen % 2 == 1 else s[mid-1: mid+1]