import math
n,m = map(int, input().split())
print(math.gcd(n, m), (n*m)//math.gcd(n,m), sep="\n")