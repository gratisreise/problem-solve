from collections import Counter
def solution(s):
    cnt = Counter(s.lower())
    return True if cnt['p'] == cnt['y'] else False