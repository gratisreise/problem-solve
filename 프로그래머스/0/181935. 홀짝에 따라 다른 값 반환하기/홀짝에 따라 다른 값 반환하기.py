
def solution(n):
    return sum(i for i in range(n+1) if i % 2 == 1)  if n % 2 == 1 else sum(i**2 for i in range(n+1) if i % 2 == 0)