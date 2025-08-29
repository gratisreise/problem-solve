import collections

n = int(input())
counts = collections.Counter(input()[0] for _ in range(n))
result = ''.join(sorted(c for c, count in counts.items() if count >= 5))
print(result if result else 'PREDAJA')

"""
Counter 객체 이용



"""