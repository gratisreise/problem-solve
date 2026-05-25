def solution(rank, attendance):
    idxs = [x for x in range(len(rank))]
    print(idxs)
    idxs.sort(key=lambda x: rank[x])
    ret = []
    idx = 0
    print(idxs)
    while len(ret) < 3 and idx < len(idxs):
        if attendance[idxs[idx]]:
            ret.append(idxs[idx] )
        idx += 1
    a, b, c = ret
    
    return 10000 * a + 100 * b + c
    
"""
참여가능 중 3명 선발
idx를 숫자 높은 순으로 정렬해서 참석가능한 3명뽑고 거기서 계산하기
"""