time = list(map(int, input().split()))
sum_m = time[0] * 60 + time[1] - 45 if len(time) > 1 else time[0] * 60 - 45
H = str(sum_m // 60) if sum_m >= 0 else "23"
M = str(sum_m % 60)
print(H, M)