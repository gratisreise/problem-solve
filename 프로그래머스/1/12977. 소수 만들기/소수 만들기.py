def solution(nums):
    size = len(nums)
    ssums = []
    for i in range(size):
        for j in range(i+1, size):
            for k in range(j+1, size):
                ssums.append(nums[i] + nums[j] + nums[k])
    n = max(ssums)
    prime = [False] * (n+1)
    prime[0] = prime[1] = True
    for i in range(2, n+1):
        if prime[i]: continue
        for j in range(i+i, n+1, i):
            prime[j] = True
    return sum(1 for x in ssums if not prime[x])
    