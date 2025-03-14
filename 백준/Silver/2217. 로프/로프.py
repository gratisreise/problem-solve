n = int(input())
ropes = [int(input()) for _ in range(n)]
ropes.sort(reverse=True)  # 내림차순 정렬

max_weight = 0
for i in range(n):
    current = ropes[i] * (i + 1)
    if current > max_weight:
        max_weight = current
print(max_weight)
