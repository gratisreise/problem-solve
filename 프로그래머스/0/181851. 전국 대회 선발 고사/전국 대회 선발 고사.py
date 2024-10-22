def solution(rank, attendance):
    ret = []
    for i, f in enumerate(attendance):
        if f: ret.append(i)
    ret = sorted(ret, key=lambda x: rank[x])
    return 10000 * ret[0] + 100 * ret[1] + ret[2]