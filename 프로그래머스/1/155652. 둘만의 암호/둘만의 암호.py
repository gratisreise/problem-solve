def solution(s, skip, index):
    alp = [chr(x+ord('a')) for x in range(26)]
    ret = []
    for c in s:
        pos = alp.index(c)
        cnt = index
        while cnt > 0:
            pos = (pos + 1) % 26
            if alp[pos] in skip:
                continue
            cnt -= 1
        ret.append(alp[pos])
    return ''.join(ret)