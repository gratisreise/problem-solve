h,m = map(int, input().split())
sum_m = h * 60 + m - 45
print(23 if sum_m < 0 else sum_m // 60, sum_m % 60)