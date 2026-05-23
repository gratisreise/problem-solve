from collections import Counter
def solution(s):    
    cnt = [0] * 26
    for c in s:
        cnt[ord(c)-ord('a')] += 1
    return ''.join(chr(i +ord('a')) for i in range(len(cnt)) if cnt[i] == 1)
        