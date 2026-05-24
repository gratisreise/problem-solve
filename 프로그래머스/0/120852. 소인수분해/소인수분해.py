def solution(n):
    isprime = [True] * (n+1)
    
    for i in range(2, n+1):
        if not isprime[i]: continue
        for j in range(i*2, n+1, i):
            isprime[j] = False

    prime = [x for x in range(2, n+1) if isprime[x]]
    return [x for x in prime if n % x == 0]
        
         
    