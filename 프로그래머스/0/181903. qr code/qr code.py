def solution(q, r, code):
    return ''.join(c for i,c in enumerate(code) if i % q == r)