from collections import Counter
def solution(my_string):
    cnt = Counter(my_string)
    alp = [0] * 52
    print(cnt)
    for c in cnt.keys():
        if ord(c) < ord('a'):
            alp[ord(c) - ord('A')] = cnt[c]
        else:
            alp[ord(c) - ord('a') + 26] = cnt[c]
    return alp
    