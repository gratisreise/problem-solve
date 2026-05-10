def solution(rny_string):
    return ''.join(c if c != 'm' else 'rn' for c in rny_string)