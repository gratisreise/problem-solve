def solution(n):
    prime = [False] * (n+1)
    prime[0] = prime[1] = True
    for i in range(2, n+1):
        if not prime[i]:
            for j in range(i+i, n+1, i):
                prime[j] = True
    return sum(1 for i in range(2, n+1) if not prime[i])
            
        
    
"""
1. 소수확인배열 만들기
2. 누적합으로 해당하는 숫자의 소수의 합을 더한다
"""