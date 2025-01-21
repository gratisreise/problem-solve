cnt = [0] * 10
for c in str(int(input()) * int(input()) * int(input())):
    cnt[int(c)] += 1
print(*cnt, sep = "\n") 