def solution(n): 
    che = [0 for _ in range(n + 1)]
    for i in range(2, n+1):
        if che[i]: continue
        for j in range(i*2, n+1, i):
            if che[j]: continue
            che[j] = 1
    prime = [i for i in range(2, n+1) if not che[i]]
    ret = []
    for i in prime:
        while n % i == 0: 
            ret.append(i)
            n = int(n/i)
    ret = list(set(ret))
    ret.sort()
    return ret
    
    
    
    # 소수판단배열 
    # 그 소수 배열을 돌면서 나누기 반복