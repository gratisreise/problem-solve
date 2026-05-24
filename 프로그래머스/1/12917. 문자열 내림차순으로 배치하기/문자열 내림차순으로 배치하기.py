def solution(s):
    return ''.join(c for c in sorted(list(s), reverse=True))